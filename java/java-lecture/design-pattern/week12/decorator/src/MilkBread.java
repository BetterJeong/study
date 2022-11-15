public class MilkBread extends Toast {

    @Override
    public void addTopping(ToppingDecorator toppingDecorator) {
        super.name.append("우유식빵 토스트");
        super.kcal += 350;
    }
}

