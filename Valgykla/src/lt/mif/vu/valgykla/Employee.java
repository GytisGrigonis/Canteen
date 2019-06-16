package lt.mif.vu.valgykla;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import lt.mif.vu.valgykla.Duties;

public class Employee extends Person{
	private Duties duties;
	private int wage;
	private LocalDate birthday;
	
	final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public Employee(String name, Duties duties, int wage, String formatDateTime) {
		super(name);
		this.duties = duties;
		this.wage = wage;
		this.birthday = LocalDate.parse(formatDateTime, formatter);
	}
	
	public Duties getDuties() {
		return duties;
	}
	
	public void setDuties(Duties duties) {
		this.duties = duties;
	}
	
	public int getWage() {
		return wage;
	}
	
	public void setWage(int wage) {
		this.wage = wage;
	}
	
	@Override
	public int getPeriod() {
		LocalDate currentDate = LocalDate.now();
        return Period.between(birthday, currentDate).getYears();
	}
	
	public void setAge(LocalDate birthday) {
		this.birthday = birthday;
	}
}
