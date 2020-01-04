package AbstractClasses;

public class Main {
    public static void main (String [] args) {
       // Geometries geometries = new Geometries()  ---- Doesnt work bc abstract class can't be init
        Geometries geometries = new Square("Square");
        System.out.println(geometries);
        geometries.draw();
        geometries = new Circle("Circle");
        System.out.println(geometries);
        geometries.draw();


    }
}
