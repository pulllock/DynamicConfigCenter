package me.cxis.dcc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.cxis.dcc.manager.ConfigManager;
import me.cxis.dcc.model.ConfigVO;
import me.cxis.dcc.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = {"配置管理"})
@RestController
@RequestMapping("/config")
public class ConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

    @Resource
    private ConfigManager configManager;

    @ApiOperation(value = "添加配置", notes = "添加配置和配置实例，同步新增Zookeeper节点")
    @ApiImplicitParam(name = "config", value = "配置", dataType = "ConfigVO", paramType = "body", required = true)
    @PostMapping("/addConfig")
    public Result<Boolean> addConfig(@RequestBody ConfigVO config) {
        // TODO 校验
        Result<Boolean> result = new Result<>();
        result.setModel(configManager.addConfig(config));
        return result;
    }

    @ApiOperation(value = "更新配置", notes = "更新配置和配置实例，同步更新Zookeeper节点")
    @ApiImplicitParam(name = "config", value = "配置", dataType = "ConfigVO", paramType = "body", required = true)
    @PostMapping("/updateConfig")
    public Result<Boolean> updateConfig(@RequestBody ConfigVO config) {
        // TODO 校验
        Result<Boolean> result = new Result<>();
        result.setModel(configManager.updateConfig(config));
        return result;
    }

}
