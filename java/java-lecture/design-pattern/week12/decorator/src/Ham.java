public class Ham extends ToppingDecorator {

    @Override
    public String Name() {
        return "햄";
    }

    @Override
    public int Kcal() {
        return 200;
    }
}
