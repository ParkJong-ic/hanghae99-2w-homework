import transportation.Bus;
import transportation.Taxi;


public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(915,0);
        Bus bus2 = new Bus(216,0);
        bus1.carNumber();
        bus2.carNumber();
        if(bus1.carNumber() != bus2.carNumber()) {
            System.out.println("차량번호가 다릅니다.");
        } else {
            System.out.println("차량번호가 같습니다.");
        }
        bus2.takePassenger(2);
        bus2.changeState("운행중");
        bus2.changeGasAmount(-50);
        bus2.changeState("차고지행");
        bus2.changeGasAmount(10);
        bus2.changeState("운행중");
        bus2.takePassenger(45);
        bus2.takePassenger(5);
        bus2.changeGasAmount(-55);
        System.out.println("===============================");

        Taxi taxi1 = new Taxi(4785);
        Taxi taxi2 = new Taxi(3756);
        taxi1.carNumber();
        taxi2.carNumber();
        if(bus1.carNumber() != bus2.carNumber()) {
            System.out.println("차량번호가 다릅니다.");
        } else {
            System.out.println("차량번호가 같습니다.");
        }
        taxi2.getStart();
        taxi2.takePassenger(2,"서울역",2);
        taxi2.changeGasAmount(-80);
        taxi2.payPrice();
        taxi2.takePassenger(5, "", 0);
        taxi2.takePassenger(3,"구로디지털단지역",12);
        taxi2.changeGasAmount(-20);
        taxi2.payPrice();
    }
}
