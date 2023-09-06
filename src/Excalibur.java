public class Excalibur {
    private String name;
    private static final Excalibur instance = new Excalibur("Sword");

    public static Excalibur getInstance() {
        return instance;
    }

    private Excalibur(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public static void main(String[] args)  {
        System.out.println(Excalibur.getInstance().getName());
    }
}
