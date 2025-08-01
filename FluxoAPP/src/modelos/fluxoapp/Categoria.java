package modelos.fluxoapp;

public class Categoria {
private String nome;
private String tipo;

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public Categoria(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
}

@Override
public String toString() {
return "Categoria: " + nome + ", Tipo: " + tipo;    
}


    
}