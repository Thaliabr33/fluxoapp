  package app.fluxoapp;

import java.util.Scanner;

import modelos.fluxoapp.Usuario;
import transacoes.fluxoapp.Movimentacao;
import transacoes.fluxoapp.MovimentacaoControler;

public class Main {
    public static void main(String[] args) {
        Usuario novoUsuario = new Usuario(0, null, null, null);

        Movimentacao novaMovimentacao = new Movimentacao(null, null, 0, null, null, 0);
        MovimentacaoControler novoControle = new MovimentacaoControler();
        int operacao =0-1;
        Scanner leia = new Scanner(System.in);
        System.out.println("Bem-vindo ao FluxoAPP!");
        System.out.println("Digite seu nome: ");
        novoUsuario.setNome(leia.nextLine());
        System.out.println("Digite seu email: ");
        novoUsuario.setEmail(leia.nextLine());
        System.out.println("Digite o seu salario: ");
        novoUsuario.setSaldo(leia.nextDouble());
    
        do {
    exibeMenu();
System.out.println("Digite a operação desejada: ");
operacao = leia.nextInt();
switch (operacao) {
    case 1:
    System.out.println("Cadastrar movimentação!");
    System.out.println("Digite a descrição: ");
    novaMovimentacao.setDescricao(leia.next());
    System.out.println("Digite o valor: ");
    novaMovimentacao.setValor(leia.nextDouble());
    System.out.println("Digite a data (dd/mm/aaaa): ");
    novaMovimentacao.setData(leia.next());
    System.out.println("Digite a categoria: Despesa ou Receita: ");
    novaMovimentacao.setCategoria(leia.next());
    novoControle.adicionarMovimentacao(novaMovimentacao);
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
    case 0:
    System.out.println("Saindo...");
    break;
    default:
    System.out.println("Operação inválida! Tente novamente.");
        }
    } while (operacao != 0);
        
    }
        

public static void exibeMenu() {
    System.out.println("Menu de Operações:");
    System.out.println("1 - Cadastrar Movimentação");
    System.out.println("2 - Listar Movimentações");
    System.out.println("3 - Remover Movimentação");
    System.out.println("0 - Sair");
    System.out.print("Escolha uma opção: ");
}
} 