package com.wufeida.remind.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ding")
public class DingConf {
    public String dingUrl;
    public String keyword;
}
