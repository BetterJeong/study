import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Cafe cafe;

        System.out.print("A 카페를 갈까, B 카페를 갈까? >> ");
        String answer = sc.next();
        if (answer.equals("A")) {
            cafe = new ACafe();
        }
        else {
            cafe = new BCafe();
        }
        cafe.go();
    }
}