package fit.wenchao.frpcwebui.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.wenchao.frpcwebui.config.ConfigProcesser;
import fit.wenchao.frpcwebui.constants.ResponseCode;
import fit.wenchao.frpcwebui.model.JsonResponse;
import fit.wenchao.frpcwebui.model.vo.ConfigItemVO;

@RestController
@RequestMapping("/frpc")
public class ConfigController {
    private static Logger log = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    ConfigProcesser configProcesser;

    @GetMapping("/configs")

    public JsonResponse test() {

        List<ConfigItemVO> results = configProcesser.process();

        return new JsonResponse(ResponseCode.SUCCESS, results);
    }
}