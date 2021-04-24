/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AR3FAT
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface StudentRemote extends Remote {
    public void Insert(String Name, String Dept) throws RemoteException;
   // public String Delet(int ID);
//    public String Update(int ID, String Name, String Dept);
    
    public ArrayList<Student> getStudents() throws RemoteException;
//    void insert(String id, String fname, String lname, String department );
//    void delete(String id) throws RemoteException;
   // public ArrayList Display() throws RemoteException;
    public void close() throws RemoteException;
}
