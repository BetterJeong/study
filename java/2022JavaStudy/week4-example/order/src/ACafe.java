import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ACafe implements Cafe {

    // 커피만 주문 가능

    @Override
    public void go() throws InterruptedException {
        System.out.println("안녕하세요~ A 카페에 오신 걸 환영합니다 ^_^");
        run();
    }

    @Override
    public Order order(int orderNum) {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        Drink drink = new Coffee();

        System.out.print("주문자 성함을 말씀해주세요 >> ");
        person.setName(sc.next());
        System.out.println("A 카페는 커피만 주문 가능합니다.");
        System.out.print("주문하실 메뉴를 말씀해주세요 >> ");
        drink.setName(sc.next());
        System.out.print("사이즈는 어떻게 하시겠어요? (TALL, GRANDE, VENTI) >> ");
        String size = sc.next();
        if (size.equals("TALL")) { drink.setSize(Size.TALL); }
        else if (size.equals("GRANDE")) { drink.setSize(Size.GRANDE); }
        else if (size.equals("VENTI")) { drink.setSize(Size.VENTI); }

        return new Order(orderNum, person, drink);
    }

    @Override
    public int selectOption() {
        return Cafe.super.selectOption();
    }

    @Override
    public void makeCoffee() throws InterruptedException {
        Cafe.super.makeCoffee();
    }

}
