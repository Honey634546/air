package com.ari;

/**
 * @author Honey
 * @date 2020/4/4 14:02
 */
public class Package {
    private float length;
    private float width;
    private float height;
    private float weight;
    String s_location,e_location;

    public Package(float length, float width, float height, float weight,String s_location,String e_location) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.s_location=s_location;
        this.e_location=e_location;
    }

    public String getS_location() {
        return s_location;
    }

    public void setS_location(String s_location) {
        this.s_location= s_location;
    }

    public String getE_location() {
        return e_location;
    }

    public void setE_location(String e_location) {
        this.e_location = e_location;
    }

    public float getS(){
        return length+height+width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
