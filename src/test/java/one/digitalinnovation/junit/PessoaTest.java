package one.digitalinnovation.junit;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {


    @Test
    void deveCalcularIdadeCorretamente(){
        Pessoa jessica = new Pessoa("Jéssica", LocalDateTime.of(2000, 1, 1, 15, 0, 0));
        Assertions.assertEquals(25, jessica.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade(){
        Pessoa joao = new Pessoa("Joãozinho", LocalDateTime.of(2020, 1, 1, 15, 0));
        Assertions.assertFalse(joao.ehMaiorDeIdade());

        Pessoa darieldon = new Pessoa("Darieldon", LocalDateTime.of(1994, 11, 9, 12, 50));
        Assertions.assertTrue(darieldon.ehMaiorDeIdade());

        List<Pessoa> pessoas = List.of(new Pessoa("Julia", LocalDateTime.now()), new Pessoa("Maria", LocalDateTime.now()));

        Assertions.assertAll("pessoas",
                () -> Assertions.assertFalse(pessoas.get(0).ehMaiorDeIdade()),
                () -> Assertions.assertFalse(pessoas.get(1).ehMaiorDeIdade())
        );
    }

}
