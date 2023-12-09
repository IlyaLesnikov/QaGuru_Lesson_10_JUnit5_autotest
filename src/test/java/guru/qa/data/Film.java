package guru.qa.data;

public enum Film {
    EUROTOUR("Евротур"),
    FOUNDER("Основатель");
    private final String description;
    Film(String description) {
        this.description = description;
    }
    public String getEurotour() {
        return description;
    }
    public String getFounder() {
        return description;
    }
}

