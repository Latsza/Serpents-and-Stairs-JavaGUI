package prjectSerpentsAndStairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Boardprjct {
    final static int rows = 10;
    final static int columns = 10;
    final static List<String>[][] boardArray = new ArrayList[rows][columns];
    private static Player[] playersArray;
    public static final int[][] serpents = new int[6][2];
    public static final int[][] ladders = new int[6][2];

    static {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardArray[i][j] = new ArrayList<>();
            }
        }
        m_serpentsALedders();
    }

    public static void m_displayBoardInTableFromClass() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Board.table.setValueAt((i * columns + j + 1), i, j);
            }
        }
        Board.table.repaint();
    }

    public static void updateBoardWithPlayersPosition(boolean firstTimeR, Player[] playersArray, int players) {
        if (firstTimeR) {
            for (int i = 0; i < players; i++) {
                int[] position = playersArray[i].getPosition();
                boardArray[position[0]][position[1]].add(playersArray[i].getUniqueNumber() + ": " + playersArray[i].arraynames[i]);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String currentValue = Board.table.getValueAt(i, j).toString();
                StringBuilder playerInfo = new StringBuilder(currentValue);
                for (String player : boardArray[i][j]) {
                    playerInfo.append(" ").append(player);
                }
                Board.table.setValueAt(playerInfo.toString(), i, j);
            }
        }
    }

    public static void m_serpentsALedders() {
        ladders[0][0] = 3;
        ladders[0][1] = 22;
        ladders[1][0] = 5;
        ladders[1][1] = 28;
        ladders[2][0] = 24;
        ladders[2][1] = 61;
        ladders[3][0] = 20;
        ladders[3][1] = 37;
        ladders[4][0] = 17;
        ladders[4][1] = 67;
        ladders[5][0] = 60;
        ladders[5][1] = 84;

        serpents[0][0] = 30;
        serpents[0][1] = 6;
        serpents[1][0] = 47;
        serpents[1][1] = 26;
        serpents[2][0] = 49;
        serpents[2][1] = 11;
        serpents[3][0] = 53;
        serpents[3][1] = 19;
        serpents[4][0] = 77;
        serpents[4][1] = 35;
        serpents[5][0] = 98;
        serpents[5][1] = 47;
    }

    public static void m_DiceR(JTextArea txtrSdf) {
        Random d6 = new Random();
        int ran_temp = d6.nextInt(6) + 1;
        Random d6_2 = new Random();
        int ran_temp_2 = d6_2.nextInt(6) + 1;
        int v_valueDices = ran_temp + ran_temp_2;

        txtrSdf.setText("Dice output: " + v_valueDices);
        Boardprjct.m_movePlayer(v_valueDices);
    }

    public static void m_movePlayer(int v_valueDices) {
        Player currentPlayer = Player.getCurrentPlayer();
        int[] currentPosition = currentPlayer.getPosition();
        int currentIndex = currentPosition[0] * columns + currentPosition[1];
        int newPositionIndex = currentIndex + v_valueDices;

        if (newPositionIndex >= rows * columns) {
            newPositionIndex = rows * columns - 1;
        }

        boolean moved;
        do {
            moved = false;
            for (int[] ladder : ladders) {
                if (newPositionIndex == ladder[0]) {
                    newPositionIndex = ladder[1];
                    moved = true;
                    break;
                }
            }
            for (int[] serpent : serpents) {
                if (newPositionIndex == serpent[0]) {
                    newPositionIndex = serpent[1];
                    moved = true;
                    break;
                }
            }
        } while (moved);

        int newRow = newPositionIndex / columns;
        int newCol = newPositionIndex % columns;

        int[] newPosition = new int[]{newRow, newCol};
        boardArray[currentPosition[0]][currentPosition[1]].remove(currentPlayer.getUniqueNumber() + ": " + currentPlayer.arraynames[Player.currentPlayerIndex]);
        Board.table.setValueAt(currentIndex + 1, currentPosition[0], currentPosition[1]);

        currentPlayer.setPosition(new int[]{newRow, newCol});
        boardArray[newRow][newCol].add(currentPlayer.getUniqueNumber() + ": " + currentPlayer.arraynames[Player.currentPlayerIndex]);

        updateBoardWithPlayersPosition(false, Player.playersArray, Player.playersArray.length);

        if (newPositionIndex == (rows * columns) - 1) {
            String winnerName = currentPlayer.arraynames[Player.currentPlayerIndex];
            JOptionPane.showMessageDialog(null, "Player " + winnerName + " has won!");
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                resetBoard();
            } else {
                System.exit(0);
            }
        } else {
            Player.nextPlayer();}
        }
    
    public static void resetBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardArray[i][j].clear();
                Board.table.setValueAt((i * columns + j ), i, j);
            }
        }
        for (Player player : Player.playersArray) {
            player.setPosition(new int[]{0, 0});
        }
        updateBoardWithPlayersPosition(true, Player.playersArray, Player.playersArray.length);
    }
}