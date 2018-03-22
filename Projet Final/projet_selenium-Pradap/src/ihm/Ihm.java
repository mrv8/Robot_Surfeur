package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import navigation.Navigation;


public abstract class Ihm extends JFrame implements MouseListener {

    public static void main(String[] args) /*throws InterruptedException*/ {
        
    	//interface
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Robot surfer");
        fenetre.setSize(600, 500);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        
        JPanel pan = new JPanel();
        JTextField keyWords = new JTextField ("Saisir les mots-clés"); //Champs de saisie des mots-clés
        JTextField url = new JTextField ("Saisir l'URL"); //Champs de saisi de l'url
        JRadioButton random = new JRadioButton("Random");
        JRadioButton score = new JRadioButton("score");

        ButtonGroup choice = new ButtonGroup();
        choice.add(score);
        choice.add(random);
        choice.setSelected(random.getModel(), true);
        choice.setSelected(random.getModel(), true);
        JButton bouton = new JButton("Valider");

        
        bouton.addActionListener(new ActionListener() {
            
        	@Override
            public void actionPerformed(ActionEvent e){

                String[] motsCles = keyWords.getText().split(" ");
                
                    if( random.isSelected() == true)
                    {
                        System.out.println("Random est selectionné");
                        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\FirefoxDrive\\geckodriver.exe");
                        Navigation Sc = new Navigation();
                        Sc.OpenPage(url.getText());
                        Sc.NavigationRandom();
                    }

                    else if (score.isSelected() == true )
                    {
                        System.out.println("Score est selectionné");
                        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\FirefoxDrive\\geckodriver.exe");
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
        fenetre.getContentPane().add(bouton);
        fenetre.setVisible(true);
    }
}
