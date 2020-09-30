
/**
 * Escreva a descrição da classe Copo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Copo extends Sorvete
{
    public Copo(TamanhoSorvete tamanho){
            super((tamanho == TamanhoSorvete.PEQUENO ? "Copo Pequeno" : "Copo Grande" )
            ,(tamanho == TamanhoSorvete.PEQUENO ? 7 : 8),
            (tamanho == TamanhoSorvete.PEQUENO ? 3.00f : 4.50f),
            (tamanho == TamanhoSorvete.PEQUENO ? 3 : 6)
            );
            
            
    }
}
