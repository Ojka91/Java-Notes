package Casting;

public class Writter extends Employee {

    final WritingType writtingType;

    public Writter (String name, double salary, WritingType writingType){
        super(name, salary);
        this.writtingType = writingType;
    }

    public String getDetails(){
        return super.getDetails() + " writtingtype " + writtingType.getDescription();
    }

    public WritingType getWrittingType (){
        return writtingType;
    }

    public String getWrittingTypeDesc(){
        return writtingType.getDescription();
    }
}
