package AbstractClasses;


public abstract class Geometries {
    //Attribute
    protected String geometryName;

    //Constructor
    protected Geometries(String geometryName){
        this.geometryName = geometryName;
    }

    //Abstract method
    public abstract void draw(); //Abstract method

    //As we can see with getters and setters, abstract class accept no abstract method
    public String getGeometryName() {
        return geometryName;
    }

    public void setGeometryName(String geometryName) {
        this.geometryName = geometryName;
    }

    @Override
    public String toString() {
        return "Geometries{" +
                "geometryName='" + geometryName + '\'' +
                '}';
    }
}
