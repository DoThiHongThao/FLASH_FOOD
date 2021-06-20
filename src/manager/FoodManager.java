/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import manager.NavBar;
/**
 *
 * @author DELL
 */
public class FoodManager extends NavBar{
    private static final long serialVersionUID = 1L;

	private String column[] = new String[] {
			"Code Food", "Name", "Price", "Type"
		};
    
    private String[][] objects;
    
    
    private JTable table;
  
	public FoodManager(Application application) {
            super(application);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 68, 947, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 0, 1079, 540);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Food");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
                
                JButton addButton = new JButton("Create");
                addButton.setBounds(820, 25, 100, 40);
                panel_1.add(addButton);
                
                addButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        new CreateFood(application).setVisible(true);
                    }
                });
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 65, 1059, 485);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(10, 10, 914, 428);
		panel_2.add(scrollPane);
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new LineBorder(SystemColor.control));
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowHeight(35);
		setTable();
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		scrollPane.setViewportView(table);
		
		

	}

	public String[][] getObjects() {
		return objects;
	}

	public void setObjects(String[][] objects) {
		this.objects = objects;
	}
	

	public void setTable() {
            this.objects = application.connect.get_Foods();
            table.setModel(new DefaultTableModel(
                objects,
                column
            ));
	}
	
}
