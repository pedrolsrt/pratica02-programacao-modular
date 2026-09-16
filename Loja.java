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

                    System.out.print("Digite a quantidade (0 para voltar): ");
                    int quantidade = teclado.nextInt();

                    if (quantidade == 0) {
                        break;
                    }

                    if (quantidade < 0) {
                        System.out.println("Quantidade invalida.");
                        break;
                    }

                    Item item = new Item(produtoEscolhido, quantidade);
                    fatura.adicionarItem(item);

                    System.out.println("Compra adicionada com sucesso.");
                    break;

                case 2:
                    fatura.exibirFatura();

                    System.out.println("\n0 - Voltar");
                    System.out.print("Digite 0 para voltar: ");
                    teclado.nextInt();

                    break;

                case 3:
                    if (fatura.getItens().size() == 0) {
                        System.out.println("\nNenhum item para excluir.");
                        break;
                    }

                    fatura.exibirFatura();

                    System.out.println("\n0 - Voltar");
                    System.out.print("Digite o numero do item que deseja excluir: ");
                    int itemExcluir = teclado.nextInt();

                    if (itemExcluir == 0) {
                        break;
                    }

                    if (itemExcluir < 1
                            || itemExcluir > fatura.getItens().size()) {
                        System.out.println("Item invalido.");
                        break;
                    }

                    fatura.removerItem(itemExcluir - 1);

                    System.out.println("Item excluido com sucesso.");
                    break;

                case 4:
                    if (fatura.getItens().size() == 0) {
                        System.out.println("\nNenhum item para alterar.");
                        break;
                    }

                    fatura.exibirFatura();

                    System.out.println("\n0 - Voltar");
                    System.out.print("Digite o numero do item que deseja alterar: ");
                    int itemAlterar = teclado.nextInt();

                    if (itemAlterar == 0) {
                        break;
                    }

                    if (itemAlterar < 1
                            || itemAlterar > fatura.getItens().size()) {
                        System.out.println("Item invalido.");
                        break;
                    }

                    System.out.print("Digite a nova quantidade (0 para voltar): ");
                    int novaQuantidade = teclado.nextInt();

                    if (novaQuantidade == 0) {
                        break;
                    }

                    if (novaQuantidade < 0) {
                        System.out.println("Quantidade invalida.");
                        break;
                    }

                    fatura.alterarQuantidade(
                            itemAlterar - 1,
                            novaQuantidade
                    );

                    System.out.println("Quantidade alterada com sucesso.");
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