package Model;


import java.util.ArrayList;

public interface Displayable
{
    ArrayList<String> getLine(int line);
    ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);

    public int getFirstLineToDisplay();
    public int getLineToHighlight();
    public int getLastLineToDisplay();
    public int getLinesBeingDisplayed();

    public void setFirstLineToDisplay(int firstLine);
    public void setLineToHighlight(int highlightedLine);
    public void setLastLineToDisplay(int lastLine);
    public void setLinesBeingDisplayed(int numberOfLines);

}
