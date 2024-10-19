
package biblioteca;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome_inserido;
        String num_inserido;
        String email_inserido;
        String titulo_inserido;
        String autor_inserido;
        int ano_publi_inserido;
        int num_exemplares_inserido;
        
        int i=0;
        int f=0;
        Usuarios uso[] = new Usuarios[4];
        Livros lv[] = new Livros[4];   
        
            
        
        int opc=0;
        while(opc !=8){
        
       
        System.out.println("digite a opçao que gostaria de executar");
        System.out.println("1 cadastro clinte");
        System.out.println("2 cadastro livro");
        System.out.println("3 emprestimos");
        System.out.println("4 devoluçao");
        System.out.println("5 listagem livros");
        System.out.println("6 listagem de clientes");
        System.out.println("7 livros emprestados");
        System.out.println("8 sair");          
        opc = scan.nextInt();
        
        
        if(opc==1){
            
            
            do{
                if(i<4){
                    System.out.println("para cadastrar o "+(i+1)+" clinte preencha os campos abaixo");
                    System.out.println("digite o nome de usuario");
                    nome_inserido = scan.nextLine();
                    System.out.println("digite o email do usuario");
                    email_inserido =scan.nextLine();
                    System.out.println("digite o numero de indentificacao");
                    num_inserido= scan.nextLine();
                    
                    uso[i] = new Usuarios( nome_inserido ,email_inserido,num_inserido);
                    i++;   
                }else{
                    System.out.println("desculpe nao ha mais espaco para novos clintes");
                }
                
                
            }while(i<4);
       
        }else if(opc==2){
            
            do{
                if(f<4){
                    System.out.println("para cadastrar o "+(f+1)+" livro preencha os campos abaixo");
                    System.out.println("digite o titulo do livro");
                    titulo_inserido = scan.nextLine();
                    System.out.println("digite os autores do livro");
                    autor_inserido= scan.nextLine();
                    System.out.println("digite o ano de publicacao");
                    ano_publi_inserido=scan.nextInt();
                    System.out.println("digite o numero de exemplares");
                    num_exemplares_inserido = scan.nextInt();
                    lv[f]= new Livros(titulo_inserido, autor_inserido, ano_publi_inserido,num_exemplares_inserido);    
                    
                }else{
                    System.out.println("desculpe nao ha mais espaco novos livros");
                }
                    
                
                
                
            }while(f<4);
            
        }else if(opc==3){
            
        }else if(opc == 4){
            
        }else if(opc == 5){
            
        }else if(opc== 6){
            
        }else if(opc ==7){
            
            
        }else if(opc==8){
           
            
        }
        
        
        
        
        
        
        }
        
        
        
        
       
    }
    
}
