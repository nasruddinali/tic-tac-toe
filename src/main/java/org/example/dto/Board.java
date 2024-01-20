package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private char[][] board;
    private int size;

    public void initializeBoard() {
        this.size = 3;
        this.board = new char[size][];
        for (int i = 0; i < size; i++) {
            board[i] = new char[size];
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean mark(int x, int y, Player player) {
        if (!(isValid(x, y, player)))
            return false;
        board[x][y] = player.getMark();
        return checkWinner(x, y, player);

    }

    private boolean checkWinner(int x, int y, Player player) {
        return checkHorizontal(x, y, player) ||
                checkVertical(x, y, player) ||
                checkDiagonal(x, y, player);

    }

    private boolean checkDiagonal(int x, int y, Player player) {
        int i = x;
        int j = y;
        while(i >= 0 && j>=0)
            if(board[i--][j--] != player.getMark())
                return false;
        i = x;
        j = y;

        while (i < size && j < size)
            if(board[i++][j++] != player.getMark())
                return false;

        i = x;
        j = y;

        while( i >= 0 && j < size){
            if(board[i--][j++] != player.getMark())
                return false;
        }
        i = x;
        j = y;

        while( j >= 0 && i < size){
            if(board[i++][j--] != player.getMark())
                return false;
        }
        return true;
    }

    private boolean checkVertical(int x, int y, Player player) {
        for (int i = 0; i < size; i++)
            if (board[i][y] != player.getMark())
                return false;

        return true;
    }

    private boolean checkHorizontal(int x, int y, Player player) {
        for (int i = 0; i < size; i++)
            if (board[x][i] != player.getMark())
                return false;

        return true;
    }

    private boolean isValid(int x, int y, Player player) {
        return !(x < 0 || y < 0 || x >= this.size || y >= this.size || board[x][y] != '-');
    }

    public void printBoard() {
        for (int i = 0 ; i < size ; i++) {
            for(int j = 0 ;j < size ;j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("\n");
        }
    }
}
