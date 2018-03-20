import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Maria
 */
public class Pokemon implements java.io.Serializable{
    
    //Con esta variable hacemos posible el contador para asignar el número de pokédex a cada pokemon
    private static final AtomicInteger count = new AtomicInteger(0); 
    
    private final String nombrePokemon;
    private int nivel;
    private final String descripcionPokemon;
    private final String tipo;
    private Boolean atrapado;
    private final int numeroPokédex;
    private final String numeroPokédexFormateado;
    private Boolean shiny;
    private int contadorShiny;
    private int contadorVistos;
    private int contadorAtrapados;
    
    
    public Pokemon(String nom, String type, String desc)
    {
        this.nombrePokemon = nom;
        this.tipo = type;
        this.descripcionPokemon = desc;
        this.nivel = 1;
        this.atrapado = false;        
        this.numeroPokédex = count.incrementAndGet();
        this.numeroPokédexFormateado = numeroPokedexFormateado(this.numeroPokédex);
        this.shiny = false;
        this.contadorShiny = 0;
        this.contadorVistos = 0;
        this.contadorAtrapados = 0;
    }
    
    //Con este método conseguimos añadir ceros delante del número al que corresponde cada
    //pokémon en la pokédex (para conseguir visualizarlos como en la pokédex de los juegos originales)
    public String numeroPokedexFormateado(int num)
    {
        //A este método se le puede cambiar el segundo parámetro para que añada delante tantos ceros
        //como se precise.
        String formatString = String.format("%%0%dd", 3);         
        String formattedString = String.format(formatString, num);
        
        return formattedString;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescripcionPokemon() {
        return descripcionPokemon;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumeroPokédex() {
        return numeroPokédex;
    }

    public String getNumeroPokédexFormateado() {
        return numeroPokédexFormateado;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Boolean getAtrapado() {
        return atrapado;
    }

    public void setAtrapado(Boolean atrapado) {
        this.atrapado = atrapado;
    }

    public Boolean getShiny() {
        return shiny;
    }

    public int getContadorShiny() {
        return contadorShiny;
    }

    public void setShiny(Boolean shiny) {
        this.shiny = shiny;
    }

    public void setContadorShiny(int contadorShiny) {
        this.contadorShiny = contadorShiny;
    }

    public int getContadorVistos() {
        return contadorVistos;
    }

    public int getContadorAtrapados() {
        return contadorAtrapados;
    }

    public void setContadorVistos(int contadorVistos) {
        this.contadorVistos = contadorVistos;
    }

    public void setContadorAtrapados(int contadorAtrapados) {
        this.contadorAtrapados = contadorAtrapados;
    }
    
}
