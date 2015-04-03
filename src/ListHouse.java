//details of a single house
import java.util.*;

public class ListHouse implements Listable {

    private int lotNumber;
    private String firstName;
    private String lastName;
    private int price;
    private int squareFeet;
    private int bedRooms;

    public ListHouse(int lotNumber, String firstName, String lastName, int price, int squareFeet, int bedRooms) {
        this.lotNumber = lotNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.price = price;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    public Listable copy() {
        ListHouse obj = new ListHouse(lotNumber, firstName, lastName, price, squareFeet, bedRooms);
        return obj;
    }

    public int compareTo(Listable tempList) {
        ListHouse other = (ListHouse) tempList;
        return (this.lotNumber - other.lotNumber);
    }

    public int lotNumber() {
        return lotNumber;
    }
    
    public String firstName() {
        return firstName;
    }
    
    public String lastName() {
        return lastName;
    }

    public int price() {
        return price;
    }

    public int squareFeet() {
        return squareFeet;
    }

    public int bedRooms() {
        return bedRooms;
    }
    
}
