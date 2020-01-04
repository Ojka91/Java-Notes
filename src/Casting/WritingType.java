package Casting;

public enum WritingType {
    CLASSIC("Hand Writting"),
    MODERN("Computer");

    private final String description;

    private WritingType(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
