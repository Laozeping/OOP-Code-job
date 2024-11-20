
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

        System.out.println("欢迎使用医疗预约系统。要访问医生的基本信息，请按1。要访问患者信息，请按2。要访问当前患者信息，请按3。要访问当前预约列表，请按4。要取消当前预约，请按5。");
        System.out.print("请输入您的选择 (1，2，3，4，5):例如：java AssignmentOne 1");

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
                System.out.println("无效的选择。");
        }
        scanner.close();
    }

    private static void displayDoctorInfo(List<HealthProfessional> doctors) {
        System.out.println("全科医生基本信息：");
        for (HealthProfessional doctor : doctors) {
            if (doctor instanceof GeneralPractitioner) {
                ((GeneralPractitioner) doctor).printDetails();
            }
        }
        System.out.println("------------------------------");
        System.out.println("骨科医生基本信息：");
        for (HealthProfessional doctor : doctors) {
            if (doctor instanceof OrthopedicPractitioner) {
                ((OrthopedicPractitioner) doctor).printDetails();
            }
        }
    }

    private static void displayPatientInfo(List<Appointment> appointments) {
        System.out.println("患者基本信息：");
        for (Appointment appointment : appointments) {
            System.out.println("Patient Name: " + appointment.getPatientName());
            System.out.println("Mobile: " + appointment.getMobile());
            System.out.println("------------------------------");
        }
    }

    private static void displayCurrentPatientInfo(List<Appointment> appointments) {
        System.out.println("当前患者信息：");
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
            System.out.println("当前没有预约。");
            return;
        }
        for (Appointment appointment : appointments) {
            appointment.printDetails();
        }
    }

    private static void cancelBooking(List<Appointment> appointments, Scanner scanner) {
        System.out.println("请输入您要删除的患者的手机号:");
        String patientMobile = scanner.nextLine();
        appointments.removeIf(appointment -> appointment.getMobile().equals(patientMobile)); // Efficient removal

        System.out.println("已成功删除" + patientMobile + "号码的患者，接下来是删除后的预约名单：");
        printExistingAppointments(appointments);
    }
}