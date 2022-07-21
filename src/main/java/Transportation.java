import java.util.Objects;

public class Transportation {
    //대중교통 인스턴스
    protected int tsNum;
    protected int fuel;
    protected int speed;
    protected String gearBox;
    protected int maxPassenger;
    protected int passenger;
    protected int price;

    //생성자
    public Transportation(){
        this.fuel = 100;
        this.speed = 0;
        this.gearBox = "운행중";
        this.maxPassenger = 50;
        this.tsNum = 100;
    }

    public Transportation(int tsNum) {
        this();
        this.tsNum = tsNum;
    }

    // 버스 번호 호출
    public void tsCall(int tsNum) {
        System.out.println("현재 해당 " + tsNum + "번 대중교통 정보는 " + this.gearBox + "입니다");
    }

    //속도를 올리고 내리면 기름이 소비되는 구조의 메서드
    //기름이 10이하로 떨어지면 '주유 경고' 메시지
    public int changeSpeed(int speed) {
        this.speed += speed;
        if (speed > 0) {
            this.fuel -= (float)this.speed * 0.2f;
        } else {
            this.fuel -= (float)this.speed * 0.1f;
        }

        if (Objects.equals(this.gearBox, "운행중") && this.speed > 10) {
            System.out.println("속도를 변경합니다");
            System.out.println("현재 속도는 " + this.speed + ", 주유량은" + fuel + " 입니다");
            if (this.fuel <= 0) {
                System.out.println("더이상 운행이 불가능합니다.");
                this.gearBox = "차고지행";
            } else if (this.fuel < 10) {
                System.out.println("경고! 주유를 해야합니다!");
            }
        } else if (10 >= this.speed && this.speed >= 1) {
            System.out.println("경고! 주유를 해야합니다!");
            System.out.println("현재 속도는 " + this.speed + ", 주유량은" + fuel + " 입니다");

        } else {
            System.out.println("지금은 운행할 수 없습니다");
            System.out.println("차고지로 이동합니다");
            this.gearBox = "차고지행";
        }
        return this.speed;
    }
    // 승객과 요금을 확인할 수 있는 메서드
    public void takePassenger(int passenger, int price) {
        this.price = price;
        this.passenger += passenger;
        int totalPrice = this.passenger * this.price;
        int totalSeat = 0;

        if (this.gearBox == "운행중" && this.passenger < maxPassenger) {
            totalSeat += maxPassenger - this.passenger;
            System.out.println("방금 탄 승객은 " + this.passenger + " 명이며 요금은 현재 " + totalPrice + " 원입니다");
            System.out.println("남은 좌석은 " + totalSeat + " 개입니다.");

        } else {
            System.out.println("더이상 탑승 할 수 없습니다!");
            this.gearBox = "차고지행";
        }
    }
}

