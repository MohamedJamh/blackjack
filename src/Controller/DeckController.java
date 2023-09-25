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

    public static int[] bets = new int[]{1, 5, 25, 50, 100, 500,1000};
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
        do {
            startRound();
            if(Gambler.getBudget() < 5){
                System.out.println("Sorry Out Of Budget");
                break;
            }
            else{
                System.out.println("Would you like another round :\n");
                System.out.println("Y for yes :\n");
                System.out.println("Press key for no :\n");
                if(myScanner.nextLine().equalsIgnoreCase("Y")) startRound();
            }
        }while (true);
    }
    public static void startRound(){
        System.out.printf("------------------ ROUND ------------------ budget: %f\n",Gambler.getBudget());
        int betChoice;
        do {
            System.out.println("Available bets :");
            for (int i = 0; i < bets.length; i++) {
                if( bets[i] <= Gambler.getBudget() ) System.out.printf("%d - %d Dollars .\n", i+1, bets[i]);
            }
            System.out.println("99 - All In ");
            try {
                System.out.println("Please Enter Your Bet :");
                betChoice = Integer.parseInt(myScanner.nextLine());
                if(betChoice - 1 < bets.length){
                    Gambler.setBet(bets[betChoice - 1]);
                    break;
                } else if (betChoice == 99) {
                    Gambler.setBet(Gambler.getBudget());
                    break;
                }
            }catch (Exception ignored){}
        }while (true);
    }

    public static void spreadCards(){
        for (int i = 1; i <= 4 ; i++) {

        }
    }
    public static void endGame(){
        //TODO:This method end the blackjack game show remaining balance
    }
}
