public class HealthProfessional {
    private final int ID;
    private final String name;
    private final String title;

    public HealthProfessional(int ID, String name, String title) {
        this.ID = ID;
        this.name = name;
        this.title = title;
    }

    public void printDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
    }
}