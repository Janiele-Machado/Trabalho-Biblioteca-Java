
package biblioteca;


public class Emprestimo {
     public Livros livros;
     public Usuarios usu;
 
    
    void estado_uso (Livros liv,Usuarios usu){
        this.livros=liv;
        this.usu=usu;
        
        if (this.usu.usu_disp != 0 ) {
           livros.estado_livro();
           this.usu.usu_disp=1;
           this.usu.livroEmprestado = this.livros;
          
        }else {
            System.out.println("Desculpe,Voce ja tem um livro em emprestimo");
        }
             
        
    }
     
}
