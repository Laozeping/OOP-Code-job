public class OrthopedicPractitioner extends HealthProfessional {
    private String specialityArea;

    public OrthopedicPractitioner(int ID, String name, String title, String specialty, String specialityArea) {
        super(ID, name, title, specialty);
        this.specialityArea = specialityArea;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Speciality Area: " + specialityArea);
        System.out.println("Type: Orthopedic Practitioner");
    }

    public OrthopedicPractitioner(String name) {
        super(name);
    }
}