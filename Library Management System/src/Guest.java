public class Guest extends Person {
    //VARIABLES
    private String occupation;

    //CONSTRUCTOR
    Guest(String ID, String name, String phone, String occupation) {
        super(ID, name, phone,1,7);
        this.occupation = occupation;
    }

    //GETTER
    public String getOccupation() {return occupation;}

    //SETTER
    public void setOccupation(String occupation) {this.occupation = occupation;}
}
