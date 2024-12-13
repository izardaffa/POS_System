
package com.pos;

/**
 *
 * @author Raihan Sastra W
 */
public class Pegawai extends User {  
    private String department;  

    public Pegawai(String username, String password, String department) {  
        super(username, password);  
        this.department = department;  
    }  

    public String getDepartment() {  
        return department;  
    }  

    @Override  
    public void displayInfo() {  
        super.displayInfo();  
        System.out.println("Department: " + department);  
    }  
}  
