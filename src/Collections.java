import javax.jws.soap.SOAPMessageHandlers;
import java.util.ArrayList;
import java.util.*;
public class Collections {
    public static void main (String [] args) {

        //does accept duplicates
        List<String> myList = new ArrayList();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        //added repeated element
        myList.add("3");

        //does not accept duplicates
        Set<Integer> mySet = new HashSet();
        mySet.add(100);
        mySet.add(200);
        mySet.add(300);
        //add duplicated element
        mySet.add(300);
        mySet.add(84);

        //map replace duplicated value with the lastone
        Map<String, Boolean> myMap = new HashMap();
        myMap.put("var1", false);
        myMap.put("var2", true);
        myMap.put("var3", true);
        myMap.put("var4", true);
        //duplicated element
        myMap.put("var2", false);

        print(myMap.keySet()); //print only keys
        print(myMap.values()); //print only values

        System.out.println(myMap.get("var2"));

        print(mySet);
        print(myList);

    }


    private static void print(Collection collection){ //Array, Set, Map ..... implements from Collections
        for (Object el: collection) {
            System.out.println(el);
        }
    }
}
