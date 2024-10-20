package biblioteca;

public class Usuarios {
    private String nome;
    private String email;
    private String num_ident;
    public int usu_disp;
    private Livros livroEmprestado;

    public Usuarios(String nome, String email, String num_ident){
        this.nome = nome;
        this.email = email;
        this.num_ident = num_ident;
        this.usu_disp=0;//o usuario vai ser criado ja com a disponibilidade de poder pegar um livro emprest.
        this.livroEmprestado = null; // Inicialmente, o usuário não tem livro emprestado
    }
    

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNum_ident() {
        return num_ident;
    }
    
    public void dados(){
        System.out.println("Usuario: " + this.nome);
        System.out.println("Email: " + this.email);
        System.err.println("Numero de identificação: " + this.num_ident);
    }
    public void estado_uso(Livros livro){
        if(usu_disp==0){
            livro.estado_livro();
            this.livroEmprestado = livro;
            this.usu_disp=1;
        }else{
            System.out.println("desculpe voce ja tem um livro em emprestimo");
        }
    }
    public void delv_uso(){
        if(usu_disp == 1 && livroEmprestado != null){
           livroEmprestado.delv();
           livroEmprestado = null; 
            usu_disp = 0; 
            System.out.println(this.nome + " devolveu o livro.");
           
            
        }else{
            System.out.println("voce nao tem livros para devolver");
        }
    }
}
