package me.cxis.dcc.sample.controller;

import me.cxis.dcc.sample.dcc.DccConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dcc/sample")
public class SampleController {

    @GetMapping("testConfig")
    public String testConfig() {
        return DccConfig.userPrefix;
    }
}
