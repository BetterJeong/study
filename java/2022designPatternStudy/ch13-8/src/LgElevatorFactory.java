public class LgElevatorFactory extends ElevatorFactory{
    @Override
    public Elevator createElevator() {
        return new LgElevator();
    }

    @Override
    public Motor createMotor() {
        return new LgMotor();
    }

    @Override
    public Door createDoor() {
        return new LgDoor();
    }

    @Override
    public DirectionLamp createLamp() {
        return new LgLamp();
    }
}
