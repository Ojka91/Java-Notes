public class Exceptions {
    public static void main (String [] args) {
       try {
           Divide divide = new Divide(10,0);
       }catch (OperationException ex){
           System.out.println(ex + ex.getMessage());
           ex.getMessage();
       }
    }

    public class Divide{
        private int numerator;
        private int denominator;

        public Divide(int numerator, int denominator) throws OperationException{

            if(this.denominator == 0){
                throw new OperationException("Denominator = 0");
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }
    public class OperationException extends Exception{
        public OperationException(String msg){
            super(msg);
        }

    }
}
