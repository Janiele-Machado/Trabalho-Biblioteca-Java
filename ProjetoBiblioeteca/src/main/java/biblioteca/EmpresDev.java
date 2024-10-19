
package biblioteca;

public class EmpresDev {
    public Livros livro;
    public Usuarios usu;
    private boolean emprest;
    
    void empres (Livros liv_titulo,Usuarios usu){
         this.livro = liv_titulo;
         this.usu=usu;
         
        if (this.livro.emprestado==false) { //esse primeiro if vai testar se o livro foi emprestado ou nao 
            if (this.usu.usu_disp==true) {
                this.usu.usu_disp=false;
                this.livro.emprestado=true;
                System.out.println("Emprestimo realizado com sucesso");
            }
//emprestado vai mudar de valor e tbm tem que colocar o usuario e o livro indisponivel; 
            
        }else{
            System.out.println("O livro nao esta disponivel para o emprestimo");
            
        }
                
        
    }
}
