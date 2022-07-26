package ss19_string_regex.exercise.validate_phone;

public class Main {
    private static final String[] validName = new String[]{"(84)-(0978489648)", "(84)-(0962517223)"};
    private static final String[] invalidName = new String[]{"(a8)-(22222222)", "(34)-(012345678)"};

    public static void main(String[] args) {
        ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();

        for (String phoneNumber : validName) {
            boolean isvalid = validatePhoneNumber.validate(phoneNumber);
            System.out.println("Name is: " + phoneNumber + " is valid: " + isvalid);
        }

        for (String phoneNumber : invalidName) {
            boolean isvalid = validatePhoneNumber.validate(phoneNumber);
            System.out.println("Name is: " + phoneNumber + " is valid: " + isvalid);
        }
    }
}
