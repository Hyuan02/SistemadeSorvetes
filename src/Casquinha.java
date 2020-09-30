
/**
 * Escreva a descrição da classe Casquinha aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Casquinha extends Sorvete
{
    
    public Casquinha(TamanhoSorvete tamanho){
        super((tamanho == TamanhoSorvete.PEQUENO ? "Casquinha" : "Cascão" )
            ,(tamanho == TamanhoSorvete.PEQUENO ? 9 : 10),
            (tamanho == TamanhoSorvete.PEQUENO ? 3.00f : 4.50f),
            (tamanho == TamanhoSorvete.PEQUENO ? 2 : 4)
            );
    }
}
