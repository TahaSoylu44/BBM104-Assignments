import java.util.HashMap;

public abstract class AcademicEntity {
    private final String code;
    private final String name;
    private static HashMap<String, AcademicEntity> mapAcademicEntity = new HashMap<>();

    AcademicEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //GETTER
    public String getCode() {return code;}
    public String getName() {return name;}
    public static HashMap<String, AcademicEntity> getMapAcademicEntity() {return mapAcademicEntity;}

    //SETTER
    public static void setMapAcademicEntity(String code, AcademicEntity academicEntity) {mapAcademicEntity.put(code, academicEntity);}
}
