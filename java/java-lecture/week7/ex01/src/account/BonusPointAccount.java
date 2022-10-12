package account;

import java.util.Objects;

public class BonusPointAccount extends Account{

    int bonusPoint;

    public BonusPointAccount(String accountNo, String name, int balance, int bonusPoint) {
        super(accountNo, name, balance);
        this.bonusPoint = bonusPoint;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        bonusPoint += amount * 0.1;
        System.out.println(accountNo+" 계좌에 "+amount+"원 추가");
        System.out.println(accountNo+" 계좌의 포인트 "+amount*0.1+"원 적립");
    }

    @Override
    public void check() {
        System.out.println("잔액: "+balance);
        System.out.println("누적 포인트: "+bonusPoint);
    }

}
