/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rccms.client.util;
import rccms.common.domain.User;

/**
 *
 * @author IT MODERN LTD
 */
public class UserSession {

    private static UserSession instance;
    private User user; // or User object

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    public boolean isInspector(){
        return this.user.getRole().equals("INSPECTOR");
    }
    
    public boolean isAdmin(){
        return this.user.getRole().equals("ADMIN");
    }

    public void clearSession() {
        user = null;
    }
}
