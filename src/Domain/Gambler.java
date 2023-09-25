package Domain;

public class Gambler extends Player {
    private static double budget;
    private static double bet;
    public static double getBet() {
        return bet;
    }
    public static void setBet(double bet) {
        Gambler.bet = bet;
        Gambler.budget -= bet;
    }
    public static double getBudget() {
        return budget;
    }
    public static void setBudget(double budget) {
        Gambler.budget = Math.floor(budget);
    }
}
