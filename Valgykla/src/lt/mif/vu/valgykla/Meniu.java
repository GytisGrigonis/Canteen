package lt.mif.vu.valgykla;

public class Meniu {
	private String name;
	private String ingredients;
	private int price;
	
	public Meniu(String name, String ingredients, int price) {
		this.name = name;
		this.ingredients = ingredients;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
