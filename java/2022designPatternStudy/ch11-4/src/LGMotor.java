public class LGMotor extends Motor {
    public LGMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("LGMotor 구동");
        System.out.println("방향: "+direction);
    }
}
