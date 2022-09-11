package cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Inventario;

public class GerenciadorInventario {
    public List<Inventario> lista = new ArrayList<>();

    public static void main(String[] args) {
        GerenciadorInventario gi = new GerenciadorInventario();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            opc = construirMenu(gi, sc);
        } while(opc!=5);
    }

    private static int construirMenu(GerenciadorInventario gi, Scanner sc) {
        int opc;
        System.out.println("***MENU***");
        System.out.println("1. Cadastrar Produtos");
        System.out.println("2. Saida de Produtos");
        System.out.println("3. Depositar");
        System.out.println("4. Estoque");
        System.out.println("5. Sair");
        System.out.println("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());

        switch(opc) {
            case 1:
                gi.execCadastrar(sc);
            break;

            case 2:
                gi.execSaida(sc);
            break;

            case 3:
                gi.execDepositar(sc);
            break;

            case 4:
                gi.execEstoque();
            break;

            case 5:
                System.out.println("***FIM***");
            break;

            default: 
                System.out.println("Opcao invalida");
        }
        return opc;
    }

    public void execCadastrar(Scanner sc) {
        Inventario produto = new Inventario();
        System.out.println("Digite o numero do produto: ");
        produto.setnumProduto(Integer.parseInt(sc.nextLine()));

        System.out.println("Digite o nome do produto: ");
        produto.setnomeProduto(sc.nextLine());

        System.out.println("Digite a quantidade de itens: ");
        produto.setquantidadeProduto(Integer.parseInt(sc.nextLine()));

        lista.add(produto);
        System.out.println("Produto Cadastrado com sucesso");
    }

    public void execSaida(Scanner sc) {
        System.out.println("Digite o numero do produto: ");
        int proc = Integer.parseInt(sc.nextLine());
        Inventario produto = null;

        for(Inventario i : lista) {
            if(i.getnumProduto()==proc) {
                produto = i;
                break;
            }
        }
        if(produto!=null) {
            System.out.println("Digite o numero de produtos a serem retirados: ");
            boolean ok = produto.saida(Double.parseDouble(sc.nextLine()));
            if(ok) {
                System.out.println("Retirada efetuada");
            }else {
                System.out.println("Valor nao existente");
            }
        }else {
            System.out.println("Produto nao encontrado");
        }
    }

    public void execDepositar(Scanner sc) {
        System.out.println("Digite o numero do produto a ser depositado: ");
        int proc = Integer.parseInt(sc.nextLine());
        Inventario inv = null;

        for(Inventario i : lista) {
            if(i.getnumProduto()==proc) {
                inv = i;
                break;
            }
        }
        if(inv!=null) {
            System.out.println("Digite o valor a ser acrescentado: ");
            boolean ok = inv.cadastrar(Double.parseDouble(sc.nextLine()));
            if(ok) {
                System.out.println("Deposito efetuado");
            }else {
                System.out.println("Valor nao pode ser menor ou igual a 0");
            }
        }else {
            System.out.println("Produto nao encontrado");
        }
    }

    public void execEstoque() {
        for(Inventario i : lista) {
            System.out.println(i.toString());
        }
    }
}
