public class Rectangle {

    private Point leftTop;
    private Point rightBottom;
    private int width;
    private int height;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = leftTop.getY() - rightBottom.getY();
    }

    public int getArea() {
        return width * height;
    }

    public int getRound() {
        return (width + height) * 2;
    }
}
