public class ToppingDecorator extends Toast {
    private Toast decoratedToast;

    public ToppingDecorator() {
    }

    @Override
    public void addTopping(ToppingDecorator toppingDecorator) {
        decoratedToast.addTopping(toppingDecorator);
    }
}
