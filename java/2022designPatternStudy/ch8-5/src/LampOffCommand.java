public class LampOffCommand implements Command{
    private Lamp theLamp;

    public LampOffCommand(Lamp thelamp) {
        this.theLamp = thelamp;
    }

    public void execute() {
        theLamp.turnOff();
    }
}
