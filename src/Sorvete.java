import java.util.ArrayList;
/**
 * Classe abstrata que representa o produto sorvete.
 * 
 * @author Hyuan 
 * @version (V1)
 */
public abstract class Sorvete extends Produto
{
	/**
	 * A lista de sabores(bolas) que um sorvete pode conter.
	 */
    protected ArrayList<Sabor> sabores;
    /**
     * O limite do n�mero de bolas.
     */
    private int limit;
    
    /**
     * Construtor para o produto sorvete.
     * @param nome - O nome do sorvete.
     * @param codigo - O codigo do sorvete.
     * @param preco - O pre�o que pode variar de acordo com seu tipo.
     * @param limit - O limite do numero de bolas, podendo variar de acordo com o tipo.
     */
    public Sorvete(String nome, int codigo, float preco, int limit){
        super(nome, codigo, preco); // Construtor de produto
        sabores = new ArrayList<Sabor>(); // Inicia lista de sabores
        this.limit = limit; // Armazena o limite de bolas.
    } 
    
    /**
     * Adiciona um sabor na lista de sabores do sorvete.
     * @param sabor - O sabor a ser adicionado.
     * @return
     */
    public boolean addSabor(Sabor sabor){
        if(sabores.size() < limit){ // Verifica se ja chegou ao limite de bolas ou n�o.
          sabores.add(sabor); // Adiciona na lista caso n�o tenha chegado.
          return true; // Retorna que a adi��o foi um sucesso.
        }
        
        return false; // Caso n�o tenha sido conclu�da retorna falso.
    }
    
    public boolean isFull() {
    	return sabores.size() == limit;
    }
}
