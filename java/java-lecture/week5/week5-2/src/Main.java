public class Main {
    public static void main(String[] args) {

        Child child1 = new Child(15);
        Child child2 = new Child(9);

        // 1차 게임
        child1.win(child2, 2);
        // 결과
        System.out.println("어린이1 현재 구슬 수: " +child1.getNumOfMarble());
        System.out.println("어린이2 현재 구슬 수: " +child2.getNumOfMarble());

        // 2차 게임
        child2.win(child1, 7);
        // 결과
        System.out.println("어린이1 현재 구슬 수: " +child1.getNumOfMarble());
        System.out.println("어린이2 현재 구슬 수: " +child2.getNumOfMarble());


    }
}