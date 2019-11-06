package main;

public class ArenaCell {

    Card card = null;

    public void ArenaCell(){
        this.card = null;
    }

    public void placeCard(Card card){

        if(card.type == "land")
            //TODO add land behavior
            this.card = card;
        else if (card.type == "warrior") {
            //TODO add Warrior behavior
            this.card = card;
        }
    }

    public String checkCard(){
        if (card != null) {
            return this.card.name;
        }
        else{
            return "Empty";
        }
    }

    @Override
    public String toString() {
        if (card != null){
            return String.format("[_%-4s]", card.name).replace(' ', '_');
//            return card.name;
        }
        else{
            return "[_____]";
        }

    }
}
