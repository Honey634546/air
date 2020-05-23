package com.ari;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honey
 * @date 2020/4/4 16:27
 */
public class Person {
    private List<Package> packages=new ArrayList<>();
    public String Cockpit_type,Passenger_type,Throuth_US,Flight_type,s_location,e_location;
    private int number_of_package=0,money_type;
    private float price;

    public Person(String cockpit_type, String passenger_type, String throuth_US, String flight_type) {
        Cockpit_type = cockpit_type;
        Passenger_type = passenger_type;
        Throuth_US = throuth_US;
        Flight_type = flight_type;
    }

    public void addPackage(float length, float width, float height, float weight){
//        System.out.println(length);
//        System.out.println(width);
        Package newPackage=new Package(length,width,height,weight,this.getS_location(),this.getE_location());
        packages.add(newPackage);
    }

    public void setLocation(String s_location,String e_location){
        this.s_location=s_location;
        this.e_location=e_location;
    }


    public void add_money_type(int money_type){
        if(money_type==4){
            money_type=3;
        }
        this.money_type=money_type;

    }

    public String getCockpit_type() {
        return Cockpit_type;
    }

    public void setCockpit_type(String cockpit_type) {
        Cockpit_type = cockpit_type;
    }

    public String getPassenger_type() {
        return Passenger_type;
    }

    public void setPassenger_type(String passenger_type) {
        Passenger_type = passenger_type;
    }

    public String getThrouth_US() {
        return Throuth_US;
    }

    public void setThrouth_US(String throuth_US) {
        Throuth_US = throuth_US;
    }

    public String getFlight_type() {
        return Flight_type;
    }

    public void setFlight_type(String flight_type) {
        Flight_type = flight_type;
    }

    public String getS_location() {
        return s_location;
    }

    public void setS_location(String s_location) {
        this.s_location = s_location;
    }

    public String getE_location() {
        return e_location;
    }

    public void setE_location(String e_location) {
        this.e_location = e_location;
    }

    public int getNumber_of_package() {
        return number_of_package;
    }

    public void setNumber_of_package(int number_of_package) {
        this.number_of_package = number_of_package;
    }

    public int getMoney_type() {
        return money_type;
    }

    public void setMoney_type(int money_type) {
        this.money_type = money_type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumOfPackages(){
        return packages.size();
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public void addPackage(Package pack){
        this.packages.add(pack);
    }

    public static void main(String[] args) {

    }
}
