package lt.mif.vu.valgykla;
import java.util.ArrayList;
import java.util.List;

public class Canteen implements CateringEstablishments{
	private ArrayList<Meniu> dishes = new ArrayList<Meniu>();
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public ArrayList<Meniu> getDishes() {
		return dishes;
	}
	
	public ArrayList<Client> getClients(){
		return clients;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	public boolean addDish(Meniu dish) {
		return dishes.add(dish);
	}
	
	public boolean addClient(Client client) {
		return clients.add(client);
	}
	
	public boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	
	public boolean removeClient(Client client) {
		return clients.remove(client);
	}
	
	public boolean removeEmployee(Employee employee) {
		return employees.remove(employee);
	}
	
	public boolean removeDish(Meniu dish) {
		return dishes.remove(dish);
	}
	
	public boolean removeDish(List<Meniu> dish) {
		return dishes.removeAll(dish);
	}
}
