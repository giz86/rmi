

import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.rmi.*;
import java.util.*;
import java.net.MalformedURLException;
import java.util.Scanner;
public class Clients {
  public static Scanner scann = new Scanner(System.in);

  
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        boolean condition = false;
        StudentRemote studlist;
        try {
            studlist= (StudentRemote) Naming.lookup("rmi://10.240.72.32:1099/StudService");
        
        do{  
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Quit");
            System.out.println("Insert your choice: ");
            String input = scann.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("please enter number only!");
            }
            try{
                switch(choice){
                    case 0:
                        condition = true;
                        break;
                    case 1:
                        try {
                                          
            
            
            String name,Dept;
            System.out.println("Enter the Name of the student");
            name=scann.nextLine();
            System.out.println("Enter the Dept");
            Dept=scann.nextLine();
             studlist.Insert(name, Dept);
                            
                        } catch (Exception e) {
                        }
                        condition = true;
                        break;
                    case 2:
                        try {
                              
            ArrayList<Student> studList= (ArrayList)studlist.getStudents();
            
            for(Student ss:studList)
            {
                System.out.println("ID - " + ss.getId());
                System.out.println("Name - " + ss.getName());
                System.out.println("Dept - "+ ss.getDept());
                System.out.println( );
            
            }
                            
                        } catch (Exception e) {
                        }
                        condition = true;
                        break;
                    case 3:
                        condition = false;
                        studlist.close();
                        break;
                        
                }
                
            
            }
            catch(Exception e){
                condition = true;
            }
        }while(condition); 
} catch (Exception e) {
        
      
    }
    }

}