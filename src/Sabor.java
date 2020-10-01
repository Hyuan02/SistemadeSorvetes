
/**
 * Classe para os sabores de sorvete.
 * 
 * @author Hyuan
 * @version (v1)
 */
public class Sabor extends Produto
{
    /**
     * Tipo de sabor podendo ser {@code TipoSabor.CONVENCIONAL} ou {@code TipoSabor.ESPECIAL}
     */
    private TipoSabor tipo;
    
    /**
     * O nome do sabor.
     */
    private String nomeSabor;
    
    /**
     * Construtor da classe, inicializando os parâmetros de tipo e nome.
     */
    public Sabor(){
        super("Sabor Convencional", 06, 1.00f);
        tipo = TipoSabor.CONVENCIONAL;
        nomeSabor = "Laranja";
    }
    /**
     * Método para modificar a instância da classe.
     * @param tipo - O tipo do sabor, podendo ser {@code TipoSabor.CONVENCIONAL} ou {@code TipoSabor.ESPECIAL}
     * @param nomeSabor - O nome do sabor.
     */
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
        this.nomeSabor = nomeSabor;
    }
    
}
