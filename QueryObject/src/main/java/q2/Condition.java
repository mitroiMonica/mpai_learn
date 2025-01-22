package q2;

public class Condition {
    private String conditionText;

    public Condition() {
        conditionText = "";
    }

    public Condition greater(String op1, String op2) {
        conditionText += op1 + " > " + op2;
        return this;
    }

    public Condition equals(String op1, String op2) {
        conditionText += op1 + " = " + op2;
        return this;
    }

    public Condition less(String op1, String op2) {
        conditionText += op1 + " < " + op2;
        return this;
    }

    public Condition and(Condition op1, Condition op2) {
        conditionText += op1.conditionText + " and " + op2.conditionText;
        return this;
    }

    public String apply() {
        System.out.println("applying " + conditionText);
        return conditionText;
    }
}
