
package biblioteca;

public class EmpresDev {
    public Livros livro;
    public Usuarios usu;
    private boolean emprest;
    
    void empres (Livros liv_titulo,Usuarios usu){
         this.livro = liv_titulo;
         this.usu=usu;
         
        if (this.livro.emprestado==false) {
           //emprestado vai mudar de valor e tbm tem que colocar o usuario e o livro indisponivel; 
            
        }
                
        
    }
}
