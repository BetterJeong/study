public class LampOnCommand implements Command{
    private Lamp theLamp;

    public LampOnCommand(Lamp thelamp) {
        this.theLamp = thelamp;
    }

    public void execute() {
        theLamp.turnOn();
    }
}
