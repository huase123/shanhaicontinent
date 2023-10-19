import java.util.Random;

public class TestDemo {
    public static void main(String[] args) {
        int age = 1;
        float v = new Random().nextFloat();
        for (int i = 0; i < 20; i++) {
            age += i*i*i/10;
            System.out.println(age);
        }
    }
}
