
/**
 * Classe abstrata para os produtos do sistema.
 * 
 * @author Hyuan 
 * @version (v01)
 */
public abstract class Produto
{
    
    private String nome;
    private int codigo;
    private float preco;
    
    /**
     * Retorna o nome do produto.
     *
     * @return o nome.
     */
    public String getNome()
    {
        return this.nome;
    }
    
    /**
     * Modifica o nome do produto.
     *
     * @param  o novo nome.
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    /**
     * Retorna o codigo do produto
     *
     * @return - o codigo.
     */
    public int getCodigo()
    {
        return this.codigo;
    }
    
    /**
     * Modifica o codigo do produto.
     *
     * @param codigo - O novo codigo do produto.
     * 
     */
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    /**
     * Retorna o pre�o do produto.
     *
     * @return - o pre�o.
     */
    public float getPreco()
    {
        return this.preco;
    }
    
    /**
     * Modifica o pre�o do produto.
     *
     * @param pre�o - O novo pre�o do produto.
     */
    public void setPreco(float preco)
    {
        // ponha seu código aqui
        this.preco = preco;
    }
    
    /**
     * Construtor para a classe de produto.
     * @param nome - O nome do produto.
     * @param codigo - O c�digo do produto.
     * @param preco - O pre�o do produto.
     */
    public Produto(String nome, int codigo, float preco){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }
}
