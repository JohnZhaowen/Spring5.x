package com.john.spring.core.value;

import org.springframework.beans.factory.annotation.Value;

public class ValueUser {

    @Value("zhangsan")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${os.name}")
    private String osName;

    @Value("${person.nickname}")
    private String nickname;

    public ValueUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "ValueUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", osName='" + osName + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
