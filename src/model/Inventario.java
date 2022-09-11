package model;

public class Inventario {
    private int numProduto;
    private String nomeProduto;
    private int quantidadeProduto;

    public int getnumProduto() {
        return numProduto;
    }

    public void setnumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    public String getnomeProduto() {
        return nomeProduto;
    }

    public void setnomeProduto(String string) {
        this.nomeProduto = string;
    }

    public int getquantidadeProduto() {
        return quantidadeProduto;
    }

    public void setquantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return "numProduto=" + numProduto + "\n" + 
               "nomeProduto=" + nomeProduto + "\n" +
               "quantidadeProduto=" + quantidadeProduto + "\n"; 
    }

    public boolean cadastrar(double valor) {
        if(valor>0) {
            quantidadeProduto+= valor;
            return true;
        }
        return false;
    }

    public boolean saida(double valor) {
        if(valor<=quantidadeProduto) {
            quantidadeProduto -= valor;
            return true;
        }
        return false;
    }
}
