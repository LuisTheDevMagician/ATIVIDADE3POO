import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static List<Genero> generos = new ArrayList<>();
    public static List<Filme> filmes = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Ingresso> ingressos = new ArrayList<>();
    public static List<Sala> salas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;

       while (i != 0){
           System.out.println("=======Informe a Opção que você deseja:=======");
           System.out.println("1 - Cadastrar Genero");
           System.out.println("2 - Cadastrar Filme");
           System.out.println("3 - Cadastrar Sala");
           System.out.println("4 - Cadastrar Cliente");
           System.out.println("5 - Vender Ingresso");
           System.out.println("6 - Listar Filmes");
           System.out.println("7 - Listar Ingressos");
           System.out.println("8 - Sair do Sistema");
           System.out.println("================================");

           String op = sc.nextLine();

           switch (op) {

               case "1":
                   Genero gen = new Genero();
                   System.out.println("=======Cadastrar Genero======");
                   System.out.println("Informe o nome do genero: ");
                   gen.setDescricao(sc.nextLine());
                   System.out.println("Cadastre o Código do gênro");
                   gen.setCodigo(sc.nextLine());
                   System.out.println("Genero Cadastrado com Sucesso!");
                   System.out.println("================================");
                   generos.add(gen);
                   break;

               case "2":
                   Filme f = new Filme();
                   System.out.println("=======Cadastrar Filme=======");
                   System.out.println("Informe o nome do Filme");
                   f.setNome(sc.nextLine());
                   System.out.println("Informe o Codigo do Gênero do Filme");
                   for(Genero g : generos){
                       System.out.println("Códigos - " + g.getCodigo() + " | Descrição - " + g.getDescricao());
                   }
                   String cod = sc.nextLine();
                   boolean generoEncontrado = false;

                   for (Genero g : generos) {
                       if (cod.equals(g.getCodigo())) {
                           f.setGenero(g);
                           generoEncontrado = true;
                           break;
                       }
                   }

                   if (!generoEncontrado) {
                       System.out.println("=======Código Inválido. Voltando ao menu.=======");
                       System.out.println("================================");
                       continue; // Volta para o início do loop 'while'
                   }
                   System.out.println("Informe a duração em Minutos do Filme");
                   f.setDuracaoMinutos(sc.nextInt());
                   sc.nextLine();
                   System.out.println("Filme Cadastrado com Sucesso!");
                   System.out.println("================================");
                   filmes.add(f);
                   break;

               case "3":
                    Sala s = new Sala();
                    System.out.println("=======Cadastrar Sala======");
                    System.out.println("Informe o número do Sala");
                    s.setNumero(sc.nextLine());
                   System.out.println("Informe a capacidade do Sala");
                   s.setCapacidade(sc.nextInt());
                   sc.nextLine();
                   System.out.println("Sala Cadastrado com Sucesso!");
                   System.out.println("===============================");
                   salas.add(s);
                   break;

               case "4":
                   Cliente c = new Cliente();
                   System.out.println("=======Cadastrar Cliente=======");
                   System.out.println("Informe o nome do Cliente: ");
                   c.setNome(sc.nextLine());
                   System.out.println("Informe o CPF do Cliente: ");
                   c.setCpf(sc.nextLine());
                   System.out.println("Informe o Endereço do Cliente: ");
                   c.setEndereco(sc.nextLine());
                   System.out.println("Cliente Cadastrado com Sucesso!");
                   System.out.println("===============================");
                   clientes.add(c);
                   break;

               case "5":
                   Ingresso in = new Ingresso();
                   System.out.println("=======Vender Ingresso=======");
                   System.out.println("Informe o nome do Cliente:");
                   for(Cliente cliente : clientes){
                       System.out.println("Nomes dos clientes - " + cliente.getNome());
                   }
                   String nomeCliente = sc.nextLine();
                   boolean clienteEncontrado = false;

                   for(Cliente cliente : clientes ){
                       if(nomeCliente.equals(cliente.getNome())){
                           in.setCliente(cliente);
                           clienteEncontrado = true;
                           break;
                       }
                   }

                   if(!clienteEncontrado){
                       System.out.println("========Cliente não Existe. Voltando ao menu.=======");
                       System.out.println("================================");
                       continue;
                   }

                   System.out.println("Informe o tipo de Ingresso");
                   in.setTipo(sc.nextLine());
                   System.out.println("Informe a Sala que deseja");
                   for(Sala salay : salas){
                       System.out.println("Códigos das salas: " + salay.getNumero());
                   }

                   String salaX = sc.nextLine();
                   boolean salaEncontrado = false;

                   for(Sala sala : salas){
                       if(salaX.equals(sala.getNumero())){
                           in.setSala(sala);
                           salaEncontrado = true;
                           break;
                       }
                   }

                   if(!salaEncontrado){
                       System.out.println("=======Essa sala não existe. Voltando ao Menu======");
                       System.out.println("===============================");
                       continue;
                   }

                   System.out.println("Informe o Assento do Cliente");
                   in.setLocalizacao(sc.nextLine());

                   System.out.println("Qual filme deseja escolher?");
                   for(Filme filme : filmes){
                       System.out.println("Filmes disponíveis: " + filme.getNome());
                   }

                   String nomeFilme = sc.nextLine();
                   boolean filmeEncontrado = false;

                   for(Filme filme : filmes){
                       if(nomeFilme.equals(filme.getNome())){
                           in.setFilme(filme);
                           filmeEncontrado = true;
                           break;
                       }
                   }
                   if(!filmeEncontrado){
                       System.out.println("=======Filme não ecnontrado. Voltando ao menu.======");
                       System.out.println("===============================");
                       continue;
                   }

                   System.out.println("Preencha o código do Ingresso");
                   in.setCodigo(sc.nextLine());

                   System.out.println("=======Ingresso cadastrado com Sucesso!=======");
                   System.out.println("===============================");
                   ingressos.add(in);
                   break;

                   case "6":
                       System.out.println("======== Filme Cadastrados =======");
                            for(Filme filme : filmes){
                                System.out.println("Título do filme: " + filme.getNome());
                                System.out.println("Genero do filme: " + filme.getGenero().getDescricao());
                                System.out.println("Duracao do filme: " + filme.getDuracaoMinutos());
                                System.out.println("_______________________________________________________");
                            }
                            break;

                   case "7":
                       System.out.println("Ingressos Comprados");
                       for(Ingresso ingresso : ingressos){
                           System.out.println("Código do Ingresso: " + ingresso.getCodigo());
                           System.out.println("Tipo do Ingresso: " + ingresso.getTipo());
                           System.out.println("Dono do Ingresso: " + ingresso.getCliente().getNome());
                           System.out.println("Sala do Ingresso: " + ingresso.getSala().getNumero());
                           System.out.println("Filme do Ingresso: " + ingresso.getFilme().getNome());
                           System.out.println("Assento: " + ingresso.getLocalizacao());
                           System.out.println("_______________________________________________________");
                       }
                       break;

                   case "8":
                       System.out.println("Você saiu do Sistema");
                       i = 0;
                       break;

                   default:
                       System.out.println("Escolha uma opção válida");
                       break;
           }

       }

    }
}

