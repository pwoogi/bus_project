public class Bus extends Transportation {

    public Bus(int tsNum) {
        super(tsNum);
        this.maxPassenger = 30;

    }
    public Bus(){
        super();
    }

    @Override
    public void tsCall(int tsNum, String gearBox) {
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