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
public class PriorityQueue {
    Node Head;
    int time=0;
    DateClass date;
    class Node{
        class Date{
            int served_minutes;
            int served_hours;
            String route;
 
            private void setTime(int hours, int minutes, String route){
                //customer will served after 5 minutes:
                if(minutes>=60)
                    hours++;
                if(hours>=12){
                    route = "P.M";
                    if(hours>12)
                      hours = hours%12;
                }
                served_hours=hours;
                served_minutes = minutes%60;
                this.route = route;
            }
            
            public String servedTime(){
                if(served_minutes<10)
                    return served_hours+":0"+served_minutes+" "+route;
                return served_hours+":"+served_minutes+" "+route;
            }
            public int getMinutes(){return served_minutes;}
            public int getHours(){return served_hours;}
            
        }
        String Name;
        int Priority;
        Node next;
        boolean isPrint;
        int tokenNo;
        Date date;
        public Node(String name, int priority) {
            Name = name;
            Priority = priority;
            next=null;
            isPrint= false;
            date= new Date();
        }
        public void setTokenNo(int i){tokenNo=i;}
    }

    public PriorityQueue() {
    }
    private void setTiming(Node node){
        while(node!=null){
            node.date.setTime(node.date.getHours(), node.date.getMinutes()+5,node.date.route);
            node = node.next;
        }
    }
    private void setToken(Node node){
        while(node!=null){
            node.setTokenNo(node.tokenNo+1);
            node =node.next;
        }
    }
    public void insertAtEnd(String name, int pr){
        Node newNode = new Node(name, pr);
        if(Head==null){
            Head=newNode;
            Head.setTokenNo(1);
            date = new DateClass();
            Head.date.setTime(date.getHours(), date.getMinutes(),date.route);
        }
        else{
            Node cur= Head;
            Node pre =cur;
            if(cur.Priority<newNode.Priority){
                newNode.date.setTime(Head.date.getHours(),Head.date.getMinutes(), Head.date.route);
                setTiming(Head);
                newNode.tokenNo =Head.tokenNo;
                setToken(Head);
                newNode.next=Head;
                Head = newNode;
                return;
            }
            while(cur!=null){
                if(cur.Priority==newNode.Priority){
                    pre= cur;
                    cur= cur.next;
                }
                else if(cur.Priority>newNode.Priority){
                    pre=cur;
                    cur= cur.next;
                }
                else
                    break;
            }           
            newNode.date.setTime(pre.date.getHours(),pre.date.getMinutes()+5, pre.date.route);
            //pre.date.setTime(newNode.date.getHours(), newNode.date.getMinutes()+5); //after 5 minutes
            
            if(pre.next==null){
                pre.next = newNode;
                newNode.tokenNo = getToken();
            }
            else{
                setTiming(cur);
                newNode.setTokenNo(cur.tokenNo);
                setToken(cur);
                pre.next=newNode;
                newNode.next=cur;
            }
        }     
    }
    private int getToken(){
        Node cur=Head;
        int token=0;
        while(cur!=null){
            if(cur.tokenNo>token)
                token =cur.tokenNo;
            cur=cur.next;
        }
        return token+1;
    }
    public String RemoveFrombeginnig(){
        
        if(Head==null){
            return null;
        }
        if(Head.next==null){
            String value=Head.Name;
            Head=null;
            time=time-60;//decramenting the time
            return value;
        }
        else {
            String value=Head.Name;
        Head=Head.next;
        time=time-60;//decramenting the time
        return value;
        }
    }
    public boolean isEmpty(){
        return Head==null;
    }
    
    public String peek() {
        return Head.Name;
    }
    
    public void Print(){
        Node cur=Head;
        //System.out.println("");
        while (cur!=null){
            System.out.println("\nserved Time: "+ cur.date.servedTime());
            System.out.print("\nName :"+ cur.Name+ " "+cur.tokenNo);
            cur=cur.next;
        }
    }
    
    public Node printToken(){
        Node cur = Head;
        while(cur!=null){
            if(!cur.isPrint){
                cur.isPrint= true;
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    
    public static void main(String args[]){
        PriorityQueue pq = new PriorityQueue();
        pq.insertAtEnd("Ameer Hamza", 1);   //token :3
        pq.insertAtEnd("Juniad", 2);    //  token : 1
        pq.insertAtEnd("Khannal",2);    //  token: 2
        pq.Print();
    }
}


