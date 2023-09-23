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
        };
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
