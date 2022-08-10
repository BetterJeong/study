public class Main {
    public static void main(String[] args) {
        Display roadWithCrossingAndLaneAndTraffic = new LaneDecorator(
                new TrafficDecorator(new CrossingDecorator(new RoadDisplay())));
        roadWithCrossingAndLaneAndTraffic.draw();
    }
}