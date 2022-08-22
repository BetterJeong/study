public class Main {
    public static void main(String[] args) {
        ElevatorFactory factory = null;
        String vendorName = "LG";
        if (vendorName.equalsIgnoreCase("LG")) {
            factory = new LgElevatorFactory();
        }
        else {
            factory = new HyundaiElevatorFactory();
        }
        Elevator elevator = ElevatorCreator.assembleElevator(factory);
        elevator.move(Direction.UP);
    }
}