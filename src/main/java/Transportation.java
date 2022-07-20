import java.util.Objects;

public class Transportation {
    protected int tsNum;
    protected int fuel = 100;
    protected int speed = 0;
    protected String gearBox = "운행중";
    protected int maxPassenger = 50;
    protected int passenger;
    protected int price;

    //생성자

    public Transportation(int tsNum) {
        this.tsNum = tsNum;
    }

    public Transportation() {}


    // 버스 번호 호출
    public void tsCall(int tsNum, String gearBox) {
        System.out.println("현재 해당 " + tsNum + "번 대중교통 정보는 " + gearBox + "입니다");
    }

    //속도변경 메서드
    //상태 : 속도를 입력하면 운행상태가 "운행중"인지를 확인
    // 만약 아니면 "차고지행"으로 상태를 변경하고 메시지를 띄움
    //속도 : 10보다 작거나 같을때 주유경고 메시지
    // 메시지 위치 오류 : 수정필요
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

