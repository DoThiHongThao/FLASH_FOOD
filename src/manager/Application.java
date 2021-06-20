/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import javax.swing.JFrame;

// connect
import connect.Connect;
import controller.BaseController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class Application extends JFrame{
    
    public Connect connect;
    public BaseController baseController;
    
    public FoodManager foodManager;
    public StaffManager staffManager;
    public TypeManager typeManager;
    public ArrayList<NavBar> list;
    
    public Application () throws SQLException {
        setBounds(100, 100, 965, 620);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        // connect database
        connect = new Connect();
        // controller
        baseController = new BaseController();
        
        // VIEW
        foodManager = new FoodManager(this);
        typeManager = new TypeManager(this);
        staffManager = new StaffManager(this);
        // Navbar
        list = new ArrayList<NavBar>();
        
        // add list
        list.add(foodManager);
        list.add(staffManager);
        list.add(typeManager);
        // set Frame
        Iterator<NavBar> iterator = list.iterator();
        
        while(iterator.hasNext()) {
            add(iterator.next());
        }
        
        setVisible(true);
    }
    
    public void switchPanel(NavBar jPanel) {
        Iterator<NavBar> iterator = list.iterator();
        while(iterator.hasNext()) {
                iterator.next().setVisible(false);
        }

        list.get(list.indexOf(jPanel)).setVisible(true);
//        list.get(list.indexOf(jPanel)).switchStatus();
    }
}
