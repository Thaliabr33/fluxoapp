package modelos.fluxoapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import transacoes.fluxoapp.Movimentacao;

public class ExportadorDados {

    public static void exportarUsuarioMovimentacoes(Usuario usuario, List<Movimentacao> movimentacoes, String nomeArquivo) throws IOException {
        // Diretório "exportacoes" fora da pasta src, baseado no diretório onde o programa está rodando
        String pastaExportacao = System.getProperty("user.dir") + File.separator + "exportacoes";
        File pasta = new File(pastaExportacao);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // Caminho completo para o arquivo
        String caminhoArquivo = pastaExportacao + File.separator + nomeArquivo + ".csv";

        try (FileWriter writer = new FileWriter(caminhoArquivo, StandardCharsets.UTF_8)) {
            writer.write("Nome,Email,Saldo\n");
            writer.write(usuario.getNome() + "," + usuario.getEmail() + "," + usuario.getSaldo() + "\n\n");

            writer.write("Descrição,Tipo,Valor,Data,Categoria\n");
            for (Movimentacao mov : movimentacoes) {
                writer.write(
                    mov.getDescricao() + "," +
                    mov.getTipo() + "," +
                    mov.getValor() + "," +
                    mov.getData() + "," +
                    mov.getCategoria() + "\n"
                );
            }
        }
    }
}
