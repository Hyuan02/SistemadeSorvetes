
/**
 * Classe que simboliza o produto para Pedido Água, podendo ser escolhido entre com e sem gás, e grande ou pequeno.
 * 
 * @author Hyuan
 * @version v01
 */

public class Agua extends Produto
{
    private TamanhoAgua tamanho;
    private TipoAgua tipo;

    /**
     * Construtor da classe Agua que inicia com parâmetros de tamanho e tipo. 
     */
    public Agua(){
        super("Água pequena s/gas", 1, 3.00f);
        this.tamanho = TamanhoAgua.PEQUENO;
        this.tipo = TipoAgua.CONVENCIONAL; 
    }
    
    /**
     * Método para escolher as características de água do objeto.
     * 
     * @param tamanho O tamanho da Agua, que pode ser pequena ou grande
     * @param tipo O tipo da Agua, que pode ser {@code TipoAgua.CONVENCIONAL} ou {@code TipoAgua.GAS}
     * @return void
     */
    public void SetAgua(TamanhoAgua tamanho, TipoAgua tipo){
        this.setNome("Água" + (tamanho == TamanhoAgua.PEQUENO ? "pequena" : "grande") + (tipo == TipoAgua.CONVENCIONAL ? "s/gas" : "c/gas"));
        if(this.tipo == TipoAgua.CONVENCIONAL) {
            if(this.tamanho == TamanhoAgua.PEQUENO){
                this.setPreco(3.00f); //configura preço
                this.setCodigo(2); // codigo de produto
            }
            else{
                this.setPreco(5.00f); //configura preço
                this.setCodigo(3); // codigo de produto
            }
        }
        else{
            if(this.tamanho == TamanhoAgua.PEQUENO){
                this.setPreco(3.50f); //configura preço
                this.setCodigo(4); // codigo de produto
            }
            else{
                this.setPreco(6.00f); //configura preço
                this.setCodigo(5); // codigo de produto
            }
        }
    }
}
