import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Point leftTop = new Point();
        Point rightBottom = new Point();

        System.out.print("left-top 의 x, y 값 >> ");
        leftTop.setXY(sc.nextInt(), sc.nextInt());

        System.out.print("right-bottom 의 x, y 값 >> ");
        rightBottom.setXY(sc.nextInt(), sc.nextInt());

        Rectangle rectangle = new Rectangle(leftTop, rightBottom);

        rectangle.show();
    }
}