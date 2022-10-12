package account;

public class CreditLineAccount extends Account{

    int creditLine;

    public CreditLineAccount(String accountNo, String name, int balance, int creditLine) {
        super(accountNo, name, balance);
        this.creditLine = creditLine;
    }

    @Override
    public int withdraw(int amount) {
        if (amount <= balance + creditLine) {
            balance -= amount;
            System.out.println(accountNo+" 계좌에서 "+amount+" 원 출금 완료");
            return amount;
        }
        else {
            System.out.println("잔액 부족");
            return 0;
        }
    }
}
