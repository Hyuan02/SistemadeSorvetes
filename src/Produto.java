
/**
 * Classe base para os produtos do sistema.
 * 
 * @author Hyuan 
 * @version v01
 */
public abstract class Produto
{
    
    private String nome;
    private int codigo;
    private float preco;
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public String getNome()
    {
        // ponha seu código aqui
        return this.nome;
    }
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public void setNome(String nome)
    {
        // ponha seu código aqui
        this.nome = nome;
    }
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public int getCodigo()
    {
        // ponha seu código aqui
        return this.codigo;
    }
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public void setCodigo(int codigo)
    {
        // ponha seu código aqui
        this.codigo = codigo;
    }
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public float getPreco()
    {
        // ponha seu código aqui
        return this.preco;
    }
    
    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public void setPreco(float preco)
    {
        // ponha seu código aqui
        this.preco = preco;
    }
    
    public Produto(String nome, int codigo, float preco){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }
}
