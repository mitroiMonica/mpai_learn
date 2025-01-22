package q1;

public class Select {
    private String queryText;
    public Select(String source) {
        queryText = "select * from " + source;
    }

    public Select where(String condition){
        queryText += "where " + condition;
        return this;
    }

    public void execute(){
        System.out.println("executing: " + queryText);
    }

}
