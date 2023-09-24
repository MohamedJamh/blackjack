package Controller;

import Domain.CardSymbol;
import Domain.Cards;
import Domain.Dealer;
import Domain.Gambler;
import Service.CardsService;
import Service.DeckService;

import java.util.Arrays;
import java.util.Scanner;

public class DeckController {
    public static Dealer deckDealer;
    public static Gambler gambler;
    public static int[][] cardsBank;
    public static Cards cards;
    private static final Scanner myScanner = new Scanner(System.in);

    public static void opening() {
        System.out.println("------------------ BLACKJACK GAME ------------------");
        do {
            System.out.println("Please Enter Your Budget (Minimum 100 Dollars) :");
            try {
                Gambler.setBudget(Double.parseDouble(myScanner.nextLine()));
            }catch (Exception ignored){
            }
        }while (Gambler.getBudget() < 100);
        startGame();
    }
    public static void startGame(){
        int[][] cards = CardsService.createCardsList(1, CardSymbol.DIAMOND);
        cards = DeckService.shiftCards(cards);
        DeckService.drawPlayingCards(cards);
        startRound();
    }
    public static void startRound(){}
    public static void endGame(){
        //TODO:This method end the blackjack game show remaining balance
    }
}
