package factory_method;

public class MicrosoftWord implements AbstractDocument {
    private String name;

    MicrosoftWord() {
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
