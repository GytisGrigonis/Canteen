package lt.mif.vu.work;
import java.util.Scanner;

import javax.swing.JOptionPane;

import lt.mif.vu.valgykla.Canteen;
import lt.mif.vu.valgykla.Client;
import lt.mif.vu.valgykla.Duties;
import lt.mif.vu.valgykla.Employee;
import lt.mif.vu.valgykla.Meniu;
import lt.mif.vu.valgykla.Vegan;
import lt.mif.vu.work.Reader;
import lt.mif.vu.work.Writer;

import java.io.IOException;

public class UserInterface{
	public static void run(Canteen v) throws IOException {
	int x = 1;
	Scanner scan = new Scanner(System.in);
	while(x != 0) {
		System.out.println("\n0 - baigti darba");
		System.out.println("\n1 - pateikti Meniu");
		System.out.println("\n2 - ideti nauja patiekala i Meniu");
		System.out.println("\n3 - istrinti visus patiekalus");
		System.out.println("\n4 - atspausdinti darbuotoju sarasa");
		System.out.println("\n5 - samdyti darbuotoja");
		System.out.println("\n6 - atejo klientas (paimamas is failo)");
		System.out.println("\n7 - atspausdinti i faila klientu sarasa");
		System.out.println("\n8 - prideti veganiska patiekala");
		x = scan.nextInt();
		switch(x) {
		case 0 :
        	System.out.println("Programa baige darba.");
            break;
		case 1:
			for(int i=0; i < v.getDishes().size(); i++) {
        		System.out.println("Patiekalo pavadinimas: " + v.getDishes().get(i).getName());
        		System.out.println("Ingredientai: " + v.getDishes().get(i).getIngredients());
        		System.out.println("Kaina: " + v.getDishes().get(i).getPrice() + " eu");
        		System.out.println();
        	}
			break;
		case 2:
			System.out.println("\nIveskite pavadinima ");
			String name = scan.next();
			System.out.println("\nIveskite ingredientus ");
			String ingredients = scan.next();
			System.out.println("\nIveskite kaina ");
			int price = scan.nextInt();
			if(price < 0) {
				try {
					throw new LessThanZero("Kaina negali buti mazesne uz nuli");
				}
				catch(LessThanZero e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
			else {
				Meniu dish = new Meniu(name, ingredients, price);
				v.addDish(dish);
			}
        	break;
		case 3:
			v.removeDish(v.getDishes());
        	break;
		case 4:
			for(Employee e:v.getEmployees()) {
        		System.out.println("Darbuotojo vardas: " + e.getName());
        		System.out.println("Pareigos: " + e.getDuties());
        		System.out.println("Atlyginimas: " + e.getWage() + " eu");
        		System.out.println();
        	}
        	break;
		case 5:
			System.out.println("\nIveskite varda \n");
			name = scan.next();
			System.out.println("\nPasirinkite pareigas:\n"
					+ "1 - direktorius\n"
					+ "2 - virejas\n"
					+ "3 - kasininkas\n");
			int pick = scan.nextInt();
			System.out.println("\nIveskite alga \n");
			int wage = scan.nextInt();
			System.out.println("Iveskite gimimo metus (yyyy-MM-dd) \n");
			String date = scan.next();
			if(pick == 1) {
				Employee employee = new Employee(name, Duties.DIREKTORIUS, wage, date);
				v.addEmployee(employee);
			}
			if(pick == 2) {
				Employee employee = new Employee(name, Duties.VIREJAS, wage, date);
				v.addEmployee(employee);
			}
			if(pick == 3) {
				Employee employee = new Employee(name, Duties.KASININKAS, wage, date);
				v.addEmployee(employee);
			}
			break;
		case 6:
			name = null;
			String bill = null;
			String table = null;
			String line1 = Reader.read();
			String[] splitted = line1.split(", ");
			name = splitted[0];
			bill = splitted[1];
			table = splitted[2];
			int billInt = Integer.parseInt(bill);	
			int tableInt = Integer.parseInt(table);	
			Client client = new Client(name, billInt, tableInt);
			v.addClient(client);
			break;
		case 7:
			String line = ("Naujas klientu sarasas: ");
			Writer.write(line);
			for(Client c:v.getClients()) {
				line = ("Kliento vardas: " + c.getName() + "\n" + 
						"Saskaitos dydis: " + c.getBill() + " eu " + "\n" + 
						"Staliuko numeris: " + c.getTableNumber()) + "\n";
				Writer.write(line);
			}
			break;
		case 8:
			Vegan burgeris = new Vegan("Mesainis", "Bandele, mesa, padazas, salotos", 7, "Zuvimi"); 
			System.out.println(burgeris.toString());
			break;
        default:
        	System.out.println("Netinkama ivestis");
        	break;
		}
	}
	scan.close();
	}
}


