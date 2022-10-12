import account.*;

public class Bank {
    public static void main(String[] args) {
        Account[] accounts = new Account[5];
        accounts[0] = new Account("1234", "가나다", 1000);
        accounts[1] = new CheckingAccount("2345", "나다라", 10000, "123123");
        accounts[2] = new CheckingTrafficCardAccount("3456", "다라마", 100000, "234234", true);
        accounts[3] = new CreditLineAccount("4567", "라마바", 1000, 2000);
        accounts[4] = new BonusPointAccount("5678", "마바사", 1000, 0);

        for (Account account : accounts) {
            account.check();
            account.deposit(1000);
            account.check();
            System.out.println("출금 금액: "+account.withdraw(100));
            account.check();
            System.out.println("출금 금액: "+account.withdraw(10000));
            account.check();

            if (account instanceof CheckingTrafficCardAccount) {
                CheckingTrafficCardAccount checkingTrafficCardAccount = (CheckingTrafficCardAccount) account;
                System.out.println("출금 금액: "+checkingTrafficCardAccount.payTrafficCard("234234", 100));
                checkingTrafficCardAccount.check();
            }
            else if (account instanceof CheckingAccount) {
                CheckingAccount checkingAccount = (CheckingAccount) account;
                System.out.println("출금 금액: "+checkingAccount.pay("123123", 100));
                System.out.println("출금 금액: "+checkingAccount.pay("121212", 100));
                checkingAccount.check();
            }

            System.out.println("------------------");
        }
    }
}