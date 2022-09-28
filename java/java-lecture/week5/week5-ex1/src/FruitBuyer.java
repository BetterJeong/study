public class FruitBuyer {

    private int money = 5000;
    private int numOfApple;

    public void buyApple(FruitSeller s, int money) {
        this.money -= money;
        numOfApple += s.saleApple(money);
    }

    public void showResult() {
        System.out.println("보유 현금: "+money+"원");
        System.out.println("구매 사과 수: "+numOfApple+"개");
    }

}
