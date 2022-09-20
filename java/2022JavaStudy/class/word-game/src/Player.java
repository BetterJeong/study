public class Player {

    private String name;
    private String word;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }

    public boolean checkSuccess(char lastChar, char firstChar) {
        if (lastChar == firstChar) {
            return true;
        }
        else {
            return false;
        }
    }

}
