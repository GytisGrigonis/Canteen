package lt.mif.vu.work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import lt.mif.vu.valgykla.Canteen;
import lt.mif.vu.valgykla.Client;
import lt.mif.vu.valgykla.Duties;
import lt.mif.vu.valgykla.Employee;
import lt.mif.vu.valgykla.Meniu;

public class Listener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		Meniu Dish1 = new Meniu("Vistienos kepsnys", "Vistiena, ryziai, darzoves", 4);
		Meniu Dish2 = new Meniu("Plovas", "Ryziai, mesa, padazas", 3);
		Employee gytis = new Employee("Gytis", Duties.DIREKTORIUS, 1000, "1998-02-15");
		Employee haris = new Employee("Haroldas", Duties.KASININKAS, 500, "1994-03-10");
		Client client1 = new Client("Saulius", 50, 7);
		Client client2 = new Client("Tomas", 60, 5);
		Canteen v = new Canteen();
		v.addDish(Dish1);
	    v.addDish(Dish2);
	    v.addClient(client1);
	    v.addEmployee(gytis);
	    v.addEmployee(haris);
	    v.addClient(client2);
	    try {
			UserInterface.run(v);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
