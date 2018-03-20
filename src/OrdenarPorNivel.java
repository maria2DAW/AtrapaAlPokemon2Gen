
import java.util.Comparator;

/**
 *
 * @author Maria
 */
public class OrdenarPorNivel implements Comparator<Pokemon>{
    
    // Used for sorting in ascending order of
    // roll number
    @Override
    public int compare(Pokemon a, Pokemon b)
    {
        //Así ordena de menor a mayor
        //return a.nivel - b.nivel;
        
        //Así ordena de mayor a menor
        return b.getNivel() - a.getNivel();

    }
    
}
