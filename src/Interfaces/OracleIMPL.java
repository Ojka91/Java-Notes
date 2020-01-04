package Interfaces;

public class OracleIMPL implements DataAcces {

    @Override //override is optional, doesnt override anything, just telling the compiler
    public void insert() {
        System.out.println("Inserting oracle...");
    }

    @Override
    public void select() {
        System.out.println("Select from oracle...");
    }
}
