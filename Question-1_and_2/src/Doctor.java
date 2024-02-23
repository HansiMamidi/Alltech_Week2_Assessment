import java.util.ArrayList;

public class Doctor {

	private String docId;
	private String docName;
	private ArrayList<Appointment> apptList;
	
	
	public Doctor(String docId, String docName) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.apptList = new ArrayList<>();
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public ArrayList<Appointment> getApptList() {
		return apptList;
	}
	public void setApptList(ArrayList<Appointment> apptList) {
		this.apptList = apptList;
	}
	
	public void addAppointment(Appointment appointment) {
		apptList.add(appointment);
		
	}
	
	public void printAppointment() {
		for (Appointment appointment : apptList) {
            System.out.println("Appointment Date: " + appointment.getAppDate() +
                    ", No. of Patients: " + appointment.getNoOfPatients());
        }
	}

}
