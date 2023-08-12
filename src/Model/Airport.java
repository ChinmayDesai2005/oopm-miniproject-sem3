package Model;

import java.lang.Math;

public class Airport {
    private String airportId;
    private String airportName;
    private String airportLocation;
    private String airportCode;
    private int airportCapacity;
    private String isInternational;
    private int noOfHangers;
    private int noOfRunways;

    public void setAirportId(String airportId){this.airportId = airportId;}

    public void setAirportName(String airportName){
        this.airportName = airportName;
    }

    public void setAirportLocation(String airportLocation){
        this.airportLocation = airportLocation;
    }

    public void setAirportCode(String airportCode){
        this.airportCode = airportCode;
    }

    public void setAirportCapacity(int airportCapacity){
        this.airportCapacity = airportCapacity;
    }

    public void setIsInternational(String isInternational){
        this.isInternational = isInternational;
    }

    public void setNoOfHangers(int noOfHangers){
        this.noOfHangers = noOfHangers;
    }

    public void setNoOfRunways(int noOfRunways){
        this.noOfRunways = noOfRunways;
    }

    public String getAirportName(){
        return this.airportName;
    }

    public String getAirportLocation(){
        return this.airportLocation;
    }

    public String getAirportCode(){
        return this.airportCode;
    }

    public String getAirportId(){
        return this.airportId;
    }

    public String getIsInternational(){
        return this.isInternational;
    }

    public int getAirportCapacity(){
        return this.airportCapacity;
    }

    public int getNoOfHangers(){
        return this.noOfHangers;
    }

    public int getNoOfRunways(){
        return this.noOfRunways;
    }



}
