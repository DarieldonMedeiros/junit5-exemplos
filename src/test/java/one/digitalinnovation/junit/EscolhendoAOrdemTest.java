package one.digitalinnovation.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

// MethodOrderer.MethodName.class -> ordena a execução via ordem alfabética
// Random -> Executa em uma ordem aleatória
// DisplayName -> Ordena a execução de acordo com o DisplayName
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoAOrdemTest {

    @DisplayName("A")
    @Order(4)
    @Test
    void validaFluxoA(){
        assertTrue(true);
    }

    @DisplayName("B")
    @Order(3)
    @Test
    void validaFluxoB(){
        assertTrue(true);
    }

    @DisplayName("C")
    @Order(2)
    @Test
    void validaFluxoC(){
        assertTrue(true);
    }

    @DisplayName("D")
    @Order(1)
    @Test
    void validaFluxoD(){
        assertTrue(true);
    }
}
