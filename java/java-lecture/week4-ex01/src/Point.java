public class Point {

    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void show() {
        System.out.println("("+x+","+y+")");
    }

}
