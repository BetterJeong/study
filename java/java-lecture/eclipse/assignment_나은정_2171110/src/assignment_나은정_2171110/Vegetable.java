package assignment_나은정_2171110;

public class Vegetable extends ToppingDecorator{

    @Override
    public String Name() {
        return "야채";
    }

    @Override
    public int Kcal() {
        return 10;
    }
}
