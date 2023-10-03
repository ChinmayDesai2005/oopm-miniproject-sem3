package Model;

import java.util.ArrayList;

public class Airport implements AirportTerminal{
    private int airportId;
    private String airportName;
    private String airportLocation;
    private String airportCode;
    private int airportCapacity;
    private boolean isInternational;
    private int noOfHangers;
    private int noOfRunways;

    ArrayList<String> airport_terminals = new ArrayList<String>();

    public void setAirportId(int airportId){this.airportId = airportId;}

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

    public void setIsInternational(boolean isInternational){
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

    public int getAirportId(){
        return this.airportId;
    }

    public boolean getIsInternational(){
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

    @Override
    public void addAirportTerminal(String terminal) { this.airport_terminals.add(terminal); }

    @Override
    public void removeAirportTerminal(int terminal_no) { this.airport_terminals.remove(terminal_no); }

    @Override
    public void displayAirportTerminals() {
        for (int i = 0; i < airport_terminals.size(); i++) {
            System.out.println("Airport Terminal"+i+" : "+airport_terminals.get(i));
        }
    }




}
