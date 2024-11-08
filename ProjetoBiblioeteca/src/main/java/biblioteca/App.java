package biblioteca;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        int n_lv = 0;
        int n_uso = 0;
        Usuarios uso[] = new Usuarios[4];
        Livros lv[] = new Livros[4];
        Emprestimo emp[] = new Emprestimo[4];

        int opc = 0;
        while (opc != 11) {
            try {
//Menu completo da biblioteca.
                System.out.println("-------------MENU BIBLIOTECA-------------");
                System.out.println("|Digite a opcao que gostaria de executar:|");
                System.out.println("|1- Cadastro De Clientes                 |");
                System.out.println("|2- Cadastro De Livros                   |");
                System.out.println("|3- Emprestimos                          |");
                System.out.println("|4- Devolucao                            |");
                System.out.println("|5- Listagem De Livros                   |");
                System.out.println("|6- Listagem De Clientes                 |");
                System.out.println("|7- Listagem De Livros Emprestados       |");
                System.out.println("|8- Salvar                               |");
                System.out.println("|9- Excluir Livro                        |");
                System.out.println("|10- Excluir Usuario                     |");
                System.out.println("|11- Sair                                |");
                System.out.println("------------------------------------------");
                String opct = scan.nextLine();
                opc = Integer.parseInt(opct);

                if (opc == 1) {  // primeira opção (Cadastro de Clientes.)

                    boolean entrada_valida;
                    do {
                        if (i < 4) {
                            entrada_valida = false;
                            while (!entrada_valida) {
                                try {
                                    System.out.println("Para cadastrar o " + (i + 1) + " -o cliente preencha os campos abaixo:");
                                    System.out.println("Digite o nome de usuario:");
                                    nome_inserido = scan.nextLine();
                                    System.out.println("Digite o email do usuario:");
                                    email_inserido = scan.nextLine();
                                    System.out.println("Digite o numero de identificacao:");
                                    String input = scan.nextLine();
                                    num_inserido = Integer.parseInt(input);// Tenta converter para int
                                    // Se não lançar exceção, significa que a entrada é válida

                                    boolean numero_duplicado = false;// Verificar se o número de identificação já foi cadastrado
                                    for (int j = 0; j < i; j++) {
                                        if (uso[j].getNum_ident() == num_inserido) {
                                            numero_duplicado = true;
                                            break;

                                        }

                                    }
                                    if (numero_duplicado) {
                                        System.out.println("Erro: Este número de identificação já foi cadastrado. Tente novamente.");
                                    } else {
                                        uso[i] = new Usuarios(nome_inserido, email_inserido, num_inserido);
                                        entrada_valida = true;
                                        n_uso++;
                                        i++;
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada invalida. Por favor, digite apenas numeros inteiros para o numero de identificacao, resgistro nao foi feito.");

                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());

                                }

                            }

                        } else {
                            System.out.println("Desculpe nao ha mais espaco para novos clientes");
                        }

                    } while (i < 4);

                } else if (opc == 2) {// Segunda opção (Cadastro de livros.)

                    while (f < 4) {
                        boolean entrada_valida = false;

                        while (!entrada_valida) {
                            if (f < 4) {

                                try {
                                    System.out.println("Para cadastrar o " + (f + 1) + " -o livro preencha os campos abaixo");
                                    System.out.println("Digite o titulo do livro:");
                                    titulo_inserido = scan.nextLine();
                                    System.out.println("Digite os autores do livro:");
                                    autor_inserido = scan.nextLine();
                                    System.out.println("Digite o ano de publicacao:");
                                    String ano_p = scan.nextLine();
                                    System.out.println("Digite o numero de exemplares:");
                                    String exemp = scan.nextLine();
                                    ano_publi_inserido = Integer.parseInt(ano_p);// Tenta converter para int
                                    num_exemplares_inserido = Integer.parseInt(exemp);// Tenta converter para int

                                    lv[f] = new Livros(titulo_inserido, autor_inserido, ano_publi_inserido, num_exemplares_inserido);
                                    f++;
                                    entrada_valida = true;

                                    n_lv++;
                                } catch (NumberFormatException e) {
                                    System.out.println("nao pode colocar letras nos campos: numero de exemplares e/ou ano de publicacao");

                                    break;

                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());

                                    break;

                                }

                            } else {
                                System.out.println("Desculpe nao ha mais espaco novos livros");
                            }
                        }
                    }

                } else if (opc == 3) { // terceira opção (Emprestimo de livros.)
                    try {
                        int procura;
                        try {
                            System.out.println("Digite o seu numero de identificacao de usuario");
                            String opc3t = scan.nextLine();
                            procura = Integer.parseInt(opc3t);
                            scan.nextLine();//para resolver o bug de pular a pergunta;
                            boolean usuarioEncontrado = false; //  para saber se o usuário foi encontrado

                            for (int h = 0; h < 4; h++) {
                                if (uso[h].getNum_ident() == procura) {
                                    System.out.println("Ola usuario: " + uso[h].getNome());
                                    usuarioEncontrado = true; // Usuario foi encontrado
                                    System.out.println("Digite o titulo do livro que deseja pegar emprestado:");
                                    String procura_livro = scan.nextLine();
                                    boolean livroEncontrado = false; // para saber se o livro foi encontrado

                                    for (int j = 0; j < 4; j++) {
                                        if (lv[j].titulo.equals(procura_livro)) { //.equals() compara o conteúdo das strings nao achei outro modo
                                            System.out.println("Livro encontrado!");
                                            emp[h] = new Emprestimo();
                                            emp[h].estado_uso(lv[j], uso[h]); //voce tem que enviar a variavel com tudo!!!
                                            livroEncontrado = true;
                                            if (uso[h].usu_disp == 1 && uso[h].livroEmprestado == lv[j]) { //testa para só retornar a data devolução se o emprestimo for concluido com sucesso;
                                                System.out.println("Data de Devolucao do livro: " + lv[j].getDataDevolucao());//mostra o dia da devolução;
                                            }
                                            break; //para quando achar o livro,o for nao continuar rodando 
                                        }
                                    }

                                    if (livroEncontrado == false) { //retorno para o caso do usuario digitar um livro invalido;
                                        System.out.println("Desculpe, livro nao encontrado.");
                                    }

                                    break; //para quando achar o usuario,o for nao continuar rodando;
                                }
                            }
                            if (usuarioEncontrado == false) { //para o caso do usuario inserir um codigo invalido;

                                System.out.println("Desculpa, nao achamos voce no nosso sistema");

                            }
                        } catch (NumberFormatException e) {
                            System.out.println("O numero de intendificacao  nao contem letras tente novamente");
                        }
                    } catch (Exception e) {
                        System.out.println("Desculpe, mas nao existem livros e/ou usuarios cadastrados ");
                    }

                } else if (opc == 4) {// quarta opção (Devolução)
                    try {

                        int procura_opc4;
                        try {
                            System.out.println("Digite o seu numero de identificacao de usuario");
                            String opc4t = scan.nextLine();
                            procura_opc4 = Integer.parseInt(opc4t);

                            scan.nextLine();//para resolver o bug de pular a pergunta;
                            boolean usuarioEncontrado = false; //  para saber se o usuário foi encontrado

                            for (int h = 0; h < 4; h++) {
                                if (uso[h].getNum_ident() == procura_opc4) {
                                    System.out.println("Ola usuario" + uso[h].getNome());
                                    usuarioEncontrado = true; // Usuario foi encontrado
                                    System.out.println("Digite o titulo do livro que deseja devolver:");
                                    String procura_livro = scan.nextLine();
                                    boolean livroEncontrado = false; // para saber se o livro foi encontrado

                                    for (int j = 0; j < 4; j++) {
                                        if (lv[j].titulo.equals(procura_livro)) { //.equals() compara o conteúdo das strings nao achei outro modo
                                            System.out.println("Livro encontrado! ");
                                            uso[h].delv_uso();
                                            livroEncontrado = true;
                                            break; //para quando achar o livro,o for nao continuar rodando 
                                        }
                                    }
                                    if (livroEncontrado == false) { //retorno para o caso do usuario digitar um livro invalido;
                                        System.out.println("Desculpe, livro nao encontrado.");
                                    }

                                    break; //para quando achar o usuario,o for nao continuar rodando;
                                }
                            }
                            if (usuarioEncontrado == false) { //para o caso do usuario inserir um codigo invalido;

                                System.out.println("Desculpa, nao achamos voce no nosso sistema");

                            }
                        } catch (NumberFormatException e) {
                            System.out.println("O numero de intendificacao  nao contem letras tente novamente");
                        }
                    } catch (Exception e) {
                        System.out.println("Desculpe, mas nao existem livros e/ou usuarios cadastrados");

                    }
                } else if (opc == 5) {
                    try {
                        System.out.println("--------Listagem de Livros---------");
                        for (int t = 0; t < n_lv; t++) {
                            lv[t].dados();
                            System.out.println("-----------------------------------------------------------");
                        }
                    } catch (Exception e) { //retorno para o caso da pessoa pedir para listar livros sem antes cadastrar;
                        System.out.println("Desculpe, mas nao ha livros cadastrados para listagem");
                    }

                } else if (opc == 6) {
                    try {
                        System.out.println("---------------Listagem de Clientes--------------");
                        for (int t = 0; t < n_uso; t++) {
                            uso[t].dados();
                            System.out.println("---------------------------------------------------------------");

                        }
                    } catch (Exception e) {//retorno para o caso da pessoa pedir para listar livros sem antes cadastrar;
                        System.out.println("Desculpe, nao ha usuarios cadastrado");
                    }

                } else if (opc == 7) {
                    try {
                        System.out.println("-------Registro de Emprestimos---------");
                        for (int h = 0; h < 4; h++) {
                            emp[h] = new Emprestimo();
                            emp[h].exibirEmprestimos(uso[h]);
                        }
                    } catch (Exception e) {
                        System.out.println("Desculpe, nao ha nenhum livro e/ou usuario cadastrado para listagem");
                    }

                } else if (opc == 8) {
                    // Tenta criar um PrintWriter para escrever em "dados_biblioteca.txt"
                    try (PrintWriter writer = new PrintWriter(new FileWriter("dados_biblioteca.txt"))) {
                        // salvar usuarios
                        writer.println("------Usuarios------");
                        for (int j = 0; j < n_uso; j++) {
                            if (uso[j] != null) {
                                writer.println("nome: " + uso[j].getNome());
                                writer.println("email: " + uso[j].getEmail());
                                writer.println("numero de indentificacao " + uso[j].getNum_ident());
                            }
                        }
                        // salvar livros
                        writer.println("------livros------");
                        for (int j = 0; j < n_lv; j++) {
                            if (lv[j] != null) {
                                writer.println("tiulo:" + lv[j].titulo);
                                writer.println("autor:" + lv[j].autor);
                                writer.println("ano de publicacao: " + lv[j].getAno_publi());
                                writer.println("numero de exemplares:" + lv[j].getNum_exemplares());
                            }

                        }
                        // salvar emprestimo
                        writer.println("------emprestimos------");
                        for (int j = 0; j < n_uso; j++) {
                            //esse if sao para evitar o erro caso tente salver algum emprestimo q nao foi feito ja q sao 4 emp;
                            if (emp[j] != null) {
                                writer.println("titulo do livro :" + emp[j].getLivroemp(uso[j]));
                                writer.println("nome do usuario: " + emp[j].getNome_emp(uso[j]));
                                writer.println("data de emprestimo:" + emp[j].getdataemp(uso[j]));

                            }

                        }
                        System.out.println("Dados salvos com sucesso em dados_biblioteca.txt");

                    } catch (IOException e) {
                        //IOException é uma exceção em Java que ocorre em operações de I/O, como falha ao ler/escrever arquivos, arquivos não encontrados ou problemas de rede
                        //e como se fosse aquela testagem do fopen em c++ so que em tratamento de exeçoes uma exeçao q ja e do java
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }

                } else if (opc == 9) { // Excluir Livro
                    System.out.println("Digite o título do livro que deseja excluir:");
                    String tituloExclu = scan.nextLine();
                    boolean livroEncontrado = false;

                    for (int o = 0; o < lv.length; o++) {
                        if (lv[o] != null && lv[o].titulo.equalsIgnoreCase(tituloExclu)) {
                            // Desloca todos os elementos após o livro excluído para a esquerda
                            for (int j = o; j < 4 - 1; j++) {
                                lv[j] = lv[j + 1];
                            }
                            lv[3] = null;//limpa a ultima posição
                            System.out.println("O livro '" + tituloExclu + "' foi excluído com sucesso.");
                            livroEncontrado = true;
                            n_lv--;//faz o decremento na quantidade de livros cadastrados;
                            f--;
                            break;
                        }
                    }
                    if (!livroEncontrado) {
                        System.out.println("Livro nao encontrado.");
                    }

                } else if (opc == 10) { // Excluir Usuario
                    System.out.println("Digite o nome do usuario que deseja excluir:");
                    String nomeExclu = scan.nextLine();
                    boolean usuarioEncontrado = false;

                    for (int o = 0; o < uso.length; o++) {
                        if (uso[o] != null && uso[o].getNome().equalsIgnoreCase(nomeExclu)) {
                            // Desloca todos os elementos após o usuario excluído para a esquerda
                            for (int j = o; j < 4 - 1; j++) {
                                uso[j] = uso[j + 1];
                            }
                            uso[3] = null;//limpa a ultima posição

                            System.out.println("O usuario '" + nomeExclu + "' foi excluido com sucesso.");
                            usuarioEncontrado = true;
                            n_uso--;//faz o decremento na quantidade de usuarios cadastrados
                            i--;
                            break;
                        }
                    }
                    if (!usuarioEncontrado) {
                        System.out.println("Usuario nao encontrado.");
                    }

                } else if (opc == 11) {
                    System.out.println("Obrigado e ate mais!");

                } else {
                    System.out.println("Opcao invalida, tente novamente.");
                }

               
            } catch (NumberFormatException e) {
                System.out.println("escolha uma opçao com numero");
            }
            
        }scan.close();
    }
}
