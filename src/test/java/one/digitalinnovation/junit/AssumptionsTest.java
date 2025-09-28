package one.digitalinnovation.junit;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssumptionsTest {

    @Test
    void validarAlgoSomenteNoUsuarioDarieldon(){
        assumeTrue("darie".equals(System.getenv("USERNAME")));
        assertEquals(10, 5 + 5);
    }
}
