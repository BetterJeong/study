public class Restaurant {
    public Apple servingApple(String kind) {
        Apple apple = null;
        apple = AppleFactory.getApple(kind);
        apple.wash();
        apple.peel();
        apple.slice();
        return apple;
    }
}
