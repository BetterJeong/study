import lotto.Lotto;
import lotto.LottoCard;

import java.util.Scanner;

public class LottoSim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LottoCard lottoCard1 = new LottoCard(5);

        LottoCard lottoCard2;
        Lotto[] lottos = new Lotto[3];
        for (int i = 0; i < 3; i++) {
            int[] arr = new int[6];
            System.out.println("로또 번호를 입력해주세요");
            for (int j = 0; j < 6; j++) {
                arr[j] = sc.nextInt();
            }
            Lotto lotto = new Lotto(arr);
            lottos[i] = lotto;
        }
        lottoCard2 = new LottoCard(lottos,3);

        lottoCard1.show();
        lottoCard2.show();
    }
}