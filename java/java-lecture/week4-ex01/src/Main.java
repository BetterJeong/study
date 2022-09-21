import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Point leftTop = new Point();
        Point rightBottom = new Point();

        System.out.print("left-top 의 x 값 >> ");
        leftTop.setX(sc.nextInt());
        System.out.print("left-top 의 y 값 >> ");
        leftTop.setY(sc.nextInt());

        System.out.print("right-bottom 의 x 값 >> ");
        rightBottom.setX(sc.nextInt());
        System.out.print("right-bottom 의 y 값 >> ");
        rightBottom.setY(sc.nextInt());

        Rectangle rectangle = new Rectangle(leftTop, rightBottom);

        System.out.println("직사각형의 넓이: " + rectangle.getArea());
        System.out.println("직사각형의 둘레: " + rectangle.getRound());

    }
}