
package biblioteca;

public class EmpresDev {
    public Livros livro;
    public Usuarios usu;
    //private boolean emprest;
    
    void emprestimo (Livros liv,Usuarios usu){ /*esse método realizara os emprestimos,testando antes a disponibilidade*/
         this.livro = liv;
         this.usu=usu;
        if (this.livro.emprestado==false) { //esse primeiro if vai testar se o livro foi emprestado ou nao 
            if (this.usu.usu_disp==true) { //nesse outro if vai testar se o usuario pode pegar emprestado ou nao;
                this.usu.usu_disp=false;
                this.livro.emprestado=true;
                System.out.println("Emprestimo realizado com sucesso");
                System.out.println("A data de emprestimo: ");
                
            }else{
                System.out.println("Erro em emprestimo,o usuario ja esta com um livro emprestado");
            }            
        }else{
            System.out.println("O livro nao esta disponivel para o emprestimo");
            
        }
                
        
    }
    
    void devolucao(Livros liv,Usuarios usu){ //método de devoluçao,que torna o livro e o usuário disponivel
        this.livro=liv;
        this.usu=usu;
        
        if (this.livro.emprestado==true & this.usu.usu_disp==false) { //testa se tanto o livro esta emprestado,tanto o usuario;
            this.livro.emprestado=false;
            this.usu.usu_disp=true;
            System.out.println("Devolucao realizada com sucesso!");
        }else if (this.livro.emprestado==false) {
            System.out.println("O livro ja esta disponivel");
        }else if (this.usu.usu_disp==true) {
            System.out.println(usu.getNome()+" Nao possui emprestimos ativos");
        }
           
        
        
    } 
    
    void registro_emprest(Livros liv){
        System.out.println("Registro de empréstimos: ");
        System.out.println("Livro: "+liv.titulo+" Emprestado para " /*+liv.usu.nome" no dia "+ liv.data_emprest*/);
    }
    
}
