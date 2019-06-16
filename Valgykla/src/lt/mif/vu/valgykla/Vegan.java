package lt.mif.vu.valgykla;

public class Vegan extends Meniu{
	private String meatSubstitute;
	public Vegan(String name, String ingredients, int price, String meatSubstitute) {
		super(name, ingredients, price);
		this.meatSubstitute = meatSubstitute;
	}
	
	public String getMeatSubstitute() {
		return meatSubstitute;
	}
	
	public void setMeatSubstitute(String meatSubstitute) {
		this.meatSubstitute = meatSubstitute;
	}
	
	public String toString() {
		return "Patiekale pavadinimu " + getName() + " mesa bus pakeista " + meatSubstitute;
	}
}
