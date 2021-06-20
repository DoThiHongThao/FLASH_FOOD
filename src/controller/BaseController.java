/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author DELL
 */
import connect.Connect;
import java.sql.SQLException;
import model.User;

public class BaseController {
    
    private String errors = "";
    
    protected Connect connect;
    
    public BaseController() throws SQLException {
        connect = new Connect();
    }
    
//    public User Signin(String username, String password) {
      public User Signin(String email, String password){
//        String _email = "[a-zA-Z0-9]+\\@gmail\\.com";
        String _password = ".{8,}";
          System.out.println(email);
//        if (email.isEmpty()) {
//                errors += "Email not null \n";
//        } else if (!email.matches(_email)) {
//                errors += "Email co dang abc@gmail.com \n";
//        }
        if (password.isEmpty()) {
                errors += "Password not null \n";
        } else if (!password.matches(_password)) {
                errors += "Password phai nhieu hon 8 ky tu\n";
        }
        
        if (!"".equals(errors)) {
            return new User();
        }
        
        return connect.getUser(email, password);
    }
      
    public String getError() {
        return errors;
    }
    
    public void setErrors (String errors) {
        this.errors = errors;
    }
}
