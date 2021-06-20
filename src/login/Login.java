/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import controller.BaseController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import manager.Application;
import model.User;

/**
 *
 * @author DELL
 */
public class Login extends JFrame implements KeyListener{
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
        protected BaseController baseController;
	/**
	 * 
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Login() throws SQLException {

            baseController = new BaseController();
            setBounds(500, 250, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            this.addKeyListener(this);

            JButton btnLogin = new JButton("Login");

            btnLogin.setBounds(189, 207, 86, 25);
            contentPane.add(btnLogin);

            btnLogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    String email = txtUsername.getText();
                    String password = txtPassword.getText();
                    
                    User user = baseController.Signin(email, password);
                    String errors = baseController.getError();
                    if (user != null && errors == "") {
                        try {
                            Application application = new Application();
                            setVisible(false);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (user == null) {
                        JOptionPane.showMessageDialog(new JFrame(), "Email and Password incorrected", "Inane error", JOptionPane.ERROR_MESSAGE);
			return;
                    } else {
                        JOptionPane.showConfirmDialog(new JFrame(), errors, "Inane error", JOptionPane.ERROR_MESSAGE);
                        baseController.setErrors("");
			return;
                    }
                }
            });

            txtUsername = new JTextField();
            txtUsername.setBounds(189, 87, 187, 30);
            contentPane.add(txtUsername);
            txtUsername.setColumns(10);

            JLabel lblUsername = new JLabel("Email:");
            lblUsername.setBounds(74, 86, 86, 30);
            contentPane.add(lblUsername);

            JLabel lblPassword = new JLabel("Password:");
            lblPassword.setBounds(74, 144, 86, 30);
            contentPane.add(lblPassword);

            txtPassword = new JPasswordField();
            txtPassword.setBounds(189, 146, 187, 30);
            contentPane.add(txtPassword);

            JLabel lblLogin = new JLabel("Login");
            lblLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
            lblLogin.setBounds(189, 31, 96, 35);
            contentPane.add(lblLogin);


            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}
}
