package Model;

public class CommercialFlight extends Flight{
    private int noOfPassengers;
    private String flightClasses;


    public CommercialFlight(int flightId, String flightName, String flightCode, String flightModel, int noOfPassengers, String flightClasses){

        super(flightId, flightName, flightCode, flightModel);
        setNoOfPassengers(noOfPassengers);
        setFlightClasses(flightClasses);

    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }
    public void setFlightClasses(String flightClasses) {
        this.flightClasses = flightClasses;
    }

    public int getNoOfPassengers() { return this.noOfPassengers; }
    public String getFlightClasses() { return this.flightClasses; }

    public String displayFlight(){
        return display() + "\nNo of Passengers : "+getNoOfPassengers()+"\nFlight Classes : "+getFlightClasses();

    }
}
