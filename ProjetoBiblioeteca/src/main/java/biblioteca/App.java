package biblioteca;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome_inserido;
        int num_inserido;
        String email_inserido;
        String titulo_inserido;
        String autor_inserido;
        int ano_publi_inserido;
        int num_exemplares_inserido;

        int i = 0;
        int f = 0;
        Usuarios uso[] = new Usuarios[4];
        Livros lv[] = new Livros[4];
        Emprestimo emp[] = new Emprestimo[4];

        int opc = 0;
        while (opc != 8) {

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
            scan.nextLine();//para resolver o bug de pular a pergunta;

            if (opc == 1) {

                do {
                    if (i < 4) {
                        System.out.println("para cadastrar o " + (i + 1) + " clinte preencha os campos abaixo");
                        System.out.println("digite o nome de usuario");
                        nome_inserido = scan.nextLine();
                        System.out.println("digite o email do usuario");
                        email_inserido = scan.nextLine();
                        System.out.println("digite o numero de indentificacao");
                        num_inserido = scan.nextInt();
                        scan.nextLine();//para resolver o bug de pular a pergunta; 

                        uso[i] = new Usuarios(nome_inserido, email_inserido, num_inserido);
                        i++;
                    } else {
                        System.out.println("desculpe nao ha mais espaco para novos clintes");
                    }

                } while (i < 4);

            } else if (opc == 2) {

                do {
                    if (f < 4) {
                        System.out.println("para cadastrar o " + (f + 1) + " livro preencha os campos abaixo");
                        System.out.println("digite o titulo do livro");
                        titulo_inserido = scan.nextLine();
                        System.out.println("digite os autores do livro");
                        autor_inserido = scan.nextLine();
                        System.out.println("digite o ano de publicacao");
                        ano_publi_inserido = scan.nextInt();
                        scan.nextLine();//para resolver o bug de pular a pergunta;
                        System.out.println("digite o numero de exemplares");
                        num_exemplares_inserido = scan.nextInt();
                        scan.nextLine();//para resolver o bug de pular a pergunta;
                        lv[f] = new Livros(titulo_inserido, autor_inserido, ano_publi_inserido, num_exemplares_inserido);
                        f++;

                    } else {
                        System.out.println("desculpe nao ha mais espaco novos livros");
                    }

                } while (f < 4);

            } else if (opc == 3) {
                int procura;
                System.out.println("digite o seu codigo de usuario");
                procura = scan.nextInt();
                scan.nextLine();//para resolver o bug de pular a pergunta;

                for (int h = 0; h < 4; h++) {
                    if (uso[h].getNum_ident() == procura) {
                        System.out.println("ola usuario: " + uso[h].getNome());
                        System.out.println("digite o titulo do livro que deseja pegar emprestado");
                        String procura_livro = scan.nextLine();
                        for (int j = 0; j < 4; j++) {
                            if (lv[j].titulo.equals(procura_livro)) { //.equals() compara o conteúdo das strings nao achei outro modo
                                System.out.println("livro encontrado!");
                                emp[h] = new Emprestimo();
                                emp[h].estado_uso(lv[j], uso[h]); //voce tem que enviar a variavel com tudo!!!

                            }
                        }

                    } else {
                        System.out.println("desculpa nao achamos voce no nosso sistema");
                        break;
                    }
                }

            } else if (opc == 4) {
                int procura_opc4;
                System.out.println("digite o seu codigo de usuario");
                procura_opc4 = scan.nextInt();
                scan.nextLine();//para resolver o bug de pular a pergunta;

                for (int h = 0; h < 4; h++) {
                    if (uso[h].getNum_ident() == procura_opc4) {
                        System.out.println("ola usuario" + uso[h].getNome());
                        System.out.println("digite o titulo do livro que deseja devolver");
                        String procura_livro = scan.nextLine();
                        for (int j = 0; j < 4; j++) {
                            if (lv[j].titulo.equals(procura_livro)) { //.equals() compara o conteúdo das strings nao achei outro modo
                                System.out.println("livro encontrado ");
                                uso[h].delv_uso();

                            }
                        }
                    }
                }
            } else if (opc == 5) {
                System.out.println("livros :");
                for (int t = 0; t < 4; t++) {
                    System.out.println("titulo : " + lv[t].titulo);
                    System.out.println("autor : " + lv[t].autor);
                    System.out.println("ano de publicacao: " + lv[t].getAno_publi());
                    System.out.println("numero de exemplares" + lv[t].getNum_exemplares());
                    System.out.println("-----------------------------------------------------------");
                }

            } else if (opc == 6) {
                System.out.println("clientes :");
                for (int t = 0; t < 4; t++) {
                    uso[t].dados();
                    System.out.println("---------------------------------------------------------------");

                }

            } else if (opc == 7) {
                System.out.println("Registro de emprestimos");
                for (int h = 0; h < 4; h++) {
                    emp[h] = new Emprestimo();
                    emp[h].exibirEmprestimos(uso[h]);
                }

            } else if (opc == 8) {
                System.out.println("obrigado e ate mais");

            } else {
                System.out.println("opcao invalida tente novamente");
            }

        }

    }

}
