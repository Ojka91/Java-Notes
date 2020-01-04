public class Enum {
    public static void main (String [] args){
        //Print DAY
        System.out.println(Days.TUESDAY);
        System.out.println(Days.TUESDAY.getDay());
        DayInfo(Days.WEDNESDAY);
    }

    //Static variables always caps
    public enum Days{
        MONDAY(1), //you can add variables to
        TUESDAY(2),
        WEDNESDAY(3);
        private final int number;

        Days(int day){
            this.number = day;
        }
        public int getDay(){
            return number;
        }
    }

    public static void DayInfo(Days day){
        switch (day){
            case MONDAY:
                System.out.println("First day of week");
                break;
            case TUESDAY:
                System.out.println("Second day");
                break;
            case WEDNESDAY:
                System.out.println("Third day");
        }
    }

}
