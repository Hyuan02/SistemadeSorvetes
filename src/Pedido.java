
import java.util.ArrayList;
/**
 * Classe respons�vel pela gest�o dos pedidos na aplica��o.
 * @
 * @author Hyuan 
 * @version (V1)
 */
public class Pedido
{
	/**
	 * Representa a lista de pedidos que foram feitos durante a execu��o da aplica��o.
	 */
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    /**
     * Representa o pedidoAtual que est� sendo feito na aplica��o.
     */
    private static Pedido pedidoAtual;
    
    /**
     * Representa os produtos contidos em um pedido.
     */
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    /**
     * Representa o valor total do pedido.
     */
    private float valorTotal = 0.0f; 

    /**
     * Construtor da classe pedido, em que sempre quando um novo pedido � instanciado, ele se torna o pedidoAtual.
     */
    public Pedido(){
        pedidoAtual = this;
    }

    /**
     * Fun��o que encerra o pedidoAtual e ent�o limpa a referencia do mesmo.
     */
    public static void finalizarPedido(){
        pedidoAtual.atribuirValorTotal(); // Calcula valor total
        pedidos.add(pedidoAtual); // Adiciona pedidoAtual na lista de pedidos
        pedidoAtual = null; // Zera refer�ncia.
    }

    /**
     * Fun��o que adiciona um produto no pedido instanciado.
     * @param produto - O produto a ser adicionado.
     */
    public void addProduto(Produto produto){
        produtos.add(produto); // Adiciona na lista de produtos.
    }

    /**
     * Fun��o que remove um produto no pedido instanciado.
     * @param produto - O produto a ser removido.
     */
    public void removerProduto(Produto produto){
        produtos.remove(produto); // Remove o produto da lista.
    }

    /**
     * Fun��o que calcula o valor total do pedido instanciado.
     * @return O valor total.
     */
    public float atribuirValorTotal(){
    	valorTotal = 0; //zera valorTotal para recalcular
        for(Produto produto : produtos){ //Loop entre produtos do pedido
            valorTotal+=produto.getPreco(); //Soma valor de cada um deles.
        }
        return valorTotal; //Retorna valor do pedido.
    }
    
    /**
     * Fun��o que retorna a lista de produtos do pedido instanciado.
     * @return Lista de produtos.
     */

    public ArrayList<Produto> getProdutos(){
        return produtos;
    }
    /**
     * Fun��o que calcula o valor somado em pedidos durante a execu��o do programa.
     * @return Valor total de pedidos.
     */

    public static float FinalizarCaixa(){
        float valorCaixa = 0.0f; //Cria uma variavel para soma.
        for(Pedido pedido : pedidos){ //Loop entre pedidos
            valorCaixa += pedido.valorTotal; //Soma para variavel
        }
        return valorCaixa; //Retorna valor total.
    }
    /**
     * Fun��o para retorno do pedido atual na aplica��o
     * @return - O pedido atual.
     */
    public static Pedido getPedidoAtual(){
        return pedidoAtual;
    }
}
