package account;

public class CheckingAccount extends Account {

    String cardNo;

    public CheckingAccount(String accountNo, String name, int balance, String cardNo) {
        super(accountNo, name, balance);
        this.cardNo = cardNo;
    }

    public int pay(String cardNo, int amount) {
        if (this.cardNo.equals(cardNo)) {
            return super.withdraw(amount);
        }
        else {
            System.out.println("카드 번호가 다릅니다");
            return 0;
        }
    }

}
