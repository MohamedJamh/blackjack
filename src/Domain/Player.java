package Domain;

import java.util.Arrays;

public class Player {
    protected int[][] handCards = new int[0][];
    protected int score;

    public int[][] getHandCards() {
        return handCards;
    }

    public void hit(int[] card){
        int[][] newHandCards = new int[handCards.length + 1][];
        System.arraycopy(handCards,0,newHandCards,0,handCards.length);
        newHandCards[handCards.length] = card;
        handCards = newHandCards;
    }
    public  void emptyHands(){
        handCards = new int[0][];
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
