package q2;

public class Main {
    public static void main(String[] args) {
        Select select = new Select("Clients");
        Condition c1 = new Condition().equals("name", "Monik");
        Condition c2 = new Condition().greater("age", "18");
        Condition condition = new Condition().and(c1, c2);
        select.where(condition.apply());
        select.execute();
    }
}
