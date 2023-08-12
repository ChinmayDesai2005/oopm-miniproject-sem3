package Model;

import java.util.Calendar;
public class Flight {
    private int flightId;
    private String flightName;
    private String flightCode;
    private String flightModel;
    private int flightCapacity;

    public void setFlightId(int flightId){this.flightId = flightId;}
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public void setFlightCapacity(int flightCapacity) {
        this.flightCapacity = flightCapacity;
    }

    public int getFlightId(){return this.flightId;}

    public String getFlightName() {
        return this.flightName;
    }

    public String getFlightCode() {return this.flightCode;}

    public String getFlightModel() {
        return this.flightModel;
    }

    public int getFlightCapacity() {
        return this.flightCapacity;
    }



}