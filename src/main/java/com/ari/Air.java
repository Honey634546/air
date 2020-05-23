package com.ari;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honey
 * @date 2020/4/2 18:24
 */
public class Air {
    private String[] Cockpit_type={"头等舱旅客","公务舱旅客","悦享经济舱、超级经济舱","经济舱旅客"};
    private String[] Passenger_type={"普通乘客","婴儿乘客","凤凰知音终身白金卡、白金卡乘客","凤凰知音金卡、银卡乘客","星空联盟金卡乘客"};
    private String[] Throuth_US={"是","否"};
    private String[] Flight_type={"区域1","区域2","区域3","区域4","区域5"};
    private String[][] t_areas={{"欧洲","非洲","中东","亚洲","西南太平洋"},{"欧洲","非洲","亚洲","西南太平洋"},{"欧洲","非洲","亚洲"}};
    private String[][] f_areas={{"美洲","加勒比地区"},{"中东"},{"日本","巴基斯坦","新加坡","哈萨克斯坦","西南太平洋"}};
//    Npassenger passenger;
    private Person person;

    //String[] choice,double[] weight
    public Air(Person person){
        this.person=person;
    }

    public double caculate_cost(){
        int default_number=2;
        int package_number=person.getNumOfPackages();
        double cost=0;
        List<Package> packages=person.getPackages();
        if(person.getS_location().equals("中国大陆")&&person.getE_location().equals("中国大陆")){
            double sum_of_weight=0;
            for(int i=0;i<package_number;i++){
                sum_of_weight+=packages.get(i).getWeight();
            }
            //头等舱旅客
            if(person.Cockpit_type.equals(Cockpit_type[0])){
                if(person.Passenger_type.equals(Passenger_type[1])){
                    cost=get_cost(sum_of_weight,10);
                }else{
                    cost=get_cost(sum_of_weight,40);
                }
            }
            //公务舱旅客
            else if(person.Cockpit_type.equals(Cockpit_type[1])) {
                if(person.Passenger_type.equals(Passenger_type[1])){
                    cost=get_cost(sum_of_weight,10);
                }else{
                    cost=get_cost(sum_of_weight,30);
                }
            }
            //经济舱旅客
            else if(person.Cockpit_type.equals(Cockpit_type[2])||person.Cockpit_type.equals(Cockpit_type[3])) {
                if(person.Passenger_type.equals(Passenger_type[1])){
                    cost=get_cost(sum_of_weight,10);
                }else{
                    cost=get_cost(sum_of_weight,20);
                }

            }
        }
        else{
            if(person.Cockpit_type.equals(Cockpit_type[0]) || person.Cockpit_type.equals(Cockpit_type[1])){
                cost=get_cost(2,32);
            }else if(person.Cockpit_type.equals(Cockpit_type[2])){
                cost=get_cost(2,23);
            }else{
//                if(match_area().equals("B")){
//                    cost=get_cost(2,23);
//                }else{
//                    cost=get_cost(1,23);
//                }
            }
        }
        return cost;
    }

    public double get_cost(int free_number,int free_weight){
        List<Package> packages=person.getPackages();
        int package_number=person.getNumOfPackages();
        double cost=0;
        ArrayList<Float> t=new ArrayList<>();
        ArrayList<Float> s=new ArrayList<>();
//        for(int i=0;i<package_number;i++){
//            t.add(packages.weight);
//        }
        for(Package pack:packages){
            t.add(pack.getWeight());
            s.add(pack.getS());
        }

//        for(int i=0;i<package_number;i++){
//            s.add(packages[i].size);
//        }

        for(int i=package_number-1;i>=0;i--){
            if(free_number>0&&t.get(i)<=free_weight&&s.get(i)<=158){
                t.remove(i);
                s.remove(i);
                free_number-=1;
                if(free_number==0||t.size()==0){
                    break;
                }
            }
        }
        int over_number=1;//表示超出免费额度的行李数目
        if(t.size()==0){
            return 0;
        }else{
            for(int i=0;i<t.size();i++){
                cost+=get_c(t.get(i),s.get(i),over_number,free_weight);
                over_number+=1;
            }
        }
        return cost;
    }

    //匹配航线处于AB中哪个区域内
//    public String match_area(){
//        String area="A";
//        boolean find=false;
//        for(int i=0;i<f_areas.length;i++){
//            for(int j=0;j<f_areas[i].length;j++){
//                if(person.getS_location()==f_areas[i][j]){
//                    for (String[] t_area : t_areas) {
//                        for (String s : t_area) {
//                            if (person.getE_location() == s) {
//                                area = "B";
//                                break;
//                            }
//                        }
//                    }
//                    find=true;
//                }
//                if(find){
//                    break;
//                }
//            }
//            if(find){
//                break;
//            }
//        }
//        return area;
//    }

