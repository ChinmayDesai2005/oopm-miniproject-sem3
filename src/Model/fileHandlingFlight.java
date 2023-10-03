package Model;

import java.util.ArrayList;

abstract class fileHandlingFlight {
    abstract public ArrayList<CommercialFlight> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<CommercialFlight> flights);

}
