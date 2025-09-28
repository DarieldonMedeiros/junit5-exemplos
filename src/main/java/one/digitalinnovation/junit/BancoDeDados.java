package one.digitalinnovation.junit;

import java.util.logging.Logger;

public class BancoDeDados {

    private static final Logger LOGGER = Logger.getLogger(BancoDeDados.class.getName());

    public static void iniciarConexao(){
        LOGGER.info("Iniciou conexão!");
    }

    public static void finalizarConexao(){
        LOGGER.info("Finalizou conexão!");
    }

    public static void inserirDados(Pessoa pessoa){
        // insere pessoa no banco de dados
        LOGGER.info("Inseriu dados!");
    }
    public static void removerDados(Pessoa pessoa){
        // remove pessoa no banco de dados
        LOGGER.info("Removeu dados!");
    }

}
