package assignment_나은정_2171110;

public class Toast {

    StringBuffer name;
    int kcal;

    public Toast() {
        this.name = new StringBuffer();
        this.kcal = 0;
    }
    
    public void serve() {
    	getName();
    	getKcal();
        System.out.println();
    }

    private void getName() {
    	System.out.println("주문한 토스트 : "+name);
    }
    
    private void getKcal() {
    	System.out.println("칼로리 : "+kcal+"Kcal");
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


}
