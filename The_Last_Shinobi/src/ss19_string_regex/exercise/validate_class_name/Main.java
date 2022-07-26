package ss19_string_regex.exercise.validate_class_name;

public class Main {
    private static final String[] validName = new String[]{"C0318G", "A3466L", "P1098I"};
    private static final String[] invalidName = new String[]{"M0318G", "P0323A", "F1252V"};

    public static void main(String[] args) {
        ValidateClassName validateClassName = new ValidateClassName();

        for (String className : validName) {
            boolean isvalid = validateClassName.validate(className);
            System.out.println("Name is: " + className + " is valid: " + isvalid);
        }

        for (String className : invalidName) {
            boolean isvalid = validateClassName.validate(className);
            System.out.println("Name is: " + className + " is valid: " + isvalid);
        }
    }
}
