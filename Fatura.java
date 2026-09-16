import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        itens = new ArrayList<>();
        valorTotal = 0;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(int indice) {
        if (indice >= 0 && indice < itens.size()) {
            itens.remove(indice);
            calcularValorTotal();
        }
    }

    public void alterarQuantidade(int indice, int novaQuantidade) {
        if (indice >= 0 && indice < itens.size() && novaQuantidade > 0) {
            itens.get(indice).setQuantidade(novaQuantidade);
            calcularValorTotal();
        }
    }

    public void calcularValorTotal() {
        valorTotal = 0;

        for (Item item : itens) {
            valorTotal += item.getValorTotal();
        }
    }

    public void exibirFatura() {
        if (itens.size() == 0) {
            System.out.println("Nenhum item foi comprado.");
            return;
        }

        System.out.println("\n===== FATURA =====");

        for (int i = 0; i < itens.size(); i++) {
            System.out.println("\nItem " + (i + 1));
            itens.get(i).exibirInformacoes();
        }

        System.out.printf("\nValor total da fatura: R$ %.2f%n", valorTotal);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}