package factory_method;

public class GoogleDoc implements AbstractDocument {
    private String name;

    GoogleDoc() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println(this.name + " has opened");
    }
}
