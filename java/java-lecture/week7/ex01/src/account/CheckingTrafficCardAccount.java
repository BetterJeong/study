package account;

public class CheckingTrafficCardAccount extends CheckingAccount{

    boolean hasTrafficCard;

    public CheckingTrafficCardAccount(String accountNo, String name, int balance, String cardNo, boolean hasTrafficCard) {
        super(accountNo, name, balance, cardNo);
        this.hasTrafficCard = hasTrafficCard;
    }

    public int payTrafficCard(String cdNo, int amount) {
        if (hasTrafficCard) {
            return super.pay(cdNo, amount);
        }
        else {
            System.out.println("교통카드로 등록되어 있지 않습니다");
            return 0;
        }
    }

}
