package biblioteca;

import java.time.LocalDate;

public class Livros {

    // Atributos da classe
    public String titulo;
    public String autor;
    private int ano_publi;
    private int numero_exemplares;
    private LocalDate data_Emprestimo;
    private LocalDate dataDevolucao;

    // Construtores da classe livro
    public Livros(String titulo, String autor, int ano_publi, int num_exemplares) {
        if(autor.matches(".*\\d.*")){
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

    public int getNum_exemplares (){
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

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataEmprestimo) {
        this.dataDevolucao = dataEmprestimo;
                // Calcula a data de devolução, a partir do dia do empréstimo
        this.dataDevolucao= dataEmprestimo.plusDays(7); // Adicionando 7 dias à data do empréstimo

    }
    
    // Criação de um metodo para mostrar se ainda tem livros do mesmo tipo
    
    public void estado_livro() {
        if (numero_exemplares == 0) {
            System.out.println("desculpa nao a mais exemplares");

        } else {

            numero_exemplares--;
            System.out.println("Um exemplar foi emprestado com sucesso. Exemplares restantes: " + numero_exemplares);
        }

    }

    public void delv() {
        numero_exemplares++;
        System.out.println("Um exemplar foi devolvido com sucesso ! Exemplares disponiveis: " + numero_exemplares);
    }

}
