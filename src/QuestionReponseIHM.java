import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.net.URL;


public class QuestionReponseIHM extends JFrame implements ActionListener,Serializable {
    String[] questions = { 
    		"Quel est le nom du groupe avec les membres suivants: John Deacon, Brian May, Freddie Mercury, Roger Taylor?", 
    		"En quelle année le Parrain(The god father) a-t-il été publié pour la première fois?",
    		"Quel pays a remporté la Coupe du monde de 1982 en Espagne en battant l'Allemagne de l'Ouest 3-1?",
    		"Quel degré de température est le plus froid",
    		"La fin de la Première Guerre mondiale" ,
    		"Quel était le deuxième prénom de Michael Jackson", 
    		"De quelle nationalité était l'artiste Pablo Ruiz Picasso",
    		"Quelle est la capitale du colombie",
    		"La naissance de Bouddha",
    		"La plus ancienne université du monde",
    		"Qui a marqué le but de la victoire lors de la finale de la coupe du monde 2010",
    		"Fondation de la Chine communiste",
    		};
    String[][] choix= {{"Queen","Guardians","The Monsters","The Beatles"},
    		           {"1986","1962","1979","1972"},
    		           {"Italie","Brazil","France","Espagne"},
    		           {"-200 °C","0 °F","0 K","0 °R"},
    		           {"1929","1914","1918","1944"},
    		           {"Joseph","Jhon","James","Cesar"},
    		           {"Américaine","Française","Italienne","Espagnol"},
    		           {"Barranquilla","Cali","Medellín","Bogota"},
    		           {"1256 BC","486 BC","265 JC","50 JC"},
    		           {"Salamanca","Oxford"," Karueein","Bologna"},
    		           {"Robben","Iniesta","Villa","Messi"},
    		           {"1949","1938","1953","1963"},
    		           };
    char[] reponses= {'A','D','A','C','C','A','D','D','B','C','B','A'};
    char devine;
    char reponse;
    int indice;
    int devines_correctes=0;
    int nbr_questions=questions.length;
    int temps=20;
    int resultat ;
    JFrame f =new JFrame();
    final ImageIcon icon = new ImageIcon("src/blue.gif");
    Image img = icon.getImage();
    JTextField Tfield = new JTextField();
    JTextArea Tarea = new JTextArea();
    JButton A = new JButton();
    JButton B = new JButton();
    JButton C = new JButton();
    JButton D = new JButton();
    JButton aide= new JButton();
    JLabel temps_label= new JLabel();
    JLabel joueur = new JLabel();
    JLabel secondes_restantes= new JLabel();
    JTextField nbr_cor = new JTextField();
    JTextField Score = new JTextField();
    
    JTextField Tfield1 = new JTextField();
    JTextArea Tarea1 = new JTextArea();
    JButton aide1= new JButton();
    JLabel temps_label1= new JLabel();
    JLabel secondes_restantes1= new JLabel();
    JTextField nbr_cor1 = new JTextField();
    JTextField Score1 = new JTextField();
    JPanel p = new JPanel(){                                                           
        Image img = icon.getImage();                                                 
   
        {setOpaque(false);}
        public void paintComponent(Graphics graphics)
        {
            graphics.drawImage(img, 0, 0, this);
            super.paintComponent(graphics);
        }};
        AudioClip sound;

