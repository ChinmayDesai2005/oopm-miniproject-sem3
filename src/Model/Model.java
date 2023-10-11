package Model;

public class Model {
    protected manageFlight manageFlightData = new manageFlight();

    public Model()
    {
        manageFlightData.setLinesBeingDisplayed(25);
        manageFlightData.setFirstLineToDisplay(0);
    }

    public manageFlight getManageFlightData()
    {
        return manageFlightData;
    }
}
