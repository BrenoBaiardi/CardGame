package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Assets...");

        ArrayList<Card> cards_list= new ArrayList<Card>();

        for(int i = 0; i < 10; i++){
            if (i%2==0) {
                cards_list.add(new WarriorCard("W"+Integer.toString(i+1), "red", 2, 2));
            }
            else{
                cards_list.add(new LandCard("L"+Integer.toString(i+1), "blue"));
            }
            //uncomment to print list
            //System.out.println(cards_list.get(cards_list.size()-1));
        }

        System.out.println(cards_list.size());

        Deck d1 = new Deck("d1",cards_list);
        Deck d2 = new Deck("d2",cards_list);

        Player p1 = new Player("Play1",d1);
        Player p2 = new Player("Play2",d2);

        System.out.println(p1);
        System.out.println(p2);

        Game game = new Game(p1,p2);

//        System.out.println(game);
//        game.nextTurn();
//        System.out.println(game);

        System.out.println(p1.hand);

//        Card use;
//        use = p1.hand.cards.get(0);
//        p1.useCard(use.name);
//        use = p1.hand.cards.get(0);
//        p1.useCard(use.name);
//
//        use = p2.hand.cards.get(0);
//        p2.useCard(use.name);


        System.out.println(p1.hand);
        System.out.println(p2.hand);


        game.printField();


    }



}