    //超过的行李单件价格计算
    public double get_c(double weight,double size,int over_number,double free_weight){
        int cost=0;
        int type=person.getMoney_type();
        if(person.Flight_type.equals(Flight_type[0])){
            if(over_number==1){
                if(type==0){
                    cost+=1400;
                }else{
                    cost+=220;
                }
            }else if(over_number==2){
                if(type==0){
                    cost+=2000;
                }else{
                    cost+=310;
                }
            }else{
                if(type==0){
                    cost+=3000;
                }else{
                    cost+=460;
                }
            }
            if(weight>free_weight||size>158){
                cost+=area_overweight_cost(person.Flight_type,weight,size,type);
            }
        }else if(person.Flight_type.equals(Flight_type[1])){
            if(over_number==1||over_number==2){
                if(type==0){
                    cost+=1100;
                }else if(type==1){
                    cost+=160;
                }else {
                    cost+=140;
                }
            }else{
                if(type==0){
                    cost+=1590;
                }else if(type==1){
                    cost+=230;
                }else {
                    cost+=200;
                }
            }
            if(weight>free_weight||size>158){
                cost+=area_overweight_cost(person.Flight_type,weight,size,type);
            }
        }else if(person.Flight_type.equals(Flight_type[2])){
            if(over_number==1||over_number==2){
                if(type==0){
                    cost+=1170;
                }else if(type==1){
                    cost+=170;
                }else {
                    cost+=225;
                }
            }else{
                if(type==0){
                    cost+=1590;
                }else if(type==1){
                    cost+=230;
                }else {
                    cost+=300;
                }
            }
            if(weight>free_weight||size>158){
                cost+=area_overweight_cost(person.Flight_type,weight,size,type);
            }
        }else if(person.Flight_type.equals(Flight_type[3])){
            if(over_number==1||over_number==2){
                if(type==0){
                    cost+=1380;
                }else{
                    cost+=200;
                }
            }else{
                if(type==0){
                    cost+=1590;
                }else{
                    cost+=230;
                }
            }
            if(weight>free_weight||size>158){
                cost+=area_overweight_cost(person.Flight_type,weight,size,type);
            }
        }else if(person.Flight_type.equals(Flight_type[4])){
            if(over_number==1){
                if(type==0){
                    cost+=830;
                }else{
                    cost+=120;
                }
            }else if(over_number==2){
                if(type==0){
                    cost+=1100;
                }else{
                    cost+=160;
                }
            }else{
                if(type==0){
                    cost+=1590;
                }else{
                    cost+=230;
                }
            }
            if(weight>free_weight||size>158){
                cost+=area_overweight_cost(person.Flight_type,weight,size,type);
            }
        }
        return cost;
    }

    //计算国内航线中行李所需要的费用
    public double get_cost(double sum_of_weight,int free_weight){
        int package_number=person.getNumOfPackages();
        double cost=0;
        List<Package> packages=person.getPackages();
        if (sum_of_weight <= free_weight) {
            return 0;
        } else {
            sum_of_weight = 0;
            int temp = 0;
            double temp_weight = 0;
            for (int i = 0; i < package_number; i++) {
                sum_of_weight += packages.get(i).getWeight();
                if (sum_of_weight > free_weight) {
                    //记录第几件行李开始超重
                    temp = i;
                    sum_of_weight -= packages.get(i).getWeight();
                    break;
                }
            }
            //铂金卡旅客
            if (person.Passenger_type.equals(Passenger_type[2])) {
                for (int i = package_number - 1; i >= temp; i--) {
                    if (packages.get(i).getWeight() > 30) {
                        continue;
                    } else {
                        if (sum_of_weight > free_weight) {
                            temp_weight += packages.get(temp).getWeight();
                        } else {
                            temp_weight += packages.get(temp-1).getWeight();
                        }
                        for (int t = temp + 1; t < i; t++) {
                            temp_weight += packages.get(t).getWeight();
                        }
                        for (int t = i + 1; t < package_number; t++) {
                            temp_weight += packages.get(t).getWeight();
                        }
                        break;
                    }
                }
                //如果剩下所有行李全都>能免费携带的行李重量
                if (temp_weight == 0) {
                    if (sum_of_weight > free_weight) {
                        if(packages.get(temp).getWeight()>30){
                            temp_weight += packages.get(temp).getWeight();
                        }
                    } else {
                        if(packages.get(temp-1).getWeight()>30){
                            temp_weight += packages.get(temp-1).getWeight();
                        }
                    }
                    for (int t = temp + 1; t < package_number; t++) {
                        temp_weight += packages.get(t).getWeight();
                    }
                }
            }
            //金卡、银卡旅客和星空卡旅客
            else if (person.Passenger_type.equals(Passenger_type[3]) || person.Passenger_type.equals(Passenger_type[4])) {
                for (int i = package_number - 1; i > temp; i--) {
                    if (packages.get(i).getWeight() < 20) {
                        continue;
                    } else {
                        if (sum_of_weight > 40) {
                            temp_weight += packages.get(temp).getWeight();
                        } else {
                            temp_weight += packages.get(temp-1).getWeight();
                        }
                        for (int t = temp + 1; t < i; t++) {
                            temp_weight += packages.get(t).getWeight();
                        }
                        for (int t = i + 1; t < package_number; t++) {
                            temp_weight += packages.get(t).getWeight();
                        }
                        break;
                    }
                }
                if (temp_weight == 0) {
                    if (sum_of_weight > free_weight) {
                        if(packages.get(temp).getWeight()>20){
                            temp_weight += packages.get(temp).getWeight();
                        }
                    } else {
                        if(packages.get(temp-1).getWeight()>20){
                            temp_weight += packages.get(temp-1).getWeight();
                        }
                    }
                    for (int t = temp + 1; t < package_number; t++) {
                        temp_weight += packages.get(t).getWeight();
                    }
                }
            }else{
                if (sum_of_weight > free_weight) {
                    temp_weight += packages.get(temp).getWeight();
                } else {
                    temp_weight += packages.get(temp).getWeight();
                }
                for (int t = temp + 1; t < package_number; t++) {
                    temp_weight += packages.get(t).getWeight();
                }
            }
            System.out.println(temp_weight);
            cost = 0.015 * temp_weight*person.getPrice();
        }
        return Math.round(cost);
    }

