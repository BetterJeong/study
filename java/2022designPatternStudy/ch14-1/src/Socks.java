public class Socks extends ParcelItem{
    public Socks(int weight) {
        super(weight);
    }

    @Override
    public int price() {
        return weight/100*200;
    }
}
