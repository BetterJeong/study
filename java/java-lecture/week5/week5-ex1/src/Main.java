public class Main {
    public static void main(String[] args) {

        FruitSeller fruitSeller = new FruitSeller();
        FruitBuyer fruitBuyer = new FruitBuyer();

        fruitBuyer.buyApple(fruitSeller, 2000);
        fruitSeller.showResult();
        fruitBuyer.showResult();

    }
}