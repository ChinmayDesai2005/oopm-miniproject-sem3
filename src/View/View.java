package View;

import Model.Flight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View {
    FlightPanel mainFlightPanel = new FlightPanel();

    public View() {

        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chinm\\OneDrive\\Desktop\\Files\\oopm-miniproject-sem3\\src\\flightIcon.png");
        mainFlightPanel.pack();
        mainFlightPanel.setSize(700, 800);
        mainFlightPanel.setVisible(true);
        System.out.println(mainFlightPanel.getSize());
        mainFlightPanel.setTitle("Flight Management System");
        mainFlightPanel.setIconImage(icon);
    }

    public FlightPanel getFlightPanel(){
        return mainFlightPanel;
    }
}

