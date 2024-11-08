package biblioteca;


public class Usuarios {

    private String nome;
    private String email;
    private int num_ident;
    public int usu_disp;
    public Livros livroEmprestado;//variavel guardara o livro que o usuario pegou emprestado;

    public Usuarios(String nome, String email, int num_ident) {
        // Verifica se o nome contém números e lança IllegalArgumentException se for o caso
        if(nome.matches(".*\\d.*")){
            throw new IllegalArgumentException("O nome não pode conter números.");
        }
        
        
        this.nome = nome;
        this.email = email;
        this.num_ident = num_ident;
        this.usu_disp = 0;//o usuario vai ser criado ja com a disponibilidade de poder pegar um livro emprest.
        this.livroEmprestado = null; // Inicialmente, o usuário não tem livro emprestado
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public int getNum_ident() {
        return num_ident;
    }

    public void dados() {
        System.out.println("Usuario: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Numero de identificacao: " + this.num_ident);
    }

    public void delv_uso() {
        if (usu_disp == 1 && livroEmprestado != null) {
            livroEmprestado.setData_Emprestimo(null);//remove a data de emprestimo;
            livroEmprestado.setDataDevolucao(null);//remove a data de devolução;
            livroEmprestado.delv();
            livroEmprestado = null;
            usu_disp = 0;
            System.out.println(this.nome + " devolveu o livro.");

        } else {
            System.out.println("voce nao tem livros para devolver");
        }
    }
}
