import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Jane Doe", "Dr.", "Cardiology");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "John Smith", "Dr.", "Pediatrics");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Alice Johnson", "Dr.", "Family Medicine");
        OrthopedicPractitioner op1 = new OrthopedicPractitioner(4, "Bob Williams", "Mr.", "Physiotherapy"); // Changed to OrthopedicPractitioner
        OrthopedicPractitioner op2 = new OrthopedicPractitioner(5, "Eva Brown", "Ms.", "Joint Replacement"); //Changed to OrthopedicPractitioner


        gp1.printDetails();
        System.out.println("--------------------");
        gp2.printDetails();
        System.out.println("--------------------");
        gp3.printDetails();
        System.out.println("--------------------");
        op1.printDetails();
        System.out.println("--------------------");
        op2.printDetails();
        System.out.println("--------------------");


        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        List<Appointment> appointments = new ArrayList<>();

        appointments.add(new Appointment("Alice", "123-456-7890", LocalTime.of(10, 0), gp1));
        appointments.add(new Appointment("Bob", "987-654-3210", LocalTime.of(14, 30), op1)); //Changed to op1
        appointments.add(new Appointment("Charlie", "555-123-4567", LocalTime.of(11, 0), gp2));
        appointments.add(new Appointment("David", "111-222-3333", LocalTime.of(9, 0), op2)); //Changed to op2


        printExistingAppointments(appointments);
        System.out.println("--------------------");

        cancelBooking(appointments, "987-654-3210");

        System.out.println("--------------------");

        printExistingAppointments(appointments);

        System.out.println("------------------------------");

    }

    static void printExistingAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printDetails();
                System.out.println("--------------------");
            }
        }
    }

    static void cancelBooking(List<Appointment> appointments, String mobile) {
        appointments.removeIf(appointment -> appointment.getMobile().equals(mobile));
    }
}