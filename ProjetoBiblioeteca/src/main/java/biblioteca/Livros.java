
package biblioteca;
public class Livros {
    // Atributos da classe
    String titulo;
    String autor;
    private int ano_publi;
    private int num_exemplares;
   
   // Construtores da classe livro
    public Livros (String titulo, String autor, int ano_publi, int num_exemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publi = ano_publi;
        this.num_exemplares = num_exemplares;
    }
}
