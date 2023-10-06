package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	
	private Products product;
	
	public OrderItem(Integer quantity, Double price, Products product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Double subTotal() {
		double result = quantity * price;
		return result;
	}
	
	public String toString() {
		return product.getName() + ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}

}
