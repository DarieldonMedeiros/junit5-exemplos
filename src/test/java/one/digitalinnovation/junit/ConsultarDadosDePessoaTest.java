package one.digitalinnovation.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class ConsultarDadosDePessoaTest {

    @BeforeAll
    static void configuraConexao(){
        BancoDeDados.iniciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste(){
        BancoDeDados.inserirDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0)));
    }

    @AfterEach
    void removeDadosParaTeste(){
        BancoDeDados.removerDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0)));
    }

    @Test
    void validarDadosDeRetorno(){
        assertTrue(true);
    }

    @Test
    void validarDadosDeRetorno2(){
        assertNull(null);
    }

    @AfterAll
    static void finalizaConexao(){
        BancoDeDados.finalizarConexao();
    }
}
