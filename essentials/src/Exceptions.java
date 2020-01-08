public class Exceptions {
    public static void main(String[] args) {
        //envolve into trycatch bc it can throws an error
        try {
            Divide divide = new Divide(10, 0);
        } catch (OperationException ex) {
            System.out.println(ex + ex.getMessage());
            ex.getMessage();
        }
    }
}
     class Divide{
        private int numerator;
        private int denominator;

        public Divide(int numerator, int denominator) throws OperationException{ //can throws an OperationExc

            if(this.denominator == 0){
                throw new OperationException("Denominator = 0"); //execute an exception
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    //creation own exception
     class OperationException extends Exception{
        public OperationException(String msg){
            super(msg);
        }

    }

