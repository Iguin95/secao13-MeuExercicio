package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Products;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		
		Client client = new Client(name, email, LocalDate.parse(birthDate, fmt)); 
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Instant moment = Instant.now();
		
		Order order = new Order(moment, status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for(int i = 1; i<=n;i++) {
			sc.nextLine();
			System.out.printf("Enter #%d item data:\n", i);
			System.out.print("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			Products product = new Products(nameProduct, price);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			
			OrderItem oI = new OrderItem(quantity, price, product);
			order.addItem(oI);
			
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}


}
