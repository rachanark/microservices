package com.example.microservices.personinfo.model;

public class PersonalData {
    String dob;
    Integer age;
    String address;

    public PersonalData() {
    }

    public PersonalData(String dob, Integer age, String address) {
        this.dob = dob;
        this.age = age;
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
