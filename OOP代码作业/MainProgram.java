public class MainProgram {
    public static void main(String[] args) {
        GeneralPractitioner gp = new GeneralPractitioner(1, "Dr. John", "General Physician", "Family Medicine");
        AnotherHealthProfessional ahp = new AnotherHealthProfessional(2, "Dr. Smith", "Specialist Dietitian", "Nutrition");
        Appointment appointment = new Appointment("Jane Doe", "555-1234", "09:00", gp);

        gp.printDetails();
        ahp.printDetails();
        appointment.printDetails();
    }

    // Your additional methods here
}

class HealthProfessional {
    private final int ID;
    private final String name;
    private final String basicInfo;

    public HealthProfessional(int ID, String name, String basicInfo) {
        this.ID = ID;
        this.name = name;
        this.basicInfo = basicInfo;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Basic Info: " + basicInfo);
    }
}

class GeneralPractitioner extends HealthProfessional {
    private final String specialization;

    public GeneralPractitioner(int ID, String name, String basicInfo, String specialization) {
        super(ID, name, basicInfo);
        this.specialization = specialization;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialization: " + specialization);
    }
}

class AnotherHealthProfessional extends HealthProfessional {
    private final String category;

    public AnotherHealthProfessional(int ID, String name, String basicInfo, String category) {
        super(ID, name, basicInfo);
        this.category = category;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Category: " + category);
    }
}

class Appointment {
    private final String patientName;
    private final String mobilePhone;
    private final String timeSlot;
    private final HealthProfessional doctor;

    public Appointment(String patientName, String mobilePhone, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobilePhone = mobilePhone;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile Phone: " + mobilePhone);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Doctor: ");
        doctor.printDetails();
    }
}