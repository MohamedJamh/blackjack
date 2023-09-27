package Service;

import Domain.CardSymbol;
import _primitiveClasses.ArrayFunctions;

public class CardsService {
    public static int[][] createCardsList(int number , CardSymbol symbol){
        int[][] cards = new int[0][2];
        for(CardSymbol cardSymbol: CardSymbol.values()){
            if( cardSymbol.ordinal() >= symbol.ordinal() ){
                for(int i = 1; i <= 13 ;i++ ){
                    if( i >= number){
                        number = 1;
                        cards = ArrayFunctions.pushXInto2D(cards.length,cards, new int[]{i , cardSymbol.ordinal()+ 1});
                    }
                }
            }
        }
        return cards;
    }
    public static int getHandCardsScore(int[][] cards){
        int score = 0;
        int acesToEleven = 0;
        for (int[] card : cards){
            if(card[0] == 1){
                if( score + 11 <= 21) {
                    score += 11;
                    acesToEleven++;
                }
                else score += 1;
            }
            else if(2 <= card[0] && card[0] <= 9) score += card[0];
            else if(10 <= card[0] ) score += 10;
            if (score > 21 && acesToEleven != 0){
                score -= 10;
                acesToEleven--;
            }
        }
        return score;
    }
}
