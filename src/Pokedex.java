import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria
 */
public class Pokedex extends javax.swing.JFrame {

    private List<Pokemon> listaPokemon;
    //Para el ranking
    private List<Pokemon> listaPokemonMayorAMenor;    
    private int numPokemon;
    static public int numPokemonVistos;
    static public int numPokemonAtrapados;
    
    /**
     * Creates new form Pokedex
     */
    public Pokedex() {
        initComponents();
        
        //Cambiamos el icono del jframe
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src"+File.separator+"Images"+File.separator+"logo.png"));
        
        listaPokemon = AtrapaAlPokemon.listaPokemon;
        numPokemon = 0;
        numPokemonVistos = 0;
        numPokemonAtrapados = 0;
        
        
        jLabelNumPokemon.setText("0/" + listaPokemon.size());
        
        jLabelNomPokemon.setVisible(false);
        jLabelTipoPokemon.setVisible(false);
        jLabelInfoPokemon.setVisible(false);
        jLabelPokeVistos.setVisible(false);
        jLabelPokeAtrapados.setVisible(false);
        jLabelPokeShinyAtrapados.setVisible(false);
        
        listaPokemonMayorAMenor = new ArrayList<>();
        
        generarTablaPokemon(listaPokemon);
            
        //Se actualiza en el label el número de pokémon atrapados hasta el momento
        jLabelNumPokemon.setText(String.valueOf(numPokemon) + "/" + listaPokemon.size());
        
        //Se ordena la lista "listaPokemonMayorAMenor" para usarla en el ranking
        Collections.sort(listaPokemonMayorAMenor, new OrdenarPorNivel());
        
        generarRanking();     
    }
    
    public void generarRanking()
    {
        int initHeigh = 10;
        int initLeft = 10;
        int interHSpace = 48;
        
        for (int f = 0; f < listaPokemonMayorAMenor.size(); f++)
        {
            pokemonEnRanking(listaPokemonMayorAMenor.get(f).getNombrePokemon(), listaPokemonMayorAMenor.get(f).getNivel(), initHeigh, initLeft);
            initLeft = initLeft + 80 + interHSpace;
        }
    }
    
