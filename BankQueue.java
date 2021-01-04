/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;

/**
 *
 * @author Gopi lund
 */
public class BankQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Credit obj=new Credit();
        int time =obj.list.time;
        String name=obj.list.RemoveFrombeginnig();
     
        System.out.println("Welcome to  ...");
        System.out.println("Name =  "+name);
        System.out.println("Catageroty =   "+"Credit");
        System.out.println("Time=   "+time);
        System.out.println("Token number=   1");
    }
    
}