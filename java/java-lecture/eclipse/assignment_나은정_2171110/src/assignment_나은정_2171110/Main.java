package assignment_나은정_2171110;

public class Main {
    public static void main(String args[]) {
        Toast toast1 = new NormalBread();
        toast1.addTopping(new Cheese());
        toast1.addTopping(new Ham());
        toast1.serve();
        Toast toast2 = new WheatBread();
        toast2.addTopping(new Vegetable());
        toast2.addTopping(new Egg());
        toast2.serve();
        Toast toast3 = new ButterBread();
        toast3.addTopping(new Ham());
        toast3.addTopping(new Ham());
        toast3.addTopping(new Ham());
        toast3.serve();
    }
}