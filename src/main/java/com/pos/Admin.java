package com.pos;

/**
 *
 * @author Raihan Sastra W
 */
public class Admin extends User {  
    private String adminLevel;  

    public Admin(String username, String password, String adminLevel) {  
        super(username, password);  
        this.adminLevel = adminLevel;  
    }  

    public String getAdminLevel() {  
        return adminLevel;  
    }  

    @Override  
    public void displayInfo() {  
        super.displayInfo();  
        System.out.println("Admin Level: " + adminLevel);  
    }  
} 
