package wordle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Wordle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wordle frame = new Wordle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JButton tlBotones[] = new JButton['Z' - 'A' + 1];
	JButton btnLetras[][] = new JButton[6 /* intentos */][5 /* letras */];
	ArrayList<String> listaPalabras = new ArrayList<String>();
	String palabraSeleccionada = "";
	String palabraEscrita = "";
	int columnaID = 0;
	
	public boolean leerPalabrasDeArchivo() {
		try {
			File fl = new File("palabras.txt");
			Scanner scan = new Scanner(fl);
			while (scan.hasNextLine()) {
				String p = scan.nextLine().toUpperCase();
				boolean saltar = false;
				for(char c : p.toCharArray()) {
					/* saltamos letras fuera del rango A-Z, ejemplo: Ñ o tildes Á, É, Í, Ó, Ú */
					if (c < 'A' || c > 'Z') {
						saltar = true;
						break;
					}
				}
				
				if (saltar) continue;
				
				listaPalabras.add(p);
			}

			scan.close();
			
			return listaPalabras.size() != 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean comprobarPalabra(String palabra) {
		for(String p : listaPalabras) {
			if (p.equals(palabra)) return true;
		}
		return false;
	}
	
	public void resetearJuego() {
		/* leemos la palabra desde el archivo 'palabras.txt' */
		if (leerPalabrasDeArchivo() == false) {
			System.out.println("Error");
		}
		
		/* randomizamos la palabra */
		palabraSeleccionada = listaPalabras.get((int)(Math.random() * listaPalabras.size()));
		
		System.out.println("Palabra seleccionada: " + palabraSeleccionada);
		
		/* reseteamos el texto por si volvemos a jugar */
		for(int x = 0; x < btnLetras.length; x++) {
			for(int y = 0; y < btnLetras[x].length; y++) {
				if (btnLetras[x][y] == null) continue;

				btnLetras[x][y].setText("");
			}
		}
	}
	
	public void meterLetra(String text) {
		if (palabraEscrita.length() == 5) return;

		/* ponemos la letra pulsada */
		JButton btn = btnLetras[columnaID][palabraEscrita.length()];
		btn.setText(text);

		/* concatenamos la letra */
		palabraEscrita = palabraEscrita.concat(text);
	}
	
	/**
	 * Create the frame.
	 */
	public Wordle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JButton btnQ = new JButton("Q");
		btnQ.setBounds(51, 400, 47, 29);
		contentPane.add(btnQ);
		
		tlBotones['Q' - 'A'] = btnQ;
		
		JButton btnW = new JButton("W");
		btnW.setBounds(108, 400, 47, 29);
		contentPane.add(btnW);
		
		tlBotones['W' - 'A'] = btnW;
		
		JButton btnE = new JButton("E");
		btnE.setBounds(165, 400, 47, 29);
		contentPane.add(btnE);
		
		tlBotones['E' - 'A'] = btnE;
		
		JButton btnR = new JButton("R");
		btnR.setBounds(216, 400, 47, 29);
		contentPane.add(btnR);
		
		tlBotones['R' - 'A'] = btnR;
		
		JButton btnT = new JButton("T");
		btnT.setBounds(267, 400, 47, 29);
		contentPane.add(btnT);
		
		tlBotones['T' - 'A'] = btnT;
		
		JButton btnY = new JButton("Y");
		btnY.setBounds(324, 400, 47, 29);
		contentPane.add(btnY);
		
		tlBotones['Y' - 'A'] = btnY;
		
		JButton btnU = new JButton("U");
		btnU.setBounds(381, 400, 47, 29);
		contentPane.add(btnU);
		
		tlBotones['U' - 'A'] = btnU;
		
		JButton btnI = new JButton("I");
		btnI.setBounds(438, 400, 47, 29);
		contentPane.add(btnI);
		
		tlBotones['I' - 'A'] = btnI;
		
		JButton btnO = new JButton("O");
		btnO.setBounds(495, 400, 47, 29);
		contentPane.add(btnO);
		
		tlBotones['O' - 'A'] = btnO;
		
		JButton btnP = new JButton("P");
		btnP.setBounds(552, 400, 47, 29);
		contentPane.add(btnP);
		
		tlBotones['P' - 'A'] = btnP;
		
		JButton btnA = new JButton("A");
		btnA.setBounds(51, 439, 47, 29);
		contentPane.add(btnA);
		
		tlBotones['A' - 'A'] = btnA;
		
		JButton btnS = new JButton("S");
		btnS.setBounds(108, 440, 47, 29);
		contentPane.add(btnS);
		
		tlBotones['S' - 'A'] = btnS;
		
		JButton btnD = new JButton("D");
		btnD.setBounds(165, 440, 47, 29);
		contentPane.add(btnD);
		
		tlBotones['D' - 'A'] = btnD;
		
		JButton btnF = new JButton("F");
		btnF.setBounds(216, 440, 47, 29);
		contentPane.add(btnF);
		
		tlBotones['F' - 'A'] = btnF;
		
		JButton btnG = new JButton("G");
		btnG.setBounds(267, 440, 47, 29);
		contentPane.add(btnG);
		
		tlBotones['G' - 'A'] = btnG;
		
		JButton btnH = new JButton("H");
		btnH.setBounds(324, 439, 47, 29);
		contentPane.add(btnH);
		
		tlBotones['H' - 'A'] = btnH;
		
		JButton btnJ = new JButton("J");
		btnJ.setBounds(381, 439, 47, 29);
		contentPane.add(btnJ);
		
		tlBotones['J' - 'A'] = btnJ;
		
		JButton btnK = new JButton("K");
		btnK.setBounds(438, 440, 47, 29);
		contentPane.add(btnK);
		
		tlBotones['K' - 'A'] = btnK;
		
		JButton btnL = new JButton("L");
		btnL.setBounds(495, 439, 47, 29);
		contentPane.add(btnL);
		
		tlBotones['L' - 'A'] = btnL;
		
		JButton btnZ = new JButton("Z");
		btnZ.setBounds(165, 481, 47, 29);
		contentPane.add(btnZ);
		
		tlBotones['Z' - 'A'] = btnZ;
		
		JButton btnX = new JButton("X");
		btnX.setBounds(216, 481, 47, 29);
		contentPane.add(btnX);
		
		tlBotones['X' - 'A'] = btnX;
		
		JButton btnC = new JButton("C");
		btnC.setBounds(267, 480, 47, 29);
		contentPane.add(btnC);
		
		tlBotones['C' - 'A'] = btnC;
		
		JButton btnV = new JButton("V");
		btnV.setBounds(324, 480, 47, 29);
		contentPane.add(btnV);
		
		tlBotones['V' - 'A'] = btnV;
		
		JButton btnB = new JButton("B");
		btnB.setBounds(381, 480, 47, 29);
		contentPane.add(btnB);
		
		tlBotones['B' - 'A'] = btnB;
		
		JButton btnN = new JButton("N");
		btnN.setBounds(438, 481, 47, 29);
		contentPane.add(btnN);
		
		tlBotones['N' - 'A'] = btnN;
		
		JButton btnM = new JButton("M");
		btnM.setBounds(495, 480, 47, 29);
		contentPane.add(btnM);
		
		tlBotones['M' - 'A'] = btnM;
		
		/* listener común para cada botón de letras */
		ActionListener commonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meterLetra(((JButton) e.getSource()).getText());
			}
		};
		
		/* metemos el listener comun para todas las teclas */
		for(JButton button : tlBotones) {
			if (button == null) continue;
			
			button.addActionListener(commonListener);
		}
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarPalabra(palabraEscrita)) {
					JOptionPane.showMessageDialog(contentPane, "LA PALABRA NO EXISTE EN EL DICCIONARIO", "Wordle", JOptionPane.ERROR_MESSAGE);
					
					return;
				}
				
				if (palabraEscrita.equals(palabraSeleccionada)) {
					JOptionPane.showMessageDialog(contentPane, "CORRECTO");
					
					/* se acaba el juego */
					
					return;
				}
				
				/* ponemos el color de los botones al mismo de las letras de la cuadrícula */
				for(int i = 0; i < palabraEscrita.length(); i++) {
					JButton btnTeclado = tlBotones[palabraEscrita.charAt(i) - 'A'],
							btnLetra = btnLetras[columnaID][i];
					
					btnTeclado.setBackground(Color.gray);
					btnLetra.setBackground(Color.gray);
					
					int buscarPos = palabraSeleccionada.indexOf(palabraEscrita.charAt(i));
					if (buscarPos != i && buscarPos >= 0) {
						btnTeclado.setBackground(Color.yellow);
						btnLetra.setBackground(Color.yellow);
					}

					if (palabraSeleccionada.charAt(i) == palabraEscrita.charAt(i)) {
						btnTeclado.setBackground(Color.green);
						btnLetra.setBackground(Color.green);
					}
				}
				
				/* reseteamos la palabra escrita por intento */
				palabraEscrita = "";
				
				/* siguiente intento */
				columnaID++;
				if (columnaID == 6) {
					JOptionPane.showMessageDialog(contentPane, "INCORRECTO. La palabra era " + palabraSeleccionada, "Wordle", JOptionPane.ERROR_MESSAGE);
					
					/* se acaba el juego */
					
					return;
				}
			}
		});
		btnEnviar.setBounds(51, 480, 104, 29);
		contentPane.add(btnEnviar);
		
		JButton btnBS = new JButton("<");
		btnBS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (palabraEscrita.length() == 0) return;
				
				/* eliminamos la letra anterior escrita */
				btnLetras[columnaID][palabraEscrita.length() - 1].setText("");
				palabraEscrita = palabraEscrita.substring(0, palabraEscrita.length() - 1);
			}
		});
		btnBS.setBounds(552, 481, 47, 29);
		contentPane.add(btnBS);
		
		/* creamos la cuadrícula 5 (letras)x6(intentos) */
		int posY = 13;
		for(int x = 0; x < btnLetras.length; x++, posY += 65) {
			int posX = 120;
			for(int y = 0; y < btnLetras[x].length; y++, posX += 70) {
				btnLetras[x][y] = new JButton("");
				btnLetras[x][y].setEnabled(false);
				btnLetras[x][y].setBounds(posX, posY, 65, 51);
				contentPane.add(btnLetras[x][y]);
				
				posX += 5;
			}
		}
		
		resetearJuego();
	}
}
