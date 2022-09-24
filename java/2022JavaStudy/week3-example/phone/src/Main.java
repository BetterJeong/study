public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("난정", new Phone("아이폰", "010-1234-1234"));
        Person p2 = new Person("난정 아님", new Phone("갤럭시", "010-5678-5678"));

        p1.playGame();
        p2.playGame();

        p1.sendMessage(p2);
        p2.sendMessage(p1);

    }
}