package Domain;

public class Cards {
    private static int[][]  playingCards;
    private static int[][]  remaining;


    public static int[][] getPlayingCards() {
        return playingCards;
    }

    public static void setPlayingCards(int[][] playingCards) {
        Cards.playingCards = playingCards;
    }

    public static int[][] getRemaining() {
        return remaining;
    }

    public static void setRemaining(int[][] remaining) {
        Cards.remaining = remaining;
    }
}
