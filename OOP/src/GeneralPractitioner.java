public class GeneralPractitioner extends HealthProfessional {
    private String specialityArea; // 声明 specialityArea 变量

    public GeneralPractitioner(int ID, String name, String title, String specialty, String specialityArea) {
        super(ID, name, title, specialty);
        this.specialityArea = specialityArea; // 初始化 specialityArea 变量
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Speciality Area: " + specialityArea); // 使用 specialityArea 变量
        System.out.println("Type: General Practitioner");
    }

    public GeneralPractitioner(String name) {
        super(name); // 调用父类构造函数
    }
}