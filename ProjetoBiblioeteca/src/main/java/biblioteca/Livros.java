package biblioteca;

import java.time.LocalDate;

public class Livros {

    // Atributos da classe Livros
    public String titulo;
    public String autor;
    private int ano_publi;
    private int numero_exemplares;
    private LocalDate data_Emprestimo;
    private LocalDate dataDevolucao;

    // Construtores da classe Livros
    public Livros(String titulo, String autor, int ano_publi, int num_exemplares) {
        if (autor.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O nome do autor não pode conter números.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.ano_publi = ano_publi;
        this.numero_exemplares = num_exemplares;

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
        return numero_exemplares;
    }

    public void setNum_exemplares(int num_exemplares) {
        this.numero_exemplares = num_exemplares;
    }

    // Criação de get e set para data de emprestimo
    public LocalDate getData_Emprestimo() {
        return data_Emprestimo;
    }

    public void setData_Emprestimo(LocalDate dataEmprestimo) {
        this.data_Emprestimo = dataEmprestimo;
    }
    //   get e set da data de devolução
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataEmprestimo) {
        this.dataDevolucao = dataEmprestimo;
        // Calcula a data de devolução, a partir do dia do empréstimo
        this.dataDevolucao = dataEmprestimo.plusDays(7); // Adicionando 7 dias à data do empréstimo

    }

    //Criação de um método para a listagem de livros;
    public void dados() {
        System.out.println("Titulo : " + this.titulo);
        System.out.println("Autor : " + this.autor);
        System.out.println("Ano de publicacao: " + this.ano_publi);
        System.out.println("Numero de exemplares" + this.numero_exemplares);
    }

    // Criação de um metodo para decrementar a quantidade de livros,depois do emprestimo;
    public void estado_livro() {
        if (numero_exemplares == 0) { //retorno para o caso das unidades desse livro acabarem;
            System.out.println("desculpa nao a mais exemplares");

        } else {

            numero_exemplares--;
            System.out.println("Um exemplar foi emprestado com sucesso. Exemplares restantes: " + numero_exemplares);
        }

    }

    // Criação de um metodo para incrementar a quantidade de livros,depois da devolução;
    public void delv() {
        numero_exemplares++;
        System.out.println("Um exemplar foi devolvido com sucesso ! Exemplares disponiveis: " + numero_exemplares);
    }

}
