package com.ui;

/**
 * @author Honey
 * @date 2020/4/12 18:14
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ListSelectionListener, ActionListener {

    JMenuItem item1,item2,item3,item4;
    JMenuBar menuBar;
    JMenu menu,subMenu,subMenu1;
    JScrollPane scrollPane1,scrollPane2;


    JLabel label1,label2,label3,label4,label5,label6;
    JTextField text1;
    JComboBox box1,box2,box3,box4;
    JButton check_button;
    public UI(){

        label1=new JLabel("行  李  件  数  ：");
        label2=new JLabel("座  舱  类  型  ：");
        label3=new JLabel("旅  客  类  型  ：");
        label4=new JLabel("是否途径美国 ：");
        label5=new JLabel("航  班  类  型  ：");
        label6=new JLabel("<html><h3 style='text-align:left;color:blue;'>注解</h3>区域一：美洲除美国/加拿大外/加勒比海地区与欧洲/非洲/中东/亚洲/西南太平洋之间的航线；<br />" +
                "<br />区域二：欧洲/中东与非洲/亚洲/西南太平洋之间航线；日本与西南太平洋之间航线：日本/西南太平洋与亚洲（不含日本及西南太平洋）/非洲之间航<br />线；<br /> " +
                "<br />区域三：加拿大与美洲（除美国/加拿大外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线<br />" +
                "<br />区域四：美国（含夏威夷）与美洲（除美国外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线<br />" +
                "<br />区域五：非洲与亚洲（除日本外)之间航线；欧洲与中东之间航线；亚洲（除日本)内航线；美洲（除美国/加拿大）及加勒比海地区内航线；上述未<br />列明的航线; </html>");//使用html换行输入提示信息

        check_button=new JButton("确定");

        text1=new JTextField(50);

        String[] Cockpit_type={"头等舱旅客","公务舱旅客","悦享经济舱、超级经济舱","经济舱旅客"};
        box1=new JComboBox(Cockpit_type);

        String[] Passenger_type={"普通乘客","婴儿乘客","凤凰知音终身白金卡、白金卡乘客","凤凰知音金卡、银卡乘客","星空联盟金卡乘客"};
        box2=new JComboBox(Passenger_type);

        String[] Throuth_US={"是","否"};
        box3=new JComboBox(Throuth_US);

        String[] Flight_type={"区域1","区域2","区域3","区域4","区域5"};
        box4=new JComboBox(Flight_type);

        menuBar=new JMenuBar();
        menu=new JMenu("菜单");

        check_button.addActionListener(this);
        init();

        this.setJMenuBar(menuBar);
        this.setVisible(true);
        this.setSize(800,570);
        this.setTitle("国航行李计算器");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init(){
//        label1.setBounds(230,30,150,20);
        label2.setBounds(230,70,150,20);
        label3.setBounds(230,110,150,20);
        label4.setBounds(230,150,150,20);
        label5.setBounds(230,190,150,20);
//        text1.setBounds(320,30,200,20);
        box1.setBounds(320,70,200,20);
        box2.setBounds(320,110,200,20);
        box3.setBounds(320,150,200,20);
        box4.setBounds(320,190,200,20);
        check_button.setBounds(350,230,100,20);
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.add(label1);
        panel1.add(text1);
        panel1.add(label2);
        panel1.add(box1);
        panel1.add(label3);
        panel1.add(box2);
        panel1.add(label4);
        panel1.add(box3);
        panel1.add(label5);
        panel1.add(box4);
        panel1.add(check_button);
        scrollPane1=new JScrollPane(panel1);
        this.getContentPane().add(scrollPane1,BorderLayout.CENTER);

        JPanel panel2=new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.add(label6);
        scrollPane2=new JScrollPane(panel2);
        this.getContentPane().add(scrollPane2,BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check_button){
            PackageUI a=new PackageUI((String)box1.getSelectedItem(),(String)box2.getSelectedItem(),(String)box3.getSelectedItem(),(String)box4.getSelectedItem());
            dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }



    public static void main(String[] args) {
        UI a=new UI();
    }
}
