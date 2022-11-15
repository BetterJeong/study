public class WheatBread extends Toast {
    @Override
    public void addTopping(ToppingDecorator toppingDecorator) {
        super.name.append("호밀식빵 토스트");
        super.kcal += 250;
    }
}
