package biblioteca;

import java.time.LocalDate;

public class Emprestimo {

    public Livros livros;
    public Usuarios usu;

    void estado_uso(Livros liv, Usuarios usu) {
        this.livros = liv;
        this.usu = usu;

        if (this.usu.usu_disp == 0) {
            livros.estado_livro();
            this.usu.usu_disp = 1;// Cliente tem um empréstimo ativo
            this.usu.livroEmprestado = this.livros;
            livros.setData_Emprestimo(LocalDate.now()); // Registrar a data do empréstimo

        } else {
            System.out.println("Desculpe,Voce ja tem um livro em emprestimo");
        }

    }

    public void exibirEmprestimos(Usuarios usu) {//resolvi o uso do this;
        this.usu=usu;
        
        if (this.usu.usu_disp == 1) {
            System.out.println("Livro: " + this.usu.livroEmprestado.titulo);
            System.out.println("Emprestado por: " + this.usu.getNome());
            System.out.println("Na data: " + this.usu.livroEmprestado.getData_Emprestimo());
            System.out.println("-------------------------------------------");
        }
    }
}
