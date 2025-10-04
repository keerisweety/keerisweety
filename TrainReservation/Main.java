package TrainReservation;
import java.sql.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/trainReservation";
		String usern = "root";
		String sec = "root123";
		Connection con = DriverManager.getConnection(url,usern,sec);
		Scanner sc= new Scanner(System.in);
		Reservation system = new Reservation();
		system.addTrain(new Train (101, "Express A", "City A","City B",5));
		system.addTrain(new Train (102, "Express B", "City B","City C",3));
		String username = null;
		
		while (true) {
			System.out.println("\n--Train Reservation System--");
			System.out.println("1.Reggiter\n2.Login\n3.Exit");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Enter username:");
				String uname = sc.nextLine();
				System.out.print("Enter password:");
				String pass = sc.nextLine();
				system.registerUser(uname, pass);
				break;
				
			case 2:
				System.out.print("Username:");
				uname = sc.nextLine();
				System.out.print("Password:");
				pass = sc.nextLine();
				if(system.login(uname, pass)) {
					username = uname;
					System.out.println("Login successful!");
					boolean loggedln = true;
					while(loggedln) {
						System.out.println("\n1.View Trains\n2.Book Ticket\n3.View Bookings\n4.Cancel Ticket\n5.Logout");
						int opt = sc.nextInt();
						switch(opt) {
						case 1:
							system.showTrains();
							break;
						case 2:
							System.out.print("Enter Train Number to book:");
							int tnum = sc.nextInt();
							system.bookTrain(uname, tnum);
							break;
						case 3:
							system.viewBookings(username);
							break;
						case 4:
							System.out.print("Enter Train Number to cancel:");
							int cancelNum = sc.nextInt();
							system.cancelBooking(username, cancelNum);
							break;
						case 5:
							loggedln = false;
							break;
							
						}
					}
				}else {
					System.out.println("Invalid credentials.");
				}
				break;
				
			case 3:
				System.out.println("Existing system...");
				System.exit(0);
			}
		}
		
	}

}
