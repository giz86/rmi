/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AR3FAT
 */
import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudImp extends UnicastRemoteObject implements StudentRemote{
   

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/studservice";
            
            String USER ="root";
            String PASS ="";
            public Connection conn= null;
            Statement stmt = null;
    public StudImp()throws RemoteException{
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
        }
    }
     public  ArrayList<Student> getStudents()throws RemoteException{
 ArrayList<Student>list =new ArrayList<Student>();
    //RETURNED OUTISED TRY CATCH BECASUE IF EXCEPTION WITH CONNECTION STILL STUDENT ARRAY LIST IS RETURNED
        try {
           
//            Connection coon=DriverManager.getConnection("jdbc:mysql://localhost:3306/studservice","root","");
             
            System.out.println("connecting to a selected database...");
            
            //connection
           
//         Statement stmt=conn.createStatement();
            System.err.println("connected database Sucessfully");
            
            System.out.println("creating statment..");
            
            
            String sql= "SELECT * FROM student_data";
            ResultSet rs= stmt.executeQuery(sql);  
            
            while (rs.next()){
            
                int id = rs.getInt("ID");
                String name =rs.getString("Name");
                String dept= rs.getString("Dept");
               
                
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setDept(dept);
                
                list.add(student);
                 
            }
        } catch (Exception e) 
            { e.printStackTrace();
        }
   return list;
    }

    @Override
    public void Insert(String Name, String Dept) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studservice","root","");
            System.out.println("connecting to a selected database...");

            Statement stmt=conn.createStatement();
            stmt.execute("insert into student_data(name, dept) values('"+Name+"','"+Dept+"')");
              System.out.println("enserted seccsefully");
              
        } catch (Exception ex) {
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }
    
    @Override
    public void close() throws RemoteException{
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
    
}
  
