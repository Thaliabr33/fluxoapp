package app.fluxoapp;

import java.util.Scanner;

import modelos.fluxoapp.Usuario;
import transacoes.fluxoapp.Movimentacao;
import transacoes.fluxoapp.MovimentacaoControler;
import modelos.fluxoapp.ExportadorDados;
public class Main {
    public static void main(String[] args) {
        Usuario novoUsuario = new Usuario(0, null, null, null);

        MovimentacaoControler novoControle = new MovimentacaoControler();
        int operacao =0-1;
        Scanner leia = new Scanner(System.in);
        System.out.println("Bem-vindo ao FluxoAPP!");
        System.out.println("Vamos começar criando um usuário.");
        System.out.println("Digite seu nome: ");
        novoUsuario.setNome(leia.nextLine());
        System.out.println("Digite seu e-mail: ");
        novoUsuario.setEmail(leia.nextLine());
        System.out.println("Digite o seu salário: ");
        novoUsuario.setSaldo(leia.nextDouble());
        System.out.println("Escolha uma senha: ");
        leia.nextLine();
        novoUsuario.setSenha(leia.nextLine());
        System.out.println("Usuário criado com sucesso!");
        System.out.println("Nome: " + novoUsuario.getNome());
    do {
        System.out.println("Vamos para o login!");
        System.out.println("Digite sua senha: ");
        String senha = leia.nextLine();
        if (senha.equals(novoUsuario.getSenha())) {
            System.out.println("Login realizado com sucesso!");
        }
        else {
            System.out.println("Senha incorreta! Tente novamente.");
        }
    } while (!novoUsuario.getSenha().equals(leia.nextLine()));
    
    System.out.println("Bem-vindo, " + novoUsuario.getNome() + "! Vamos gerenciar suas movimentações financeiras.");

    do {
        exibeMenu();
        System.out.println("Digite a operação desejada: ");
        operacao = leia.nextInt();
        switch (operacao) {
            case 1:
                System.out.println("Cadastrar movimentação!");
                System.out.println("Digite o valor: ");
                double valor = leia.nextDouble();
                System.out.println("Digite a data (dd/mm/aaaa): ");
                String data = leia.next();
                System.out.println("Digite a categoria: Despesa ou Receita: ");
                String categoria = leia.next();
        while (!categoria.equalsIgnoreCase("Despesa") && !categoria.equalsIgnoreCase("Receita")) {
            System.out.println("Categoria inválida! Por favor, digite 'Despesa' ou 'Receita'.");
            System.out.println("Digite a categoria: Despesa ou Receita: ");
            categoria = leia.next();
        }
        System.out.println("Digite a descrição: ");
        leia.nextLine(); // Consome o \n pendente
        String descricao = leia.nextLine();

                Movimentacao novaMovimentacao = new Movimentacao(descricao, categoria, valor, data, categoria, novoUsuario.getId());
                novoControle.adicionarMovimentacao(novaMovimentacao);

                if (categoria.equalsIgnoreCase("Despesa")) {
                    novoUsuario.setSaldo(novoUsuario.getSaldo() - valor);
                } else if (categoria.equalsIgnoreCase("Receita")) {
                    novoUsuario.setSaldo(novoUsuario.getSaldo() + valor);
                }

                System.out.println("Movimentação cadastrada com sucesso!");
                break;
            case 2:
                System.out.println("Listar movimentações!");
                novoControle.listarMovimentacao();
                break;
            case 3:
                System.out.println("Remover movimentação!");
                System.out.println("Digite o índice da movimentação a ser removida: ");
                int index = leia.nextInt();
                novoControle.removerMovimentacao(index);
                break;
            case 4:
                System.out.println("Exibir saldo do usuário: R$" + novoUsuario.getSaldo());
                break;
            case 5:
                System.out.println("Exportar dados para arquivo!");
                leia.nextLine();
                System.out.print("Digite o nome do arquivo para exportar (ex: dados.txt): ");
                String nomeArquivo = leia.nextLine();
                try {
                    ExportadorDados.exportarUsuarioMovimentacoes(
                        novoUsuario,
                        novoControle.getMovimentacoes(),
                        nomeArquivo
                    );
                    System.out.println("Dados exportados com sucesso para " + nomeArquivo);
                } catch (Exception e) {
                    System.out.println("Erro ao exportar dados: " + e.getMessage());
                }
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Operação inválida! Tente novamente.");
        }
    } while (operacao != 0);
        
    leia.close();
}

    public static void exibeMenu() {
        System.out.println("Menu de Operações:");
        System.out.println("1 - Cadastrar Movimentação");
        System.out.println("2 - Listar Movimentações");
        System.out.println("3 - Remover Movimentação");
        System.out.println("4 - Exibir Saldo do Usuário");
        System.out.println("5 - Exportar dados para arquivo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}