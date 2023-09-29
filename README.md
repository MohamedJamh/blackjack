# blackjack
I BlackJack Game with most of its conceptes implemented in a Java console applicaiton

# Project Context
The objective of your project is to create a console-based blackjack game for a video game development company. This blackjack game should automate the game's business logic, meaning it must be able to handle the rules of blackjack and allow players to play against the computer.

In a deck of cards, a card is characterized by its rank (1 for Ace, 2 to 10 for corresponding cards, 11 for Jack, 12 for Queen, 13 for King), and its suit (1 for Diamonds, 2 for Hearts, 3 for Spades, and 4 for Clubs).

# Example:
[12, 3]: Queen of Spades

[5, 1]: 5 of Diamonds

We want to create a deck of 52 cards defined as a list of cards. To do this, we will define a method that constructs a list of cards following a given card, and then use it to create the deck of cards starting from the Ace of Diamonds. To achieve this, you should use:

A method that constructs the list of following cards given a card as a parameter. This list must respect the order of suits (Diamonds, Hearts, Spades, Clubs); thus, the last card corresponds to the King of Clubs. (13 4) -> (), (8 4) -> (9 4) (10 4) (11 4) (12 4) (13 4) (12 3) -> ((13 3) (1 4) (2 4) (3 4) (4 4) (5 4) (6 4) (7 4) (8 4) (9 4) (10 4) (11 4) (12 4) (13 4))

A method that creates the deck of 52 cards defined as a list of card pairs.

Example: (create_cards) -> ((1 1) (2 1) … (12 4) (13 4))

To shuffle, you need to be able to draw a card at random to make it the first card of the shuffled deck. To do this, we will randomly select the index i of the card to be drawn, and then extract the card at index i from the deck. Here are three methods that allow you to implement this:

The extract_ith_card method that extracts the i-th card from a given list of cards as a parameter. This method returns a list consisting of the extracted card and the list of remaining cards: extract_ith_card(array: [(1 1) (12 3) (14 4)], index: 2) -> [(12 3), [(1 1) (14 4)]]

The draw_a_card method that randomly draws a card from a given list of cards as a parameter. This function returns a list consisting of the drawn card and the list of remaining cards after drawing. To write this method, use the random n function, which returns a random number between 0 (inclusive) and n (exclusive), as well as the extract_ith_card method. (draw_a_card '(array: [(1 2) (13 4) (5 3) (1 1) (6 3)]) -> [(6 3), [(1 2) (13 4) (5 3) (1 1)]]

Write the shuffle_deck method that shuffles the cards in a given list of cards as a parameter. This method returns the list of shuffled cards. Note that this method uses the draw_a_card method. (shuffle_deck '(array: [(10 1) (4 4) (5 2)]) -> [(10 1) (5 2) (4 4)])

Drawing cards is different from randomly drawing cards: drawing cards involves a deck of cards. When drawing cards, you take the cards on top of the deck. When discarding, you put the cards below the deck.

The draw_n_cards method that allows you to draw the first n cards from a given list of cards as a parameter. This method returns a list consisting of the list of drawn cards and the list of remaining cards in the deck. (draw_n_cards '(deck: [(13 4) (5 3) (1 1) (6 3)], index: 2) -> ([(13 4) (5 3)], [(1 1) (6 3)])

The discard_cards method that takes two lists of cards as parameters (a list of cards corresponding to the deck and a list of cards to discard) and returns the list of cards from the deck, with the discarded cards placed at the end. (discard_cards '(deck: [(1 1) (1 2)]), dealer + player cards: [(3 4) (4 3)]) -> [(1 1) (1 2) (3 4) (4 3)]

A game of blackjack will pit the player against the dealer. The dealer starts by drawing one card and then gives two to the player. The goal of this game is to approach or reach the number 21 without exceeding it. The card values are established as follows: cards from 2 to 10 retain their values, face cards are worth 10, and the Ace is worth 1 or 11 if it can complete 21.

The player can request as many cards as they want. If they exceed 21, they lose. If they stop before that, the dealer draws cards until they exceed 17 to avoid taking risks. If the dealer scores less than the player, or if they exceed 21, the player wins. If the dealer scores less, the player loses. Otherwise, it's a tie.
