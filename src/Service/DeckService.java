package Service;

import Domain.Cards;

public class DeckService {

    public static int[][] getTheNthCard(int[][] cards,int index){
//        TODO:this method is for extracting a card based on its index and the rest of card list
        return null;
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

//        TODO:this method is for drawing cards to play with returns an 3 Dimension array
//        int[][][] card =  {
//                {
//                    {1, 2}, {1, 2}
//                },
//                {
//                    {3, 4}, {4, 5}
//                }
//        };
        return null;
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
