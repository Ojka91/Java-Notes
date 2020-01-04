package Interfaces;

public class Main {
    public static void main (String [] args) {

            DataAcces dataAcces = new OracleIMPL();

            dataAcces.insert();
            dataAcces.select();
        System.out.println(dataAcces.MAX_REGISTER);
    }
}
