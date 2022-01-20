package ir.maktab.regexValidation;

public class Validation {
    public boolean validateEmail(String email) throws RuntimeException {
        if (email.matches("^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)")) {
            return true;
        }
        throw new RuntimeException("invalid Email!");
    }

    public boolean validateName(String name) throws RuntimeException {
        if (name.length() > 2 && name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            return true;
        }
        throw new RuntimeException("invalid name!");
    }

    public boolean validateNumber(String number) throws RuntimeException {
        if (number.matches("^[0-9]*$")) {
            return true;
        }
        throw new RuntimeException("invalid number!");
    }
    public boolean validatePassword(String password) throws RuntimeException {
        if (password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")) {
            return true;
        }
        throw new RuntimeException("invalid password!");
    }
}
