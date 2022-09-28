public class FruitSeller {

    private final int APPLE_UNIT_COST = 1000;
    private int numOfApple = 20;
    private int money;

    public int saleApple(int money) {
        int num = money / APPLE_UNIT_COST;
        numOfApple -= num;
        money += money;
        return num;
    }

    public void showResult() {
        System.out.println("남은 사과: "+numOfApple+"개");
        System.out.println("판매 수익: "+money+"원");
    }

}
