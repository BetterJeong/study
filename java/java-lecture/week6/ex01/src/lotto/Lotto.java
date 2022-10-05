package lotto;

import java.util.Random;

public class Lotto {

    public int[] lottoNumber;
    public boolean isValid;

    public Lotto() {
        lottoNumber = generate();
        isValid = verify();
    }

    public Lotto(int[] lottoNumber) {
        this.lottoNumber = lottoNumber;
        this.isValid = verify();
    }

    public Lotto(int a, int b, int c, int d, int e, int f) {
        lottoNumber = new int[6];
        lottoNumber[0] = a;
        lottoNumber[1] = b;
        lottoNumber[2] = c;
        lottoNumber[3] = d;
        lottoNumber[4] = e;
        lottoNumber[5] = f;
        this.isValid = verify();
    }

    public void show() {
        if (isValid) {
            for (int i = 0; i < lottoNumber.length; i++) {
                System.out.print(lottoNumber[i]+" ");
            }
            System.out.println();
        }
        else {
            System.out.println("유효하지 않은 로또 번호입니다.");
        }
    }

    public int[] getNumbers() {
        if (isValid) {
            return lottoNumber;
        }
        else {
            return null;
        }
    }

    private int[] generate() {
        Random rd = new Random();
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            boolean b = true;
            int n = rd.nextInt(45)+1;

            for (int j = 0; j < i; j++) {
                if (n == arr[j]) {
                    b = false;
                }
            }

            if (b) {
                arr[i] = n;
            }
            else {
                i--;
                continue;
            }
        }

        return arr;
    }

    private boolean verify() {
        boolean b = true;
        for (int i = 0; i < 6; i++) {
            if (lottoNumber[i] > 45 || lottoNumber[i] < 1) {
                b = false;
                break;
            }
            for (int j = i+1; j < 6 ; j++) {
                if (lottoNumber[i] == lottoNumber[j]) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }

}
