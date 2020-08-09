package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import buisnessLogic.RegistrationProcess;
import buisnessLogic.Validation;
import model.User;
import model.LoginUser;

public class Main {
static int choice;
static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
static String name,email,mobile,password,id;
static String custEmail,custPassword;
static User user = new User();
static RegistrationProcess reg = new RegistrationProcess();
static Validation valid = new Validation();
static CustomerController cc = new CustomerController();
static LoginUser loginuser = new LoginUser();
static String username,pass;
static AdminController ac = new AdminController();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LocalDateTime mydateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		
		System.out.println("**************************************************************************");
		System.out.println("             ");
		System.out.println("---------------WELCOME TO INVENTORY MANAGEMENT SYSTEM-------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("---------------Today's Date and Current Time is: "+ mydateObj.format(myFormatObj)+"--------");
		System.out.println("             ");
		System.out.println("***************************************************************************");
		do {
		System.out.println(" ");
		System.out.println("Choose the following:");
		System.out.println("             ");
		System.out.println("             ");
		System.out.println("1. REGISTRATION");
		System.out.println("             ");
		System.out.println("2. LOGIN");
		System.out.println("             ");
		System.out.println("3. ADMIN");
		System.out.println("             ");
		System.out.println("4. EXIT");
		System.out.println("                     ");
		System.out.println("                  ");
		System.out.println("Select the required option:");
		choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			
			System.out.println("Enter your name :");
			name = br.readLine();
			System.out.println("Enter your email id:");
			email = br.readLine();
			System.out.println("Enter mobile number:");
			mobile = br.readLine();
			System.out.println("Enter password:");
			password = br.readLine();
			
			
			user.setName(name);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setPassword(password);		
			
			if(!reg.checksignUp(user)) {
				System.out.println("             ");
				System.out.println("Invalid Email and Password");
			}else {
				reg.register(user);
				System.out.println("             ");
				System.out.println("              ");
				//System.out.println("REGISTRATION SUCCESSFUL!");
			}
			break;
		case 2:
			System.out.println("             ");
			System.out.println("             ");
			System.out.println("**********************CUSTOMER LOGIN*******************************");
			System.out.println( "Enter email id:");
			custEmail = br.readLine();
			System.out.println("Enter password:");
			custPassword = br.readLine();
			
			loginuser.setEmail(custEmail);
			loginuser.setPassword(custPassword);
			
			if(valid.checkUser(loginuser)==true) {
				System.out.println("             ");
				System.out.println("             ");
				System.out.println("******************LOGIN SUCCESSFUL*****************************");
				cc.customer();// cutsomer controller function.
				
			}else {
				System.out.println("             ");
				System.out.println("             ");
				System.out.println("******************INVALID CREDENTAILS***********************");
			}
			break;
		case 3:
			System.out.println("Enter username : ");
			username = br.readLine();
			System.out.println("Enter password:");
			pass = br.readLine();
			loginuser.setEmail(username);
			loginuser.setPassword(pass);
			if(valid.checkAdmin(loginuser)==true) {
				System.out.println("             ");
				System.out.println("************************ADMIN LOGIN SUCCESSS*******************************************");
				ac.admin();// admin controller function
			}else {
				System.out.println("*************************INVALID CREDENTIALS FOR ADMIN LOGIN********************************");
				
			}
			break;
		case 4:
			System.out.println("********************************Thank you for Visiting the Store*****************");
			System.exit(0);
			break;
		default:
			System.out.println("Inavlid Choice");
			
		}
		}while(choice!=5);
		
	}

}
