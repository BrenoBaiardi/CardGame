public class Game {

    Player p1;
    Player p2;
    int turnCounter=1;
    //TODO create field-list]
    //TODO create field color weight

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        p1.drawCard(5);
        this.p2 = p2;
        p2.drawCard(5);

        p1.beginTurn();
    }

    public void nextTurn(){
        if (p1.isPlaying()){
            p1.endTurn();
            p2.beginTurn();
        }
        else if (p2.isPlaying()){
            p2.endTurn();
            p1.beginTurn();
        }
        else{
            //TODO Create Turn Exception and replace SysOutPrint
            System.out.println("Error while passing turn");
        }
        turnCounter+=1;
    }

    @Override
    public String toString() {
        return "\n#-#-Game Status-#-#\n" +
                "\nPlayer1=" + p1.getName() +
                "\nplaying=" + p1.isPlaying() +
                "\n\nPlayer2=" + p2.getName() +
                "\nplaying=" + p2.isPlaying() +
                "\n\nTurn Nº => " + turnCounter;
    }
}
