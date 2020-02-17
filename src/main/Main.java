package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

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

        for (int i = 0; i < cards_list1.size(); i++) {
            cards_list1.get(i).owner = "owner_1";
        }

        System.out.println(cards_list1);

        for (int i = 0; i < cards_list2.size(); i++) {
            cards_list1.get(i).owner = "owner_2";
        }

        //init decks and players
        Deck d1 = new Deck("d1",cards_list1);
        Deck d2 = new Deck("d2",cards_list2);
        Player p1 = new Player("Play1",d1);
        Player p2 = new Player("Play2",d2);

//        System.out.println(p1);
//        System.out.println(p2);

        //init game
        Game game = new Game(p1,p2);
        System.out.println(game);
        try {
            game.nextTurn();
        } catch (TurnException e) {
            e.printStackTrace();
        }
        System.out.println(game);

//        System.out.println(p1.hand);

//        Card use;
//        use = p1.hand.cards.get(0);
//        p1.useCard(use.name);
//        use = p1.hand.cards.get(0);
//        p1.useCard(use.name);
//
//        use = p2.hand.cards.get(0);
//        p2.useCard(use.name);

        Card use;

        use = p2.hand.cards.get(0);
        try {
            use = p1.hand.cards.get(0);
            p1.useCard(use.name);
            use = p1.hand.cards.get(0);
            p1.useCard(use.name);
//            p2.useCard(use.name);
        } catch (CardNotFoundException | TurnException e) {
            e.printStackTrace();
        }


        System.out.println(p1.hand);
        System.out.println(p2.hand);

        Arena arena = new Arena();
        arena.addCard(cards_list.get(0),0,0);
        arena.addCard(cards_list.get(1),0,1);
//        System.out.println("card inserted in Grid");
//        System.out.println(arena.checkField(0,0));
//        System.out.println("the above card was in grid");

        System.out.println(arena);
        System.out.println(arena.checkField(0,0));
        System.out.println(arena.checkField(0,1));
        System.out.println(arena.checkField(1,0));

    }



}
