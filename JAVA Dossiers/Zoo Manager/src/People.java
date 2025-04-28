public abstract class People {
    private final String name;
    private final String id;

    /**
     * Constructs people instances
     * @param name      People name
     * @param id        People specific id
     */
    People(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //GETTERS
    public String getName() {return name;}
    public String getId() {return id;}
}
