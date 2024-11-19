
public class HealthProfessional {
    private int ID;
    private final String name;
    private String title;
    private String specialty;

    public HealthProfessional(int ID, String name, String title, String specialty) {
        this.ID = ID;
        this.name = name;
        this.title = title;
        this.specialty = specialty;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
        System.out.println("Specialty: " + specialty);
    }

    public HealthProfessional(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}