public class Egg extends ToppingDecorator{

    @Override
    public String Name() {
        return "달걀";
    }

    @Override
    public int Kcal() {
        return 100;
    }
}
