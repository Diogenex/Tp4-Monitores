package com.utn.lab4.Tp4.TP4.Config;

import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

    @Bean
    public UserAgentAnalyzer getUserAgentAnalyzer() {
        return UserAgentAnalyzer.newBuilder()
                .withField("AgentName")
                .withField("OperatingSystemNameVersion")
                .build();
    }
}