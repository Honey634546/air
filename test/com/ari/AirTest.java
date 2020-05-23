package com.ari;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

public class AirTest extends TestData{

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(dataProvider="providerMethod")
    public void testCaculate_cost(Map<?, ?> param) {
        String cockpit_type= (String) param.get("cockpit_type");
        String passenger_type= (String) param.get("passenger_type");
        String throuth_US=(String)param.get("throuth_US");
        String flight_type=(String)param.get("flight_type");
        String s_location=(String)param.get("s_location");
        String e_location=(String)param.get("e_location");
        float price=Float.valueOf((String)param.get("price"));
        double ans=Double.valueOf((String)param.get("ans"));

        String packages=(String)param.get("packages");
        String[] pack=packages.split(",");

        Person person=new Person(cockpit_type,passenger_type,throuth_US,flight_type);
        person.setLocation(s_location,e_location);
        person.setPrice(price);
        for(int i=0;i<pack.length;i=i+4){
            float length=Float.valueOf(pack[i]);
            float width=Float.valueOf(pack[i+1]);
            float height=Float.valueOf(pack[i+2]);
            float weight=Float.valueOf(pack[i+3]);
            person.addPackage(length,width,height,weight);
        }
        Air air=new Air(person);
        Assert.assertEquals(air.caculate_cost(),ans);
    }
}