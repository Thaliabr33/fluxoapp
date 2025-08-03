package modelos.fluxoapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import transacoes.fluxoapp.Movimentacao;

public class ExportadorDados {
    public static void exportarUsuarioMovimentacoes(Usuario usuario, List<Movimentacao> movimentacoes, String caminhoArquivo) throws IOException {
        try (java.io.OutputStreamWriter writer = new java.io.OutputStreamWriter(new java.io.FileOutputStream(caminhoArquivo), java.nio.charset.StandardCharsets.UTF_8)) {
            writer.write("Nome: " + usuario.getNome() + "\n");
            writer.write("Email: " + usuario.getEmail() + "\n");
            writer.write("Saldo: " + usuario.getSaldo() + "\n\n");
            writer.write("Movimentações:\n");
            for (Movimentacao mov : movimentacoes) {
                writer.write("Descrição: " + mov.getDescricao() + "\n");
                writer.write("Tipo: " + mov.getTipo() + "\n");
                writer.write("Valor: " + mov.getValor() + "\n");
                writer.write("Data: " + mov.getData() + "\n");
                writer.write("Categoria: " + mov.getCategoria() + "\n");
            }
        }
    }
}
