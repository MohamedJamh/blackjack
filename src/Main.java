import Controller.DeckController;
import Domain.Cards;
import Domain.Dealer;
import Domain.Gambler;
import Domain.Player;
import Service.CardsService;
import Service.DeckService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DeckController.deckDealer = new Dealer();
        DeckController.opening();
    }
}