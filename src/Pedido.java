
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Pedido aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pedido
{
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private static Pedido pedidoAtual;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private float valorTotal = 0.0f; 

    public Pedido(){
        pedidoAtual = this;
    }

    public static void finalizarPedido(){
        pedidoAtual.atribuirValorTotal();
        pedidos.add(pedidoAtual);
        pedidoAtual = null;
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        produtos.remove(produto);
    }

    private void atribuirValorTotal(){
        for(Produto produto : produtos){
            valorTotal+=produto.getPreco();
        }
    }

    public ArrayList<Produto> getProdutos(){
        return produtos;
    }

    public static float FinalizarCaixa(){
        float valorCaixa = 0.0f;
        for(Pedido pedido : pedidos){
            valorCaixa += pedido.valorTotal;
        }
        return valorCaixa;
    }
    
    public static Pedido getPedidoAtual(){
        return pedidoAtual;
    }
}
