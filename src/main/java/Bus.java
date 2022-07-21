public class Bus extends Transportation {
    protected int maxPassenger;

    public Bus(int tsNum) {
        super(tsNum);
    }

    public Bus(){
        super();
        this.maxPassenger = 30;
    }

    @Override
    public void tsCall(int tsNum) {
        System.out.println("현재 버스는 " + this.tsNum + "번 버스이며 상태는 " + this.gearBox + "입니다");
    }

    @Override
    public int changeSpeed(int speed) {
        return super.changeSpeed(speed);
    }

    @Override
    public void takePassenger(int passenger, int price) {
        super.takePassenger(passenger, price);
    }
}