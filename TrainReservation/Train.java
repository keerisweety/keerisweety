package TrainReservation;

public class Train {
		public int trainNumber;
		public String trainName;
		public String from;
		public String to;
		public int seatsAvailable;
		
		public Train(int trainnumber , String trainName , String from , String to , int seatsAvailable) {
			this.trainNumber = trainNumber;
			this.trainName = trainName;
			this.from = from;
			this.to = to;
			this.seatsAvailable = seatsAvailable;
		
	}
		
		public void displayTrain() {
			System.out.println(trainNumber +"-" + trainName + "|From:" + from + "To:" + to + "|Seats:" + seatsAvailable);
			
		}

}
