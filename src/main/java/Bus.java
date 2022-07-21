import java.util.Objects;

public class Bus extends Transportation {
    protected int maxPassenger;

    public Bus(int tsNum) {
        super(tsNum);
        this.tsNum = tsNum;
        this.maxPassenger = 30;
    }

    public Bus() {
        super();
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
        this.price = price;
        this.passenger += passenger;
        int totalPrice = this.passenger * this.price;
        int totalSeat = 0;

        if (Objects.equals(this.gearBox, "운행중") && this.passenger < this.maxPassenger) {
            totalSeat += maxPassenger - this.passenger;
            System.out.println("방금 탄 승객은 " + this.passenger + " 명이며 요금은 현재 " + totalPrice + " 원입니다");
            System.out.println("남은 좌석은 " + totalSeat + " 개입니다.");

        } else {
            System.out.println("더이상 탑승 할 수 없습니다!");
            this.gearBox = "차고지행";
        }
    }
}