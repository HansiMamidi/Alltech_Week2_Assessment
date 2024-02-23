	import java.util.Date;
	
	public class Appointment {
		private Date appDate;
		private int noOfPatients;
		public Appointment(Date appDate, int noOfPatients) {
			super();
			this.appDate = appDate;
			this.noOfPatients = noOfPatients;
		}
	
		public Appointment() {
			// TODO Auto-generated constructor stub
		}

		public Date getAppDate() {
			return appDate;
		}
		public void setAppDate(Date appDate) {
			this.appDate = appDate;
		}
		public int getNoOfPatients() {
			return noOfPatients;
		}
		public void setNoOfPatients(int noOfPatients) throws InvalidDataException {
			if(noOfPatients<1 || noOfPatients>15) {
				throw new InvalidDataException("No.of patients should vary between 1 to 15");
			}
			this.noOfPatients = noOfPatients;
		}
		
	
	}
