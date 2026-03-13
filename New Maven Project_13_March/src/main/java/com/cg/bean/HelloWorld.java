package com.cg.bean;

import java.util.List;

public class HelloWorld {
    private String  name;
    private List<String> lang;
//    public HelloWorld(String name){
//        this.name=name;
//    }


    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String sayHello(){
        return name.toUpperCase();
    }
}
