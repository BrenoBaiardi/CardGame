package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Arena {

    public int rows_size = 5;
    public int columns_size = 5;
    public ArenaCell[][] arenaLands = new ArenaCell[rows_size][columns_size];
    public ArenaCell[][] arenaWarriors = new ArenaCell[rows_size][columns_size];

    public Arena(){
        for (int row = 0; row < rows_size; row++) {
            for (int column = 0; column < columns_size; column++) {
                arenaLands[row][column] = new ArenaCell(row, column);
                arenaWarriors[row][column] = new ArenaCell(row, column);
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

    // "Field" will be the name of the cell in the game
    // the check field method checks what is in the specific field
    // TODO - Maybe it could return ArenaCell Type
    public String checkField(int r, int c){
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

    public ArenaCell checkCardInField(String card_name) throws CardNotFoundException {
        for (int row = 0; row < rows_size; row++) {
            for (int column = 0; column < columns_size; column++) {
//                System.out.println(!this.arenaLands[row][column].isEmpty() || !this.arenaWarriors[row][column].isEmpty());
//                if ( !this.arenaLands[row][column].isEmpty() || !this.arenaWarriors[row][column].isEmpty()){
                    if (!this.arenaLands[row][column].isEmpty() &&
                            this.arenaLands[row][column].card.getName() == card_name){
                        return arenaLands[row][column];
                    }
                    else if (!this.arenaWarriors[row][column].isEmpty() &&
                            this.arenaWarriors[row][column].card.getName() == card_name){
                        return arenaWarriors[row][column];
                    }
//                }
            }
        }
        throw new CardNotFoundException("Card not in Arena");
    }

    public Card getWarrior(int row, int column){
        return arenaWarriors[row][column].card;
    }

    public Card getLand(int row, int column){
        return arenaLands[row][column].card;
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

