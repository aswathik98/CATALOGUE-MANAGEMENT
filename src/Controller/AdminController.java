package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.OrderDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Order;
import model.Product;
import model.User;

public class AdminController {
	
	static int choice ,pid,quantity,price;
	static String pname,category,brand,id,name,email,password,mobile;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Product p= new Product();
	static ProductDAO productdao = new ProductDAO();
	static UserDAO userdao = new UserDAO();
	static OrderDAO orderdao = new OrderDAO();
	static List<Product> plist = new ArrayList<Product>();
	static List<User> ulist = new ArrayList<User>();
	static User u = new User();
	static List<Order> orderList = new ArrayList<Order>();
	
	public void admin() throws Exception {
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("    ");
		System.out.println("******************THE ADMIN LIST*****************************");
		System.out.println("    ");
		System.out.println("1. ADD PRODUCT");
		System.out.println("    ");
		System.out.println("2. DELETE PRODUCT");
		System.out.println("    ");
		System.out.println("3. DISPLAY ALL THE PRODUCTS");
		System.out.println("    ");
		System.out.println("4. SEARCH PRODUCT");
		System.out.println("    ");
		System.out.println("5. DISPLAY CUSTOMER DETAILS");
		System.out.println("    ");
		System.out.println("6. DISPLAY CUSTOMER ORDER DETAILS");
		System.out.println("    ");
		System.out.println("7. DELETE CUSTOMER DETAILS");
		System.out.println("    ");
		//System.out.println("8. CANCEL ORDERS");
		System.out.println("8. EXIT");
		System.out.println("    ");
		System.out.println("Choose the following:");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			
			System.out.println("Enter product name :");
			pname = br.readLine();
			System.out.println("Enter product category:");
			category = br.readLine();
			System.out.println("Enter product brand:");
			brand = br.readLine();

			System.out.println("Enter price :");
			price = Integer.parseInt(br.readLine());
			
			//setters
			p.setPname(pname);
			p.setCategory(category);
			p.setBrand(brand);
			p.setPrice(price);
			productdao.insert(p);
			System.out.println("    ");
			
			System.out.println("-----------------------Product Successfully Added to the Store!!----------------------");
			
			break;
		case 2:
			System.out.println("Enter product ID to be deleted:");
			pid = Integer.parseInt(br.readLine());
			
			productdao.delete(pid);
			
			break;
		case 3:
			
			plist = productdao.displayProducts();
			System.out.println("************************************************************************************************************************************************************************* ");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("                                  Products In Store                                   ");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("*************************************************************************************************************************************************************************");
			System.out.println("    ");
			
			if(plist!=null)
			{
				System.out.println("ProductID         ProductName            Category              Brand             Price ");
				for(Product p: plist) {
					
					System.out.println("****************************************************************************************************************************************************************");
					System.out.println(p.getPid()+"         	"+p.getPname()+"         		"+p.getCategory()+"        		 "+ p.getBrand()+"        	"+p.getPrice()  );
				}
			}
			//message if list is empty
			else {
				System.out.println("-----------------------------------Store is Empty!!-----------------------------------");
			}
			break;
		case 4:
			System.out.println("Enter the product id to be searched:");
			pid = Integer.parseInt(br.readLine());
			
			productdao.search(pid);
			
			break;
		case 5:
			ulist = userdao.displayUsers();
			System.out.println("************************************************************************************************************************************************************************* ");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("                                 CUSTOMER DETAILS                                  ");
			System.out.println("    ");
			System.out.println("    ");
			System.out.println("*************************************************************************************************************************************************************************");
			System.out.println("    ");
			System.out.println("    ");
			if(ulist!=null)
			{
				System.out.println("ID         		Name           		Email              	Mobile     ");
				for(User ul: ulist) {
					
					System.out.println("****************************************************************************************************************************************************************");
					System.out.println(ul.getUserid()+"           "+ul.getName()+"           "+ul.getEmail()+"                "+ul.getMobile());
				}
			}
			//message if list is empty
			else {
				System.out.println("-----------------------------------NO CUSTOMERS!!-----------------------------------");
			}
			break;
	
		case 6:
			orderList = orderdao.getAllOrders();
			
			System.out.println("*********************************************************************************************************************************");
			System.out.println("                                                        Customer Order Details                                                   ");
			System.out.println(">>=============================================================================================================================<<");
			
			if(orderList!=null)
			{
				
				System.out.println("OrderID   Customer Name             Product ID           Price      Quantity ");
				for(Order o: orderList) {
					
					System.out.println("================================================================================================================================");
					System.out.println(o.getId()+"         "+o.getCustname()+"            "+      o.getPid()+"                 "+o.getPrice()+"          "+o.getQuantity());
				}
				System.out.println(">>=============================================================================================================================<<");
			}
			//message if no orders placed
			else 
			{
				System.out.println("-----------------------------------No Orders Placed!----------------------------------");
			}
			break;
		case 7:
			System.out.println("Enter the customer id to be deleted:");
			id = br.readLine();
			userdao.delete(id);
			break;
		/*
		 * case 8: System.out.println("Enter the order id to be deleted :"); String id =
		 * br.readLine(); orderdao.deleteOrder(id); break;
		 */
		case 8:
			System.out.println("*******************Thank you for visiting the store*********************************");
			System.exit(0);
			break;
		default:
			System.out.println("***********Invalid Choice ADMIN !*******");
		}
		
		}while(choice!=10);
}
}
