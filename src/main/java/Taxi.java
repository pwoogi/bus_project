import java.util.Objects;

public class Taxi extends Transportation {
    protected String destination = "";
    protected int toDestination = 1;
    protected int basicCharge = 3000;
    protected int extraCharge = 1000;


    public Taxi(int tsNum) {
        super(tsNum);
        this.tsNum = tsNum;
        this.gearBox = "일반";
        this.maxPassenger = 4;
    }
    public  Taxi(){
    }

    @Override
    public void tsCall(int tsNum, String gearBox) {
        System.out.println("호출한 택시는 " + this.tsNum + "번이며 상태는 " + this.gearBox + "입니다");
    }

    @Override
    public int changeSpeed(int speed) {
        return super.changeSpeed(speed);
    }

//    @Override
//    public void takePassenger(int passenger, int price){
//        this.price = price;
//        this.passenger += passenger;
//        int totalPrice = this.passenger * this.price;
//        int totalSeat = 0;
//
//        if(this.gearBox == "일반" && this.passenger < maxPassenger){
//            totalSeat += maxPassenger - this.passenger;
//            System.out.println("방금 탄 승객은 " + this.passenger+ " 명이며 요금은 현재 "+ totalPrice +" 원입니다");
//            System.out.println("남은 좌석은 " + totalSeat+ " 개입니다.");
//
//        }else {
//            System.out.println("최대 승객수를 초과했습니다!");
//            this.gearBox = "차고지행";
//        }
//    }
    public void payment(String destination, int passenger){
        this.passenger += passenger; //2 왜 ti.takePassenger 메서드 호출하면 passenger +3 더한 값이 나올까?
        this.destination = destination; //서울

        int totalDistance; // 문자열길이 2
        int basicPayment;
        int totalPayment = 0;
        int totalSeat = 0;

        String [] finalDestination = this.destination.split("");
        totalDistance = finalDestination.length;
        basicPayment = totalDistance * (this.basicCharge * this.passenger);
        //여기서부터 문제
        if((this.gearBox == "일반") && this.passenger <= this.maxPassenger) {
            totalSeat += this.maxPassenger - this.passenger;
            //위에 두줄까지 문제
            if (totalDistance < 5) {
                System.out.println("목적지 : " + destination + "까지의 총 요금은 " + basicPayment + "원입니다.");
            } else {
                totalPayment = (toDestination * basicPayment) + (this.basicCharge + this.extraCharge);
                System.out.println("목적지 : " + destination + "까지의 총 요금은 " + totalPayment + "원입니다.");
            }
        }else {
            System.out.println("최대 승객수를 초과했습니다!");
            this.gearBox = "운행불가";
        }
    }
}
