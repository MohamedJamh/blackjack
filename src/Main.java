import Domain.Cards;
import Service.DeckService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        for (int[] card : CardsService.createCardsList(1, CardSymbol.DIAMOND)){
//            System.out.println(Arrays.toString(card));
//        }
        int[][] palying = {
            {1,2},{2,3}
        };
        int[][] remaining = {
                {5,6},{7,8},{8,9}
        };
        Cards.setPlayingCards(palying);
        Cards.setRemaining(remaining);
        int[][] bank = {
                {9,9},{9,9},{9,9},{9,9}
        };
        System.out.println(Arrays.deepToString(DeckService.discardCards(bank)));
    }
}