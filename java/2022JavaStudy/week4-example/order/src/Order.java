public class Order {

    private int num;
    private Person person;
    private Drink drink;

    public Order(int num, Person person, Drink drink) {
        this.num = num;
        this.person = person;
        this.drink = drink;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
        return person.getName() + "님, 주문하신 " + drink.getName() + " 나왔습니다!\n주문번호: " + num;
    }
}
