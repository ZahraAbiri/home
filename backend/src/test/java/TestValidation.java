import ir.maktab.regexValidation.Validation;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestValidation {
    static Validation validation;
    @Before
    void init() {
        this.validation = new Validation();
    }

    @ParameterizedTest
    @CsvSource({"aA2saraa,true", "4,false", "123kj,false", "10Aabaran,true"})
    void validPassword(String password, boolean resul) {
        boolean result = validation.validatePassword(password);
        Assertions.assertEquals(resul, result);
    }

    @ParameterizedTest
    @CsvSource({"sara,true", "s2aa,false", "123kamran,false", "baran,true"})
    void validateName(String name, boolean resul) {
        boolean result = validation.validateName(name);
        Assertions.assertEquals(resul, result);
    }
    @ParameterizedTest
    @CsvSource({"sara@gmail.com,true", "s.g.come,false", "sara@gmail.ir,false", "baran123@gmail.com,true"})
    void validateEmail(String email, boolean resul) {
        boolean result = validation.validateEmail(email);
        Assertions.assertEquals(resul, result);
    }


}
