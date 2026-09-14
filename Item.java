public class Item {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        valorTotal = produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        calcularValorTotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void exibirInformacoes() {
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Valor unitario: R$ %.2f%n", produto.getPreco());
        System.out.printf("Valor total: R$ %.2f%n", valorTotal);
    }
}