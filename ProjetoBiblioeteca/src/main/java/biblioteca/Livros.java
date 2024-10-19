
package biblioteca;
public class Livros {
    // Atributos da classe
    public String titulo;
    public String autor;
    private int ano_publi;
    private int num_exemplares;
    public boolean emprestado = false;
    
   // Construtores da classe livro
    public Livros (String titulo, String autor, int ano_publi, int num_exemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publi = ano_publi;
        this.num_exemplares = num_exemplares;
    }
    //Criação de get e set para ano da publicação
   
    public int getAno_publi() {
        return ano_publi;
    }

    public void setAno_publi(int ano_publi) {
        this.ano_publi = ano_publi;
    }
    //Criação de get e set para numero de exemplares

    public int getNum_exemplares() {
        return num_exemplares;
    }

    public void setNum_exemplares(int num_exemplares) {
        this.num_exemplares = num_exemplares;
    }
    
    
}
