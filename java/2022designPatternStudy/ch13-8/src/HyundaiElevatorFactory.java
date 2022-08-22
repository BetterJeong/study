public class HyundaiElevatorFactory extends ElevatorFactory{
    @Override
    public Elevator createElevator() {
        return new HyundaiElevator();
    }

    @Override
    public Motor createMotor() {
        return new HyundaiMotor();
    }

    @Override
    public Door createDoor() {
        return new HyundaiDoor();
    }

    @Override
    public DirectionLamp createLamp() {
        return new HyundaiLamp();
    }
}
