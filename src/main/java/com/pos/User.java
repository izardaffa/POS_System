package com.pos;

/**
 *
 * @author Raihan Sastra W
 */
public class User {  
    private String username;  
    private String password;  

    public User(String username, String password) {  
        this.username = username;  
        this.password = password;  
    }  

    public String getUsername() {  
        return username;  
    }  

    public String getPassword() {  
        return password;  
    }  

    public void displayInfo() {  
        System.out.println("Username: " + username);  
    }  
}  
