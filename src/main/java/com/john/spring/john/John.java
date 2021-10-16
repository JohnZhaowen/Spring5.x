package com.john.spring.john;

public class John {

    private String name;

    private Integer age;

    public John() {
    }

    public John(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "John[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
