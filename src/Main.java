import Service.DeckService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        for (int[] card : CardsService.createCardsList(1, CardSymbol.DIAMOND)){
//            System.out.println(Arrays.toString(card));
//        }
        int[][] arr = {
                {1,2}, {34}, {56}, {78}, {910}, {1112}, {1314}, {1516}
        };
        System.out.println(Arrays.deepToString(DeckService.pullCard(arr)));
    }
}