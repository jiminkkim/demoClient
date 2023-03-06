package com.example.democlient.properties;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NonNull
@ConfigurationProperties(prefix = "serv")
public class ServProperties {
    private String servIp;
}
