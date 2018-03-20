import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class AtrapaAlPokemon {
    
    public static List<Pokemon> listaPokemon;
    private String nomOculto;
    private Pokemon pokemonAAdivinar;
    private int pokeballs;
    private List<Character> letrasIntroducidas;
    
    private Boolean quitarVida; 
    
    /*CONSTRUCTOR*/
    public AtrapaAlPokemon()
    {
        //listaPokemonAtrapados = new ArrayList<>();
        
        letrasIntroducidas = new ArrayList<>();
        
        listaPokemon = new ArrayList<>();
        
        listaPokemon.add(new Pokemon("Chikorita", "Planta", "Al luchar, Chikorita agita la hoja que tiene para mantener a raya al rival. Pero, al mismo tiempo, libera una suave fragancia que apacigua el encuentro y crea un ambiente agradable y de amistad."));
        listaPokemon.add(new Pokemon("Bayleef", "Planta", "Bayleef tiene un collar de hojas alrededor del cuello y un brote de un árbol en cada una de ellas. La fragancia que desprenden estos brotes anima a la gente."));
        listaPokemon.add(new Pokemon("Meganium", "Planta", "La fragancia de la flor de Meganium aplaca y suaviza los ánimos. Al luchar, este Pokémon libera mayor cantidad de esencia para disminuir el ánimo de combate de su oponente."));
        listaPokemon.add(new Pokemon("Cyndaquil", "Fuego", "Cyndaquil se protege soltando llamas por el lomo. Cuando está enfadado, las llamas son fieras, pero, si está cansado, solo consigue echar algunas chispas que no llegan a cuajar en una completa combustión."));
        listaPokemon.add(new Pokemon("Quilava", "Fuego", "Quilava mantiene a sus rivales a raya con la intensidad de sus llamas y las ráfagas de aire ígneo que producen. También aprovecha su espectacular agilidad para esquivar ataques a la vez que abrasa al rival con sus llamas."));
        listaPokemon.add(new Pokemon("Typhlosion", "Fuego", "Typhlosion se oculta tras un trémulo haz de calor que crea mediante sus intensas y sofocantes llamaradas. Este Pokémon causa explosiones de fuego que reducen todo a cenizas."));
        listaPokemon.add(new Pokemon("Totodile", "Agua", "Totodile tiene cuerpo pequeño, pero fuertes mandíbulas. A veces, piensa que solo está dando un mordisquito y hace unas heridas bastante considerables."));
        listaPokemon.add(new Pokemon("Croconaw", "Agua", "Una vez que Croconaw le ha clavado los colmillos a su presa, es imposible que escape porque los tiene hacia adentro como si fueran anzuelos. Cuando Croconaw hinca los dientes, no hay escapatoria."));
        listaPokemon.add(new Pokemon("Feraligatr", "Agua", "Feraligatr intimida a sus oponentes abriendo las grandes fauces que tiene. En combate, golpea el suelo bruscamente con las gruesas y fuertes patas traseras que tiene para cargar contra su rival a una velocidad de vértigo."));
        listaPokemon.add(new Pokemon("Sentret", "Normal", "Sentret no duerme a menos que otro haga guardia. El que hace de centinela lo despertará al mínimo signo de peligro. Cuando este Pokémon se separa de su manada, es incapaz de echarse a dormir, presa del miedo."));
        listaPokemon.add(new Pokemon("Furret", "Normal", "Furret es de constitución muy delgada. En combate le resulta útil porque puede escabullirse con habilidad por cualquier huequito y escapar. A pesar de que tiene patas cortas, es ágil y veloz."));
        listaPokemon.add(new Pokemon("Hoothoot", "Normal-Volador", "Hoothoot tiene un órgano interno que identifica y percibe la rotación de la tierra. Gracias a este órgano, el Pokémon ulula todos los días a la misma hora."));
        listaPokemon.add(new Pokemon("Noctowl", "Normal-Volador", "Noctowl no falla a la hora de cazar a su presa en la oscuridad. El éxito se lo debe a una vista privilegiada, que le permite ver donde apenas hay luz, y a las ligeras y flexibles alas que tiene, que no hacen ruido alguno al volar."));
        listaPokemon.add(new Pokemon("Ledyba", "Bicho-Volador", "Ledyba segrega un fluido aromático por los seis puntos de unión que tiene entre las patas y el cuerpo. A través de este fluido se comunica con otros y les informa acerca de sus sentimientos variando la esencia."));
        listaPokemon.add(new Pokemon("Ledian", "Bicho-Volador", "Dicen que en zonas en las que el aire está limpio, en las que se ven las estrellas, hay enormes poblaciones de Ledian. La razón es muy sencilla: este Pokémon usa la luz de las estrellas como fuente de energía."));
        listaPokemon.add(new Pokemon("Spinarak", "Bicho-Veneno", "La tela que teje Spinarak puede considerarse como su segundo sistema nervioso. Dicen que puede adivinar qué tipo de presa ha caído en su red con solo observar las leves vibraciones de los hilos de la tela."));
        listaPokemon.add(new Pokemon("Ariados", "Bicho-Veneno", "Ariados tiene unas patas con forma de garfio que le permiten correr por techos y superficies verticales. Este Pokémon oprime al rival con una tela de araña fina y resistente."));
        listaPokemon.add(new Pokemon("Crobat", "Veneno-Volador", "Cuando este Pokémon vuela batiendo solo las alas delanteras o traseras, es porque lleva volando bastante tiempo. Cuando se cansa, Crobat alterna las alas."));
        listaPokemon.add(new Pokemon("Chinchou", "Agua-Eléctrico", "Chinchou libera cargas eléctricas positivas y negativas a través de las dos antenas que tiene para que su rival pierda el conocimiento. Asimismo, usa los destellos de electricidad para comunicarse con otros."));
        listaPokemon.add(new Pokemon("Lanturn", "Agua-Eléctrico", "A Lanturn lo llaman la Estrella del Fondo del Mar por la antena iluminada que tiene. Este Pokémon produce luz creando una reacción química entre una bacteria y los fluidos corporales de la antena."));
        listaPokemon.add(new Pokemon("Pichu", "Eléctrico", "A Pichu le resulta más fácil cargarse de electricidad en días de nubarrones o cuando sopla un aire muy seco. Es posible oír la electricidad estática que emana de este Pokémon."));
        listaPokemon.add(new Pokemon("Cleffa", "Hada", "Cuando hay lluvia de estrellas, a los Cleffa se les puede ver danzando en círculos durante toda la noche. Solo paran cuando rompe el día; entonces, dejan de bailar y calman su sed con el rocío de la mañana."));
        listaPokemon.add(new Pokemon("Igglybuff", "Normal-Hada", "Las cuerdas vocales de Igglybuff no están suficientemente desarrolladas. Si tuviera que cantar mucho, se haría daño en la garganta. Este Pokémon suele hacer gárgaras con agua pura de manantial."));
        listaPokemon.add(new Pokemon("Togepi", "Hada", "Togepi usa los sentimientos positivos de compasión y alegría que desprenden las personas y los Pokémon. Este Pokémon almacena sentimientos de felicidad en su interior y después los comparte con otros."));
        listaPokemon.add(new Pokemon("Togetic", "Hada-Volador", "Dicen que Togetic es un Pokémon que trae buena suerte y que, si detecta a alguien que es puro de corazón, sale para compartir su alegría con él."));
        listaPokemon.add(new Pokemon("Natu", "Psíquico-Volador", "Natu no puede volar porque las alas no le han crecido lo suficiente. Si alguien cruza la mirada con él, se la devolverá fijamente, aunque, si hace el mínimo movimiento, huirá dando saltitos para ponerse a salvo."));
        listaPokemon.add(new Pokemon("Xatu", "Psíquico-Volador", "Xatu permanece de pie inmóvil y tranquilo en el mismo sitio durante todo el día. Se cree que no se mueve por temor a lo que ha visto que ocurrirá en el futuro."));
        listaPokemon.add(new Pokemon("Mareep", "Eléctrico", "Mareep tiene un pelaje lanudo suave que produce carga estática por el roce. Cuanto más se carga de electricidad estática, más brilla la bombilla que tiene en el extremo de la cola."));
        listaPokemon.add(new Pokemon("Flaaffy", "Eléctrico", "La calidad de la lana de Flaaffy varía para poder generar mucha electricidad estática con muy poca cantidad de lana. Las zonas suaves de la piel en las que no tiene pelaje están protegidas contra la electricidad."));
        listaPokemon.add(new Pokemon("Ampharos", "Eléctrico", "Ampharos desprende tanta luz que es posible verle hasta desde el espacio. Antes, la gente usaba su luz como sistema de comunicación para enviarse señales."));
        listaPokemon.add(new Pokemon("Bellossom", "Planta", "Cuando Bellossom se expone a gran cantidad de luz solar, le empiezan a girar las hojas que le rodean. La danza de este Pokémon es famosa en las zonas del sur."));
        listaPokemon.add(new Pokemon("Marill", "Agua-Hada", "La cola de Marill contiene un aceite que hace las veces de chaleco salvavidas. Si ves una moviéndose en el agua, seguro que debajo hay un Marill medio sumergido buscando plantas acuáticas para comer."));
        listaPokemon.add(new Pokemon("Azumarill", "Agua-Hada", "Azumarill puede hacer burbujas de aire si ve a algún Pokémon que esté a punto de ahogarse. Estas burbujas de aire son básicas para que los Pokémon puedan seguir respirando."));
        listaPokemon.add(new Pokemon("Sudowoodo", "Roca", "Sudowoodo se camufla adoptando la imagen de un árbol para que no le ataque ningún enemigo. El problema viene en invierno, ya que las extremidades superiores tienen color verde y es fácil identificarle."));
        listaPokemon.add(new Pokemon("Politoed", "Agua", "El mechón rizado de Politoed confirma su condición de rey. Dicen que cuanto más le crece y más se le riza, mayor es el respeto que recibe de sus súbditos."));
        listaPokemon.add(new Pokemon("Hoppip", "Planta-Volador", "Este Pokémon flota en el aire y se deja llevar. Cuando percibe que el viento va a cambiar a fuerte, Hoppip entrelaza sus hojas con otros Hoppip para hacer resistencia y evitar salir volando por la fuerza de la corriente."));
        listaPokemon.add(new Pokemon("Skiploom", "Planta-Volador", "Skiploom florece cuando la temperatura llega a 18 °C. La apertura de los pétalos varía según la temperatura que haga. Por este motivo, la gente lo usa a veces a modo de termómetro."));
        listaPokemon.add(new Pokemon("Jumpluff", "Planta-Volador", "Jumpluff se vale de los cálidos vientos del sur para volar a tierras lejanas. Si llega a zonas de aire frío en pleno vuelo, descenderá y tomará tierra."));
        listaPokemon.add(new Pokemon("Aipom", "Normal", "La cola de Aipom termina en una especie de mano a la que, con un poco de cabeza, se le puede dar muy buen uso. Pero hay un problema: como se ha acostumbrado a usarla mucho, las de verdad se le han vuelto algo torponas."));
        listaPokemon.add(new Pokemon("Sunkern", "Planta", "Sunkern intenta moverse lo menos posible para conservar todos los nutrientes que ha guardado en su interior y poder evolucionar. Ni come siquiera; se alimenta solo del rocío de la mañana."));
        listaPokemon.add(new Pokemon("Sunflora", "Planta", "Sunflora transforma la energía solar en nutrientes. De día, cuando hace calor, está en continuo movimiento. Solo para cuando comienza a anochecer."));
        listaPokemon.add(new Pokemon("Yanma", "Bicho-Volador", "Yanma tiene un ángulo de visión de 360° sin mover los ojos. Es un gran volador, experto en hacer repentinas paradas y cambios de dirección en el aire. Aprovecha la habilidad que tiene de volar para lanzarse sobre su presa."));
        listaPokemon.add(new Pokemon("Wooper", "Agua-Tierra", "Wooper suele vivir en el agua, pero es posible también verle en tierra en busca de comida. Cuando está en terreno firme, se cubre con una película viscosa tóxica."));
        listaPokemon.add(new Pokemon("Quagsire", "Agua-Tierra", "Quagsire caza dejando las fauces abiertas en el agua y esperando a que su presa entre sin darse cuenta. Como se queda quieto, el Pokémon no pasa mucha hambre."));
        listaPokemon.add(new Pokemon("Espeon", "Psíquico", "Espeon es tremendamente leal al Entrenador al que considera digno de ello. Dicen que este Pokémon desarrolló sus poderes adivinatorios para evitar que su Entrenador sufra daño alguno."));
        listaPokemon.add(new Pokemon("Umbreon", "Siniestro", "Umbreon evolucionó tras haber estado expuesto a ondas lunares. Suele esconderse en la oscuridad en silencio y esperar a que su presa se mueva. Cuando se lanza al ataque, le brillan los anillos del cuerpo."));
        listaPokemon.add(new Pokemon("Murkrow", "Siniestro-Volador", "Murkrow ha sido temido y repudiado por todos por ser supuestamente fuente de mala suerte. Este Pokémon siente debilidad por todo lo que brilla y resplandece. A las mujeres les roba los anillos."));
        listaPokemon.add(new Pokemon("Slowking", "Agua-Psíquico", "Slowking dedica cada día tiempo a investigar, en un intento por resolver los misterios del mundo. Aunque, según parece, a este Pokémon se le olvida todo lo que ha aprendido si se separa del Shellder que lleva en la cabeza."));
        listaPokemon.add(new Pokemon("Misdreavus", "Fantasma", "Misdreavus asusta a la gente con un chillido escalofriante y sollozante. Y, al parecer, usa las esferas rojas para absorber los sentimientos de miedo de los enemigos y usarlos como alimento."));
        listaPokemon.add(new Pokemon("Unown", "Psíquico", "Estos Pokémon tienen forma de caracteres antiguos. No se sabe qué surgió primero, si la vieja escritura o los distintos Unown. Esta cuestión sigue siendo objeto de estudio, pero aún no se ha averiguado nada."));
        listaPokemon.add(new Pokemon("Wobbuffet", "Psíquico", "Si dos o más Wobbuffet se encuentran, se volverán competitivos e intentarán superarse en resistencia. Pero también puede que intenten aguantar sin comer; algo que los Entrenadores deben tener muy en cuenta."));
        listaPokemon.add(new Pokemon("Girafarig", "Normal-Psíquico", "Girafarig tiene un cerebro también en la cabeza de la cola que reacciona atacando ante olores y sonidos. Cuando alguien se acerca a este Pokémon por la espalda, puede provocar que la cabeza trasera se abalance y lo muerda."));
        listaPokemon.add(new Pokemon("Pineco", "Bicho", "Pineco permanece colgado de la rama de un árbol esperando pacientemente a su presa. Si alguien sacude el árbol en el que está mientras come y le molesta, se tira al suelo y explota sin dar ningún tipo de aviso."));
        listaPokemon.add(new Pokemon("Forretress", "Bicho-Acero", "Forretress se esconde dentro de su concha de acero reforzada. Solo la abre cuando va a atrapar a su presa, pero ocurre tan rápido que no da tiempo de ver su interior."));
        listaPokemon.add(new Pokemon("Dunsparce", "Normal", "La cola de Dunsparce es un taladro que usa para enterrarse en el suelo de espaldas. De todos es sabido que este Pokémon hace su nido a gran profundidad y con una forma muy compleja."));
        listaPokemon.add(new Pokemon("Gligar", "Tierra-Volador", "Gligar planea por el aire sin hacer ningún ruido, como si fuera patinando. Este Pokémon se agarra a la cara de su rival con las patas traseras, con forma de garra, y las pinzas de las delanteras y le inyecta veneno por el aguijón."));
        listaPokemon.add(new Pokemon("Steelix", "Acero-Tierra", "Steelix vive a mayor profundidad aún que Onix. Se le conoce por su tendencia a excavar hacia el interior del planeta. Hay datos que muestran que este Pokémon ha llegado a alcanzar 1 km de profundidad."));
        listaPokemon.add(new Pokemon("Snubbull", "Hada", "Al tener los colmillos por fuera, Snubbull da miedo y espanta a los Pokémon pequeños, que huyen aterrados. Parece que a él le da un poco de pena que salgan huyendo."));
        listaPokemon.add(new Pokemon("Granbull", "Hada", "Granbull tiene la mandíbula inferior demasiado desarrollada y colmillos enormes y pesados que le obligan a inclinar la cabeza hacia atrás para compensar el peso. Si no se le asusta, no muerde."));
        listaPokemon.add(new Pokemon("Qwilfish", "Agua-Veneno", "Qwilfish bebe agua y se hincha, y a continuación usa la presión del agua que ha tragado para lanzar púas tóxicas por todo el cuerpo. Para este Pokémon nadar es una especie de desafío."));
        listaPokemon.add(new Pokemon("Scizor", "Bicho-Acero", "Scizor tiene un cuerpo duro como el acero que no es fácil de alterar con ningún ataque común. Este Pokémon bate las alas para regular la temperatura corporal."));
        listaPokemon.add(new Pokemon("Shuckle", "Bicho-Roca", "Shuckle permanece escondido bajo las rocas en silencio y, cuando se pone a comer las bayas que almacena, se encierra en el caparazón. Las bayas se mezclan con sus fluidos corporales y originan zumo."));
        listaPokemon.add(new Pokemon("Heracross", "Bicho-Lucha", "Heracross carga en línea recta contra el enemigo, se le queda encajado por debajo, lo agarra y lo lanza con ayuda del fuerte cuerno que tiene. Este Pokémon tiene fuerza hasta para echar abajo un árbol descomunal."));
        listaPokemon.add(new Pokemon("Sneasel", "Siniestro-Hielo", "Sneasel trepa por los árboles agarrándose a la corteza con las garras curvas que tiene. Este Pokémon busca nidos desprovistos de vigilancia paterna para robar los huevos y comérselos."));
        listaPokemon.add(new Pokemon("Teddiursa", "Normal", "A Teddiursa le encanta chuparse las palmas impregnadas de dulce miel. Este Pokémon fabrica su propia miel mezclando frutos y el polen que recoge Beedrill."));
        listaPokemon.add(new Pokemon("Ursaring", "Normal", "En los bosques habitados por Ursaring, dicen que abundan los arroyos y árboles gigantes en los que guardan su alimento. Este Pokémon se dedica todos los días a pasear por el bosque para buscar comida y guardarla."));
        listaPokemon.add(new Pokemon("Slugma", "Fuego", "Por el sistema circulatorio de Slugma corre magma líquido. Si este Pokémon se enfriara, el magma perdería el calor y se solidificaría, por lo que se resquebrajaría por completo, perdería algunos trozos y reduciría su tamaño."));
        listaPokemon.add(new Pokemon("Magcargo", "Fuego-Roca", "La coraza de Magcargo es en realidad su propia piel que quedó endurecida al enfriarse. Está muy resquebrajada y es muy frágil; se desharía solo con tocarla. Este Pokémon debe sumergirse en magma para recuperar su forma."));
        listaPokemon.add(new Pokemon("Swinub", "Hielo-Tierra", "Swinub busca el alimento frotando el hocico contra el suelo. Su comida preferida es una seta que crece bajo la hierba marchita. A veces, al frotar, descubre fuentes termales."));
        listaPokemon.add(new Pokemon("Piloswine", "Hielo-Tierra", "Piloswine está cubierto por un pelaje tupido y de largas cerdas que le permite soportar el frío polar. Este Pokémon usa los colmillos para desenterrar los alimentos que hayan podido quedar bajo el hielo."));
        listaPokemon.add(new Pokemon("Corsola", "Agua-Roca", "Las ramas de Corsola brillan con belleza hasta en siete colores cuando les da el sol. Si se le rompe alguna, el Pokémon la regenera en tan solo una noche."));
        listaPokemon.add(new Pokemon("Remoraid", "Agua", "Remoraid traga agua y usa los abdominales para lanzarla a gran velocidad contra una presa que esté en el aire. Cuando está a punto de evolucionar, este Pokémon nada en los ríos corriente abajo."));
        listaPokemon.add(new Pokemon("Octillery", "Agua", "Octillery se apodera de su enemigo con los tentáculos y lo deja inmovilizado antes de propinarle el golpe final. Si el enemigo resulta ser demasiado fuerte, Octillery expulsará tinta para escapar."));
        listaPokemon.add(new Pokemon("Delibird", "Hielo-Volador", "Delibird usa la cola a modo de saco para llevar su alimento. En una ocasión, un famoso escalador consiguió alcanzar la cima más alta del mundo gracias a que uno de estos Pokémon compartió sus alimentos con él."));
        listaPokemon.add(new Pokemon("Mantine", "Agua-Volador", "En los días que hace sol, es posible ver bancos de Mantine saltando con elegancia por entre las olas del mar. A estos Pokémon no les molestan los Remoraid que se les pegan."));
        listaPokemon.add(new Pokemon("Skarmory", "Acero-Volador", "Skarmory está totalmente encerrado en el interior de una fuerte coraza protectora. En vuelo, puede llegar a alcanzar los 300 km/h y usa las afiladas alas que tiene para azotar al rival."));
        listaPokemon.add(new Pokemon("Houndour", "Siniestro-Fuego", "Houndour sale a cazar con el resto de la manada con total coordinación. Estos Pokémon se comunican unos con otros usando una serie de aullidos para acorralar a su presa. El compañerismo que existe entre ellos es incomparable."));
        listaPokemon.add(new Pokemon("Houndoom", "Siniestro-Fuego", "En la manada de Houndoom, el que tiene los cuernos más arqueados hacia atrás tiene un mayor papel de liderazgo. Estos Pokémon suelen elegir al jefe en duelo."));
        listaPokemon.add(new Pokemon("Kingdra", "Agua-Dragón", "Kingdra vive en lo más profundo del océano, donde no habita ninguna otra especie. Siempre se ha pensado que su bostezo causaba las corrientes en remolino que se dan en el océano."));
        listaPokemon.add(new Pokemon("Phanpy", "Tierra", "Phanpy cava un agujero profundo para hacer su nido en el suelo, en la ribera de los ríos, y marca con la trompa la zona para que el resto vea que ese terreno ya está ocupado."));
        listaPokemon.add(new Pokemon("Donphan", "Tierra", "A Donphan le encanta enrollarse como una pelota y cargar contra el enemigo rodando a toda velocidad. Una vez que ha comenzado a rodar, no es fácil pararlo."));
        listaPokemon.add(new Pokemon("Porygon2", "Normal", "Porygon2 fue creado por el hombre gracias a los avances de la ciencia. Esta obra humana ha sido provista de inteligencia artificial que le permite aprender gestos y sensaciones nuevas por su cuenta."));
        listaPokemon.add(new Pokemon("Stantler", "Normal", "Hace tiempo, se comerciaba con la magnífica cornamenta de Stantler. Se vendía como obra de arte a alto precio. Los interesados en cornamentas de valor incalculable empezaron a cazarlos y casi provocan su extinción."));
        listaPokemon.add(new Pokemon("Smeargle", "Normal", "Smeargle marca los límites de su territorio liberando un fluido corporal por el extremo de la cola. En la actualidad se han encontrado más de 5000 tipos de marcas distintas dejadas por este Pokémon."));
        listaPokemon.add(new Pokemon("Tyrogue", "Lucha", "Tyrogue se pone demasiado nervioso si no lo sacan a entrenarse cada día. Su Entrenador debe establecer y mantener ciertos métodos de entrenamiento durante la cría."));
        listaPokemon.add(new Pokemon("Hitmontop", "Lucha", "Hitmontop hace el pino con la cabeza y se pone a girar rápido al tiempo que reparte patadas. Esta es una técnica ofensiva y defensiva a la vez. Este Pokémon se desplaza más rápido girando sobre sí que caminando."));
        listaPokemon.add(new Pokemon("Smoochum", "Hielo-Psíquico", "Smoochum va corriendo por todos lados, pero se cae también con frecuencia. Y, en cuanto tiene ocasión, se mira en algún sitio para ver si se ha manchado la cara."));
        listaPokemon.add(new Pokemon("Elekid", "Eléctrico", "Elekid acumula electricidad. Si entra en contacto con algo de metal y descarga accidentalmente toda la electricidad almacenada, empieza a agitar los brazos en círculo para volver a cargarse."));
        listaPokemon.add(new Pokemon("Magby", "Fuego", "El estado de salud de Magby se puede determinar observando el fuego que emana al respirar. Si las llamas que echa por la boca son amarillas, está bien. Pero, si además de las llamas sale humo negro, está cansado."));
        listaPokemon.add(new Pokemon("Miltank", "Normal", "Miltank da al día 20 l de una leche dulce que es la delicia de pequeños y mayores. Aquellos que no pueden tomarla, se decantan por los yogures."));
        listaPokemon.add(new Pokemon("Blissey", "Normal", "Blissey es capaz de sentir la tristeza a través del sedoso pelaje. Si detecta que alguien está apenado, irá hasta donde esté y compartirá un Huevo Suerte para devolverle la sonrisa."));
        listaPokemon.add(new Pokemon("Raikou", "Eléctrico", "Raikou tiene la velocidad del rayo. Los rugidos de este Pokémon emiten ondas de choque que se esparcen vibrando por el aire y sacuden el suelo como si fueran auténticas descargas de rayo."));
        listaPokemon.add(new Pokemon("Entei", "Fuego", "Entei contiene el fulgor del magma en su interior. Se cree que este Pokémon nació de la erupción de un volcán. Escupe numerosas ráfagas de fuego que devoran y reducen a cenizas todo lo que tocan."));
        listaPokemon.add(new Pokemon("Suicune", "Agua", "Suicune emana la pureza de los manantiales. Suele corretear por el campo con gran elegancia. Este Pokémon tiene el poder de purificar el agua contaminada."));
        listaPokemon.add(new Pokemon("Larvitar", "Roca-Tierra", "Larvitar nace bajo tierra a gran profundidad. Para subir a la superficie, este Pokémon debe comer lo que encuentra en su camino para abrirse paso. Y, hasta que no está arriba, no puede verles la cara a sus padres."));
        listaPokemon.add(new Pokemon("Pupitar", "Roca-Tierra", "Pupitar crea un gas en su interior que comprime y expulsa violentamente a modo de autopropulsión. Tiene un cuerpo resistente que se mantiene inalterable hasta cuando se golpea contra duro acero."));
        listaPokemon.add(new Pokemon("Tyranitar", "Roca-Siniestro", "Tyranitar tiene una fuerza imponente; es capaz de echar abajo una montaña para hacer su nido. Este Pokémon suele merodear por las zonas de montaña en busca de nuevos rivales contra los que luchar."));
        listaPokemon.add(new Pokemon("Lugia", "Psíquico-Volador", "La fuerza que tiene Lugia en las alas es devastadora; con nada que las bata es capaz de derribar edificios enteros. Por eso mismo, prefiere vivir donde no haya nadie, en lo más profundo del mar."));
        listaPokemon.add(new Pokemon("Ho-Oh", "Fuego-Volador", "El plumaje de Ho-Oh contiene siete colores que pueden apreciarse según el ángulo desde el que les dé la luz. Dicen que sus plumas dan felicidad a quienes las llevan y, también, que este Pokémon vive a los pies del arco iris."));
        listaPokemon.add(new Pokemon("Celebi", "Psíquico-Planta", "Este Pokémon vino del futuro haciendo un viaje en el tiempo. Hay quien piensa que, mientras Celebi siga apareciendo, hay un futuro brillante y esperanzador."));
               
        this.pokeballs = 7;
                
        this.generarPokemonAleatorio();
        this.iniciarNombreOculto();
    }
            
    
    /*Método para generar el nombre aleatorio del pokémon que habrá que averiguar posteriormente.*/
    public void generarPokemonAleatorio()
    {
        int posPokeAleatorio = generarNumeroAleatorio();		
        this.pokemonAAdivinar = listaPokemon.get(posPokeAleatorio);
    }
    
    public int generarNumeroAleatorio()
    {
        int numAleatorio = (int)(Math.random() * listaPokemon.size());
        
        return numAleatorio;
    }
    
    /*Método para contruir el nombre oculto del pokémon por primera vez
    (Cada vez que se inicia una nueva partida)*/
    public void iniciarNombreOculto()
    {
        this.nomOculto = "";
        
        for(int i = 0; i < pokemonAAdivinar.getNombrePokemon().length(); i++) 
        {
            nomOculto += "*";
        }
    }
    
    /*Método para sustituir la letra introducida en el nombre oculto en caso de que
    la contenga (para ir desvelando el nombre)
    Devuelve el nombre oculto con las letras resueltas hasta el momento*/
    public String revelarPokemon(String txtIntroducido, Boolean YaSeCualEs)
    {
        //JOptionPane.showMessageDialog(null, txtIntroducido);
        
        quitarVida = false; 
        
        if(YaSeCualEs)
        {            
            if(txtIntroducido.toLowerCase().equals(pokemonAAdivinar.getNombrePokemon().toLowerCase()))
            {                
                nomOculto = pokemonAAdivinar.getNombrePokemon();
            }
            
            else
            {
                quitarVida = true;
            }
           
        }
        
        else
        {            
            revelarLetra(txtIntroducido);
        }
        
        if(quitarVida)
        {
            quitarUnaPokeball();
        }
        
        //JOptionPane.showMessageDialog(null, nomOculto);

        return nomOculto;
    }
    
    public void revelarLetra(String txt)
    {
        char x = txt.charAt(0);
        
            /*Se descompone el nombre oculto en un array de char para facilitar la búsqueda de la letra
            dentro de dicha palabra.*/
            char[] arrayCharNomOculto;
            arrayCharNomOculto = nomOculto.toCharArray();
            
            nomOculto = "";            
            
            /*Se recorre cada uno de los caracteres del nombre del pokémon en cuestión para encontrar
            la coincidencia.*/
            for(int i = 0; i < pokemonAAdivinar.getNombrePokemon().length(); i++)
            {
                //Si la palabra contiene la letra y ésta no ha sido introducida con anterioridad
                if (pokemonAAdivinar.getNombrePokemon().toLowerCase().indexOf(Character.toLowerCase(x)) != -1
                    && !letraYaIntroducida(x))
                {
                    //JOptionPane.showMessageDialog(null, "Contiene la letra y no ha sido introducida anteriormente");
                    
                    //Si se encuentra, se sustituye con la letra introducida.
                    if (Character.toLowerCase(x) == Character.toLowerCase(pokemonAAdivinar.getNombrePokemon().charAt(i)))
                    {
                        arrayCharNomOculto[i] = pokemonAAdivinar.getNombrePokemon().charAt(i);
                    }
                }
                    
                else
                {
                    quitarVida = true;
                }
                
                /*Se reconstruye el nombre oculto a partir del array de char con las letras acertadas 
                (Si se ha acertado alguna, sino se queda tal cual)*/
                nomOculto += arrayCharNomOculto[i];
            }
                
            //Añado la letra a la lista de letras introducidas
            letrasIntroducidas.add(x);
    }
    
    public void quitarUnaPokeball()
    {
        pokeballs--;
    }
    
    
    /*Método para averiguar si la letra ya ha sido introducida con anterioridad*/
    public boolean letraYaIntroducida(char x)
    {
        boolean yaIntroducida = false;		

        for(int i = 0; i < letrasIntroducidas.size(); i++)
        {
            if(letrasIntroducidas.get(i) == x)
            {
                yaIntroducida = true;
            }
        }

        return yaIntroducida;
    }
    
    public void subirNivelPokemon(int pos)
    {
        if(listaPokemon.get(pos).getNivel() < 100)
        {
            listaPokemon.get(pos).setNivel(listaPokemon.get(pos).getNivel() + 1);
        }

        //JOptionPane.showMessageDialog(null, "Nivel de " + listaPokemon.get(p).getNombrePokemon() + ": " + String.valueOf(listaPokemon.get(p).getNivel()));
                
    }
    
    public void atraparPokemon(int pos)
    {
        listaPokemon.get(pos).setAtrapado(true);
    }
    
    public void atraparOSubirNivelPokemon()
    {        
        for(int p = 0; p < listaPokemon.size(); p++)
        {
            if(pokemonAAdivinar.getNombrePokemon().equals(listaPokemon.get(p).getNombrePokemon()))
            {
                if(!listaPokemon.get(p).getAtrapado())
                {
                    atraparPokemon(p);
                }

                else
                {
                    subirNivelPokemon(p);
                }
                
                establecerContadorPokemonAtrapados(p);
            }
        }
    }
    
    public boolean pokemonAtrapado()
    {            
        return pokemonAAdivinar.getNombrePokemon().toLowerCase().equals(nomOculto.toLowerCase());
    }
    
    public boolean esShiny()
    {
        boolean shiny = false;
        int numShiny = this.generarNumeroAleatorio() + 1; //Se le aumenta uno porque los valores aleatorios 
        //empiezan por 0 y los números en la pokédex empiezan por 1. De otra manera no podrían coincidir
        //correctamente.
        
        //JOptionPane.showMessageDialog(null, String.valueOf("numShiny: " + numShiny));
        //JOptionPane.showMessageDialog(null, String.valueOf("pokemonAAdivinar.getNumeroPokédex(): " + pokemonAAdivinar.getNumeroPokédex()));
        
        if(numShiny == pokemonAAdivinar.getNumeroPokédex())
        {
            shiny = true;            
            //JOptionPane.showMessageDialog(null, "Es shiny");
            
            establecerShiny();
        }
        
        return shiny;
    }
    
    public void establecerShiny()
    {                
        for(int p = 0; p < listaPokemon.size(); p++)
        {
            if(listaPokemon.get(p).getNombrePokemon().equals(nomOculto))
            {
                listaPokemon.get(p).setContadorShiny(listaPokemon.get(p).getContadorShiny() + 1);
                listaPokemon.get(p).setShiny(true);
                
                //JOptionPane.showMessageDialog(null, String.valueOf("listaPokemon.get(p).getShiny(): " + listaPokemon.get(p).getShiny()));
                //JOptionPane.showMessageDialog(null, String.valueOf("listaPokemon.get(p).getContadorShiny(): " + listaPokemon.get(p).getContadorShiny()));
            }
        }
    }
    
    public void establecerContadorPokemonVistos()
    {
        for(int p = 0; p < listaPokemon.size(); p++)
        {
            if(listaPokemon.get(p).getNombrePokemon().equals(pokemonAAdivinar.getNombrePokemon()))
            {
                listaPokemon.get(p).setContadorVistos(listaPokemon.get(p).getContadorVistos() + 1);
                
                //JOptionPane.showMessageDialog(null, listaPokemon.get(p).getNombrePokemon()+ " vistos: " + String.valueOf(listaPokemon.get(p).getContadorVistos()));
                
            }
        }
    }
    
    public void establecerContadorPokemonAtrapados(int pos)
    {
        listaPokemon.get(pos).setContadorAtrapados(listaPokemon.get(pos).getContadorAtrapados()+ 1);                
    }
    
    public Boolean partidaFinalizada()
    {
        return getPokeballs() < 1 || this.pokemonAtrapado();
    }
    
    public void mensajePartidaFinalizada(Frame frame, String titulo, String mensaje)
    {
        ImageIcon imgPoke = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"pokemon"+File.separator+pokemonAAdivinar.getNombrePokemon()+".png").getImage());
        JOptionPane.showMessageDialog(frame, mensaje, titulo, 0, imgPoke);
    }
    
    
    
    /*GETTERS AND SETTERS*/

    public Pokemon getPokemonAAdivinar() {
        return pokemonAAdivinar;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(int pokeballs) {
        this.pokeballs = pokeballs;
    }
    
    public void resetPokeballs()
    {
        this.setPokeballs(7);
    }

    public String getNomOculto() {
        return nomOculto;
    }

    public static void setListaPokemon(List<Pokemon> listaPokemon) {
        AtrapaAlPokemon.listaPokemon = listaPokemon;
    }

    public List<Character> getLetrasIntroducidas() {
        return letrasIntroducidas;
    }

    public void setLetrasIntroducidas(List<Character> letrasIntroducidas) {
        this.letrasIntroducidas = letrasIntroducidas;
    }
   
}
