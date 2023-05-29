public enum Category {
    BOOKS("Книги"),
    STATIONERY("Канцтовары"),
    PUZZLES("Головоломки");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
