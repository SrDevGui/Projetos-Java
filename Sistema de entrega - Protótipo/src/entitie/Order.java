package entitie;
import java.util.Date;
import etities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import entitie.OrderItem;

public class Order {
 DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
 private static final LocalDateTime d02 = LocalDateTime.now(); 
 private Date moment;
 private OrderStatus status;
 private Client client;

 private List<OrderItem> itens = new ArrayList<>(); //instanciando a lista
 public Order () { 	
 }
 public Order(Date moment, OrderStatus status, Client client) {
	this.moment = moment;
	this.status = status;
	this.client = client;
 }
 public Date getMoment() {
	return moment;
 }
 public void setMoment(Date moment) {
	this.moment = moment;
 }
 public OrderStatus getOrderstats() {
	return status;
 }
 public void setOrderstats(OrderStatus orderstats) {
	this.status = orderstats;
 }
 public Client getClient() {
	return client;
 }
 public void setClient(Client client) {
	this.client = client;
 } //remover get e set list pra ninguem mexer na lista (encapsulamento), ninguem mexe na lista a nao ser pelos metodos addItem e removeItem

 
 public void additem(OrderItem item) { 
	 itens.add(item);
 }
 public void removeitem(OrderItem item) { 
	 itens.remove(item);
 }
 
 public double total() {  // para cada OrderItem item na minha lista itens acumular o valor dele na soma
	 double sum =0;
	 for (OrderItem item: itens) { 
		 sum += item.subTotal();
	 }
	 return sum;
	 
 }
 @Override
 public String toString() {
	 StringBuilder sb = new StringBuilder ();
	 sb.append("Order moment : ");
	 sb.append( d02.format(fmt1) + "\n"); // funcionou KRL !!
	 sb.append("Order status: ");
	 sb.append(status + "\n");
	 sb.append("Client : ");
	 sb.append(client + "\n");
	 sb.append("Order itens: \n");
	 for (OrderItem item: itens) {
	     sb.append(item + "\n");
     }
	 sb.append("Total price: $");
	 sb.append(String.format("%.2f", total()));
	 return sb.toString();

}
}