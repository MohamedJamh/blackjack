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
    public static int getCardsScore(int[][] cards){
        // TODO: takes a hand of cards and calculates the total
        return 0;
    }
}
