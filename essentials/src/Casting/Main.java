package Casting;

public class Main {
    public static void main (String [] args){
        Employee employee;
        employee = new Writter("John", 100, WritingType.MODERN);

        //employee.getWrittingType() can't call it bc i'ts employee

        System.out.println(employee.getDetails()); //get details from Writter bc override

        Writter writter = (Writter) employee; //downcast employee to writter
        System.out.println(writter.getWrittingTypeDesc()); //now we have writter methods

        ((Writter) employee).getWrittingTypeDesc(); //also we can downcast like this

        employee = new Director("Mmm", 500.0, "IDK");
        System.out.println(((Director)employee).getDepartament()); //casting employee to director
    }
}
