import java.util.ArrayList;

public class TransitCalculatorOwn {

    int numDays;
    int numRides;

    public TransitCalculatorOwn (int NoDays, int NoRides){
        numDays = NoDays;
        numRides = NoRides;        
    }

    String[] fareOptions = {"Pay Per Ride", "7 Day Unlimited", "30 Day Unlimited"};
    double[] optionPrice = {2.75, 33.00, 127.00};

    public double unlimited7Price() {
        double noSevenTicket = Math.ceil(numDays/7.0);
        double totalSevenTicket = noSevenTicket * optionPrice[1];

        return totalSevenTicket/numRides;
    }

    public double[] getRidePrices() {
        double payPR = optionPrice[0];
        double unl7Price = unlimited7Price();
        double thirtyDayUnl = optionPrice[2]/numRides;

        double[] pricePerRide = {payPR, unl7Price, thirtyDayUnl};
        return pricePerRide;
    }

    public String getBestFare() {

        double[] ridePrice = getRidePrices();
        int winningIndex = 0;

        for (int i = 0; i < ridePrice.length; i++){
            if( ridePrice[i] < ridePrice[winningIndex]) {
                winningIndex = i;
            }
        }
        return "You should get the " + fareOptions[winningIndex] + " option at $" + ridePrice[winningIndex]  + " per ride.";

    }

    public static void main(String[] args){

        int myDays = 30;
        int myRides = 200;

        TransitCalculatorOwn transCalc = new TransitCalculatorOwn(myDays, myRides);
        System.out.println(transCalc.getBestFare());

    }

}

