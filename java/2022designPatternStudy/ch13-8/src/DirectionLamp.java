public abstract class DirectionLamp {
    private Direction lampStatus;

    public void light(Direction direction) {
        if (lampStatus == getLampStatus()) {
            return;
        }
        doLight(lampStatus);
        setLampStatus(lampStatus);
    }

    private Direction getLampStatus() {
        return lampStatus;
    }

    private void setLampStatus(Direction lampStatus) {
        this.lampStatus = lampStatus;
    }

    protected abstract void doLight(Direction lampStatus);
}