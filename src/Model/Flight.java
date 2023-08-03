package Model;

import java.util.Date;
public class Flight {
    private String flightName;
    private Date flightDate;
    private String toAirport;
    private int noOfHours;
    private String flightModel;
    private int flightCapacity;

    public void setFlightName(String flightName){
        this.flightName = flightName;
    }

    public void setToAirport(String toAirport){
        this.toAirport = toAirport;
    }

    public void setNoOfHours(int noOfHours){
        this.noOfHours = noOfHours;
    }

    public void setFlightModel(String flightModel){
        this.flightModel = flightModel;
    }

    public void setFlightCapacity(int flightCapacity){
        this.flightCapacity = flightCapacity;
    }

    public void setFlightDate(Date flightDate){
        this.flightDate = flightDate;
    }

    public String getFlightName(){
        return this.flightName;
    }

    public String getToAirport(){
        return this.toAirport;
    }

    public int getNoOfHours(){
        return this.noOfHours;
    }

    public String getFlightModel(){
        return this.flightModel;
    }

    public int getFlightCapacity(){
        return this.flightCapacity;
    }

    public Date getFlightDate(){
        return this.flightDate;
    }

}
