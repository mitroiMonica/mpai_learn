package q2;

public class Select {
    private String query;

    public Select(String source) {
        this.query = "SELECT * FROM " + source;
    }

    public Select where(String condition) {
        this.query += (" WHERE " + condition);
        return this;
    }

    public void execute() {
        System.out.println("executing: " + this.query);
    }
}
