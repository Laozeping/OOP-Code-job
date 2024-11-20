
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignmentOne {
    public static void main(String[] args) {
        List<HealthProfessional> doctors = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();

        // Part 3-Using classes and objects

        doctors.add(new GeneralPractitioner(1, "Jane Doe", "Dr.", "Cardiology"));
        doctors.add(new OrthopedicPractitioner(4, "Bob Williams", "Mr.", "Physiotherapy"));
        doctors.add(new GeneralPractitioner(2, "John Smith", "Dr.", "Pediatrics"));
        doctors.add(new OrthopedicPractitioner(5, "Eva Brown", "Ms.", "Joint Replacement"));
        doctors.add(new GeneralPractitioner(3, "Alex Johnson", "Dr.", "Cardiology"));

        // Part 5 – Collection of appointments
        appointments.add(new Appointment("Lihua", "139-456-7890", LocalTime.of(10, 0), doctors.get(0)));
        appointments.add(new Appointment("Kuli", "187-654-3210", LocalTime.of(14, 30), doctors.get(1)));
        appointments.add(new Appointment("Moyan", "155-123-8767", LocalTime.of(11, 0), doctors.get(2)));
        appointments.add(new Appointment("Pingjing", "189-223-3453", LocalTime.of(9, 0), doctors.get(3)));
        appointments.add(new Appointment("Waner", "177-238-5009", LocalTime.of(13, 0), doctors.get(4)));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to use the medical appointment system.");
        System.out.println("To access the doctor's basic information, please press 1.");
        System.out.println("To access patient information, please press 2.");
        System.out.println("To access the current patient information, please press 3.");
        System.out.println("To access the current appointment list, please press 4.");
        System.out.println("To cancel your current appointment, please press 5.");
        System.out.print("Please enter your selection.(1，2，3，4，5): 例如：java AssignmentOne 1");

        int userChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (userChoice) {
            case 1:
                displayDoctorInfo(doctors);
                break;
            case 2:
                displayPatientInfo(appointments);
                break;
            case 3:
                displayCurrentPatientInfo(appointments);
                break;
            case 4:
                printExistingAppointments(appointments);
                break;
            case 5:
                cancelBooking(appointments, scanner);
                break;
            default:
                System.out.println("An invalid choice.");
        }
        scanner.close();
    }

    private static void displayDoctorInfo(List<HealthProfessional> doctors) {
        System.out.println("General Practitioner Basic Information:");
        for (HealthProfessional doctor : doctors) {
            if (doctor instanceof GeneralPractitioner) {
                ((GeneralPractitioner) doctor).printDetails();
            }
        }
        System.out.println("------------------------------");
        System.out.println("Basic Information of Orthopedic Surgeon:");
        for (HealthProfessional doctor : doctors) {
            if (doctor instanceof OrthopedicPractitioner) {
                ((OrthopedicPractitioner) doctor).printDetails();
            }
        }
    }

    private static void displayPatientInfo(List<Appointment> appointments) {
        System.out.println("Patient Basic Information:");
        for (Appointment appointment : appointments) {
            System.out.println("Patient Name: " + appointment.getPatientName());
            System.out.println("Mobile: " + appointment.getMobile());
            System.out.println("------------------------------");
        }
    }

    private static void displayCurrentPatientInfo(List<Appointment> appointments) {
        System.out.println("Current Patient Information:");
        for (Appointment appointment : appointments) {
            System.out.println("Patient Name: " + appointment.getPatientName());
            System.out.println("Mobile: " + appointment.getMobile());
            System.out.println("Time: " + appointment.getTime());
            System.out.println("Doctor: " + appointment.getDoctor().getName());
            System.out.println("--------------------");
        }
    }

    private static void printExistingAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("There are no appointments at the moment.");
            return;
        }
        for (Appointment appointment : appointments) {
            appointment.printDetails();
        }
    }

    private static void cancelBooking(List<Appointment> appointments, Scanner scanner) {
        System.out.println("Please enter the mobile number of the patient you want to delete:");
        String patientMobile = scanner.nextLine();
        appointments.removeIf(appointment -> appointment.getMobile().equals(patientMobile)); // Efficient removal

        System.out.println("The deletion has been successfully completed." + patientMobile + "The patient's number, followed by the appointment list after deletion:");
        printExistingAppointments(appointments);
    }
}