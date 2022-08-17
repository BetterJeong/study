public class Busa extends Apple{
    @Override
    public void wash() {
        System.out.println("부사: 물로 씻기");
    }

    @Override
    public void peel() {
        System.out.println("부사: 껍질 벗기기");
    }

    @Override
    public void slice() {
        System.out.println("부사: 자르기");
    }
}
