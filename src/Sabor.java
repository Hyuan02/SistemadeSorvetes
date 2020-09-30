
/**
 * Escreva a descrição da classe Sabor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Sabor extends Produto
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private TipoSabor tipo;
    private String nomeSabor;
    
    
    public Sabor(){
        super("Sabor Convencional", 06, 1.00f);
        tipo = TipoSabor.CONVENCIONAL;
        nomeSabor = "Laranja";
    }
    
    public void setSabor(TipoSabor tipo, String nomeSabor){
        if(tipo == TipoSabor.CONVENCIONAL){
            this.setPreco(1.00f);
            this.setNome("Sabor Convencional");
            this.setCodigo(06);
        }
        else{
            this.setPreco(2.00f);
            this.setNome("Sabor Especial");
            this.setCodigo(06);
        }
    }
    
}
