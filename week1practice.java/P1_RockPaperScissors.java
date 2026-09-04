import java.util.Scanner;
import java.util.Random;

public class P1_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        final int ROUNDS = 5;

        String[] playerMoves = new String[ROUNDS];
        String[] computerMoves = new String[ROUNDS];
        String[] results = new String[ROUNDS];

        String[] choices = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < ROUNDS; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            String computer = choices[random.nextInt(3)];

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = playRound(player, computer);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nFinal Summary");
        System.out.println("Round\tPlayer\tComputer\tResult");

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t"
                    + computerMoves[i] + "\t" + results[i]);
        }

        double winPercentage = (wins * 100.0) / ROUNDS;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}