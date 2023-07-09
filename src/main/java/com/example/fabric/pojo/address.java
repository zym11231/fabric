package com.example.fabric.pojo;

public class address {
    private String pro;//省份
    private String city;//城市
    private String street;//街道
    private String home;//具体住宅

    public address(String pro, String city, String street, String home) {
        this.pro = pro;
        this.city = city;
        this.street = street;
        this.home = home;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "address{" +
                "pro='" + pro + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
