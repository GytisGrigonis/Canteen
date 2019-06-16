package lt.mif.vu.valgykla;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RankedEmployee extends Employee{
	private LocalDate startedWorking;
	
	final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public RankedEmployee(String name, Duties duties, int wage, String formatDateTime, String formatDateTime1) {
		super(name, duties, wage, formatDateTime);
		this.startedWorking = LocalDate.parse(formatDateTime, formatter);
	}
	
	public int getBonusSalary() {
		int bonus;
		if(getPeriod() >= 3)
			bonus = 50;
		else if(getPeriod() >= 12)
			bonus = 200;
		else bonus = 0;
		return bonus;
	}
	
	@Override
	public int getPeriod() {
		LocalDate currentDate = LocalDate.now();
        return Period.between(startedWorking, currentDate).getMonths();
	}
	
	public void setWorkingYears(LocalDate date) {
		this.startedWorking = date;
	}
}
