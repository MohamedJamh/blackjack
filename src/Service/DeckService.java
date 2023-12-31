package Service;

import Controller.DeckController;
import Domain.Cards;
import java.util.Arrays;

public class    DeckService {

    public static int[][][] getTheNthCard(int[][] cards,int index){
        int[][][] newArray = new int[2][][];
        int[][] extractedCard = new int[1][];

        extractedCard[0] = cards[index];
        int[][] restOfCards = new int[cards.length - 1][];

        int i = 0;
        for (int[] card : cards){
            if( !Arrays.equals(card, cards[index])){
                restOfCards[i] = card;
                i++;
            }
        }

        newArray[0] = extractedCard;
        newArray[1] = restOfCards;
        return newArray;
    }

    public static int[][] pullCard(int[][] cards){
        int[][] shuffledCards = new int[cards.length][];
        int[][][] cardAndRest;
        int i = 0;
        while (cards.length != 0){
            int max = cards.length - 1;
            int min = 0;
            int randomIndex = (int) (Math.random() * ( max - min + 1)) + min;
            cardAndRest = getTheNthCard(cards,randomIndex);
            shuffledCards[i] = cardAndRest[0][0];
            cards = cardAndRest[1];
            i++;
        }
        return shuffledCards;
    }

    public static int[][] shiftCards(int[][] cards){
        return pullCard(cards);
    }

    public static int[][][] drawTheNthCards(int[][] cards,int index){
        int[][][] drawnCards = new int[2][][];
        int[][] first_half = Arrays.copyOfRange(cards,0,index);
        int[][] second_half = Arrays.copyOfRange(cards , index , cards.length);

        drawnCards[0] = first_half;
        drawnCards[1] = second_half;

        return drawnCards;
    }

    public static void drawPlayingCards(int[][] cards){
        int max = cards.length;
        int min = Math.round(  (float) Math.round( (float) (cards.length - 1) / 2 + cards.length - 1) / 2 );
        int randomIndex = (int) (Math.random() * ( max - min + 1)) + min;
        int[][][] drewCards = drawTheNthCards(cards,randomIndex);
        Cards.setPlayingCards(drewCards[0]);
        Cards.setRemaining(drewCards[1]);
    }

    public static int[] drawOneCard(){
        int[] drewCard = Cards.getPlayingCards()[0];
        int[][] remainPlayingCards = new int[ Cards.getPlayingCards().length - 1][];
        System.arraycopy(Cards.getPlayingCards(), 1, remainPlayingCards, 0, Cards.getPlayingCards().length - 1);
        Cards.setPlayingCards(remainPlayingCards);
        return drewCard;
    }

    public static void spreadCards(){
        for (int i = 1; i <= 2 ; i++) {
            DeckController.gambler.hit(DeckService.drawOneCard());
            DeckController.deckDealer.hit(DeckService.drawOneCard());
        }
    }

    public static void endRound(){
        storeInBank(DeckController.deckDealer.getHandCards(),DeckController.gambler.getHandCards());
        DeckController.gambler.emptyHands();
        DeckController.deckDealer.emptyHands();
    }
    public static int[][] discardCards(int[][] cardsBank){
        int[][] playingCards = Cards.getPlayingCards();
        int[][] remainingCards = Cards.getRemaining();
        int[][] allCards = new int[playingCards.length + remainingCards.length + cardsBank.length][];

        System.arraycopy(playingCards,0,allCards,0,playingCards.length);
        System.arraycopy(remainingCards,0,allCards,playingCards.length ,remainingCards.length);
        System.arraycopy(cardsBank,0,allCards,playingCards.length + remainingCards.length ,cardsBank.length);

        return allCards;
    }
    public static void storeInBank(int[][] dealersCard , int[][] gamblersCard ){
        int[][] cardsBank = DeckController.cardsBank;
        int[][] newArr = new int[cardsBank.length + dealersCard.length + gamblersCard.length][];
        System.arraycopy(cardsBank,0,newArr,0,cardsBank.length);
        System.arraycopy(dealersCard,0,newArr,cardsBank.length,dealersCard.length);
        System.arraycopy(gamblersCard,0,newArr,cardsBank.length + dealersCard.length,gamblersCard.length);
        DeckController.cardsBank = newArr;
    }

}
