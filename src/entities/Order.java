package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	Instant moment;
	OrderStatus status;
	
	List<OrderItem> items = new ArrayList<>();
	Client client;
	
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public Order(Instant moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem o : items) {
			sum += o.subTotal();
		}
		return sum;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		ZonedDateTime zonedDateTime = moment.atZone(ZoneId.systemDefault()); // Converte o Instant para ZonedDateTime usando a zona de fuso horário padrão para ser legível por humanos e não ocorrer excessões no código
	    String formattedMoment = fmt2.format(zonedDateTime); // Formata o ZonedDateTime para o formato especificado e o atribui a variável 'formattedMoment'
		
		sb.append("Order moment: ");
		sb.append(formattedMoment + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
		/*
		 * Maneira errada que eu fiz (Apenas para Comparativo):
		 * 
		sb.append("Order moment: " + moment + fmt2 + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + "(" + client.getBirthDate() + ")" 
					+ " - " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		for (OrderItem i : items) {
			sb.append(i.product.getName() + ", $" + i.product.getPrice() + ", " 
					+ "Subtotal: $" + i.subTotal());
		}
		sb.append(total());
		return sb.toString();
		*
		*/
			
	}

}
