public class Player {

    private String name;
    private boolean playing = false;
    private Deck deck;
    public Hand hand;
    //TODO create dead-zone


    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public void beginTurn(){
        playing = true;
    }

    public void endTurn(){
        playing = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPlaying() {
        return playing;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", is_playing=" + playing +
                ", deck=" + deck +
                '}';
    }

    public void drawCard(int i){
        if (hand==null){
            this.hand = new Hand();
        }
        for (int j = 0; j < i; j++) {
            Card draw = deck.draw();
            hand.addCard(draw);
        }
    }

    public void useCard(String name){
        //TODO remove card from hand, BY NAME
    }

    public void discardCard(){
        //TODO discard card into dead-zone"
    }

}