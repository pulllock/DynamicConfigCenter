package fun.pullock.dcc.sample.controller;

import fun.pullock.dcc.sample.dcc.DccConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dcc/sample")
public class SampleController {

    @Value("${TestProject.user.prefix}")
    private String userSuffix;

    /*@Value("${xxx.xxx}")
    private String xxx;*/

    @GetMapping("testConfig")
    public String testConfig() {
        return DccConfig.userPrefix;
    }

    @GetMapping("testConfigSpring")
    public String testConfigSpring() {
        return userSuffix;
    }
}
