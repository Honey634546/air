package com.ui;

/**
 * @author Honey
 * @date 2020/4/12 14:35
 */
import com.ari.Air;
import com.ari.Package;
import com.ari.Person;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PackageUI extends JFrame implements ListSelectionListener, ActionListener {

    JTable info_table;
    JComboBox box1,box2,box3;
    //起点、终点、货币类型、机票价格、长、宽、高
    JLabel label1,label2,label3,label4,label5,label6,label7,label8;

    JButton add_button,sure_button,pre_button;
    JTextField text1,text2,text3,text4,text5;
    JScrollPane scrollPane1,scrollPane2;
    int table_length=0,package_number=0;
    Vector table_values;
    DefaultTableModel defaultTableModel;
    Person person;

    public PackageUI(String Cockpit_type,String Passenger_type,String Throuth_US,String Flight_type){
        person=new Person(Cockpit_type,Passenger_type,Throuth_US,Flight_type);
        label1=new JLabel("起点：");
        label2=new JLabel("终点：");
        label3=new JLabel("货币类型：");
        label4=new JLabel("机票价格：");
        label5=new JLabel("     长      ：");
        label6=new JLabel("     宽      ：");
        label7=new JLabel("     高      ：");
        label8=new JLabel("  重  量   ：");

        add_button=new JButton("添加");
        sure_button=new JButton("计算");
        pre_button=new JButton("返回");
        String[] locations={"中国大陆","美洲","加勒比海地区","欧洲","非洲","中东","亚洲","西南太平洋","中东","日本","巴基斯坦","新加坡","哈萨克斯坦","加拿大","美国"};
        box1=new JComboBox(locations);
        box2=new JComboBox(locations);
        String[] money_type={"人民币","美元","加元","欧元"};
        box3=new JComboBox(money_type);

        text1=new JTextField(50);
        text2=new JTextField(50);
        text3=new JTextField(50);
        text4=new JTextField(50);
        text5=new JTextField(50);

        add_button.addActionListener(this);
        sure_button.addActionListener(this);
        pre_button.addActionListener(this);

        init();

        this.setVisible(true);
        this.setSize(950,400);
        this.setTitle("图片查看器");
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        label1.setBounds(45,30,150,20);
        label2.setBounds(260,30,150,20);
        label3.setBounds(130,80,150,20);
        label4.setBounds(130,110,150,20);
        label5.setBounds(130,140,150,20);
        label6.setBounds(130,170,150,20);
        label7.setBounds(130,200,150,20);
        label8.setBounds(130,230,150,20);;
        box1.setBounds(85,30,150,20);
        box2.setBounds(300,30,150,20);
        box3.setBounds(195,80,150,20);
        text1.setBounds(195,110,150,20);
        text2.setBounds(195,140,150,20);
        text3.setBounds(195,170,150,20);
        text4.setBounds(195,200,150,20);
        text5.setBounds(195,230,150,20);

        pre_button.setBounds(60,280,100,20);
        add_button.setBounds(200,280,100,20);
        sure_button.setBounds(340,280,100,20);
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.add(label1);
        panel1.add(text1);
        panel1.add(text2);
        panel1.add(text3);
        panel1.add(text4);
        panel1.add(text5);
        panel1.add(label2);
        panel1.add(box1);
        panel1.add(label3);
        panel1.add(box2);
        panel1.add(label4);
        panel1.add(box3);
        panel1.add(label5);
        panel1.add(label6);
        panel1.add(label7);
        panel1.add(label8);
        panel1.add(add_button);
        panel1.add(sure_button);
        panel1.add(pre_button);
        scrollPane1=new JScrollPane(panel1);
        this.getContentPane().add(scrollPane1, BorderLayout.CENTER);

        Vector columnNames=new Vector();
        columnNames.add("行李编号");
        columnNames.add("起点");
        columnNames.add("终点");
        columnNames.add("货币类型");
        columnNames.add("机票价格");
        columnNames.add("长");
        columnNames.add("宽");
        columnNames.add("高");
        columnNames.add("重量");
        table_values=new Vector();
        defaultTableModel =new DefaultTableModel(table_values,columnNames);

        info_table=new JTable(defaultTableModel);
//        defaultTableModel.setDataVector();
        info_table.setSize(500,200);
        info_table.setBackground(Color.YELLOW);
        scrollPane2 = new JScrollPane(info_table);
        this.getContentPane().add(scrollPane2,BorderLayout.EAST);

        this.pack();
        ListSelectionModel selectionModel=info_table.getSelectionModel();
        selectionModel.addListSelectionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_button){
            Vector columnNames=new Vector();
            columnNames.add("行李编号");
            columnNames.add("起点");
            columnNames.add("终点");
            columnNames.add("货币类型");
            columnNames.add("机票价格");
            columnNames.add("长");
            columnNames.add("宽");
            columnNames.add("高");
            columnNames.add("重量");
            if(package_number==0){
                person.setLocation((String)box1.getSelectedItem(),(String)box2.getSelectedItem());
                person.setPrice(Integer.parseInt(text1.getText()));
                person.add_money_type(box3.getSelectedIndex());
            }
            person.addPackage(Float.parseFloat(text2.getText()),Float.parseFloat(text3.getText()),Float.parseFloat(text4.getText()),Float.parseFloat(text5.getText()));
//            int size=Integer.parseInt(text2.getText())+Integer.parseInt(text3.getText())+Integer.parseInt(text4.getText());
//            person.add_package(Integer.parseInt(text5.getText()),size);
            package_number+=1;
            Vector temp=new Vector();
            temp.add(package_number);
            temp.add(box1.getSelectedItem());
            temp.add(box2.getSelectedItem());
            temp.add(box3.getSelectedItem());
            temp.add(text1.getText());
            temp.add(text2.getText());
            temp.add(text3.getText());
            temp.add(text4.getText());
            temp.add(text5.getText());
            table_values.add(temp);
            defaultTableModel.setDataVector(table_values,columnNames);
            info_table.setModel(defaultTableModel);
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
        }
        if(e.getSource()==sure_button){
            Air a=new Air(person);
            double cost=a.caculate_cost();
            String t="您的行李费为："+String.valueOf(cost);
            if(person.getMoney_type()==0){
                t=t+"元";
            }else if(person.getMoney_type()==1){
                t=t+"美元";
            }else if(person.getMoney_type()==2&&person.Flight_type.equals("区域二")){
                t=t+"欧元";
            }else{
                t=t+"加元";
            }
            JOptionPane.showMessageDialog(null, t,"行李费",JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource()==pre_button){
            UI a=new UI();
            dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public static void main(String[] args) {
        PackageUI a=new PackageUI("头等舱旅客","普通乘客","a","区域一");
    }
}
