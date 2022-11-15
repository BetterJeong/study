public class NormalBread extends Toast {

    @Override
    public void addTopping(ToppingDecorator toppingDecorator) {
        super.name.append("식빵 토스트");
        super.kcal += 300;
    }
}
