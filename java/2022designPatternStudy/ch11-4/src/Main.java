public class Main {
    public static void main(String[] args) {
        Door door = new Door();
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.UP);

        door.open();
        LGMotor lgMotor = new LGMotor(door);
        lgMotor.move(Direction.DOWN);
    }
}