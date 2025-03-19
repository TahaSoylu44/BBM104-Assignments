public abstract class Items extends Library {
    //VARIABLES
    protected String ID;
    protected String title;
    protected String type;

    //CONSTRUCTOR
    Items(String Id, String title, String type){
        this.ID = Id;
        this.title = title;
        this.type = type;
    }

    //GETTER
    public String getID() {return ID;}
    public String getTitle() {return title;}
    public String getType() {return type;}

    //SETTER
    public void setID(String ID) {this.ID = ID;}
    public void setTitle(String title) {this.title = title;}
    public void setType(String type) {this.type = type;}
}
