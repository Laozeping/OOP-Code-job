public class OrthopedicPractitioner extends HealthProfessional {
    private final String specialityArea;

    public OrthopedicPractitioner(int ID, String name, String title, String specialityArea) {
        super(ID, name, title);
        this.specialityArea = specialityArea;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Speciality Area: " + specialityArea);
        System.out.println("Type: Orthopedic Practitioner");
    }
}