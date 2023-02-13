package fit.wenchao.frpcwebui.config;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import fit.wenchao.frpcwebui.model.ConfigEntryPO;
import fit.wenchao.frpcwebui.model.vo.ConfigItemVO;

@Component
public class ConfigProcesser {
        public List<ConfigItemVO> process() {
                File configFile = getConfigFrpcDefaultFile();
                List<ConfigItemVO> results = parseFrpcConfigFile(configFile);
                return results;
        }

        private List<ConfigItemVO> parseFrpcConfigFile(File configFile) {
                try {
                        BufferedReader in = Files.newBufferedReader(configFile.toPath());
                        String line;
                        ConfigItemVO configItemVO = new ConfigItemVO();
                        List<ConfigItemVO> results = new ArrayList<>();
                        while ((line = in.readLine()) != null) {
                                line = line.trim();
                                String configItemName;
                                if (line.startsWith("[")) {

                                        configItemName = parseConfigItemName(line);
                                        if (configItemName == null) {
                                                continue;
                                        }
                                        configItemVO = new ConfigItemVO();
                                        configItemVO.setName(configItemName);
                                        List<String> valueLines;
                                        valueLines = getValueLines(in);
                                        List<ConfigEntryPO> configEntryPOs = convertValuesToConfigItemPOs(valueLines);
                                        configItemVO.setValues(configEntryPOs);
                                        results.add(configItemVO);
                                }
                        }

                        in.close();
                        return results;
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }

        private List<ConfigEntryPO> convertValuesToConfigItemPOs(List<String> valueLines) {
                List<ConfigEntryPO> configItemPOs = new ArrayList<>();

                configItemPOs = valueLines.stream()
                                .map((line) -> {
                                        String[] pairArr = line.split("=");
                                        if (pairArr == null || pairArr.length != 2) {
                                                return null;
                                        } else {
                                                ConfigEntryPO configEntryPO = new ConfigEntryPO(pairArr[0], pairArr[1]);
                                                return configEntryPO;
                                        }
                                })
                                .filter((item) -> item != null)
                                .collect(Collectors.toList());
                ;
                return configItemPOs;
        }

        private List<String> getValueLines(BufferedReader in) {
                try {
                        List<String> valueLines = new ArrayList<>();
                        String line;
                        while ((line = in.readLine()) != null) {
                                line = line.trim();
                                if (!line.startsWith("[")) {
                                        valueLines.add(line);
                                }
                        }
                        return valueLines;
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }

        private String parseConfigItemName(String line) {
                int count = 0;
                char[] resultList = new char[line.length()];

                boolean start = false, end = false;
                for (char c : line.toCharArray()) {
                        if (c == '[') {
                                start = true;
                                end = false;
                                continue;
                        }
                        if (c == ']') {
                                end = true;
                                start = false;
                                continue;
                        }

                        if (start) {
                                resultList[count++] = c;
                                continue;
                        }

                        if (end) {
                                String result = new String(resultList, 0, count);
                                return result;
                        }
                }
                return null;
        }

        private File getConfigFrpcDefaultFile() {
                String defaultConfigFilePath = "/etc/frpc-admin/frpc.ini";
                createFileIfNotExists(defaultConfigFilePath);
                return new File(defaultConfigFilePath);
        }

        private void createFileIfNotExists(String defaultConfigFilePath) {
                try {
                        File configDirFile = new File(defaultConfigFilePath).getParentFile();
                        if (!configDirFile.exists()) {
                                Files.createDirectories(Paths.get(configDirFile.getAbsolutePath()));
                        }
                        File configFile = new File(defaultConfigFilePath);
                        Files.createFile(configFile.toPath());
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
}
