package transportation;

import transportation.transportationlmpl.*;

public class Taxi extends transportation implements changeState, changeVelocity, changeGasAmount, takePassenger, carNumber, payPrice, getStart {
    String destination;
    int distance;
    int baseDistance;
    int pricePerDistance;
    int payPrice;
    int lastPrice;

    public Taxi(int id) {
        super(id, "일반", 4, 3000);
        this.destination = "";
        this.distance = 0;
        this.baseDistance = 1;
        this.pricePerDistance = 1000;
    }

    @Override
    public void changeGasAmount(int gasAmount) {
        if(this.gasAmount - gasAmount < 10) {
            this.state = "운행불가";
        } else {
            this.gasAmount += gasAmount;
        }
    }

    @Override
    public void changeState(String state) {
        this.state = state;
    }

    @Override
    public void changeVelocity(int velocity) {
        this.velocity += velocity;
    }

    @Override
    public void takePassenger(int passenger) {

    }

    @Override
    public void takePassenger(int passenger, String destination, int distance) {
            if (this.maxPassenger - passenger > 0) {
                this.payPrice = this.price + (distance - this.baseDistance) * this.pricePerDistance;
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (maxPassenger - passenger));
                System.out.println("기본 요금 확인 = " + this.price);
                System.out.println("목적지 = " + destination);
                System.out.println("목적지까지 거리 = " + distance + "km");
                System.out.println("지불할 요금 = " + payPrice);
                if(this.state.equals("일반")) {
                    this.state = "운행중";
                    System.out.println("상태 = " + this.state);
                } else {
                }
            }
                else {
                System.out.println("'최대 승객 수 초과'");
            }
        }

    @Override
    public int carNumber() {
        return this.id;
    }

    @Override
    public void payPrice() {
        this.lastPrice += payPrice;
        if(this.gasAmount < 10) {
            System.out.println("주유량 = " + this.gasAmount);
            System.out.println("상태 = " + this.state);
        } else {
            System.out.println("주유량 = " + this.gasAmount);
        }
        System.out.println("누적 요금 = " + lastPrice);
    }

    @Override
    public void getStart() {
        System.out.println("주유량 = " + this.gasAmount);
        System.out.println("상태 = " + this.state);
        }
}
