package account;

public class Account {

    String accountNo;
    String name;
    int balance;

    public Account(String accountNo, String name, int balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(accountNo+" 계좌에 "+amount+" 원 추가");
    }

    public int withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return amount;
        }
        else {
            System.out.println("잔액 부족");
            return 0;
        }
    }

    public void check() {
        System.out.println("잔액: "+balance);
    }

}
