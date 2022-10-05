package lotto;

public class LottoCard {

    public Lotto[] mLotto;
    public int mEffNum;

    public LottoCard(int mEffNum) {
        this.mEffNum = mEffNum;
        mLotto = new Lotto[mEffNum];
        for (int i = 0; i < mEffNum; i++) {
            Lotto lotto = new Lotto();
            mLotto[i] = lotto;
        }
    }

    public LottoCard(Lotto[] mLotto, int mEffNum) {
        this.mLotto = mLotto;
        this.mEffNum = mEffNum;
    }

    public void show() {
        for (int i = 0; i < mEffNum; i++) {
            mLotto[i].show();
        }
    }

    public int[][] getNumbers() {
        int[][] arr = new int[mEffNum][6];
        for (int i = 0; i < mEffNum; i++) {
            arr[i] = mLotto[i].getNumbers();
        }
        return arr;
    }

}
