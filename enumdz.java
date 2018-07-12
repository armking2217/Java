package dz2;


public class enumdz {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(daysOfWeek.MONDAY));
    }
    public static int getWorkingHours(daysOfWeek t){
        switch (t){
            case MONDAY:
                return 8*5;
            case TUESDAY:
                return 8*4;
            case WEDNESDAY:
                return 8*3;
            case THURSDAY:
                return 8*2;
            case FRIDAY:
                return 8*1;
            default:
                return 0;
        }
    }

 }

enum daysOfWeek{
    MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY

}

//vygv