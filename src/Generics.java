import sun.net.www.content.text.Generic;

/**
 * Generic types
 * E --- Element (usualy java Collections framwroek)
 * K --- Key (used on maps)
 * N --- Number (used on numbers)
 * T --- Type (repreents type, so, a class)
 * V --- Value (also used in maps)
 * S,U,V... --- Other types
 */
public class Generics {
    public static void main (String [] args) {

        //Can't use primitive types (int, boolean....) must use Object (Integer, Boolean...)
        GenericClass<Integer> myObj = new GenericClass<Integer>(15);
        myObj.getType();

        GenericClass<String> myObj2 = new GenericClass("string");
        myObj2.getType();

        GenericClass<Boolean> myObj3 = new GenericClass<>(false);
        myObj3.getType();
    }

}

//T is generic type
class GenericClass<T>{

    //define generic variable
    T object;

    //Constructor init type
    public GenericClass(T object){
        this.object = object;
    }

    //print class type
    public void getType(){
        System.out.println("class type is... " + object.getClass().getName());
    }
}
