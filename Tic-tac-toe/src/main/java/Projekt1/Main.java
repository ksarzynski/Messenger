package Projekt1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Clock;

public class Main {

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		System.out.println("New game");
		Clock clock = Clock.systemDefaultZone();
		long start = clock.millis();

		for (int i = 0; i < 10; i++) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose position for " + game.Mark + ":");

			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());

			game.addMark(a, b);

			if (game.checkWinner()) {
				System.out.println("You won!");
				long elapsedTime = (clock.millis() - start);
				System.out.println("Total game time: " + elapsedTime * 0.001 + " seconds.");
				System.exit(0);
			} else if (game.isDraw()) {
				System.out.println("Draw!");
				long elapsedTime = (clock.millis() - start);
				System.out.println("Total game time: " + elapsedTime * 0.001 + " seconds.");
				System.exit(0);
			}
			game.changePlayer();
		}
	}
}
