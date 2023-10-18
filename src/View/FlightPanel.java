package View;

import Model.*;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightPanel extends JDialog {

    private JPanel contentPane;
    private JTextField FlightId;
    private JTextField FlightName;
    private JTextField FlightCode;
    private JTextField FlightModel;
    private JTextField FlightClasses;
    private JTextField Passengers;
    private JButton NewFlight;
    private JButton UpdateFlight;
    private JButton DeleteFlight;
    private JButton Clear;
    private JButton Reload;
    private JTable table1;

    String filePath = "C:\\Users\\chinm\\OneDrive\\Desktop\\Files\\oopm-miniproject-sem3\\src\\Model\\flights.json";
    manageFlight mf1 = new manageFlight();

    ArrayList<CommercialFlight> flights = mf1.readJsonFile(filePath);


    String[] columnNames = {"Flight Id", "Flight Name", "Code", "Model", "Classes", "Passengers"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    public FlightPanel() {
        setContentPane(contentPane);
        loadFlightTable(flights);
        clearFields();
        NewFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CommercialFlight temp_flight = getDataFromFields();
                    if (alreadyExists(temp_flight) != -1) {
                        JOptionPane.showMessageDialog(contentPane, "Entry Already Exists\nPlease click Update!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        addToFlightTable(flights, temp_flight);
                        clearFields();
                        JOptionPane.showMessageDialog(contentPane, "Flight Added!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
                catch (Exception s){
                    JOptionPane.showMessageDialog(contentPane, "One or more fields are empty or incorrect!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        UpdateFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CommercialFlight temp_flight = getDataFromFields();
                    System.out.println("Temp Flight Id : " + temp_flight.getFlightId());
                    CommercialFlight old_flight = flights.get(temp_flight.getFlightId());
                    System.out.println(old_flight);
                    if (flights.contains(old_flight)) {
                        System.out.println("This is working!");
                        System.out.println(flights);
                        flights.set(old_flight.getFlightId(), temp_flight);
                        System.out.println(flights);
                        loadFlightTable(flights);
                        mf1.writeJsonFile(flights);
                        clearFields();
                        JOptionPane.showMessageDialog(contentPane, "Flight Updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(contentPane, " Unable to Update!\nNo Such Entry Exists!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(Exception s){
                    JOptionPane.showMessageDialog(contentPane, " Unable to Update!\nNo Such Entry Exists", "ERROR", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        DeleteFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommercialFlight temp_flight = getDataFromFields();
                try{
                    flights.remove(temp_flight.getFlightId());
                    updateIds(temp_flight.getFlightId());
                    loadFlightTable(flights);
                    mf1.writeJsonFile(flights);
                    clearFields();
                    JOptionPane.showMessageDialog(contentPane, "Flight Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
                catch (Exception s){
                    s.printStackTrace();
                    System.out.println("No such entry found");
                }
            }
        });

        Reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                loadFlightTable(flights);
            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.clearSelection();
                clearFields();

            }
        });

        table1.setModel(tableModel);
        table1.setDefaultEditor(Object.class, null);

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    NewFlight.setEnabled(false);
                    UpdateFlight.setEnabled(true);
                    DeleteFlight.setEnabled(true);
                    FlightId.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
                    FlightName.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
                    FlightCode.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
                    FlightModel.setText(table1.getValueAt(table1.getSelectedRow(), 3).toString());
                    FlightClasses.setText(table1.getValueAt(table1.getSelectedRow(), 4).toString());
                    Passengers.setText(table1.getValueAt(table1.getSelectedRow(), 5).toString());
                }
                catch(Exception s){
//                    s.printStackTrace();
                }

            }
        });
        table1.getTableHeader().setFont(new Font("Noto Sans", Font.PLAIN, 16));
        table1.getTableHeader().setBackground(new Color(68, 71, 90));
        table1.getTableHeader().setForeground(new Color(255, 255, 255));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);
    }

    public CommercialFlight getDataFromFields(){
        int flight_id  = Integer.parseInt(FlightId.getText());
        String flight_name = FlightName.getText();
        String flight_code = FlightCode.getText();
        String flight_model = FlightModel.getText();
        String flight_classes = FlightClasses.getText();
        int passengers = Integer.parseInt(Passengers.getText());
        return new CommercialFlight(flight_id, flight_name, flight_code, flight_model, passengers, flight_classes);
    }

    public void updateIds(int flight_id){
        for (int i = 0; i < flights.size(); i++){
            CommercialFlight flight = flights.get(i);
            flight.setFlightId(i);
        }
        loadFlightTable(flights);
    }
    public void clearFields() {
        NewFlight.setEnabled(true);
        UpdateFlight.setEnabled(false);
        DeleteFlight.setEnabled(false);
        FlightId.setText("" + flights.size());
        FlightName.setText("");
        FlightCode.setText("");
        FlightModel.setText("");
        FlightClasses.setText("");
        Passengers.setText("");
    }
    public void loadFlightTable(ArrayList<CommercialFlight> flights){
//        tableModel.addRow(new Object[]{"Vistara", "VS2009", "A380", "Economy", 380});
        clearTable();
        System.out.println(flights.size());
        for (CommercialFlight flight : flights) {
            tableModel.addRow(new Object[]{flight.getFlightId(), flight.getFlightName(), flight.getFlightCode(), flight.getFlightModel(), flight.getFlightClasses(), flight.getNoOfPassengers()});
        }
        System.out.println("Loading Flight Data!");
    }

    public void clearTable(){
        NewFlight.setEnabled(true);
        UpdateFlight.setEnabled(false);
        DeleteFlight.setEnabled(false);
        tableModel = new DefaultTableModel(null, columnNames);
        table1.setModel(tableModel);
    }

    public void addToFlightTable(ArrayList<CommercialFlight> flights, CommercialFlight flight){
        flights.add(flight);
//        System.out.println(flights.size());
//        System.out.println(tableModel.getRowCount());
        mf1.writeJsonFile(flights);
        tableModel.addRow(new Object[]{flight.getFlightId(), flight.getFlightName(), flight.getFlightCode(), flight.getFlightModel(), flight.getFlightClasses(), flight.getNoOfPassengers()});
//        loadFlightTable(flights);
    }

    public int alreadyExists(CommercialFlight flight){
        for(int i = 0; i < flights.size(); i++) {
            if (flight.getFlightName().equals(flights.get(i).getFlightName()) && flight.getFlightCode().equals(flights.get(i).getFlightCode()) && flight.getFlightModel().equals(flights.get(i).getFlightModel()) && flight.getFlightClasses().equals(flights.get(i).getFlightClasses()) && flight.getNoOfPassengers() == flights.get(i).getNoOfPassengers()){
                return i;
            }
        }
        return -1;
    }
}
