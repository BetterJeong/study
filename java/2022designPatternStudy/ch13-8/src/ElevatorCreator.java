public class ElevatorCreator {
    public static Elevator assembleElevator(ElevatorFactory factory) {
        Elevator elevator = factory.createElevator();

        Motor motor = factory.createMotor();
        elevator.setMotor(motor);

        Door door = factory.createDoor();
        elevator.setDoor(door);
        motor.setDoor(door);

        DirectionLamp lamp = factory.createLamp();
        elevator.setLamp(lamp);

        return elevator;
    }
}
