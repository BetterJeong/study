import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(11);
            System.out.println("랜덤 생성된 값");
            System.out.println("index "+i+": "+arr[i]);
        }
        System.out.println();

        while(true) {
            System.out.print("숫자 n을 입력해주세요: ");
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("숫자 m을 입력해주세요: ");
            int m = Integer.parseInt(br.readLine());

            int q = 0;
            int r = 0;

            try {
                System.out.println("arr[n]: "+arr[n]+", arr[m]: "+arr[m]);
                q = arr[n] / arr[m];
                r = arr[n] % arr[m];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("0부터 9까지의 수로 다시 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            }

            System.out.println("몫: "+q+", 나머지: "+r);
            System.out.println();
        }
    }
}