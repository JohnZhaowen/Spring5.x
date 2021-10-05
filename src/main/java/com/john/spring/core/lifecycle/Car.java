package com.john.spring.core.lifecycle;

public class Car {

    public Car(){
        System.out.println("construct car...");
    }

    public void init(){
        System.out.println("car init ...");
    }

    public void destroy(){
        System.out.println("car destroy ...");
    }
}
