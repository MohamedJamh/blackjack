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
    public static int[][] cardsBank = new int[0][];

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
        gambler = new Gambler();
        int[][] cards = CardsService.createCardsList(1, CardSymbol.DIAMOND);
        cards = DeckService.shiftCards(cards);
        DeckService.drawPlayingCards(cards);
        do {
            if(Cards.getPlayingCards().length >= 4 ) startRound();
            else{
                System.out.println("Pioche Card Reached");
                DeckService.discardCards(cardsBank);
                break;
            }
            if(Gambler.getBudget() < 5){
                System.out.println("Sorry Out Of Budget");
                break;
            }
            else{
                System.out.println("Would you like another round :");
                System.out.println("Y for yes :");
                System.out.println("Press key for no :");
            }
            DeckService.endRound();
        }while (myScanner.nextLine().equalsIgnoreCase("Y"));
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
        DeckService.spreadCards();
        gambler.setScore(CardsService.getHandCardsScore(gambler.getHandCards()));
        deckDealer.setScore(CardsService.getHandCardsScore(deckDealer.getHandCards()));
        if(gambler.getScore() == 21){
            System.out.println("BLACKJACK");
            Gambler.setBudget(Gambler.getBudget() + (Gambler.getBet() * 1.5));
        }
        else{
            do {
                showCards(true);
                if(gambler.getScore() > 21) {
                    System.out.println("BUST");
                    break;
                }
                System.out.println("1 - Hit | Press Key - Stay");
                if(myScanner.nextLine().equalsIgnoreCase("1")){
                    if(Cards.getPlayingCards().length != 0){
                        gambler.hit(DeckService.drawOneCard());
                        gambler.setScore(CardsService.getHandCardsScore(gambler.getHandCards()));
                    }
                }else break;
            } while (true);
            revealWinner(gambler.getScore());
        }
        Gambler.setBet(0);
        System.out.println(" ------------------------- ");
    }
    public static void revealWinner(int gamblerScore){
        if(gamblerScore < 21){
            showCards(false);
            while (deckDealer.getScore() < 17){
                if(Cards.getPlayingCards().length == 0) break;
                deckDealer.hit(DeckService.drawOneCard());
                deckDealer.setScore(CardsService.getHandCardsScore(deckDealer.getHandCards()));
                System.out.println(" -- Dealers hits a card -- ");
            }
            int dealerScore = deckDealer.getScore();
            showCards(false);
            if( dealerScore > 21 || dealerScore < gamblerScore ){
                if(dealerScore > 21 ) System.out.println("Dealer BUST");
                System.out.println("You Win");
                Gambler.setBudget(Gambler.getBudget() + (Gambler.getBet() * 2));
            }else if (gamblerScore < dealerScore){
                System.out.println("Dealer Wins");
            }else{
                System.out.println("PUSH PUSH");
                Gambler.setBudget(Gambler.getBudget() + Gambler.getBet());
            }
            Gambler.setBet(0);
        }
    }
    public static void showCards(boolean hideDealersCard){
        System.out.println("------------------ CARDS ------------------ \n");
        int[][] gamblerHandCards = gambler.getHandCards();
        String dealersCards = "Dealer --> ";
        if(hideDealersCard) dealersCards += "[X,X], " + Arrays.toString(deckDealer.getHandCards()[0]);
        else dealersCards += Arrays.deepToString(deckDealer.getHandCards()) + " - Dealers total " + deckDealer.getScore();
        System.out.println(dealersCards);
        System.out.println("You --> " + Arrays.deepToString(gamblerHandCards) + " - You total : " + gambler.getScore() );
    }
}
