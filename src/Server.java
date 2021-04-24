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
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            
            Registry reg= LocateRegistry.createRegistry(1099);
            StudImp instance= new StudImp();
            reg.rebind("StudService", instance);
            System.out.println("Server Running!..");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
