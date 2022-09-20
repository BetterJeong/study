import java.util.Scanner;

public class WordGameApp {

    public static void main(String[] args) {
        System.out.println("끝말잇기 게임을 시작합니다...");
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임에 참가하는 인원은 몇명입니까>>> ");
        int num = sc.nextInt();
        int index = 0;
        boolean b = true;
        Player[] players = new Player[num];

        for (int i = 0; i < num; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            players[i] = new Player(sc.next());
        }

        System.out.println("시작하는 단어는 아버지입니다");

        while(b) {
            System.out.print(players[index%3].getName()+">> ");
            players[index%3].setWord(sc.next());

            char lastChar;
            if (index == 0) {
                lastChar = '지';
            }
            else {
                int lastIndex = players[(index-1)%3].getWord().length() - 1;
                lastChar = players[(index-1)%3].getWord().charAt(lastIndex);
            }
            char firstChar = players[index%3].getWord().charAt(0);

            if (players[index%3].checkSuccess(lastChar, firstChar)) {
                index++;
            }
            else {
                b = false;
            }
        }

        System.out.println(players[index%3].getName()+"이 졌습니다.");
    }
}