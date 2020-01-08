package AbstractClasses;

public class Square extends Geometries {

    public Square (String geometryName){
        super(geometryName);
    }

    public void draw(){
        System.out.println("Drawing...  " + this.getClass().getSimpleName());
    }
}
