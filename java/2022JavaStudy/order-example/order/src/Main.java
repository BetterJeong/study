import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean b = true;
        Scanner sc = new Scanner(System.in);
        int orderNum = 0;

        System.out.println("안녕하세요~ 난정 카페에 오신 걸 환영합니다 ^_^");

        while (b) {
            System.out.println("---------------");
            System.out.println("1. 주문하기");
            System.out.println("2. 종료하기");
            System.out.println("---------------");
            System.out.print("어떻게 하시겠어요? >> ");
            int n = sc.nextInt();

            if (n == 1) {
                Order order = new Order();
                Person person = new Person();
                Drink drink = new Drink();

                orderNum++;
                System.out.print("주문자 성함을 말씀해주세요 >> ");
                person.setName(sc.next());
                System.out.print("주문하실 메뉴를 말씀해주세요 >> ");
                drink.setName(sc.next());

                order.setOrderId(orderNum);
                order.setPerson(person);
                order.setDrink(drink);

                for (int i = 3; i > 0; i--) {
                    System.out.println(i + "...");
                    sleep(1000);
                }

                System.out.println(order);
            }
            else if (n == 2) {
                System.out.println("이용해주셔서 감사합니다~");
                b = false;
            }
            else {
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}