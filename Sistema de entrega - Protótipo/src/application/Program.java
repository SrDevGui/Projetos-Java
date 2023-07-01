package application;
import entitie.Product;
import etities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import entitie.Client;
import entitie.Order;
import entitie.OrderItem;
public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.next()); // lendo para sdf
        Client client = new Client(name, email, birthDate); // instanciando o cliente com os dados que o usuario digitar
		
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next()); //valueof converte o string para o valor definido no OrderStatus  
        
	    Order order = new Order(new Date(), status, client); //new date instancia o horario atual
	    
		System.out.print("How many items to this order ?");
		int n =sc.nextInt();
		for(int i =1; i<=n; i++) {
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name:");
			sc.nextLine(); //consumi uma linha
			String productName = sc.nextLine();			
			System.out.print("Product price: ");
			Double productPrice  = sc.nextDouble();			
			product = new Product(productName, productPrice); //instanciei o produto	
			System.out.print("Quantity");
			int quantity = sc.nextInt();				
			OrderItem orderItem = new OrderItem(quantity, productPrice, product); // instanciei o OrderItem associado ao produto			
			order.additem(orderItem); //adicionar o pedido ao item de pedido
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		sc.close();
	}

}
