package health.health.management.domain.type;

public enum Location {
    SHOULEDER("어깨"), ARM("팔"), CHEST("가슴"),BACK("등"),LOWER("하체");

    private String location;

    Location(String value){
        this.location=value;
    }

    public String getLocation() {
        return location;
    }
}
