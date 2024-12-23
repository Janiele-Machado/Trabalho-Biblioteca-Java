package biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    //Atributos
    public Livros livros;
    public Usuarios usu;
    
    //método para a realização de emprestimos;
    
    void estado_uso(Livros liv, Usuarios usu) {
        this.livros = liv;
        this.usu = usu;

        if (this.usu.usu_disp == 0 & this.livros.getNum_exemplares() > 0) { //testa para saber se o livro e o usuario esta disponivel;

            this.livros.estado_livro();//aciona um método que faz a decrementação da quantidade de exemplares;

            this.usu.usu_disp = 1;// Cliente passa a ter um empréstimo ativo
            this.usu.livroEmprestado = this.livros;
            this.livros.setData_Emprestimo(LocalDate.now()); // Registra a data do empréstimo
            this.livros.setDataDevolucao(this.livros.getData_Emprestimo()); //aciona o método que calcula a data de devolução;

        } else if (this.livros.getNum_exemplares() == 0) { //retorno pro caso do numero de livros acabarem; 
            this.livros.estado_livro();

        } else { //retorno para o caso do usuario ja ter pegado um livro;
            System.out.println("Desculpe,Voce ja tem um livro em emprestimo");
        }

    }

    public void exibirEmprestimos(Usuarios usu ) {//método criado para a listagem dos emprestimos ativos;
        this.usu = usu;

        if (this.usu.usu_disp == 1) { //testa se o usuario tem algum emprestimo ativo;
            System.out.println("Livro: " + this.usu.livroEmprestado.titulo);
            System.out.println("Emprestado por: " + this.usu.getNome());
            System.out.println("Na data: " + this.usu.livroEmprestado.getData_Emprestimo());
            System.out.println("-------------------------------------------");
        }
    }
    // gets para auxiliar na opçao salvar
    public String getLivroemp(Usuarios usu){
        this.usu = usu;
        if(this.usu.usu_disp ==1){
            return this.usu.livroEmprestado.titulo;
            
        }
        return null;
        
    }
    public String getNome_emp(Usuarios usu){
        this.usu=usu;
        if(this.usu.usu_disp==1){
            return this.usu.getNome();
        }
        return null;
        
    }
    public LocalDate getdataemp(Usuarios usu){
        this.usu=usu;
        if(this.usu.usu_disp==1){
            return this.usu.livroEmprestado.getData_Emprestimo();
            
        }
        return null;
    }
}
