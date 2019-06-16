package lt.mif.vu.valgykla;

public interface CateringEstablishments {
	public boolean addDish(Meniu dish);
	
	public boolean addClient(Client client);
	
	public boolean addEmployee(Employee employee);
	
	public boolean removeClient(Client client);
	
	public boolean removeEmployee(Employee employee);
	
	public boolean removeDish(Meniu dish);
}
