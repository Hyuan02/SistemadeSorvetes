
/**
 * Escreva a descriÃ§Ã£o da classe Agua aqui.
 * 
 * @author Hyuan
 * @version v01
 */

public class Agua extends Produto
{
    private TamanhoAgua tamanho;
    private TipoAgua tipo;

    public Agua(){
        super("Água pequena s/gas", 1, 3.00f);
        this.tamanho = TamanhoAgua.PEQUENO;
        this.tipo = TipoAgua.CONVENCIONAL; 
    }

    public void SetAgua(TamanhoAgua tamanho, TipoAgua tipo){
        this.setNome("Água" + (tamanho == TamanhoAgua.PEQUENO ? "pequena" : "grande") + (tipo == TipoAgua.CONVENCIONAL ? "s/gas" : "c/gas"));
        if(this.tipo == TipoAgua.CONVENCIONAL) {
            if(this.tamanho == TamanhoAgua.PEQUENO){
                this.setPreco(3.00f); 
                this.setCodigo(2);
            }
            else{
                this.setPreco(5.00f);
                this.setCodigo(3);
            }
        }
        else{
            if(this.tamanho == TamanhoAgua.PEQUENO){
                this.setPreco(3.50f); 
                this.setCodigo(4);
            }
            else{
                this.setPreco(6.00f);
                this.setCodigo(5);
            }
        }
    }
}
