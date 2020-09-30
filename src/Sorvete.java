import java.util.ArrayList;
/**
 * Escreva a descrição da classe Sorvete aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Sorvete extends Produto
{
    protected ArrayList<Sabor> sabores;
    private int limit;
    
    public Sorvete(String nome, int codigo, float preco, int limit){
        super(nome, codigo, preco);
        sabores = new ArrayList<Sabor>();
        this.limit = limit;
    } 
    
    public boolean addSabor(Sabor sabor){
        if(sabores.size() < limit){
          sabores.add(sabor);
          return true;
        }
        
        return false;
    }
}
