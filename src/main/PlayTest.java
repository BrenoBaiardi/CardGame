package main;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayTest {
    public static void main(String[] args) throws CardNotFoundException, TurnException {

        Scanner input = new Scanner(System. in);

        //initiating the array of cards using loop
        ArrayList<Card> cards_list= new ArrayList<Card>();

        for(int i = 0; i < 10; i++){
            if (i%2==0) {
                cards_list.add(new WarriorCard("W"+Integer.toString(i+1), "red", 2, 2,"temp"));
            }
            else{
                cards_list.add(new LandCard("L"+Integer.toString(i+1), "blue","temp"));
            }
            //uncomment to print list
            //System.out.println(cards_list.get(cards_list.size()-1));
        }

        //Init card lists
        ArrayList<Card> cards_list1 = new ArrayList<Card>(cards_list);
        ArrayList<Card> cards_list2 = new ArrayList<Card>(cards_list);

        //init decks and players
        Deck d1 = new Deck("d1",cards_list1);
        Deck d2 = new Deck("d2",cards_list2);
        Player p1 = new Player("Play1",d1);
        Player p2 = new Player("Play2",d2);

        //init game
        Game game = new Game(p1,p2);
        String cmd_input;

        //game loop
        while(true){
            game.printField();
            System.out.println(game.arena);

            System.out.print(">>");
            cmd_input = input.next();
            if (cmd_input.equals("x")){
                break;
            }

            //player one move
            p1.drawCard(1);
            game.putUsedCardInArena(p1.useCard(p1.hand.cards.get(0).name),0,0);
            game.nextTurn();
            //player two move
            game.putUsedCardInArena(p2.useCard(p2.hand.cards.get(0).name),2,2);
            p2.drawCard(1);
            game.nextTurn();
        }


    }
}
