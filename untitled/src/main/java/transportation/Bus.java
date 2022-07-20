package transportation;

import transportation.transportationlmpl.*;

public class Bus extends transportation implements changeState, changeVelocity, changeGasAmount, takePassenger, carNumber {

    int currentPassenger;

    public Bus(int id, int currentPassenger) {
        super(id, "운행", 30, 1000);
        this.currentPassenger = currentPassenger;
    }

    @Override
    public void takePassenger(int passenger) {
        this.currentPassenger += passenger;
        int result;
        result = this.maxPassenger - this.currentPassenger;
        if (result < 0) {
            System.out.println("'최대 승객 수 초과'");
            this.currentPassenger = 0;
        } else {
            System.out.println("탑승 승객 수 = " + passenger);
            System.out.println("잔여 승객 수 = " + result);
            System.out.println("요금 확인 = " + this.price * passenger + "원");
        }
    }

    @Override
    public void takePassenger(int passenger, String destination, int distance) {

    }


    @Override
    public void changeState(String state) {
        this.state = state;
        this.prevState = state;
    }

    @Override
    public void changeVelocity(int velocity) {
        this.velocity += velocity;
    }

    @Override
        public void changeGasAmount(int gasAmount) {
            this.prevState = "운행중";
            this.gasAmount += gasAmount;
            if (this.gasAmount < 10) {
                this.state = "차고지행";
                System.out.println("주유량: " + this.gasAmount);
                System.out.println("상태: " + this.state);
                System.out.println("주유 필요");
            } else {
                if (this.prevState.equals(this.state)) {
                    System.out.println("주유량: " + this.gasAmount);
                } else {
                    System.out.println("주유량: " + this.gasAmount);
                    System.out.println("상태: " + this.state);
                    this.prevState = this.state;
                }
            }
        }
    @Override
    public int carNumber() {
        return this.id;
    }
}
