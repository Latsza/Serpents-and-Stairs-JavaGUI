package prjectSerpentsAndStairs;

import java.awt.Color;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Player {
    static String[] arraynames;
    static Player[] playersArray;
    private int[] position;
    private Color color;
    private int uniqueNumber;
    static int currentPlayerIndex = 0;
    private static final Color[] playerColors = {
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, 
        Color.MAGENTA, Color.CYAN, Color.PINK, Color.GRAY
    };

    public Player(String name, int[] position, Color color, int uniqueNumber) {
        this.position = position;
        this.color = color;
        this.uniqueNumber = uniqueNumber;
    }

    public void setPosition(int[] newPosition) {
        this.position = newPosition;
    }

    public int[] getPosition() {
        return this.position;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public Color getColor() {
        return color;
    }

    public static void m_setPlayers(int players, TextField textField, JButton btnThrowDice) {
        players = Integer.parseInt(JOptionPane.showInputDialog("How many players are gonna play?"));
        m_setNames(players, textField, btnThrowDice);
    }

    public static void m_setNames(int players, TextField textField, JButton btnThrowDice) {
        arraynames = new String[players];
        if (players <= 1 || players > 9) {
            m_setPlayers(players, textField, btnThrowDice);
        }
        textField.setText("waiting...");

        Boardprjct.m_displayBoardInTableFromClass();

        for (int i = 0; i < players; i++) {
            arraynames[i] = JOptionPane.showInputDialog("What's your name?");
        }

        Board.m_sttextField(arraynames, players, textField, btnThrowDice);
        m_setPlayers(players, arraynames);
    }

    public static void m_setPlayers(int players, String[] arraynames) {
        playersArray = new Player[players];
        for (int i = 0; i < players; i++) {
            playersArray[i] = new Player(arraynames[i], new int[]{0, 0}, playerColors[i % playerColors.length], i + 1); 
        }
        Boardprjct.updateBoardWithPlayersPosition(true, playersArray, players);
        
    }

    public static Player getCurrentPlayer() {
        return playersArray[currentPlayerIndex];
    }

    public static void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playersArray.length;
    }

    public static Color getCurrentPlayerClr() {
        return playerColors[currentPlayerIndex % playerColors.length];
    }
}
