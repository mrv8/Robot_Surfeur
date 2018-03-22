package ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import navigation.Navigation;

/**
 * 
 * @author valen
 *
 */
public abstract class Graphique extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Méthode principale du programme, celle-ci génére une interface homme-machine.
	 * @param args
	 */
	public static void main(String[] args) /*throws InterruptedException*/ {
        //interface
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Robot surfeur :p");
        fenetre.setSize(600, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        //JPanel pan = new JPanel();
        JTextField keyWords = new JTextField ("Final Fantasy Sephiroth");
        JTextField url = new JTextField ("https://fr.wikipedia.org/wiki/Square_(entreprise)");
        JRadioButton random = new JRadioButton("Random");
        JRadioButton score = new JRadioButton("score");
       // JRadioButton moteur = new JRadioButton("Moteur de recherche");

       ButtonGroup choice = new ButtonGroup();
        choice.add(score);
        choice.add(random);
       // choice.add(moteur);
        choice.setSelected(random.getModel(), true);
        choice.setSelected(random.getModel(), true);
       // choice.setSelected(moteur.getModel(), true);
        JButton bouton = new JButton("Valider");




        bouton.addActionListener(new ActionListener() {
        	
        	/**
        	 * 
        	 */
            @Override
            public void actionPerformed(ActionEvent e){

                String[] motsCles = keyWords.getText().split(" ");
                
                    if( random.isSelected() == true)
                    {
                        System.out.println("Random est selectionné");
                        System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
                        Navigation Sc = new Navigation();
                        Sc.OpenPage(url.getText());
                        Sc.NavigationRandom();
                    }

                    else if (score.isSelected() == true )
                    {
                        System.out.println("Score est selectionné");
                        System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
                        Navigation Sc = new Navigation();
                        
                        System.out.println(motsCles.length);
                        for (String unMotClef:motsCles) {
                            System.out.println(unMotClef);
                        }
                        Sc.OpenPage(url.getText());
                        Sc.NavigationScore(motsCles);
                    }



            }
        });
        GridLayout gl = new GridLayout(6,3);
        gl.setHgap(50); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        gl.setVgap(50); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        fenetre.setLayout(gl);
        fenetre.getContentPane().add(keyWords);
        fenetre.getContentPane().add(url);
        fenetre.getContentPane().add(random);
        fenetre.getContentPane().add(score);
       // fenetre.getContentPane().add(moteur);
        fenetre.getContentPane().add(bouton);
        fenetre.setVisible(true);
    }
}
