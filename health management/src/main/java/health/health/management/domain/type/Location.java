package health.health.management.domain.type;

public enum Location {
    SHOULEDER("어깨"), ARM("팔"), CHEST("가슴"),BACK("등"),LOWER("하체");

    private String loc;

    Location(String value){
        this.loc=value;
    }

    public String getLocation() {
        return loc;
    }
}
