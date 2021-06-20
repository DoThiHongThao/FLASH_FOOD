/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhahang;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Login;

/**
 *
 * @author DELL
 */
public class NhaHang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Login login = new Login();
        } catch (SQLException ex) {
            Logger.getLogger(NhaHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
