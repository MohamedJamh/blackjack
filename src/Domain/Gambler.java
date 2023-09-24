package Domain;

public class Gambler extends Player {
    private static double budget;

    public static double getBudget() {
        return budget;
    }

    public static void setBudget(double budget) {
        Gambler.budget = Math.floor(budget);
    }
}
