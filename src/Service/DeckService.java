package Service;

import Domain.Cards;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckService {

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
//        TODO:this method is for generating a random number (n)
//         where (0 <= n and n < cards length)
//         this method uses getTheNthCard
//         recursive logic here
        return null;
    }

    public static int[][] shiftCards(int[][] cards){
//        TODO:this method is for shuffling cards
//         this method uses pullCard
        return null;
    }

    public static int[][][] drawTheNthCards(int[][] cards,int index){
        int[][][] drawnCards = new int[2][][];
        int[][] first_half = Arrays.copyOfRange(cards,0,index);
        int[][] second_half = Arrays.copyOfRange(cards , index , cards.length);

        drawnCards[0] = first_half;
        drawnCards[1] = second_half;

        return drawnCards;
    }

    public static int[] drawOneCard(int[][] cards){
//        todo:this method gets one card in the top of remaining cards
        return null;
    }

    public static void endRound(int[][] gamblerHandCards, int[][] dealerHandCards){
        // TODO: this method puts both dealers and gambler cards into the bank
    }
    public static void discardCards(Cards cards,int[][] cardsBank){
        // TODO: this method returns the cards to its initial state
    }

}
