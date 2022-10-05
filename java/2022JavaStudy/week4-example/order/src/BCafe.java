import java.util.Scanner;

public class BCafe implements Cafe {

    // 커피 + 에이드 주문 가능

    @Override
    public void go() throws InterruptedException {
        System.out.println("안녕하세요~ B 카페에 오신 걸 환영합니다 ^_^");
        run();
    }

    @Override
    public Order order(int orderNum) {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        Drink drink = null;

        System.out.print("주문자 성함을 말씀해주세요 >> ");
        person.setName(sc.next());
        System.out.println("B 카페는 커피와 에이드를 주문 가능합니다.");
        System.out.print("커피와 에이드 중 어떤걸 주문하시겠어요? (커피, 에이드) >> ");
        String type = sc.next();
        if (type.equals("커피")) { drink = new Coffee(); }
        else if (type.equals("에이드")) { drink = new Ade(); }
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
