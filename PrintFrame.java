/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class PrintFrame extends JFrame{
    JLabel bankName ;
    JLabel dateLb;
    JLabel cname;
    JLabel token;
    JLabel stime;
    JLabel Thnk;
    DateClass date= new DateClass();
    PriorityQueue.Node node;
    PrintFrame(PriorityQueue.Node node){
        this.node = node;
        components();
        setLocationRelativeTo(null);
    }
    private void components(){
        
        setSize(300, 450);
        setLayout(null);
        Font f = new Font("serif", Font.BOLD, 18);
        Font g = new Font("serif", Font.ITALIC, 15);
        //setting date to label:
       bankName = new JLabel("******* AL - HABIB BANK *******");
       //bankName.
       cname= new JLabel("CustomerName: " + node.Name);
       token= new JLabel("Token No: "+node.tokenNo); 
       token.setFont(f);
       dateLb= new JLabel("Current Time: "+date.getCurrentDate()+" "+date.getCurrentTime());
       stime= new JLabel("Served at: " +node.date.servedTime());
        Thnk=new JLabel("Thankyou For Choosing Bank Al-Habib");
        Thnk.setFont(g);
        bankName.setBounds(10,20,200,50);
        dateLb.setBounds(10,70,300,50);
        token.setBounds(10,120,200,50);
        cname.setBounds(10,170,200,50);
        stime.setBounds(10,220,200,50);
        Thnk.setBounds(10,250,300,50);
        add(bankName);
        add(cname);
        add(token);
        add(dateLb);
        add(stime);
        add(Thnk);
    }
    
}
