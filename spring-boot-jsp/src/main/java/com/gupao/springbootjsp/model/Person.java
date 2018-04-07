package com.gupao.springbootjsp.model;

/**
 * Created by Administrator on 2018/4/6.
 */
public class Person {
    private String name;
    private Integer age;
    private String parentName;


    public Person( String name,Integer age,String parentName){
        this.name=name;
        this.age=age;
        this.parentName=parentName;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
