


import java.io.Serializable;

public class Student implements Serializable {
    private int ID;
    private String Name, Dept;
    
    //set method -id
    public void setId(int new_id){
       ID=new_id;
   }
    
   public void setName(String new_name){
        Name=new_name;
   }
   
   public void setDept(String new_dept){
       Dept =new_dept;
   }
   
   public int getId(){
    return this.ID;
   }
   
   public String getName(){
        return this.Name;
   }
   
   public String getDept(){
       return this.Dept;
   }
}



