//external house file

import java.io.*;
import java.util.*;

public class HouseFile {

    private static Formatter writer;
    private static Scanner scanner;

    boolean scannerOn = false;
    boolean writerOn = false;

    public void addHouses(SortedList list) {
        try {
            if (scannerOn) {
                scanner.close();
                scannerOn = false;
            }

            writer = new Formatter("houses.txt");

            for (int i = 0; i < list.getSize(); i++) {
                ListHouse house = list.getItem(i);
                if (i == list.getSize()-1) {
                    writer.format("%d %s %s %d %d %d", house.lotNumber(), house.firstName(), house.lastName(), house.price(), house.squareFeet(), house.bedRooms());
                } else {
                    writer.format("%d %s %s %d %d %d%n", house.lotNumber(), house.firstName(), house.lastName(), house.price(), house.squareFeet(), house.bedRooms());
                }
            }
            
            writer.close();
        } catch (Exception e) {

        }
    }

    public void resetToRead() {
        try {
            if (scannerOn) {
                scanner.close();
                scannerOn = false;
            }
            scanner = new Scanner(new FileReader("houses.txt"));
            scannerOn = true;
        } catch (Exception e) {

        }
    }

    public boolean hasNextHouse() {
        if (scannerOn && scanner.hasNextLine()) {
            return true;
        } else {
            return false;
        }
    }

    public ListHouse getNextHouse() {
        
        int lotNumber = Integer.parseInt(scanner.next());
        String firstName = scanner.next();
        String lastName = scanner.next();
        int price = Integer.parseInt(scanner.next());
        int squareFeet = Integer.parseInt(scanner.next());
        int bedRooms = Integer.parseInt(scanner.next());

        ListHouse house = new ListHouse(lotNumber, firstName, lastName, price, squareFeet, bedRooms);
        return house;
    }

}
