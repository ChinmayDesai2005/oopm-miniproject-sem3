import Model.Airport;
import Model.Flight;
import Model.Schedule;

import java.util.Calendar;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Airport details
        Airport a1 = new Airport();
         a1.setAirportName("Delhi Indira Gandhi International Airport ");
        a1.setAirportLocation("Delhi");
        a1.setAirportCode("DEL");
        a1.setIsInternational("Yes");
        a1.setNoOfRunways(3);

        Airport a2 = new Airport();
        a2.setAirportId("");
        a2.setAirportName("Mumbai Chhatrapati Shivaji International Airport");
        a2.setAirportLocation("Mumbai, India");
        a2.setAirportCode("BOM");
        a2.setIsInternational("Yes");
        a2.setNoOfRunways(3);

        Airport a3 = new Airport();
        a3.setAirportId("");
        a3.setAirportName("Kolkata Subash Chandra Bose International Airport");
        a3.setAirportLocation("Kolkata,India");
        a3.setAirportCode("CCU");
        a3.setIsInternational("Yes");
        a3.setNoOfRunways(3);

        Airport a4 = new Airport();
        a4.setAirportId("");
        a4.setAirportName("Chennai International Airport");
        a4.setAirportLocation("Chennai, India");
        a4.setAirportCode("MAA");
        a4.setIsInternational("Yes");
        a4.setNoOfRunways(3);

        Airport a5 = new Airport();
        a5.setAirportId("");
        a5.setAirportName("Visakhapatnam Airport");
        a5.setAirportLocation("Visakhapatnam");
        a5.setAirportCode("VTZ");
        a5.setIsInternational("No");
        a5.setNoOfRunways(2);

        //flight details
        Flight f1 = new Flight();
        f1.setFlightName("Vistara");
        f1.setFlightDate(11,8,2023);
        f1.setToAirport("Mumbai");
        f1.setFlightCode("AI863");
        f1.setFlightModel("32N");
        f1.setFlightCapacity(200);

        Flight f2 = new Flight();
        f2.setFlightName("Vistara");
        f2.setFlightDate(15,8,2023);
        f2.setToAirport("Kolkata");
        f2.setFlightCode("UK773");
        f2.setFlightModel("A20N");
        f2.setFlightCapacity(250);

        Flight f3 = new Flight();
        f3.setFlightName("Air India");
        f3.setFlightDate(16,8,2023);
        f3.setToAirport("London");
        f3.setFlightCode("AI131");
        f3.setFlightModel("B788");
        f3.setFlightCapacity(400);

        Flight f4 = new Flight();
        f4.setFlightName("Indigo");
        f4.setFlightDate(20,8,2023);
        f4.setToAirport("Goa");
        f4.setFlightCode("6E5051");
        f4.setFlightModel("A21N");
        f4.setFlightCapacity(250);

        Flight f5 = new Flight();
        f5.setFlightName("Emirates");
        f5.setFlightDate(9,9,2023);
        f5.setToAirport("Dubai");
        f5.setFlightCode("EK506");
        f5.setFlightModel("B77W");
        f5.setFlightCapacity(500);
        
        
        
        
        Schedule s1 = new Schedule();
        Calendar cal1 =Calendar.getInstance();
        cal1.set(2023,8,10);

        Schedule s2=new Schedule();
        Calendar cal2=Calendar.getInstance();
        cal2.set(2023,8,10);

        Schedule s3 = new Schedule();
        Calendar cal3 =Calendar.getInstance();
        cal3.set(2023,8,10);

        Schedule s4 = new Schedule();
        Calendar cal4 =Calendar.getInstance();
        cal4.set(2023,8,10);

        Schedule s5 = new Schedule();
        Calendar cal5 =Calendar.getInstance();
        cal5.set(2023,8,10);

        Schedule s6 = new Schedule();
        Calendar cal6 =Calendar.getInstance();
        cal6.set(2023,8,10);

        Schedule s7 = new Schedule();
        Calendar cal7 =Calendar.getInstance();
        cal7.set(2023,8,10);






        s1.schedule_fight_to_airport(a1,f1,cal1);
        s2.schedule_fight_to_airport(a1,f5,cal5);
        s3.schedule_fight_to_airport(a2,f2,cal2);
        s4.schedule_fight_to_airport(a3,f3,cal3);
        s5.schedule_fight_to_airport(a4,f5,cal5);
        s6.schedule_fight_to_airport(a5,f4,cal4);
        s7.schedule_fight_to_airport(a3,f3,cal3);

        s1.display_flights_scheduled();
        s2.display_flights_scheduled();
        s3.display_flights_scheduled();
        s4.display_flights_scheduled();
        s5.display_flights_scheduled();
        s6.display_flights_scheduled();
        s7.display_flights_scheduled();

    }
}