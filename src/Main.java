import Domain.CardSymbol;
import Service.CardsService;
import _primitiveClasses.ArrayFunctions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int[] card : CardsService.createCardsList(1, CardSymbol.DIAMOND)){
            System.out.println(Arrays.toString(card));
        }

    }
}