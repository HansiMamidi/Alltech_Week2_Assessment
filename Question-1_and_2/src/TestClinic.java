import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestClinic {
    public static void main(String[] args) throws InvalidDataException {
        Doctor[] doctors = new Doctor[2];
        Scanner sc = new Scanner(System.in);
        int noOfPatients;
        Date date = null;

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter Doctor ID: ");
            String docId = sc.next();
            System.out.println("Enter Doctor Name: ");
            String docName = sc.next();
            Doctor doctor = new Doctor(docId, docName);

            for (int j = 0; j < 2; j++) {
                Appointment appointment = new Appointment();
                while (true) {
                    System.out.println("Enter the appointment date " + (j + 1) + ": ");
                    String dateString = sc.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        date = dateFormat.parse(dateString);
                        System.out.println("Parsed date: " + date);
                        break;  
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                    }
                }

                while (true) {
                    System.out.println("Enter the no. of patients: ");
                    try {
                        noOfPatients = sc.nextInt();
                        appointment.setAppDate(date);
                        appointment.setNoOfPatients(noOfPatients);
                        break;
                    } catch (InvalidDataException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        sc.nextLine(); // Consume the invalid input
                    }
                }
                doctor.addAppointment(appointment);
            }
            doctors[i] = doctor;
        }

        for (Doctor doctor : doctors) {
            System.out.println("Doctor ID: " + doctor.getDocId() +
                    ", Doctor Name: " + doctor.getDocName());
            doctor.printAppointment();
        }

        System.out.println("Enter a Doctor ID to search for details: ");
        String doctorId = sc.next();

        boolean found = false;
        for (Doctor doctor : doctors) {
            if (doctor.getDocId().equals(doctorId)) {
                doctor.printAppointment();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Doctor ID does not exist");
        }

        sc.close();
    }
}