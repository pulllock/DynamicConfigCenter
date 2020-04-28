package me.cxis.dcc.controller;

import me.cxis.dcc.model.ConfigVO;
import me.cxis.dcc.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @PostMapping("/addConfig")
    public Result<Boolean> addConfig(@RequestBody ConfigVO config) {

        return null;
    }

}
