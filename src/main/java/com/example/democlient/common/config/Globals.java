package com.example.democlient.common.config;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NonNull
public class Globals {
    public String servIp;
}
