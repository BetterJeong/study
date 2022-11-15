public abstract class Toast {

    StringBuffer name;
    int kcal;

    public Toast() {
        this.name = new StringBuffer();
        this.kcal = 0;
    }

    public abstract void addTopping(ToppingDecorator toppingDecorator);

    private void addName(String name) {
        this.name.append(name);
    }

    private void addKcal(int kcal) {
        this.kcal += kcal;
    }

    public void serve() {
    }
}
