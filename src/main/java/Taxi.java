import java.util.Objects;

public class Taxi extends Transportation {
    protected String destination;
    protected int toDestination;
    protected int basicCharge;
    protected int extraCharge;
    protected int maxPassenger;

    protected int speed;
    protected int passenger;
    protected String gearBox;

    public  Taxi(){
        super();
//        this.destination = "";
//        this.toDestination = 1;
//        this.basicCharge = 3000;
//        this.extraCharge = 1000;
//        this.maxPassenger = 4;
//        this.gearBox = "일반";
    }
    public Taxi(int tsNum) {
        super(tsNum);
        this.tsNum = tsNum;
        this.destination = "";
        this.toDestination = 1;
        this.basicCharge = 3000;
        this.extraCharge = 1000;
        this.maxPassenger = 4;
        this.gearBox = "일반";
    }

    @Override
    public void tsCall(int tsNum) {
        System.out.println("호출한 택시는 " + this.tsNum + "번이며 상태는 " + this.gearBox + "입니다");
    }

    @Override
    public int changeSpeed(int speed) {
        this.speed += speed;
        if (speed > 0) {
            this.fuel -= (float)this.speed * 0.2f;
        } else {
            this.fuel -= (float)this.speed * 0.1f;
        }
        if (Objects.equals(this.gearBox, "일반") && this.speed > 10) {
            System.out.println("속도를 변경합니다");
            System.out.println("현재 속도는 " + this.speed + ", 주유량은" + fuel + " 입니다");
            if (this.fuel <= 0) {
                System.out.println("더이상 운행이 불가능합니다.");
                this.gearBox = "운행불가";
            } else if (this.fuel < 10) {
                System.out.println("경고! 주유를 해야합니다!");
            }
        } else if (10 >= this.speed && this.speed >= 1) {
            System.out.println("경고! 주유를 해야합니다!");
            System.out.println("현재 속도는 " + this.speed + ", 주유량은" + fuel + " 입니다");

        } else {
            System.out.println("지금은 운행할 수 없습니다");
            this.gearBox = "운행불가";
        }
        return this.speed;
    }
    public void payment(String destination, int passenger){
        this.passenger += passenger;
        this.destination = destination;

        int totalDistance;
        int basicPayment;
        int totalPayment = 0;
        int totalSeat = 0;

        // equals 재학습하기, 같은 타입으로 지정이 되있어야 인식을 해줄 수 있다.

        String [] finalDestination = this.destination.split("");

        totalDistance = finalDestination.length;
        basicPayment = totalDistance * (this.basicCharge * this.passenger);
        //여기서부터 문제
        if(Objects.equals(this.gearBox, "일반") && this.passenger <= this.maxPassenger) {
            totalSeat += this.maxPassenger - this.passenger;
            //위에 두줄까지 문제
            if (totalDistance < 5) {
                System.out.println("목적지 : " +"'"+ destination+"'" + "까지의 총 요금은 " + basicPayment + "원입니다.");
            } else {
                totalPayment = (toDestination * basicPayment) + (this.basicCharge + this.extraCharge);
                System.out.println("목적지 : " + "'"+destination+"'" + "까지의 총 요금은 " + totalPayment + "원입니다.");
            }
        }else {
            System.out.println("최대 승객수를 초과했습니다!");
            this.gearBox = "운행불가";
        }
    }

}
