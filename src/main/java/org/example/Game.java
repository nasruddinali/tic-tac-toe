package org.example;

import org.example.dto.Board;
import org.example.dto.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game {
    private static GameManager gameManager = GameManager.getInstance();



    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();

        playerList.add(new Player("Abdul",1,'X'));
        playerList.add(new Player("Abhishek",2,'O'));

        gameManager.setPlayers(playerList);


        Scanner scanner = new Scanner(System.in);

        while(true){
            Player player = gameManager.players.poll();

            String command = scanner.nextLine();

            String[] commands =  command.split(" ");
            System.out.println(command);
            if(commands.length == 1){
                System.out.println("exit");
                break;
            }
            int x = Integer.parseInt(commands[0]);
            int y = Integer.parseInt(commands[1]);
            boolean result = gameManager.placeMark(x,y,player);
            gameManager.players.add(player);
            if(result){
                System.out.println(player.getName()+" won the game ");
                break;
            }

        }

    }
}