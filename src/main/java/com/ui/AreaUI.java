package com.ui;

/**
 * @author Honey
 * @date 2020/4/12 18:16
 */
import javax.swing.*;
import java.rmi.server.UID;

public class AreaUI extends JFrame implements Runnable {
    JLabel label;
    public AreaUI(){
        label=new JLabel("<html><h3 style='text-align:center;color:blue;'>注解</h3><br />区域一：美洲除美国/加拿大外/加勒比海地区与欧洲/非洲/中东/亚洲/西南太平洋之间的航线；<br />" +
                "<br />区域二：欧洲/中东与非洲/亚洲/西南太平洋之间航线；日本与西南太平洋之间航线：日本/西南太平洋与亚洲（不含日本及西南太平洋）/非洲之间航线；<br /> " +
                "<br />区域三：加拿大与美洲（除美国/加拿大外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线<br />" +
                "<br />区域四：美国（含夏威夷）与美洲（除美国外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线<br />" +
                "<br />区域五：非洲与亚洲（除日本外)之间航线；欧洲与中东之间航线；亚洲（除日本)内航线；美洲（除美国/加拿大）及加勒比海地区内航线；上述未列明的航线; </html>");//使用html换行输入提示信息
        this.add(label);
        this.setVisible(true);
        this.setSize(800,300);
        this.setLocationRelativeTo(null);
        this.setTitle("区域划分说明");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) {
//        UI_divide_area a=new UI_divide_area();
//    }

    @Override
    public void run() {
    }
}