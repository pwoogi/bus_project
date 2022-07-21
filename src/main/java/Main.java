public class Main {
    public static void main(String[] args) {
        Transportation ts = new Transportation(200);
        System.out.println("===================대중교통==================");
        ts.tsCall(200);
        ts.changeSpeed(50);
        ts.takePassenger(30, 1000);
        System.out.println("===================버   스==================");
        Bus bs = new Bus(200);
        bs.tsCall(100);
        bs.changeSpeed(100);
        bs.takePassenger(10,1000);
        System.out.println("===================택   시==================");
        Taxi tx = new Taxi(1);
        tx.tsCall(1);
        tx.payment("서울역", 2);
        tx.changeSpeed(50);



    }
}
