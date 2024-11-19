public class GeneralPractitioner extends HealthProfessional {
    private String specialityArea;

    public GeneralPractitioner(int ID, String name, String title, String specialty, String specialityArea) {
        super(ID, name, title, specialty);
        this.specialityArea = specialityArea; //
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Speciality Area: " + specialityArea);
        System.out.println("Type: General Practitioner");
    }

    public GeneralPractitioner(String name) {
        super(name);
    }
}