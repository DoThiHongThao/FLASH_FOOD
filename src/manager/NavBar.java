/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 *
 * @author DELL
 */
public class NavBar extends JPanel implements KeyListener{
    private JPanel contentPane;
    public Application application;
	private JTextField searchTextField;
	
	protected int page;
	private String search;
	
	public JButton foodButton;
	public JPanel homePanel;
	public JButton typeButton;
	public JMenuBar menuBar;
  
	public NavBar(Application application) {
		
		this.page = 0;
		this.application = application;
		setSize(951, 600);
		setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 80, 70);
		add(logoPanel);
		logoPanel.setLayout(null);
		
		JButton logoButton = new JButton("S2");

		logoButton.setBackground(Color.WHITE);
		logoButton.setFont(new Font("Savoye LET", Font.BOLD, 40));
		logoButton.setBounds(0, 0, 102, 70);
		logoButton.setBorderPainted(false);
		logoPanel.add(logoButton);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(79, 0, 418, 70);
		add(searchPanel);
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		searchPanel.add(searchTextField);
		searchTextField.setColumns(20);
		searchTextField.addKeyListener(this);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchPanel.add(searchButton);
		
		homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		homePanel.setBounds(493, 0, 458, 70);
		add(homePanel);
        homePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		
		JButton homeButton = new JButton("HOME");
		homeButton.setForeground(Color.BLUE);
		homeButton.setBackground(Color.WHITE);
		homeButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		homeButton.setBorderPainted(false);
		
		
		foodButton = new JButton("FOOD");
		foodButton.setForeground(Color.BLACK);
		foodButton.setBackground(Color.WHITE);
		foodButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		foodButton.setBorderPainted(false);
                foodButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        application.switchPanel(application.foodManager);
                    }
                });
		
		
		JButton staffButton = new JButton("STAFF");
		staffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            application.switchPanel(application.staffManager);
			}
		});
		staffButton.setForeground(Color.BLACK);
		staffButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		staffButton.setBorderPainted(false);
		staffButton.setBackground(Color.WHITE);
		homePanel.add(homeButton);
		homePanel.add(foodButton);
		homePanel.add(staffButton);
		
		
		typeButton = new JButton("TYPE");
		typeButton.setForeground(Color.BLACK);
		typeButton.setBackground(Color.WHITE);
		typeButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		typeButton.setBorderPainted(false);
                typeButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        application.switchPanel(application.typeManager);
                    }
                });
		homePanel.add(typeButton);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);

		homePanel.add(menuBar);
			
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		
		}
	}
}
