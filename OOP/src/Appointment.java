import java.time.LocalTime;

public class Appointment {
    private String patientName;
    private String mobile;
    private LocalTime time;
    private HealthProfessional doctor;

    public Appointment(String patientName, String mobile, LocalTime time, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.time = time;
        this.doctor = doctor;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalTime getTime() {
        return time;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time: " + time);
        System.out.println("Doctor: " + doctor.getName());
    }
}