    Timer secoule = new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		temps--;
		secondes_restantes.setText(String.valueOf(temps));
		if(temps<=0) {
			
			afficherlesreponses();
		}
		}
	         
	});
	public QuestionReponseIHM() {
		
		URL monfichier = this.getClass().getResource("son.wav");
        sound = Applet.newAudioClip(monfichier);
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,550);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color( 0, 0, 139));
		this.setLayout(null);

		Tfield.setBounds(0, 50, 750,100);
		Tfield.setBackground(new Color(25,25,25));
		Tfield.setForeground(new Color(255,255,255));
		Tfield.setFont(new Font("Serif", Font.ROMAN_BASELINE, 35));
		Tfield.setHorizontalAlignment(JTextField.CENTER);
		Tfield.setBorder(BorderFactory.createBevelBorder(1));
		Tfield.setText("Questions Barre");
		Tfield.setEditable(false);
		
		Tarea.setBounds(0, 150, 750,75);
		Tarea.setLineWrap(true);
		Tarea.setWrapStyleWord(true);
		Tarea.setBackground(new Color(25,2,25));
		Tarea.setForeground(new Color(255,255,255));
		Tarea.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 20));
		Tarea.setBorder(BorderFactory.createBevelBorder(1));
		Tarea.setText("Example Questions Barre");
		Tarea.setEditable(false);
		
		A.setBounds(50, 25, 250,100);
		A.setFont(new Font("MV BOLI", Font.BOLD, 27));
		A.setFocusable(false);
		A.addActionListener(this);
		A.setBackground(new Color(200, 200, 200) );
		
		B.setBounds(425, 25, 250,100);
		B.setFont(new Font("MV BOLI", Font.BOLD, 27));
		B.setFocusable(false);
		B.addActionListener(this);
		B.setBackground(new Color(200, 200, 200) );

		C.setBounds(50, 150, 250,100);
		C.setFont(new Font("MV BOLI", Font.BOLD, 27));
		C.setFocusable(false);
		C.addActionListener(this);
		C.setBackground(new Color(200, 200, 200) );

		D.setBounds(425, 150, 250,100);
		D.setFont(new Font("MV BOLI", Font.BOLD, 27));
		D.setFocusable(false);
		D.addActionListener(this);
		D.setBackground(new Color(200, 200, 200) );
		
		aide.setBounds(0, 0,120 ,50);
		aide.setBackground(new Color(50,200,50));
		aide.setForeground(new Color(20,0,0));
		aide.setFont(new Font("MV BOLI", Font.BOLD, 27));
		aide.addActionListener(new Action());
		aide.setText("aide");
		
		joueur.setBounds(300, 0,150 ,50);
		joueur.setForeground(new Color(100,255,0));
		joueur.setFont(new Font("MV BOLI", Font.ITALIC, 33));
		joueur.setText("Joueur 1");
		
		secondes_restantes.setBounds(640, 0,100 ,50);
		secondes_restantes.setBackground(new Color(200,200,200));
		secondes_restantes.setForeground(new Color(255,0,0));
		secondes_restantes.setFont(new Font("MV BOLI", Font.BOLD, 50));
		secondes_restantes.setHorizontalAlignment(JTextField.CENTER);
		secondes_restantes.setBorder(BorderFactory.createBevelBorder(1));
		secondes_restantes.setOpaque(true);
		secondes_restantes.setText(String.valueOf(temps));
        
		temps_label.setBounds(520, 0,100 ,50);
		temps_label.setBackground(new Color(200,200,200));
		temps_label.setForeground(new Color(255,0,0));
		temps_label.setFont(new Font("MV BOLI", Font.BOLD, 20));
		temps_label.setHorizontalAlignment(JTextField.CENTER);
		temps_label.setText("Minuteur:");
		
		nbr_cor.setBounds(275,25,200,100);
		nbr_cor.setBackground(new Color(25,25,25));
		nbr_cor.setForeground(new Color(25,255,0));
		nbr_cor.setFont(new Font("Ink Free",Font.BOLD,50));
		nbr_cor.setBorder(BorderFactory.createBevelBorder(1));
		nbr_cor.setHorizontalAlignment(JTextField.CENTER);
		nbr_cor.setEditable(false);
		
		Score.setBounds(275, 125, 200,100);
		Score.setBackground(new Color(25,25,25));
		Score.setForeground(new Color(25,255,0));
		Score.setFont(new Font("Ink Free", Font.BOLD, 50));
		Score.setHorizontalAlignment(JTextField.CENTER);
		Score.setBorder(BorderFactory.createBevelBorder(1));
		Score.setEditable(false);
		
		
            p.setBounds(0, 225, 750,300);
			p.setForeground(new Color(255,255,255));

		p.setLayout(null);

		this.add(temps_label);
        this.add(secondes_restantes);
		this.add(Tfield);
		this.add(Tarea);
		p.add(A);
		p.add(B);
		p.add(C);
		p.add(D);
		
		
		this.add(aide);
		this.add(joueur);

	
		this.add(p);
		this.setVisible(true);
		getContentPane();
		
	    prochainquestion();
	    
	}
	public void prochainquestion() {
		if(indice>=nbr_questions) {
			resultas();
		}
		else {
			Tfield.setText("Question "+(indice+1));
			Tarea.setText(questions[indice]);
			A.setText(choix[indice][0]);
			B.setText(choix[indice][1]);
			C.setText(choix[indice][2]);
			D.setText(choix[indice][3]);
			secoule.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
        if(e.getSource()==A) {
        	reponse='A';
        	if(reponse==reponses[indice]) {
        		sound.play();
        		devines_correctes++;
        		
        	}
        }
       
        
        if(e.getSource()==B) {
        	reponse='B';
        	if(reponse==reponses[indice]) {
        		devines_correctes++;
        		sound.play();

        	}
        }
        if(e.getSource()==C) {
        	reponse='C';
        	if(reponse==reponses[indice]) {      		
        		devines_correctes++;
        		sound.play();

        	}
        }
        if(e.getSource()==D) {
        	reponse='D';
        	if(reponse==reponses[indice]) {
        		devines_correctes++;
        		sound.play();

        	}
        }
        afficherlesreponses();
	}
	public void afficherlesreponses() {
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		if(reponses[indice]=='B'||reponses[indice]=='C'||reponses[indice]=='D') {
			A.setBackground(new Color(255,0,0));
	           sound.play();

		}
		if(reponses[indice]=='A'||reponses[indice]=='C'||reponses[indice]=='D') {
			B.setBackground(new Color(255,0,0));
	           sound.play();

		}
		if(reponses[indice]=='A'||reponses[indice]=='B'||reponses[indice]=='D') {
			C.setBackground(new Color(255,0,0));
	           sound.play();

		}
		if(reponses[indice]=='A'||reponses[indice]=='C'||reponses[indice]=='B') {
			D.setBackground(new Color(255,0,0));
	           sound.play();

		}
			 if(reponses[indice]=='A') {
					A.setBackground(new Color(0,255,0));
			    }
			    if(reponses[indice]=='B') {
					B.setBackground(new Color(0,255,0));
			    }
			    if(reponses[indice]=='C') {
					C.setBackground(new Color(0,255,0));
			    }
			    if(reponses[indice]=='D') {
					D.setBackground(new Color(0,255,0));
			    }
		secoule.stop();
		Timer timer = new Timer(1500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				A.setBackground(new Color(200,200,200));
				B.setBackground(new Color(200,200,200));
				C.setBackground(new Color(200,200,200));
				D.setBackground(new Color(200,200,200));
				reponse=' ';
				temps=20;
				secondes_restantes.setText(String.valueOf(temps));
				A.setEnabled(true);
				B.setEnabled(true);
				C.setEnabled(true);
				D.setEnabled(true);
				indice++;
				prochainquestion();
			}
		         
		});
		timer.setRepeats(false);
		timer.start();
	}

	public void resultas() {
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		 resultat = (int)((devines_correctes/(double)nbr_questions)*100);
		 Tfield.setText("RESULTAS");
		 Tarea.setText("");
		 A.setVisible(false);
		 B.setVisible(false);
		 C.setVisible(false);
		 D.setVisible(false);
		 
		 nbr_cor.setText(devines_correctes+"/"+nbr_questions);
		 Score.setText(resultat+"%");
		 aide.setEnabled(false);
		 p.add(nbr_cor);
	     p.add(Score);
	}
	public class Action implements ActionListener {
	    public void actionPerformed(ActionEvent ev) {
	    	aide.setEnabled(false);
	    	if(reponses[indice]=='A') {
	    		B.setEnabled(false);
	    		C.setEnabled(false);
	    		B.setBackground(new Color(50,50,50));
	    		C.setBackground(new Color(50,50,50));
		    }
		    if(reponses[indice]=='B') {
		    	A.setEnabled(false);
	    		C.setEnabled(false);
	    		A.setBackground(new Color(50,50,50));
	    		C.setBackground(new Color(50,50,50));
		    }
		    if(reponses[indice]=='C') {
		    	D.setEnabled(false);
	    		A.setEnabled(false);
	    		D.setBackground(new Color(50,50,50));
	    		A.setBackground(new Color(50,50,50));
		    }
		    if(reponses[indice]=='D') {
		    	B.setEnabled(false);
	    		C.setEnabled(false);
	    		B.setBackground(new Color(50,50,50));
	    		C.setBackground(new Color(50,50,50));
		    }
	    }
	}

}
