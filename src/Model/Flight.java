package Model;

import java.util.Calendar;
public class Flight {
    int flightId;
    private String flightName;
    private String flightCode;
    private String flightModel;
    private int flightCapacity;

    public Flight(int flightId, String flightName, String flightCode, String flightModel, int flightCapacity)
    {
        // E1203 Vistara A380
        // Chinmay Desai
        setFlightId(flightId);
        setFlightName(flightName);
        setFlightCode(flightCode);
        setFlightModel(flightModel);
        setFlightCapacity(flightCapacity);
    }

    public Flight(String flightName, String flightCode, String flightModel, int flightCapacity)
    {
        // E1203 Vistara A380
        // Chinmay Desai
        setFlightId((int)Math.random());
        setFlightName(flightName);
        setFlightCode(flightCode);
        setFlightModel(flightModel);
        setFlightCapacity(flightCapacity);
    }


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