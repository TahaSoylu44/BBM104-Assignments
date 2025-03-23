import java.util.ArrayList;

public class Guest extends Person {
    //VARIABLES
    private final String occupation;

    //CONSTRUCTOR
    Guest(String name, String ID, String phone, String occupation) {
        super(ID, name, phone,1,7,0, new ArrayList<>());
        this.occupation = occupation;
    }

    //GETTER
    public String getOccupation() {return occupation;}

    //SETTER
    //No need to implement setter for Guest Class.
}
