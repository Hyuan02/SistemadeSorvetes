
/**
 * Classe que representa um produto do tipo Sorvete de Casquinha.
 * 
 * @author (Hyuan) 
 * @version (V1)
 */
public class Casquinha extends Sorvete
{
    /**
     * Construtor da classe da casquinha iniciando os parâmetros de tamanho, limite de bolas, codigo e preço.
     * @param tamanho - O tamanho do sorvete, podendo ser {@code TamanhoSorvete.PEQUENO} ou {@code TamanhoSorvete.GRANDE}.
     */
    public Casquinha(TamanhoSorvete tamanho){
        super((tamanho == TamanhoSorvete.PEQUENO ? "Casquinha" : "Cascão" )
            ,(tamanho == TamanhoSorvete.PEQUENO ? 9 : 10),
            (tamanho == TamanhoSorvete.PEQUENO ? 3.00f : 4.50f),
            (tamanho == TamanhoSorvete.PEQUENO ? 2 : 4)
            );
    }
}
