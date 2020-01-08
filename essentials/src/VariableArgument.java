public class VariableArgument {
    public static void main (String [] args){
        printInfo("Hola", 1,2,3,4,5,6);
        printNumbers(1,2,3,58,4,5);
    }

    public static void printNumbers (int... numbers){
        for (int number:numbers) {
            System.out.println(number);
        }
    }

    public static void printInfo (String name, int... numbers){
        System.out.println(name);
        for (int number:numbers
             ) {
            System.out.println(number);
        }
    }
}
