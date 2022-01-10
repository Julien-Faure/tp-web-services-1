package fr.mines.ales.client;

import fr.mines.ales.web.services.tp.services.RoomService;
import fr.mines.ales.web.services.tp.services.RoomServiceException_Exception;
import fr.mines.ales.web.services.tp.services.RoomServiceService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Hello world!
 */
public class App {

    public static final String EXIT = "exit";

    public static void main(String[] args) throws RoomServiceException_Exception, IOException {
        RoomService rs = new RoomServiceService().getRoomServicePort();
        String in = "";

        do {
            if (!in.isEmpty()) {
                requestRoomBooking(rs, in);
            }
            System.out.println("Quel numéro chambre souhaitez-vous ?");
            in = getInput();
        } while (!in.equalsIgnoreCase(EXIT));

        System.out.println("Bye");
    }

    private static void requestRoomBooking(RoomService rs, String in) throws RoomServiceException_Exception {
        try {
            GregorianCalendar d1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11);
            GregorianCalendar d2 = new GregorianCalendar(2014, Calendar.FEBRUARY, 19);
            XMLGregorianCalendar xmdDate1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d1);
            XMLGregorianCalendar xmdDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d2);
            rs.bookRoom(Integer.parseInt(in), xmdDate1, xmdDate2);
            System.out.println("La chambre " + in + " a été réservée.");
        } catch (NumberFormatException e) {
            System.out.println("Veuillez-nous donner un numéro de chambre.");
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
