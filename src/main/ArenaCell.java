package main;

public class ArenaCell {

    Card card = null;

    public void ArenaCell(){
        //TODO resolve how to start the grid
        // maybe the null type is being the problem here
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
        return "ArenaCell{" +
                "card=" + card +
                '}';
    }
}
