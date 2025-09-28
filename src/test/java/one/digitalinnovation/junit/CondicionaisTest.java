package one.digitalinnovation.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class CondicionaisTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "darie")

    void validarAlgoSomenteNoUsuarioDarieldon(){
        assertEquals(10, 5 + 5);
    }
}
