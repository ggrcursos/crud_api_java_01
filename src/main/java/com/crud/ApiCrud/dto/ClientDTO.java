package com.crud.ApiCrud.dto;

public class ClientDTO {

    private String name;

    private String age;

    public ClientDTO() {
    }

    public ClientDTO(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}