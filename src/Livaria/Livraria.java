/*package Livaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controle.CCliente;
import Controle.CEditora;
import Controle.CLivro;
import Controle.CVendaLivro;
import Model.Cliente;
import Model.Editora;
import Model.Livro;
import Model.VendaLivro;
import java.time.LocalDate;
import java.util.ArrayList;
import services.ClienteServicos;
import services.EditoraServicos;
import services.ServicosFactory;
import util.Validadores;
import view.Menu;

public class Livraria { // Incio CLASS

    public static CCliente CadCliente = new CCliente();
    public static CEditora CadEditora = new CEditora();
    public static CLivro CadLivro = new CLivro();
    public static CVendaLivro CadVendaLivro = new CVendaLivro();
    public static Scanner ler = new Scanner(System.in);
    public static String tpCad = null;

    public static int lerNum() {// Incio LEIA
        Scanner ler = new Scanner(System.in);
        try {
            return ler.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente..");
            lerNum();
        }
        return 0;
    }// Fim LEIA

    public static float lerNumFLOAT() {// Incio LEIA
        Scanner ler = new Scanner(System.in);
        try {
            return ler.nextFloat();
        } catch (Exception e) {
            System.out.println("Tente novamente.");
            lerNumFLOAT();
        }
        return 0;
    }// Fim LEIA
    // Inicio MENU

    public static void MenuP() {// Inicio MENU
        System.out.println();
        System.out.println();
        System.out.println("+-------------------+");
        System.out.println("|      LIVRARIA     |");
        System.out.println("+-------------------+");
        System.out.println("| 1 - Ger. Cliente  |");
        System.out.println("| 2 - Ger. Editora  |");
        System.out.println("| 3 - Ger. Livro    |");
        System.out.println("| 4 - Venda Livro   |");
        System.out.println("| 0 - Sair          |");
        System.out.println("+-------------------+");
        System.out.print("\nEscolha uma opção:\t");

    }// Fim MENU

    public static void SubMenu(int op) {// Inicio SUBMENU
        tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;
        }
        System.out.println();
        System.out.println();
        System.out.println("+------------------------------+");
        System.out.println("|         Gerenciamento        |");
        System.out.println("+------------------------------+");
        System.out.println(" 1 - Cadastrar " + tpCad);
        System.out.println(" 2 - Editar " + tpCad);
        System.out.println(" 3 - Listar " + tpCad);
        System.out.println(" 4 - Deletar " + tpCad);
        System.out.println(" 0 - Voltar");
        System.out.print(" \nEscolha uma opção:\t");
    }// Fim SUBMENU
    // Fim MENU

    // Inicio CLIENTE
    public static void cadastrarCliente() {// Inicio CADCLIENTE
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;
        ClienteServicos clienteS = ServicosFactory.getClienteServicos();

        System.out.println("|Cadastro de Cliente|");
        System.out.print("\nInforme o CPF:\t");
        boolean cpfis;
        int opCPF;
        do {// Inicio DO
            cpf = ler.nextLine();
            cpfis = Validadores.isCPF(cpf);
            if (!cpfis) {
                System.out.println("CPF inválido" + "\nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                opCPF = lerNum();

                if (opCPF == 1) {
                    System.out.println("Informe o CPF:\t");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro cancelado pelo usuário.");
                    return;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (clienteS.buscarClientebyCPF(cpf).getCpf() != null) {
            System.out.println("Cliente já cadastrado.");
        } else {
            System.out.print("Informe o nome:\t");
            nomeCliente = ler.nextLine().toUpperCase();//para deixar a leitura do nome de forma correta no listar
            System.out.print("Informe o telefone:\t");
            telefone = ler.nextLine();
            System.out.print("Informe o endereço:\t");
            endereco = ler.nextLine();
            idCliente = CadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            clienteS.cadCliente(cli);
            CadCliente.addCliente(cli);
            System.out.println("Cliente cadastro com sucesso.");

        } // Fim DO
    }// Fim CADCLIENTE

    private static void editarCliente() {// Inicio EDICLIENTE
        System.out.println("|Editar Cliente|");
        System.out.print("\nInforme o CPF:\t");
        String cpf = ler.nextLine();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = CadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("\n1- Nome:\t" + cli.getNomeCliente());
                System.out.println("2- Endereco:\t" + cli.getEndereco());
                System.out.println("3- Telefone:\t" + cli.getTelefone());
                System.out.println("4- Todos os campos acima.");
                System.out.print("Qual campo gostaria de alterar ? \nDigite aqui:\t");
                int batata = lerNum();
                if (batata == 1 || batata == 4) {
                    System.out.print("Informe o Nome:\t");
                    cli.setNomeCliente(ler.nextLine());
                }
                if (batata == 2 || batata == 4) {
                    System.out.print("Informe o Endereço:\t");
                    cli.setEndereco(ler.nextLine());
                }
                if (batata == 3 || batata == 4) {
                    System.out.print("Informe o Telefone:\t");
                    cli.setTelefone(ler.nextLine());
                }
                ClienteServicos clienteS = ServicosFactory.getClienteServicos();
                clienteS.atualizarCliente(cli);
                System.out.println("Cliente \n" + cli.toString());
            } else {
                System.out.println("Cliente não consta na base de dados.");
            }
        }

    }// Fim EDICLIENTE

    public static void deletarCliente() {// Inicio DELCLIENTE
        System.out.println("|Deletar Cliente|");
        System.out.print("\nInforme o CPF:\t");
        String cpf = ler.next();
        ClienteServicos clienteS = ServicosFactory.getClienteServicos();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = clienteS.buscarClientebyCPF(cpf);
            if (cli != null) {
                clienteS.deletarCliente(cpf);
                System.out.println("Cliente deletado com sucesso.");
            } else {
                System.out.println("Cliente não consta na base de dados.");
            }
        } else {
            System.out.println("CPF Inválido.");
        }
    }// Fim DELCLIENTE

    public static void listarCliente() {// Inicio LISTACLIENTE
        ClienteServicos clienteS = ServicosFactory.getClienteServicos();
        for (Cliente cli : clienteS.getClientes()) {
            System.out.println("-----------------------");
            System.out.println("CPF:\t" + cli.getCpf());
            System.out.println("Nome:\t" + cli.getNomeCliente());
            System.out.println("Telefone:\t" + cli.getTelefone());
            System.out.println("Endereco:\t" + cli.getEndereco());
        }
    }// Fim LISTACLIENTE
    // Fim CLIENTE

    // Inicio EDITORA
    public static void cadastrarEditora() {// Inicio CADEDITORA
        int idEditora;
        String nomeEditora;
        String cnpj;
        String endereco;
        String telefone;
        String nomeGerente;
        EditoraServicos editoraS = ServicosFactory.getEditoraServicos();

        System.out.println("|Cadastro de Editora|");
        System.out.print("\nInforme o CNPJ:\t");
        boolean cnpjis;
        int opCNPJ;
        do {// Inicio DO
            cnpj = ler.nextLine();
            cnpjis = Validadores.isCNPJ(cnpj);
            if (!cnpjis) {
                System.out.println("CNPJ inválido" + "\nDeseja tentar novamente ? 1 - Sim | 2 - Não");
                opCNPJ = lerNum();

                if (opCNPJ == 1) {
                    System.out.println("Informe o CNPJ:\t");
                } else if (opCNPJ == 2) {
                    System.out.println("Cadastro cancelado pelo usuário.");
                    return;
                }
            }
        } while (!Validadores.isCNPJ(cnpj));
        if (editoraS.buscarEditorabyCNPJ(cnpj).getcnpj() != null) {
            System.out.println("Editora já cadastrada.");
        } else {
            System.out.print("Informe o nome da Editora:\t");
            nomeEditora = ler.nextLine();
            System.out.print("Informe o Telefone:\t");
            telefone = ler.nextLine();
            System.out.print("Informe o Endereço:\t");
            endereco = ler.nextLine();
            System.out.print("Informe o Nome do Gerente:\t");
            nomeGerente = ler.nextLine();
            idEditora = CadEditora.geraID();
            Editora edi = new Editora(idEditora, nomeEditora, cnpj, endereco, telefone, nomeGerente);
            editoraS.cadEditora(edi);
            //CadEditora.addEditora(edi);
            System.out.println("Editora cadastrada com sucesso.");
        } // Fim DO
    }// Fim CADEDITORA

    private static void editarEditora() {// Inicio EDIEDITORA
        EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
        System.out.println("|Editar Editora|");
        System.out.print("\nInforme o CNPJ:\t");
        String cnpj = ler.nextLine();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = editoraS.buscarEditorabyCNPJ(cnpj);
            if (edi != null) {
                System.out.println("\n1- Nome Editora:\t" + edi.getnomeEditora());
                System.out.println("2- Endereço:\t" + edi.Getendereco());
                System.out.println("3- Telefone:\t" + edi.Gettelefone());
                System.out.println("4- Nome Gerente:\t" + edi.getgerente());
                System.out.println("5- Todos os campos acima.");
                System.out.print("Qual campo gostaria de alterar ?"
                        + "\nDigite aqui:");
                int batata = lerNum();
                if (batata == 1 || batata == 5) {
                    System.out.println("Informe o Nome da Editora:\t");
                    String nomeEditora = ler.nextLine();
                    edi.setNomeEditora(nomeEditora);
                }
                if (batata == 2 || batata == 5) {
                    System.out.println("Informe o Endereço:\t");
                    String endereco = ler.nextLine();
                    edi.setEndereco(endereco);
                }
                if (batata == 3 || batata == 5) {
                    System.out.println("Informe o Telefone:\t");
                    String telefone = ler.nextLine();
                    edi.setTelefone(telefone);
                }
                if (batata == 4 || batata == 5) {
                    System.out.println("Informe o Nome do Gerente:\t");
                    String gerente = ler.nextLine();
                    edi.setGerente(gerente);
                }
                editoraS.atualizarEditora(edi);
                System.out.println("Editora \n" + edi.toString());
            } else {
                System.out.println("Editora não consta na base de dados.");
            }
        }

    }// Fim EDIEDITORA

    public static void deletarEditora() {// Inicio DELEDITORA
        System.out.println("|Deletar Editora|");
        System.out.print("\nInforme o CNPJ:\t");
        String cnpj = ler.next();
        EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = editoraS.buscarEditorabyCNPJ(cnpj);
            if (edi != null) {
                editoraS.deletarEditora(cnpj);
                System.out.println("Editora deletada com sucesso.");
            } else {
                System.out.println("Editora não consta na base de dados.");
            }
        } else {
            System.out.println("CNPJ Inválido.");
        }
    }// Fim DELEDITORA

    public static void listarEditora() {// Inicio LISTAEDITORA
        EditoraServicos editoraS = ServicosFactory.getEditoraServicos();
        for (Editora edi : editoraS.getEditoras()) {
            System.out.println("---------------------------------");
            System.out.println("CNPJ:\t" + edi.getcnpj());
            System.out.println("Nome Editora:\t" + edi.getnomeEditora());
            System.out.println("Telefone:\t" + edi.Gettelefone());
            System.out.println("Nome do Gerente:\t" + edi.getgerente());
        }
    }// Fim LISTAEDITORA
    // Fim EDITORA

    // Inicio LIVRO
    public static void cadastrarLivro() {// Inicio CADLIVRO
        EditoraServicos livroS = ServicosFactory.getEditoraServicos();

        System.out.println("|Cadastrar livro|");
        System.out.println("\nInforme o ISBN:\t");
        String isbn = ler.nextLine();
        if (CadLivro.getLivroISBN(isbn) != null) {
            System.out.print("Livro já cadastrado.");
        } else {
            int idLivro = CadLivro.geraID();
            System.out.println("Informe o Titulo do Livro:\t");
            String nomeLivro = ler.nextLine();
            System.out.println("Informe o Autor do Livro:\t");
            String autor = ler.nextLine();
            System.out.println("Informe o Gênero:\t");
            String assunto = ler.nextLine();
            System.out.println("Informe a Quantidade de Livros:\t");
            int estoque = lerNum();
            System.out.println("Informe o preço:\t");
            float preco = ler.nextFloat();
            boolean isCNPJ = false;
            Editora idEditora = null;
            do {
                System.out.println("Informe o CNPJ da editora:\t");
                String cnpj = ler.nextLine();
                isCNPJ = Validadores.isCNPJ(cnpj);
                if (isCNPJ) {
                    idEditora = CadEditora.getEditoraCNPJ(cnpj);
                    if (idEditora == null) {
                        System.out.println("Editora não cadastrada.");
                        isCNPJ = false;
                    }
                } else {
                    System.out.println("CNPJ inválido.");
                }
            } while (isCNPJ);
            Livro li = new Livro(idLivro, nomeLivro, autor, assunto, isbn, estoque, preco, idEditora);
            CadLivro.addLivro(li);
            System.out.println("Livro cadastrado com sucesso.");

        }
    }// Fim CADLIVRO

    private static void editarLivro() {// Inicio EDILIVRO
        System.out.println("|Editar Livro|");
        System.out.print("\nInforme o ISBN:\t");
        String isbn = ler.nextLine();

        Livro li = CadLivro.getLivroISBN(isbn);
        if (li != null) {
            System.out.println("\n1- Nome Livro:\t" + li.getNomeLivro());
            System.out.println("2- Autor:\t" + li.getAutor());
            System.out.println("3- Assunto:\t" + li.getAssunto());
            System.out.println("4- Estoque:\t" + li.getEstoque());
            System.out.println("5- Preço:\t" + li.getPreco());
            System.out.println("6- Todos os campos acima.");
            System.out.print("Qual campo gostaria de alterar ? +\nDigite aqui: ");
            int batata = lerNum();
            if (batata == 1 || batata == 6) {
                System.out.println("Informe o Nome do Livro:\t");
                li.setNomeLivro(ler.nextLine());
            }
            if (batata == 2 || batata == 6) {
                System.out.println("Informe o Autor:\t");
                li.setAutor(ler.nextLine());;
            }
            if (batata == 3 || batata == 6) {
                System.out.println("Informe o Assunto:\t");
                li.setAssunto(ler.nextLine());
            }
            if (batata == 4 || batata == 6) {
                System.out.println("Informe o Estoque:\t");
                li.setEstoque(lerNum());
            }
            if (batata == 5 || batata == 6) {
                System.out.println("Informe o Preço:\t");
                li.setPreco(lerNumFLOAT());
            }
            System.out.println("Livro \n" + li.toString());
        } else {
            System.out.println("Livro não consta na base de dados.");
        }

    }// Fim EDLIVRO

    public static void deletarLivro() {// Inicio DELLIVRO
        System.out.println("| Deletar Livro|");
        System.out.print("\nInforme o ISBN:\t");
        String isbn = ler.nextLine();
        Livro li = CadLivro.getLivroISBN(isbn);
        if (li != null) {
            System.out.println("Livro " + li.getNomeLivro() + "Será deletado.");
            CadLivro.removeLivro(li);
        } else {
            System.out.println("ISBN não encontrado.");
        }
    }// Fim DELLIVRO

    public static void listarLivro() {// Inicio LISTALIVRO
        System.out.println("|Listar Livros|");
        for (Livro livro : CadLivro.getLivros()) {
            System.out.println("-------------------------------");
            System.out.println("ISBN\t" + livro.getIsbn());
            System.out.println("Titulo\t" + livro.getNomeLivro());
            System.out.println("Assunto\t" + livro.getAssunto());
            System.out.println("Autor\t" + livro.getAutor());
            System.out.println("Estoque\t" + livro.getEstoque());
            System.out.println("Autor\t" + livro.getAutor());
            System.out.println("Editora\t" + livro.getIdEditora().getnomeEditora() + "\n");

        }
    }// Fim LISTALIVRO
    // Fim LIVRO

    public static void vendaLivro() {
        int idVendaLivro;
        Cliente idCliente = null;
        ArrayList<Livro> livros = new ArrayList<>();
        float subTotal = 0;
        LocalDate dataVenda = LocalDate.now();

        do {
            System.out.println("Informe o CPF:\t");
            String CPF = ler.nextLine();
            if (Validadores.isCPF(CPF)) {
                idCliente = CadCliente.getClienteCPF(CPF);
                if (idCliente == null) {
                    System.out.println("Cliente não cadastrado, tente novamente.");
                }
            } else {
                System.out.println("CPF inexistente.");
            }
        } while (idCliente == null);
        boolean venda = true;
        do {
            Livro li = null;
            String isbn;
            do {
                System.out.println("Informe o ISBN:\t");
                isbn = ler.nextLine();
                li = CadLivro.getLivroISBN(isbn);
                if (li == null) {
                    System.out.println("Livro não encontrado, tente novamente.");
                }
            } while (li == null);
            if (li.getEstoque() > 0) {
                livros.add(li);
                CadLivro.AtualizaEstoqueLivro(li.getIsbn());
                subTotal += li.getPreco();
            } else {
                System.out.println(li.getNomeLivro() + "não tem estoque.");
            }
            System.out.println("Deseja comprar mais livros nesta venda?"
                    + "\n1 - Sim | 2 - Não"
                    + "\nDigite:\t");
            if (lerNum() == 2) {
                venda = false;
            }
        } while (venda);
        idVendaLivro = CadVendaLivro.geraID();
        VendaLivro vl = new VendaLivro(idVendaLivro, idCliente, livros, idVendaLivro, subTotal, dataVenda, idVendaLivro);
        CadVendaLivro.addVendaLivro(vl);
        System.out.println("\n|Venda|" + vl.toString());
    }

    public static void main(String[] args) {// Inicio VOID
        Menu jMenu = new Menu();
        jMenu.setVisible(true);
        /*
        CadCliente.mockClientes();
        CadEditora.mockEditora();
        CadLivro.mockLivros();
        CadVendaLivro.mockVendaLivros();
        int opM;
        do {
            MenuP();
            opM = lerNum();
            switch (opM) {
                case 1:
                case 2:
                case 3:

                    int opSM;
                    do {
                        SubMenu(opM);
                        opSM = lerNum();

                        switch (opSM) {
                            case 1:
                                System.out.println("\n|Cadastrar|");
                                if (tpCad.equals("Cliente")) {
                                    cadastrarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    cadastrarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    cadastrarLivro();
                                }
                                break;
                            case 2:
                                System.out.println("\n|Editar|");
                                if (tpCad.equals("Cliente")) {
                                    editarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    editarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    editarLivro();
                                }
                                break;
                            case 3:
                                System.out.println("\n|Listar|");
                                if (tpCad.equals("Cliente")) {
                                    listarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    listarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    listarLivro();
                                }
                                break;
                            case 4:
                                System.out.println("\n|Deletar|");
                                if (tpCad.equals("Cliente")) {
                                    deletarCliente();
                                }
                                if (tpCad.equals("Editora")) {
                                    deletarEditora();
                                }
                                if (tpCad.equals("Livro")) {
                                    deletarLivro();
                                }
                                break;
                            case 0:
                                System.out.println("\n|Menu Principal|");
                                opM = 99;
                                MenuP();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!!");
                                break;
                        }

                    } while (opSM != 0); // SubMenu
                    break;
                case 4:
                    System.out.println("\n|Venda Livros|");
                    vendaLivro();
                    break;
                case 0:
                    System.out.println("Aplicação encerrada.");
                    break;
            }
        } while (opM != 0);// Sistema
        */
    }// Fim VOID
}// Fim CLASS
