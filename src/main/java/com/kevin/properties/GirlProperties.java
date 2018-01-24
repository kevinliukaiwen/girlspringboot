package com.kevin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by kevin on 2018/1/14.
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupSize;

    private int age;

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public int getAge() {
        return age;
    }
}
