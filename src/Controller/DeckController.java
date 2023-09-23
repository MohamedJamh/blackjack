package Controller;

import Domain.Cards;
import Domain.Dealer;

public class DeckController {
    private static Dealer deckDealer;
    private static int[][] cardsBank;
    private static Cards cards;

    public static void opening() {
        //TODO:This method is the game opening asking the users budget to play with

    }
    public static void startGame(){
        //TODO:This method starts the blackjack game

        // this logic is for "pioche" inserting at last quarter of the card array
//        int max = cards.length;
//        int min = Math.round(  (float) ((cards.length - 1) / 2 + cards.length - 1) / 2 ); // gets index of last quarter of the array
//        int randomIndex = (int) (Math.random() * ( max - min + 1)) + min;
    }
    public static void endGame(){
        //TODO:This method end the blackjack game show remaining balance
    }
}
