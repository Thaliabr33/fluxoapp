package transacoes.fluxoapp;

public class Movimentacao {
    private String descricao;
    private String tipo;
    private double valor;
    private String data;
    private String categoria;
private int usuarioId;
public String getDescricao() {
    return descricao;
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
public double getValor() {
    return valor;
}
public void setValor(double valor) {
    this.valor = valor;
}
public String getData() {
    return data;
}
public void setData(String data) {
    this.data = data;
}
public String getCategoria() {
    return categoria;
}
public void setCategoria(String categoria) {
    this.categoria = categoria;
}
public int getUsuarioId() {
    return usuarioId;
}
public void setUsuarioId(int usuarioId) {
    this.usuarioId = usuarioId;
}
public Movimentacao(String descricao, String tipo, double valor, String data, String categoria, int usuarioId) {
    this.descricao = descricao;
    this.tipo = tipo;
    this.valor = valor;
    this.data = data;
    this.categoria = categoria;
    this.usuarioId = usuarioId;
}
@Override
public String toString() {
return "Movimentação: " + descricao + ", Tipo: " + tipo + ", Valor: " + valor + ", Data: " + data + ", Categoria: " + categoria + ", Usuário ID: " + usuarioId;    
}

}
