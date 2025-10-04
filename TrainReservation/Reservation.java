package TrainReservation;

import java.util.List;

import java.util.*;

public class Reservation {
	public List<Train>trains = new ArrayList<>();
	public Map<String,User>users = new HashMap<>();
	public Map<String,List<Train>>bookings = new HashMap<>();
	
	public void addTrain(Train train) {
		trains.add(train);
	}
	
	public void registerUser(String username , String password) {
		users.put(username, new User(username,password));
		System.out.println("User registersd successfully.");
		
	}
	
	public boolean login(String username,String password) {
		if(users.containsKey(username) && users.get(username).password.equals(password)) {
			return true;
		}
		
		return false;
	}
	
	public void showTrains() {
		for(Train train : trains) {
			train.displayTrain();
			}
		}
	
	public void bookTrain(String username,int trainNumber) {
		for(Train train : trains) {
			if(train.trainNumber == trainNumber && train.seatsAvailable>0) {
				train.seatsAvailable--;
				bookings.computeIfAbsent(username, k -> new ArrayList<>()).add(train);
				System.out.println("Ticket booked for train:" + train.trainName);
				return;
				
			}
		}
		
		System.out.println("Train not available or full.");
	}
	
	public void viewBookings(String username) {
		List<Train>userBookings = bookings.get(username);
		if(userBookings == null || userBookings.isEmpty()) {
			System.out.println("No bookings found.");
		}else {
			for(Train train : userBookings) {
				train.displayTrain();
				
			}
		}
	}
	
	public void cancelBooking(String username,int trainNumber) {
		List<Train>userBookings = bookings.get(username);
		if(userBookings != null) {
			Iterator<Train>iterator = userBookings.iterator();
			while(iterator.hasNext()) {
				Train t = iterator.next();
				if(t.trainNumber == trainNumber ) {
					t.seatsAvailable++;
					iterator.remove();
					System.out.println("Booking cancelled for Train:"+t.trainName);
					return;
				}
			}
			
		}
		System.out.println("No such booking found.");
	}
}