    public void pokemonEnRanking(String nomPoke, int nivelPoke, int initLeft, int initHeigh)
    {
        // panel para el ranking
        JPanel panel = new JPanel();
        panel.setSize(80, 80);
        panel.setBackground(new Color(255, 255, 153));
        panel.setLocation(initHeigh, initLeft);        
        panel.setVisible(true);
        //panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(null); //Se anula el layout del panel para que las posiciones de los elementos
                               //interiores (la imagen del pokemon y el nivel del mismo) sean absolutas
                               //y puedan ser colocadas exactamente donde se quiere.
                
        jPanelRanking.add(panel);
        
        //Label para el nivel del pokémon en el ranking
        JLabel labelNumPok = new JLabel(String.valueOf(nivelPoke));
        labelNumPok.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        labelNumPok.setHorizontalAlignment(JLabel.CENTER);
        //labelNumPok.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        labelNumPok.setBounds(0, 0, panel.getWidth(), 20);
        labelNumPok.setOpaque(true);
        labelNumPok.setBackground(new Color(255, 153, 0));
        labelNumPok.setVisible(true);
        
        //Label para la imagen del pokémon en el ranking
        JLabel labelImgPok = new JLabel();
        //labelImgPok.setBorder(BorderFactory.createLineBorder(Color.PINK));                                                                                  //Al parecer con "Image.SCALE_SMOOTH" 
                                                                                                                                                              //las imágenes no pierden tanta calidad 
        ImageIcon imgPok = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"pokemon"+File.separator+nomPoke+".png").getImage().getScaledInstance(52, 52, Image.SCALE_SMOOTH));    
       
        labelImgPok.setIcon(imgPok);
        //labelImgPok.setBounds(0, (panel.getHeight() - panel.getWidth() - 30), panel.getWidth(), panel.getWidth());
        labelImgPok.setSize(52, 52);
        //labelImgPok.setLocation(0, (panel.getHeight() - labelImgPok.getHeight() - 30));
        
        centrarLabel(panel.getWidth(), labelImgPok, labelImgPok.getWidth(), labelImgPok.getVerticalAlignment(), 25);
        
        panel.add(labelNumPok);
        panel.add(labelImgPok);
    }
            
    
    public void centrarLabel(int frameWidth, JLabel label, int labelWidth, int labelVerticalAlignment, int espExtraArriba)
    {
         //Para centrar el label en el frame
        int x = (frameWidth - labelWidth) / 2;
        label.setLocation(x, labelVerticalAlignment + espExtraArriba);
    }
    
    public void generarTablaPokemon(List<Pokemon> listaPok)
    {
        //Se crea la "tabla" de la lista de los pokémon
        int initHeigh = 20;
        int initLeft = 20;
        int interVSpace = 20;
        int interHSpace = 20;
        
        for (int f = 0; f < listaPok.size(); f++)
        {           
            agregarPanelPokemon(listaPok.get(f).getNombrePokemon(), String.valueOf(listaPok.get(f).getNumeroPokédexFormateado()), 
                    listaPok.get(f).getNivel(), initLeft, initHeigh, listaPok.get(f).getAtrapado(), 
                    listaPok.get(f).getTipo(), listaPok.get(f).getDescripcionPokemon(), listaPok.get(f).getShiny(),
                    listaPok.get(f).getContadorVistos(), listaPok.get(f).getContadorAtrapados(), listaPok.get(f).getContadorShiny());
            
            
            initLeft = initLeft + 130 + interHSpace;
            
            //Con esta fórmula conseguimos que las filas se formen a partir del elemento 5 de la lista,
            //De otro modo la lista queda deformada.
            //Esto es ideado por mí.
            if ((f-3)%4 == 0)
            {
                initLeft = 20;
                initHeigh = initHeigh + 190 + interVSpace;
            }
            
            //Si el pokémon ha sido atrapado se añade a la lsta para ordenarla posteriormente y usarla en el ranking.
            //Los pokémon atrapados se ordenan por nivel de mayor a menor.
            if(listaPok.get(f).getAtrapado())
            {
                //Se añade a la lista de pokémon ordenados por nivel los pokémon atrapados hasta el momento
                //Para visualizarlos más tarde en el ranking
                listaPokemonMayorAMenor.add(listaPok.get(f));
            }
            
            //Número de pokemon vistos en total
            numPokemonVistos = numPokemonVistos + listaPok.get(f).getContadorVistos();
            
            //Número de pokemon atrapados en total
            numPokemonAtrapados = numPokemonAtrapados + listaPok.get(f).getContadorAtrapados();
        }
        
        //Se establece el tamaño del "jPanelPokedex" para que funcione el scroll y todos los elementos
        //de la lista se muestren correctamente
        Dimension d = new Dimension(500, (initHeigh+190+10)); 
        //initHeigh será el que determine el largo del panel. 
        //Se le suma el height del elemento para que pueda ser mostrada la última fila
        jPanelPokedex.setPreferredSize(d);
        
        //FIN creación de la tabla
    }
    
    public void agregarPanelPokemon(String name, String numPokedex, int nivel, int initLeft, 
            int initHeigh, Boolean atrapado, String tipo, String desc, Boolean shiny, 
            int contVistos, int contAtrapados, int contShiny)
    {        
        // 1. Crea los objetos
        JPanel panel = new JPanel();  
        panel.setName("panel" + name);
        panel.setSize(130, 190);
        panel.setBackground(new Color(240, 240, 240));
        panel.setLocation(initLeft, initHeigh);
        //panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(null); //Se anula el layout del panel para que las posiciones de los elementos
                               //interiores (la imagen del pokemon y el nombre del mismo) sean absolutas
                               //y puedan ser colocadas exactamente donde se quiere.
                
        jPanelPokedex.add(panel);
        
        //Label para el número del pokémon en la pokédex
        JLabel labelNumPok = new JLabel("#" + numPokedex);
        labelNumPok.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        labelNumPok.setName("labelNumero" + name);
        labelNumPok.setHorizontalAlignment(JLabel.CENTER);
        //labelNomPok.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        labelNumPok.setBounds(0, 0, panel.getWidth(), 20);
        labelNumPok.setOpaque(true);
        labelNumPok.setBackground(new Color(0, 64, 255));
        labelNumPok.setVisible(true);
        
        
        //Label para el nombre del pokémon
        JLabel labelNomPok = new JLabel(name);
        labelNomPok.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
        labelNomPok.setName("labelNombre" + name);
        labelNomPok.setHorizontalAlignment(JLabel.CENTER);
        //labelNomPok.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        labelNomPok.setBounds(0, 20, panel.getWidth(), 20);
        labelNomPok.setOpaque(true);
        labelNomPok.setBackground(new Color(154, 46, 254));
        labelNomPok.setVisible(false);
                
        
        //Label para la imagen del pokémon
        JLabel labelImgPok = new JLabel();
        //labelImgPok.setBorder(BorderFactory.createLineBorder(Color.PINK));
        ImageIcon imgPok = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"pokemon"+File.separator+name+".png").getImage());        
        labelImgPok.setIcon(imgPok);
        //labelImgPok.setBounds(0, (panel.getHeight() - panel.getWidth() - 30), panel.getWidth(), panel.getWidth());
        labelImgPok.setSize(100, 100);
        //labelImgPok.setLocation(0, (panel.getHeight() - labelImgPok.getHeight() - 30));
        
        centrarLabel(panel.getWidth(), labelImgPok, labelImgPok.getWidth(), labelImgPok.getVerticalAlignment(), 60);
        
        labelImgPok.setEnabled(false);
        labelImgPok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelImgPok.setToolTipText("Clic aquí para ver los detalles de este pokémon.");
        
        
        //Label para el icono "Shiny"
        JLabel labelShinyIcon = new JLabel();
        //labelShinyIcon.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        ImageIcon imgShinyIcon = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"shiny_icon_activado.png").getImage());        
        labelShinyIcon.setIcon(imgShinyIcon);
        labelShinyIcon.setBounds(0, 40, 20, 20);
        labelShinyIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelShinyIcon.setVisible(false);
        labelShinyIcon.setToolTipText("Clic aquí para ver el aspecto shiny de este pokémon.");
        
        
        //Label para el nivel del pokémon
        JLabel labelNivelPok = new JLabel("Nivel: " + String.valueOf(nivel));
        labelNivelPok.setName("labelNivel" + name);
        labelNivelPok.setFont(new Font("Tahoma", Font.BOLD, 10));
        labelNivelPok.setHorizontalAlignment(JLabel.CENTER);
        //labelNivelPok.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        labelNivelPok.setBounds(0, (panel.getHeight() - 20), panel.getWidth(), 20);        
        labelNivelPok.setVisible(false);
        labelNivelPok.setOpaque(true);
        labelNivelPok.setBackground(new Color(64, 255, 0));
        
        //Se agregan los componentes al panel
        panel.add(labelNumPok);
        panel.add(labelNomPok);
        panel.add(labelShinyIcon);
        panel.add(labelImgPok);
        panel.add(labelNivelPok);
        
        if(atrapado)
        {
            //Número de pokémon descubiertos hasta el momento
            numPokemon++;
            
            //Se visualizan los datos del pokémon en la pokédex al hacer click en la imagen correspondiente al mismo
            labelNomPok.setVisible(true);
            labelImgPok.setEnabled(true);
            labelNivelPok.setVisible(true);
            
            labelImgPok.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    labelImgPokPokemonMouseClicked(evt, name, tipo, desc, contVistos, contAtrapados, contShiny);
                }
            });
        }
        
        if(shiny)
        {
            labelShinyIcon.setVisible(true);
            
            labelShinyIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    labelShinyIconMouseClicked(evt, name, labelImgPok, labelShinyIcon);
                }
            });
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPokedexGeneral = new javax.swing.JPanel();
        jLabelNumPokemon = new javax.swing.JLabel();
        jScrollPanePokedex = new javax.swing.JScrollPane();
        jPanelPokedex = new javax.swing.JPanel();
        jPanelContenidoPokemon = new javax.swing.JPanel();
        jLabelNomPokemon = new javax.swing.JLabel();
        jLabelTipoPokemon = new javax.swing.JLabel();
        jLabelInfoPokemon = new javax.swing.JLabel();
        jLabelPokeVistos = new javax.swing.JLabel();
        jLabelPokeShinyAtrapados = new javax.swing.JLabel();
        jLabelPokeAtrapados = new javax.swing.JLabel();
        jPanelRanking = new javax.swing.JPanel();
        jLabelTituloRanking = new javax.swing.JLabel();
        jButtonEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("POKÉDEX");
        setName("framePokedex"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 669));
        setResizable(false);
        setSize(new java.awt.Dimension(894, 639));
        getContentPane().setLayout(null);

        jPanelPokedexGeneral.setBackground(new java.awt.Color(204, 0, 0));
        jPanelPokedexGeneral.setLayout(null);

        jLabelNumPokemon.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        jLabelNumPokemon.setForeground(new java.awt.Color(204, 204, 255));
        jLabelNumPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumPokemon.setText("0/151");
        jPanelPokedexGeneral.add(jLabelNumPokemon);
        jLabelNumPokemon.setBounds(-50, 142, 192, 40);

        jScrollPanePokedex.setBackground(new java.awt.Color(204, 0, 0));
        jScrollPanePokedex.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPanePokedex.setPreferredSize(new java.awt.Dimension(650, 450));

        jPanelPokedex.setBackground(new java.awt.Color(204, 0, 0));
        jPanelPokedex.setPreferredSize(new java.awt.Dimension(648, 448));

        javax.swing.GroupLayout jPanelPokedexLayout = new javax.swing.GroupLayout(jPanelPokedex);
        jPanelPokedex.setLayout(jPanelPokedexLayout);
        jPanelPokedexLayout.setHorizontalGroup(
            jPanelPokedexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        jPanelPokedexLayout.setVerticalGroup(
            jPanelPokedexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jScrollPanePokedex.setViewportView(jPanelPokedex);

        jPanelPokedexGeneral.add(jScrollPanePokedex);
        jScrollPanePokedex.setBounds(0, 180, 650, 450);

        jPanelContenidoPokemon.setBackground(new java.awt.Color(153, 0, 0));
        jPanelContenidoPokemon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanelContenidoPokemon.setPreferredSize(new java.awt.Dimension(250, 450));

        jLabelNomPokemon.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabelNomPokemon.setForeground(new java.awt.Color(255, 102, 51));
        jLabelNomPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomPokemon.setText("NOMBRE");

        jLabelTipoPokemon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTipoPokemon.setForeground(new java.awt.Color(0, 204, 153));
        jLabelTipoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipoPokemon.setText("Tipo");
        jLabelTipoPokemon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelInfoPokemon.setBackground(new java.awt.Color(204, 204, 255));
        jLabelInfoPokemon.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jLabelInfoPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoPokemon.setText("Descripción");
        jLabelInfoPokemon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jLabelInfoPokemon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelInfoPokemon.setOpaque(true);

        jLabelPokeVistos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPokeVistos.setForeground(new java.awt.Color(255, 204, 0));
        jLabelPokeVistos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPokeVistos.setText("Vistos:");

        jLabelPokeShinyAtrapados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPokeShinyAtrapados.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPokeShinyAtrapados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPokeShinyAtrapados.setText("Shiny:");
        jLabelPokeShinyAtrapados.setToolTipText("Número de veces atrapado este pokémon shiny");

        jLabelPokeAtrapados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPokeAtrapados.setForeground(new java.awt.Color(51, 204, 0));
        jLabelPokeAtrapados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPokeAtrapados.setText("Atrapados:");

        javax.swing.GroupLayout jPanelContenidoPokemonLayout = new javax.swing.GroupLayout(jPanelContenidoPokemon);
        jPanelContenidoPokemon.setLayout(jPanelContenidoPokemonLayout);
        jPanelContenidoPokemonLayout.setHorizontalGroup(
            jPanelContenidoPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoPokemonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContenidoPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelPokeVistos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomPokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabelTipoPokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabelPokeShinyAtrapados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoPokemonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInfoPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelContenidoPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoPokemonLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelPokeAtrapados, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelContenidoPokemonLayout.setVerticalGroup(
            jPanelContenidoPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoPokemonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNomPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipoPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelInfoPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPokeVistos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabelPokeShinyAtrapados, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanelContenidoPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoPokemonLayout.createSequentialGroup()
                    .addContainerGap(357, Short.MAX_VALUE)
                    .addComponent(jLabelPokeAtrapados, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63)))
        );

        jPanelPokedexGeneral.add(jPanelContenidoPokemon);
        jPanelContenidoPokemon.setBounds(660, 180, 220, 450);

        jPanelRanking.setBackground(new java.awt.Color(153, 0, 0));
        jPanelRanking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanelRanking.setLayout(null);
        jPanelPokedexGeneral.add(jPanelRanking);
        jPanelRanking.setBounds(10, 39, 870, 100);

        jLabelTituloRanking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTituloRanking.setForeground(new java.awt.Color(255, 153, 0));
        jLabelTituloRanking.setText("Ranking");
        jPanelPokedexGeneral.add(jLabelTituloRanking);
        jLabelTituloRanking.setBounds(10, 10, 60, 30);

        jButtonEstadisticas.setText("Estadísticas");
        jButtonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadisticasActionPerformed(evt);
            }
        });
        jPanelPokedexGeneral.add(jButtonEstadisticas);
        jButtonEstadisticas.setBounds(760, 150, 110, 23);

        getContentPane().add(jPanelPokedexGeneral);
        jPanelPokedexGeneral.setBounds(0, 0, 900, 640);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadisticasActionPerformed
    
        int porcentajeCaptura = 0;
        
        if(numPokemonVistos > 0)
        {
            porcentajeCaptura = (numPokemonAtrapados*100)/numPokemonVistos;
        }
        
        String s = "Pokémon vistos: " + numPokemonVistos + 
                "\nPokémon atrapados: " + numPokemonAtrapados +
                "\nPorcentaje de captura: " + porcentajeCaptura + "%";
        
        JOptionPane.showMessageDialog(this, s, "ESTADÍSTICAS", JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_jButtonEstadisticasActionPerformed

    private Boolean aspectoShiny = false;
    
    private void labelShinyIconMouseClicked(java.awt.event.MouseEvent evt, String nomPoke, JLabel label, JLabel icono)
    {
        ImageIcon imgIconShiny = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"shiny_icon_activado.png").getImage());
        
        ImageIcon imgPok = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"pokemon"+File.separator+nomPoke+".png").getImage());
        
        if(!aspectoShiny)
        {       
            imgPok = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"shiny"+File.separator+nomPoke+"Shiny.png").getImage());        
            imgIconShiny = new ImageIcon(new ImageIcon("src"+File.separator+"Images"+File.separator+"shiny_icon.png").getImage());
            
            icono.setToolTipText("Clic aquí para ver el aspecto normal de este pokémon.");
                        
            aspectoShiny = true;
        }
        
        else
        {
            icono.setToolTipText("Clic aquí para ver el aspecto shiny de este pokémon.");
            
            aspectoShiny = false;
        }
        
        icono.setIcon(imgIconShiny);
        label.setIcon(imgPok);
    }
    
    private void labelImgPokPokemonMouseClicked(java.awt.event.MouseEvent evt, String nomPoke, String tipoPoke, String descPoke, int contVistos, int contAtrapados, int contShiny)
    {        
        jLabelNomPokemon.setVisible(true);
        jLabelTipoPokemon.setVisible(true);
        jLabelInfoPokemon.setVisible(true);
        jLabelPokeVistos.setVisible(true);        
        jLabelPokeAtrapados.setVisible(true);
        jLabelPokeShinyAtrapados.setVisible(true);
        
        jLabelNomPokemon.setText(nomPoke);
        jLabelTipoPokemon.setText(tipoPoke);
        jLabelInfoPokemon.setText("<html><center>" + descPoke + "</center></html>");
        jLabelPokeVistos.setText("Vistos: " + String.valueOf(contVistos));
        jLabelPokeAtrapados.setText("Atrapados: " + String.valueOf(contAtrapados));
        jLabelPokeShinyAtrapados.setText("Shiny: " + String.valueOf(contShiny));
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEstadisticas;
    private javax.swing.JLabel jLabelInfoPokemon;
    private javax.swing.JLabel jLabelNomPokemon;
    private javax.swing.JLabel jLabelNumPokemon;
    private javax.swing.JLabel jLabelPokeAtrapados;
    private javax.swing.JLabel jLabelPokeShinyAtrapados;
    private javax.swing.JLabel jLabelPokeVistos;
    private javax.swing.JLabel jLabelTipoPokemon;
    private javax.swing.JLabel jLabelTituloRanking;
    private javax.swing.JPanel jPanelContenidoPokemon;
    public javax.swing.JPanel jPanelPokedex;
    private javax.swing.JPanel jPanelPokedexGeneral;
    private javax.swing.JPanel jPanelRanking;
    public javax.swing.JScrollPane jScrollPanePokedex;
    // End of variables declaration//GEN-END:variables
}
