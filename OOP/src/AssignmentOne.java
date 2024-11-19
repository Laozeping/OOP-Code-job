import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignmentOne {

    public static void main(String[] args) {
        List<Appointment> appointments = new ArrayList<>();

        // Example Appointments
        appointments.add(new Appointment("Alice", "123-456-7890", LocalTime.of(10, 0), new GeneralPractitioner(1, "Jane Doe", "Dr.", "Cardiology", "General Practitioner")));
        appointments.add(new Appointment("Bob", "987-654-3210", LocalTime.of(14, 30), new OrthopedicPractitioner(4, "Bob Williams", "Mr.", "Physiotherapy", "Orthopedic Practitioner")));
        appointments.add(new Appointment("Charlie", "555-123-4567", LocalTime.of(11, 0), new GeneralPractitioner(2, "John Smith", "Dr.", "Pediatrics", "General Practitioner")));
        appointments.add(new Appointment("David", "111-222-3333", LocalTime.of(9, 0), new OrthopedicPractitioner(5, "Eva Brown", "Ms.", "Joint Replacement", "Orthopedic Practitioner")));

        Scanner scanner = new Scanner(System.in);

        // Print welcome message
        System.out.println("欢迎来到医疗预约系统，想进入医生基本信息查询请按1，想查询患者信息请按2，想查询当前患者信息请按3，想查询当前预约名单请按4，想取消当前预约请按5");

        int userChoice;
        if (args.length > 0) {
            try {
                userChoice = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("无效的命令行参数。");
                return;
            }
        } else {
            System.out.println("请使用命令行参数运行程序，例如：java AssignmentOne 1");
            return;
        }

        switch (userChoice) {
            case 1:
                displayDoctorInfo(appointments);
                break;
            case 2:
                displayPatientInfo(appointments);
                break;
            case 3:
                displayCurrentPatientInfo(appointments);
                break;
            case 4:
                displayExistingAppointments(appointments);
                break;
            case 5:
                cancelPatientAppointment(appointments, scanner);
                break;
            default:
                System.out.println("无效的选择。");
        }
        scanner.close();
    }

    private static void displayDoctorInfo(List<Appointment> appointments) {
        System.out.println("全科医生基本信息：");
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor() instanceof GeneralPractitioner) {
                ((GeneralPractitioner) appointment.getDoctor()).printDetails();
            }
        }
        System.out.println("------------------------------");
        System.out.println("骨科医生基本信息：");
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor() instanceof OrthopedicPractitioner) {
                ((OrthopedicPractitioner) appointment.getDoctor()).printDetails();
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

    private static void displayExistingAppointments(List<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("当前没有预约。");
            return;
        }
        for (Appointment appointment : appointments) {
            appointment.printDetails();
            System.out.println("--------------------");
        }
    }

    private static void cancelPatientAppointment(List<Appointment> appointments, Scanner scanner) {
        System.out.println("请输入您要删除的患者的手机号:");
        String patientMobile = scanner.nextLine();
        appointments.removeIf(appointment -> appointment.getMobile().equals(patientMobile)); // Efficient removal

        System.out.println("已成功删除" + patientMobile + "号码的患者，接下来是删除后的预约名单：");
        displayExistingAppointments(appointments);
    }
}