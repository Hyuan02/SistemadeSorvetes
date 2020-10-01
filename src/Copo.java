
/**
 * Classe que representa o produto sorvete de copo.
 * 
 * @author Hyuan 
 * @version (V1)
 */
public class Copo extends Sorvete
{
	/**
	 * Construtor da classe da copo iniciando os parâmetros de tamanho, limite de bolas, codigo e preço.
	 * @param tamanho - O tamanho do sorvete, podendo ser {@code TamanhoSorvete.PEQUENO} ou {@code TamanhoSorvete.GRANDE}.
	 */
    public Copo(TamanhoSorvete tamanho){
            super((tamanho == TamanhoSorvete.PEQUENO ? "Copo Pequeno" : "Copo Grande" )
            ,(tamanho == TamanhoSorvete.PEQUENO ? 7 : 8),
            (tamanho == TamanhoSorvete.PEQUENO ? 3.00f : 4.50f),
            (tamanho == TamanhoSorvete.PEQUENO ? 3 : 6)
            );
            
            
    }
}
