public class Child {

    private int numOfMarble;

    public Child(int numOfMarble) {
        this.numOfMarble = numOfMarble;
    }

    public int getNumOfMarble() {
        return numOfMarble;
    }

    public void setNumOfMarble(int numOfMarble) {
        this.numOfMarble = numOfMarble;
    }

    public void win(Child c, int num) {
        if (validation(c, num)) {
            c.setNumOfMarble(c.getNumOfMarble()-num);
            numOfMarble += num;
        }
    }

    private boolean validation(Child c, int num) {
        if (c.getNumOfMarble() < num) {
            System.out.println("보유한 구슬보다 많이 가져올 수 없습니다.");
            return false;
        }
        return true;
    }

}
