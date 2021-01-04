/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;

import java.util.Date;

/**
 *
 * @author HP
 */
public class DateClass {
    Date date = new Date();
    String route = "A.M";
    public String getCurrentDate(){
        return getDate()+ " "+ getMonth()+","+getYear();   
    }
    
    public int getYear(){
       return date.getYear()+1900;
    }
   
    public String getMonth(){
        int month = date.getMonth()+1;
        switch(month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";            
            case 5:
                return "May";                
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";                
            case 12:
                return "December";                          
        }
        return null;
    }
    
    public int getDate(){
        return date.getDate();
    }

    public String getCurrentTime(){
        return getHours()+":"+getMinutes()+" "+route;    
    }
    
    public int getHours(){
        int hour = date.getHours();
        if(hour>=12){
            route = "P.M";
            if(hour>12)
              hour = hour%12;
        }
        return hour;
    }
    public int getMinutes(){
        return date.getMinutes();
    }
    
    
    public static void main(String[] ar){
        DateClass dc = new DateClass();
        System.out.println(" "+dc.getCurrentDate());
                
    }
    
}
