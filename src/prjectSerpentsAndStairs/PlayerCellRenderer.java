package prjectSerpentsAndStairs;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PlayerCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        int cellIndex = row * Boardprjct.columns + column + 1; // Convert row and column to board index

        if (value != null && value.toString().contains(":")) {
            Player currentPlayer = getPlayerByCellValue(value.toString());
            
            if (currentPlayer != null) {
                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(currentPlayer.getColor());
                        g.fillOval(getWidth() / 2 - 10, getHeight() / 2 - 10, 20, 20);
                    }
                };
                panel.setOpaque(false);
                return panel;
            }
        } else {
            ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
            
            // Check if the cell contains a ladder or serpent (either end)
            if (isLadderCell(cellIndex)) {
                c.setBackground(Color.decode("#f8e45c"));
            } else if (isSerpentCell(cellIndex)) {
                c.setBackground(Color.decode("#578132"));
            } else {
                c.setBackground(Color.decode("#131313"));
            }
            return c;
        }
        
        return c;
    }

    private Player getPlayerByCellValue(String cellValue) {
        for (Player player : Player.playersArray) {
            if (cellValue.contains(player.getUniqueNumber() + ":")) {
                return player;
            }
        }
        return null;
    }

    private boolean isLadderCell(int cellIndex) {
        for (int[] ladder : Boardprjct.ladders) {
            if (ladder[0] == cellIndex || ladder[1] == cellIndex) {
                return true;
            }
        }
        return false;
    }

    private boolean isSerpentCell(int cellIndex) {
        for (int[] serpent : Boardprjct.serpents) {
            if (serpent[0] == cellIndex || serpent[1] == cellIndex) {
                return true;
            }
        }
        return false;
    }
}
