
import java.util.*;

public class SortedList {
//    protected Listable[] list;

    public static List<ListHouse> list = new ArrayList<ListHouse>();

    public void insertItem(ListHouse house) {

        int insertPosition = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(house) < 0) {
                insertPosition ++;
            } 
        }
        list.add(insertPosition ,house);
    }

    public int getSize() {
        return list.size();
    }

    public ListHouse getItem(int i) {
        return list.get(i);
    }

    public ListHouse getItem(ListHouse house) {
        int itemPosition = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).lotNumber() == house.lotNumber()) {
                itemPosition = i;
            }
        }
        return list.get(itemPosition);
    }

    public boolean findItem(ListHouse newHouse) {
        boolean itemFound = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(newHouse) == 0) {
                itemFound = true;
            }
        }
        return itemFound;
    }

    public void removeItem(ListHouse house) {
        int itemPosition = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).lotNumber() == house.lotNumber()) {
                itemPosition = i;
            }
        }
        list.remove(itemPosition);
    }
}
