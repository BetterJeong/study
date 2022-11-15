public class ButterBread extends Toast {

    @Override
    public void addTopping(ToppingDecorator toppingDecorator) {
        super.name.append("버터식빵 토스트");
        super.kcal += 400;
    }

}
