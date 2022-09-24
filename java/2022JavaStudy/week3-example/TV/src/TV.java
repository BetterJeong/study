public class TV {

    private String name;
    private boolean power;
    private int channel;
    private int volume;

    public TV(String name) {
        this.name = name;
        power = false;
        channel = 0;
        volume = 5;
    }

    public void power() {
        if (!power) {
            power = true;
            System.out.println(name + " TV 전원을 켭니다.");
        }
        else {
            power = false;
            System.out.println(name + " TV 전원을 끕니다.");
        }
    }

    public void downChannel() {
        if (power) {
            if (channel == 0) {
                System.out.println("더 이상 채널을 내릴 수 없습니다. 현재 채널: " + channel);
            }
            else {
                channel--;
                System.out.println("채널을 내립니다. 현재 채널: " + channel);
            }
        }
        else {
            System.out.println("TV가 꺼져 있습니다.");
        }
    }

    public void upChannel() {
        if (power) {
            if (channel == 10) {
                System.out.println("더 이상 채널을 올릴 수 없습니다. 현재 채널: " + channel);
            }
            else {
                channel++;
                System.out.println("채널을 올립니다. 현재 채널: " + channel);
            }
        }
        else {
            System.out.println("TV가 꺼져 있습니다.");
        }
    }

    public void downVolume() {
        if (power) {
            if (volume == 0) {
                System.out.println("더 이상 볼륨을 내릴 수 없습니다. 현재 볼륨: " + volume);
            }
            else {
                volume--;
                System.out.println("볼륨을 내립니다. 현재 볼륨: " + volume);
            }
        }
        else {
            System.out.println("TV가 꺼져 있습니다.");
        }
    }

    public void upVolume() {
        if (power) {
            if (volume == 10) {
                System.out.println("더 이상 볼륨을 올릴 수 없습니다. 현재 볼륨: " + volume);
            }
            else {
                volume++;
                System.out.println("볼륨을 올립니다. 현재 볼륨: " + volume);
            }
        }
        else {
            System.out.println("TV가 꺼져 있습니다.");
        }
    }

}
