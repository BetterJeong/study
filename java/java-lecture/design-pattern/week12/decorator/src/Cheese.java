public class Cheese extends ToppingDecorator{

    @Override
    public String Name() {
        return "치즈";
    }

    @Override
    public int Kcal() {
        return 50;
    }
}
