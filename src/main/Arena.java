package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Arena {

    public int rows_size = 5;
    public int columns_size = 5;
    //public ArenaCell[][] arenaLands = new ArenaCell[rows_size][columns_size];
    //public ArenaCell[][] arenaWarriors = new ArenaCell[rows_size][columns_size];

    //dimension 0 for lands and 1 for warriors.
    public ArenaCell[][][] arena = new ArenaCell[rows_size][columns_size][2];

    public Arena(){
        for (int row = 0; row < rows_size; row++) {
            for (int column = 0; column < columns_size; column++) {
//                arenaLands[row][column] = new ArenaCell(row, column);
//                arenaWarriors[row][column] = new ArenaCell(row, column);
                arena[row][column][0] = new ArenaCell(row, column,"L");
                arena[row][column][1] = new ArenaCell(row, column,"W");
            }
        }
    }

    //TODO remove insertion via index (x,y,z)
    // and create different methods
    public void addCard(Card card,int r, int c) {
        if (card.getType() == "land") {
            this.arena[r][c][0].placeCard(card);
        }
        if (card.getType() == "warrior") {
            this.arena[r][c][1].placeCard(card);
        }
    }

    // "Field" will be the name of the cell in the game
    // the check field method checks what is in the specific field
    // TODO - Maybe it could return ArenaCell Type
    //  Think about refactoring arena to be 3D array.
    //  WIP...
    public ArenaCell[] checkField(int r, int c) {
        return arena[r][c];
        //return arenaWarriors[r][c];
    }

    public ArenaCell checkCardInField(String card_name) throws CardNotFoundException {
        for (int row = 0; row < rows_size; row++) {
            for (int column = 0; column < columns_size; column++) {
//                System.out.println(!this.arenaLands[row][column].isEmpty() || !this.arenaWarriors[row][column].isEmpty());
//                if ( !this.arenaLands[row][column].isEmpty() || !this.arenaWarriors[row][column].isEmpty()){
                    if (!this.arena[row][column][0].isEmpty() &&
                            this.arena[row][column][0].card.getName() == card_name){
                        return arena[row][column][0];
                    }
                    else if (!this.arena[row][column][1].isEmpty() &&
                            this.arena[row][column][1].card.getName() == card_name){
                        return arena[row][column][1];
                    }
//                }
            }
        }
        throw new CardNotFoundException("Card not in Arena");
    }

    public Card getWarrior(int row, int column){
        return arena[row][column][1].card;
    }

    public Card getLand(int row, int column){
        return arena[row][column][0].card;
    }

    @Override
    public String toString() {
        String output="Arena Lands\n";
        for (int row = 0; row < arena.length; row++) {
            for (int column = 0; column < arena[0].length; column++) {
                output += arena[row][column][0].toString();
            }
            output += "\n";
        }

        output += "\n\n Arena Warriors\n";
        for (int row = 0; row < arena.length; row++) {
            for (int column = 0; column < arena[0].length; column++) {
                output += arena[row][column][1].toString();
            }
            output += "\n";
        }

        return output;
    }
}

