import java.util.HashMap;
public abstract class Items extends Library {
    //VARIABLES
    protected String ID;
    protected String title;
    protected String type;
    //protected HashMap<String, Object> mapItem;

    //CONSTRUCTOR
    Items(String Id, String title, String type) {
        this.ID = Id;
        this.title = title;
        this.type = type;
        //this.mapItem = mapItem;
    }

    //GETTER
    public String getID() {return ID;}
    public String getTitle() {return title;}
    public String getType() {return type;}
    //public HashMap<String, Object> getMapItem() {return mapItem;}

    //SETTER
    public void setID(String ID) {this.ID = ID;}
    public void setTitle(String title) {this.title = title;}
    public void setType(String type) {this.type = type;}
    //public void setMapItem(HashMap<String, Object> mapItem) {this.mapItem = mapItem;}

    //BORROW
}
