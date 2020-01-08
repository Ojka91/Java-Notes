package Casting;

public class Director extends Employee {
    private String departament;

    public Director(String name, Double salary, String departament){
        super(name, salary); //goes to super constructor
        this.departament = departament;
    }

    public String getDetails(){
       return  super.getDetails() + " departamenrt " + this.departament;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
}
