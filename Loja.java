import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Produto produto1 = new Produto("Caderno", 101, 25.90);
        Produto produto2 = new Produto("Caneta", 102, 4.50);
        Produto produto3 = new Produto("Mochila", 103, 89.90);

        Produto[] produtos = {
            produto1,
            produto2,
            produto3
        };

        Fatura fatura = new Fatura();

        int opcao;

        do {
            System.out.println("\n===== LOJA DE SUPRIMENTOS =====");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.print("Escolha uma opcao: ");

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n===== PRODUTOS =====");

                    for (Produto produto : produtos) {
                        produto.exibirInformacoes();
                        System.out.println();
                    }

                    System.out.println("0 - Voltar");
                    System.out.print("Digite o codigo do produto: ");
                    int codigo = teclado.nextInt();

                    if (codigo == 0) {
                        break;
                    }

                    Produto produtoEscolhido = null;

                    for (Produto produto : produtos) {
                        if (produto.getCodigo() == codigo) {
                            produtoEscolhido = produto;
                            break;
                        }
                    }

                    if (produtoEscolhido == null) {
                        System.out.println("Produto nao encontrado.");
                        break;
                    }

                    System.out.print("Digite a quantidade: ");
                    int quantidade = teclado.nextInt();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade invalida.");
                        break;
                    }

                    Item item = new Item(
                            produtoEscolhido,
                            quantidade
                    );

                    fatura.adicionarItem(item);

                    System.out.println("Compra adicionada com sucesso.");

                    break;

                case 2:
                    fatura.exibirFatura();

                    System.out.println("\n0 - Voltar");
                    System.out.print("Digite 0 para voltar: ");

                    int voltar = teclado.nextInt();

                    if (voltar == 0) {
                        break;
                    }

                    break;

                case 3:
                    System.out.println(
                            "\nOpcao sera implementada no Dia 3."
                    );
                    break;

                case 4:
                    System.out.println(
                            "\nOpcao sera implementada no Dia 3."
                    );
                    break;

                case 5:
                    System.out.println("\nFinalizando compra...");
                    System.out.printf(
                            "Valor final: R$ %.2f%n",
                            fatura.getValorTotal()
                    );
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);

        teclado.close();
    }
}