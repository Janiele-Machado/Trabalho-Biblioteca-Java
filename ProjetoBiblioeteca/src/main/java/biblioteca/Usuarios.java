package biblioteca;

public class Usuarios {
    private String nome;
    private String email;
    private String num_ident;

    public Usuarios(String nome, String email, String num_ident){
        this.nome = nome;
        this.email = email;
        this.num_ident = num_ident;
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
}
