package com.example.democlient;

import com.example.democlient.common.config.Globals;
import com.example.democlient.properties.ServProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@SpringBootApplication
@ConfigurationPropertiesScan("com.example.democlient.properties")
public class DemoClientApplication implements CommandLineRunner {

    @Autowired
    Globals globals;
    @Autowired
    private ServProperties ServerProp;

    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        globals.setServIp(ServerProp.getServIp());
        String ip = globals.servIp;

        int port = 4432;
        new Client1(ip, port);
    }
}
