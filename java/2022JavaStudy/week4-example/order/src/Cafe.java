import java.util.Scanner;

import static java.lang.Thread.sleep;

public interface Cafe {

    void go() throws InterruptedException;
    Order order(int orderNum);

    default void run() throws InterruptedException {
        boolean b = true;
        int orderNum = 0;

        while (b) {
            int selectOption = selectOption();

            if (selectOption == 1) {
                Order order = order(++orderNum);
                makeCoffee();
                System.out.println(order);
            }
            else if (selectOption == 2){
                System.out.println("이용해주셔서 감사합니다~");
                b = false;
            }
            else {
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    default int selectOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("1. 주문하기");
        System.out.println("2. 종료하기");
        System.out.println("---------------");
        System.out.print("어떻게 하시겠어요? >> ");
        return sc.nextInt();
    }

    default void makeCoffee() throws InterruptedException {
        System.out.println("음료를 만들고 있어요.");
        for (int i = 3; i > 0; i--) {
            System.out.println(i+"초...");
            sleep(1000);
        }
    }

}
