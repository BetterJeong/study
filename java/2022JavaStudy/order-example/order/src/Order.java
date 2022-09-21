public class Order {

    private int orderId;
    private Person person;
    private Drink drink;

    public Order() {
        orderId = 0;
        person = null;
        drink = null;
    }

    public Order(int orderId, Person person, Drink drink) {
        this.orderId = orderId;
        this.person = person;
        this.drink = drink;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return orderId + "번 "
                + person.getName() + "님 주문하신 "
                + drink.getName() + " 나왔습니다~";
    }
}
