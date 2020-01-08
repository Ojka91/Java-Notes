package InstanceOf;

//Instance of can compare the object type
public class Main {
    public static void main (String [] args){
        Geometry geo = new Geometry();
        geo = new Circle();
        checkType(geo);

    }

    public static void checkType(Geometry geometry){
        if(geometry instanceof Triangle){
            System.out.println("Triangle");
        }
        if(geometry instanceof Circle){
            System.out.println("Circle");
        }
        if(geometry instanceof Geometry){
            System.out.println("Geometry");
        }
    }
}
