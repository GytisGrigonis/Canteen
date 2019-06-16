package lt.mif.vu.work;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lt.mif.vu.valgykla.Canteen;
import lt.mif.vu.valgykla.Duties;
import lt.mif.vu.valgykla.Employee;  

public class MyGUI extends JFrame{  
		private static final long serialVersionUID = 1L;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDate = new Date();
		JFrame window = this;
		JTextField t1, t2, t3;
		JLabel error;
		JTable employees;
		JComboBox<Object> combo;
		static int id = 5;
		static Canteen c = new Canteen();
		
		public MyGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(700,300);
			setTitle("Employees");
			
			JPanel panel = new JPanel();
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("NAME");
			model.addColumn("DUTIES");
			model.addColumn("WAGE");
			model.addColumn("AGE");
			
			for(int i = 0; i < c.getEmployees().size(); i++) {
		    model.insertRow(i, new Object[]{c.getEmployees().get(i).getName(),
		    c.getEmployees().get(i).getDuties(), c.getEmployees().get(i).getWage(), 
		    c.getEmployees().get(i).getPeriod()});
			}
			
		    employees = new JTable(model); 
			JScrollPane sp = new JScrollPane(employees);

			add(panel, BorderLayout.NORTH);
			add(sp, BorderLayout.WEST);
			
			Duties duties[]= Duties.values();        
			
			JPanel addPanel = new JPanel();
			addPanel.setLayout(null);
			JLabel label = new JLabel("Add new employee:"); 
			label.setBounds(10, 10, 150, 30);
			addPanel.add(label);
			t1 =new JTextField("Name");  
			t1.setBounds(10, 40, 200, 25);
			addPanel.add(t1);
			combo=new JComboBox<Object>(duties);    
			combo.setBounds(10, 70, 200, 25);
			addPanel.add(combo);
			t2 =new JTextField("Wage");  
			t2.setBounds(10, 100, 200, 25);
			addPanel.add(t2);
			t3 =new JTextField("Birth date (yyyy-mm-dd)");  
			t3.setBounds(10, 130, 200, 25);
			addPanel.add(t3);
			JButton button = new JButton("Add employee");		
			button.addActionListener(new AddEmployeeListener());
			button.setBounds(30, 170, 140, 25);
			addPanel.add(button);
			add(addPanel, BorderLayout.CENTER);
			 
			setVisible(true); 
			setLayout(new BorderLayout()); 
		}
		
		private class AddEmployeeListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					String name = t1.getText();
				    if(!name.matches("[a-zA-Z]+"))
				    {
				    	 throw new InvalidNameException("Vardas turi buti sudarytas is raidziu!");
				    }
				    int wage = Integer.parseInt(t2.getText());
					String period = t3.getText();		
					parsedDate = format.parse(period); 
					Duties duties = (Duties) combo.getSelectedItem();
					Employee added = new Employee(name, duties, wage, period);
				
					c.addEmployee(added);
					window.dispose();
					new MyGUI();
				} 
				catch(InvalidNameException ex)
				{
	            	JFrame f = new JFrame();  
					JOptionPane.showMessageDialog(f, ex.getMessage());
				} 
				catch (java.text.ParseException e1) {
					JFrame f = new JFrame();  
					JOptionPane.showMessageDialog(f, "Neteisingai ivesta data");
				}
				catch(Exception e2) {
					JFrame f = new JFrame();  
					JOptionPane.showMessageDialog(f, "Alga gali buti tik skaiciai");
				}
			}
		}
		
		public static void addStartingData() {
			Employee gytis = new Employee("Gytis", Duties.DIREKTORIUS, 1000, "1998-02-15");
			Employee haris = new Employee("Haroldas", Duties.KASININKAS, 500, "1994-03-10");
			c.addEmployee(gytis);
			c.addEmployee(haris);
		}
} 