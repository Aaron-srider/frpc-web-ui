package fit.wenchao.frpcwebui.config;

import static fit.wenchao.frpcwebui.utils.Json.pair;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fit.wenchao.frpcwebui.model.ConfigEntryPO;
import fit.wenchao.frpcwebui.model.ConfigItemPO;
import fit.wenchao.frpcwebui.model.vo.ConfigItemVO;

@Component
public class ConfigProcesser {
        public List<ConfigItemVO> process() {
                File configFile = getConfigFrpcDefaultFile();
                List<ConfigItemVO> results = parseFrpcConfigFile(configFile);
                return results;
        }

        private List<ConfigItemVO> parseFrpcConfigFile(File configFile) {
                BufferedReader in = Files.newBufferedReader(configFile.toPath());
                String line;
                ConfigItemVO configItemVO = new ConfigItemVO();
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
                        }
                }
                // List<ConfigItemVO> results = new ArrayList<>();
                // results.add(ConfigItemVO.getInstance("common",
                // pair("token", "wc123456"),
                // pair("port", "22")));

                // results.add(ConfigItemVO.getInstance("ssh",
                // pair("token", "wc123456"),
                // pair("port", "22")));

                // results.add(ConfigItemVO.getInstance("java",
                // pair("token", "wc123456"),
                // pair("port", "22")));

                // results.add(ConfigItemVO.getInstance("backend",
                // pair("token", "wc123456"),
                // pair("port", "22")));
                return results;
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
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }
}
