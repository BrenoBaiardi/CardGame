package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Arena {

    //TODO create ArenaTest
    // some of the behaviors should be easier to test

    int rows_size = 5;
    int columns_size = 5;
    ArenaCell[][] arenaLands = new ArenaCell[rows_size][columns_size];
    ArenaCell[][] arenaWarriors = new ArenaCell[rows_size][columns_size];

    public Arena(){
        for (int row = 0; row < rows_size; row++) {
            for (int column = 0; column < columns_size; column++) {
                arenaLands[row][column] = new ArenaCell();
                arenaWarriors[row][column] = new ArenaCell();
            }
        }
    }

    public void addCard(Card card,int r, int c) {
        if (card.getType() == "land") {
            this.arenaLands[r][c].placeCard(card);
        }
        if (card.getType() == "warrior") {
            this.arenaWarriors[r][c].placeCard(card);
        }
    }

    public String checkCard(int r, int c){
        String output="R-" + r + " C-" + c + " ";
        //Have to check both arrays
        //Land check
        if (arenaLands[r][c].isEmpty()){
            output += "Empty Land";
        }
        else{
            output += arenaLands[r][c].checkCard();
        }
        output +=  " + ";
        //warrior check
        if (arenaWarriors[r][c].isEmpty()){
            output += "No warrior";
        }
        else{
            output += arenaWarriors[r][c].checkCard();
        }
        return output;
    }

    @Override
    public String toString() {
        String output="Arena Lands\n";
        for (int row = 0; row < arenaLands.length; row++) {
            for (int column = 0; column < arenaLands[0].length; column++) {
                output += arenaLands[row][column].toString();
            }
            output += "\n";
        }

        output += "\n\n Arena Warriors\n";
        for (int row = 0; row < arenaWarriors.length; row++) {
            for (int column = 0; column < arenaWarriors[0].length; column++) {
                output += arenaWarriors[row][column].toString();
            }
            output += "\n";
        }

        return output;
    }
}

