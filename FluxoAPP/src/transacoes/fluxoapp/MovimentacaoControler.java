package transacoes.fluxoapp;

import java.util.ArrayList;

public class MovimentacaoControler {
private ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
public void adicionarMovimentacao (Movimentacao mov) {
    movimentacoes.add(mov);
    System.out.println("Movimentação adicionada: " + mov);
}
public void listarMovimentacao() {
    if (movimentacoes.isEmpty()) {
        System.out.println("Nenhuma movimentação registrada.");
}
    else {
        for (Movimentacao movi : movimentacoes) {
            System.out.println(movi);
        }
    }

}
public void  removerMovimentacao (int index) {

    if (index < 0 || index >= movimentacoes.size()) {
        System.out.println("Índice inválido. Não foi possível remover a movimentação.");
}
    else{
        movimentacoes.remove(index);
    }
}
}