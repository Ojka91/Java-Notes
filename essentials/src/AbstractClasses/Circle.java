package AbstractClasses;

public class Circle extends Geometries {

    public Circle(String geometryName){
        super(geometryName); //Super constructor
    }

    //Define abstract draw method from Geometries
    public void draw(){
        System.out.println("Drawing...  " + this.getClass().getSimpleName());
    }
}
