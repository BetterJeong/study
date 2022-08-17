public class Home {
    public Apple getAppleForBreakFast(String kind) {
        Apple apple = null;
        apple = AppleFactory.getApple(kind);
        apple.wash();
        return apple;
    }
}
