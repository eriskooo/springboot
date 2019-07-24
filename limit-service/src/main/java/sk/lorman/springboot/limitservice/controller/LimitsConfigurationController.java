package sk.lorman.springboot.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lorman.springboot.limitservice.controller.dto.LimitConfiguration;
import sk.lorman.springboot.limitservice.model.Configuration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMinimum(),
                configuration.getMaximum());
        return limitConfiguration;
    }



}