    //计算所选区域的行李超重部分所需要支付的费用
    //area表示地区，weight表示行李的重量，number表示行李件数，size表示行李的尺寸，money_type表示货币种类，0表示人民币，1表示美元，2表示加元/欧元
    public int area_overweight_cost(String area,double weight,double size,int money_type){
        int cost=0;
        int type = 4;
        if(weight >23&& weight <=28&& size >=60&& size <=158){
            type=0;
        }else if(weight >28&& weight <=32&& size >=60&& size <=158){
            type=1;
        }else if(weight >=2&& weight <=23&& size >158&& size <=203){
            type=2;
        }else if(weight >23&& weight <=32&& size >158&& size <=203){
            type=3;
        }
        if(area.equals(Flight_type[0])){
            //区域一
            if(type==0){
                if(money_type==0){
                    cost+=380;
                }else{
                    cost+=60;
                }
            }else if(type==1||type==2){
                if(money_type==0){
                    cost+=980;
                }else{
                    cost+=150;
                }
            }else if(type==3){
                if(money_type==0){
                    cost+=1400;
                }else{
                    cost+=220;
                }
            }
        }else if(area.equals(Flight_type[1])){
            //区域二
            if(type==0){
                if(money_type==0){
                    cost+=280;
                }else if(money_type==1){
                    cost+=40;
                }else{
                    cost+=35;
                }
            }else if(type==1||type==2){
                if(money_type==0){
                    cost+=690;
                }else if(money_type==1){
                    cost+=180;
                }else{
                    cost+=85;
                }
            }else if(type==3){
                if(money_type==0){
                    cost+=1100;
                }else if(money_type==1){
                    cost+=160;
                }else{
                    cost+=140;
                }
            }
        }else if(area.equals(Flight_type[2])){
            //区域三
            if(money_type==0){
                cost+=520;
            }else if(money_type==1){
                cost+=75;
            }else{
                cost+=100;
            }
        }else if(area.equals(Flight_type[3])){
            //区域四
            if(type==0){
                if(money_type==0){
                    cost+=690;
                }else{
                    cost+=100;
                }
            }else if(type==1||type==2){
                if(money_type==0){
                    cost+=1040;
                }else{
                    cost+=150;
                }
            }else if(type==3){
                if(money_type==0){
                    cost+=2050;
                }else{
                    cost+=300;
                }
            }
        }else if(area.equals(Flight_type[4])){
            //区域五
            if(type==0){
                if(money_type==0){
                    cost+=210;
                }else{
                    cost+=30;
                }
            }else if(type==1||type==2){
                if(money_type==0){
                    cost+=520;
                }else{
                    cost+=75;
                }
            }else if(type==3){
                if(money_type==0){
                    cost+=830;
                }else{
                    cost+=120;
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
//        get_money_pay a=new get_money_pay();
//        String[][] t_areas={{"欧洲","非洲","中东","亚洲","西南太平洋"},{"欧洲","非洲","亚洲","西南太平洋"},{"欧洲","非洲","亚洲"}};
//        System.out.println(t_areas[2].length);

//        Person a=new Person("头等舱旅客","凤凰知音终身白金卡、白金卡乘客","否","区域5");
//        a.setPrice(1000);
//        a.setLocation("中国大陆","中国大陆");
//        a.addPackage(10,10,10,20);
//        a.addPackage(10,10,10,30);
//        Air air=new Air(a);
//        System.out.println(air.caculate_cost());

    }
}

