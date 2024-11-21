package prjectSerpentsAndStairs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JLabel;


public class Board {

    private static JFrame frmSerpentsAndStairs;
    static JTable table;
    private JTextField textField_1;
    static int rows = 10;
    static int columns = 10;
    static Object[][] boardArray = new Object[rows][columns];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Board window = new Board();
                    window.frmSerpentsAndStairs.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Board() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frmSerpentsAndStairs = new JFrame();
        frmSerpentsAndStairs.getContentPane().setForeground(new Color(45, 45, 45));
        frmSerpentsAndStairs.getContentPane().setBackground(new Color(45, 45, 45));
        frmSerpentsAndStairs.setBackground(new Color(47, 47, 47));
        frmSerpentsAndStairs.setTitle("Serpents and stairs");
        frmSerpentsAndStairs.setBounds(100, 100, 758, 571);
        frmSerpentsAndStairs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSerpentsAndStairs.getContentPane().setLayout(null);

        table = new JTable();
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setCellSelectionEnabled(true);
        table.setBounds(124, 127, 400, 400);
        table.setBackground(new Color(19, 19, 19));
        table.setTableHeader(null);
        table.setEnabled(false);
        table.setSize(500, 400);
        
        table.setRowHeight(40);
        
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
            },
            new String[] {
                " ", "", "", "", "", "", "", "", "", ""
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        table.getColumnModel().getColumn(4).setPreferredWidth(15);
        table.getColumnModel().getColumn(5).setPreferredWidth(15);
        table.getColumnModel().getColumn(6).setPreferredWidth(15);
        table.getColumnModel().getColumn(7).setPreferredWidth(15);
        table.getColumnModel().getColumn(8).setPreferredWidth(15);
        table.getColumnModel().getColumn(9).setPreferredWidth(15);

        table.setDefaultRenderer(Object.class, new PlayerCellRenderer());
        frmSerpentsAndStairs.getContentPane().add(table);

		frmSerpentsAndStairs.getContentPane().add(table); 
		JButton btnThrowDice = new JButton("");
		btnThrowDice.setIcon(new ImageIcon("/home/ltsa/eclipse-workspace/prjectSerpentsAndStairs/dices/Dices.png"));
		btnThrowDice.setEnabled(false);
		btnThrowDice.setBorderPainted(false);
		btnThrowDice.setContentAreaFilled(true);
		btnThrowDice.setFocusPainted(false);
		btnThrowDice.setOpaque(false);
		
		btnThrowDice.setForeground(new Color(255, 255, 255));
		btnThrowDice.setBackground(new Color(45, 45, 45));
		btnThrowDice.setBounds(337, 13, 100, 80);
		btnThrowDice.setFont(new Font("Cantarell", Font.BOLD, 7));
		
		  JTextArea txtrSdf = new JTextArea();
		  txtrSdf.setForeground(new Color(255, 255, 255));
		  txtrSdf.setBackground(new Color(47, 47, 47));
	        txtrSdf.setFont(new Font("Cantarell", Font.PLAIN, 12));
	        txtrSdf.setText("Dice output:");
	        txtrSdf.setBounds(337, 94, 88, 21);
	        txtrSdf.setEditable(false);
	        frmSerpentsAndStairs.getContentPane().add(txtrSdf);
		
		btnThrowDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boardprjct.m_DiceR(txtrSdf);
				
			}
		});
		frmSerpentsAndStairs.getContentPane().add(btnThrowDice);
		
		JButton btnThrowDice_1 = new JButton("Clse game");
		btnThrowDice_1.setBackground(new Color(45, 45, 45));
		btnThrowDice_1.setForeground(new Color(246, 245, 244));
		btnThrowDice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnThrowDice_1.setFont(new Font("Cantarell", Font.BOLD, 7));
		btnThrowDice_1.setBounds(635, 13, 100, 36);
		frmSerpentsAndStairs.getContentPane().add(btnThrowDice_1);
		
	
		
		JButton btnThrowDice_1_1 = new JButton("Add players ");
		btnThrowDice_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Player player = new Player(null, null, null, 0);
				
				///añade el textfiel desde el metodoxd
				m_addtextField( btnThrowDice);
				
				btnThrowDice_1_1.setEnabled(false);
			}
		});
		btnThrowDice_1_1.setForeground(new Color(246, 245, 244));
		btnThrowDice_1_1.setFont(new Font("Cantarell", Font.BOLD, 7));
		btnThrowDice_1_1.setBackground(new Color(45, 45, 45));
		btnThrowDice_1_1.setBounds(29, 13, 88, 21);
		frmSerpentsAndStairs.getContentPane().add(btnThrowDice_1_1);
		
		JButton buttonRestartProgram = new JButton("Restart Game");
		buttonRestartProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boardprjct.resetBoard();
				buttonRestartProgram.setEnabled(true);
			}
		});
		
		buttonRestartProgram.setForeground(new Color(246, 245, 244));
		buttonRestartProgram.setFont(new Font("Cantarell", Font.BOLD, 7));
		buttonRestartProgram.setBackground(new Color(45, 45, 45));
		buttonRestartProgram.setBounds(635, 69, 100, 36);
		frmSerpentsAndStairs.getContentPane().add(buttonRestartProgram);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(88, 88, 88));
		textField_1.setBounds(302, 534, 152, 25);
		frmSerpentsAndStairs.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(19, 19, 19));
		panel_1_1.setBounds(635, 216, 100, 158);
		frmSerpentsAndStairs.getContentPane().add(panel_1_1);
		
		JButton btnShowPlayercolorScheme = new JButton("Show Colors");
		btnShowPlayercolorScheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_showColors();
			}
		});
		btnShowPlayercolorScheme.setForeground(new Color(246, 245, 244));
		btnShowPlayercolorScheme.setFont(new Font("Cantarell", Font.BOLD, 7));
		btnShowPlayercolorScheme.setBackground(new Color(45, 45, 45));
		btnShowPlayercolorScheme.setBounds(635, 127, 100, 36);
		frmSerpentsAndStairs.getContentPane().add(btnShowPlayercolorScheme);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(19, 19, 19));
		panel_1_1_1.setBounds(12, 216, 100, 158);
		frmSerpentsAndStairs.getContentPane().add(panel_1_1_1);
		}

	public Dimension getTableSize() {
		return table.getSize();
	}
	public void setTableSize(Dimension size) {
		table.setSize(size);
	}
	
	public static  TextField m_addtextField(JButton btnThrowDice) {
		
		TextField textField = new TextField();
		textField.setBackground(new Color(57, 57, 57));
		textField.setForeground(new Color(246, 245, 244));
		textField.setBounds(12, 43, 135, 21);
		textField.setEnabled(false);
		textField.setText("Players: ");
		
		frmSerpentsAndStairs.getContentPane().add(textField);

		Player player = new Player(null, null, null, columns);
		player.m_setPlayers(0, textField, btnThrowDice);
		
		return textField;
	}

	public static void m_sttextField(String[] arraynames, int players, TextField textField, JButton btnThrowDice){
		String temp ; 
		StringBuilder stringBuilder = new StringBuilder();
		 for (String name : arraynames) {
		        stringBuilder.append(name).append(", ");
		    }
		 temp = "players: "+stringBuilder.toString();
		 textField.setText(temp);
			btnThrowDice.setEnabled(true);
			
		}
	
	 public static void m_showColors() {
		 String[] colores = {
		            "Red", "Blue", "Green", "Yellow", "Orange",
		            "Purple", "Blue", "Pink", "Gray"
		        };

		        JTextArea textArea = new JTextArea(10, 30);
		        textArea.setEditable(false);
		        
		        textArea.setForeground(Color.WHITE); 
		        textArea.setBackground(Color.decode("#131313")); 

		        for (int i = 1; i <= 9; i++) {
		            textArea.append("Player " + i + " is color:		 " + colores[i - 1] + "\n");
		        }
		        JFrame frame = new JFrame("Colors from players");
		        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		        frame.getContentPane().add(textArea);
		        frame.pack();
		        frame.setVisible(true);
	    }
	 	}
	
	

