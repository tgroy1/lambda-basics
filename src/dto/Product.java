package dto;

import java.util.Objects;

public class Product {
	
	private int price;
	private String name;
	private double discount;
	
	public Product(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discount, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount)
				&& Objects.equals(name, other.name) && price == other.price;
	}
	
	
	
	
}
