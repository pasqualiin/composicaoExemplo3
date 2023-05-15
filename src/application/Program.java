package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("E-mail: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (dd/MM/yyyy): ");
		Date clientBirthDate = sdf.parse(sc.next());

		Client c1 = new Client(clientName, clientEmail, clientBirthDate);

		System.out.println("Enter Order Data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, c1);

		System.out.print("How many items to this order? ");
		int numberOrders = sc.nextInt();

		for (int i = 0; i < numberOrders; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

			order.addItem(orderItem);
		}

		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(order);
		sc.close();
	}
}
