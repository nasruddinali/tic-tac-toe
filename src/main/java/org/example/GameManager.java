package org.example;


import org.example.dto.Board;
import org.example.dto.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameManager {


    public static GameManager instance;
    private Board board;
    Queue<Player> players;

    private GameManager() {
        this.board = new Board();
        board.initializeBoard();
        this.players = new LinkedList<>();
    }
    private GameManager(int size){
        this.board = new Board();
        board.setSize(size);
        board.initializeBoard();
    }
    public static GameManager getInstance(int size){
        if(instance == null){
            instance = new GameManager(size);
        }
        return instance;
    }
    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public boolean placeMark(int x, int y, Player player) {
        boolean result =  board.mark(x,y,player);
        board.printBoard();
        return result;
    }

    public void setPlayers(List<Player> players) {
        this.players.addAll(players);
    }
}
