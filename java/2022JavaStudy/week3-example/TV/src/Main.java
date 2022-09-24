import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("TV 이름을 입력해주세요 >> ");
        TV tv = new TV(sc.next());

        tv.upChannel();
        tv.power();
        tv.downChannel();
        tv.upChannel();
        tv.upVolume();
        tv.downVolume();
        tv.power();
    }
}