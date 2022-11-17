public class Toast {

    StringBuffer name;
    int kcal;

    public Toast() {
        this.name = new StringBuffer();
        this.kcal = 0;
    }

    public void addTopping(ToppingDecorator toppingDecorator) {
        addName(toppingDecorator.Name());
        addKcal(toppingDecorator.Kcal());
    }

    protected void addName(String name) {
        this.name.insert(0, name);
    }

    protected void addKcal(int kcal) {
        this.kcal += kcal;
    }

    public void serve() {
        System.out.println("주문한 토스트 : "+name);
        System.out.println("칼로리 : "+kcal+"Kcal");
        System.out.println();
    }
}
