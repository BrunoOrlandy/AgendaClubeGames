package AgendaClubeGames;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import AgendaClubeGames.Helpers.*;

public class AgendaGames implements AgendaGamesImpl {

	private Game[] gameHashTable = new Game[27];

	@Override
	public void inserirGame(Game game) {
		int hash = GameHelper.getGameHash(game.getNome());

		if (gameHashTable[hash] == null) {
			gameHashTable[hash] = game;
		} else {
			Game head = gameHashTable[hash];
			game.setProximoGame(head);

			gameHashTable[hash] = game;
		}
	}

	@Override
	public void removerGame(String gameNome) {
		int hash = GameHelper.getGameHash(gameNome);

		if (gameHashTable[hash] != null) {
			Game game = consultarGame(gameNome);
			Game head = gameHashTable[hash];
			Game atual = head;
			Game anterior = null;
			Game proximo = atual.getProximoGame();

			while (atual != null && game != null) {
				if (game.compareTo(atual) == 0) {
					if (anterior != null) {
						anterior.setProximoGame(proximo);

						gameHashTable[hash] = head;
					} else {
						gameHashTable[hash] = null;
					}

					return;
				}

				anterior = atual;
				atual = atual.getProximoGame();
				proximo = atual.getProximoGame();
			}
		}
	}

	@Override
	public Game consultarGame(String gameNome) {
		int hash = GameHelper.getGameHash(gameNome);

		Game game = gameHashTable[hash];

		while (game != null) {
			if (game.getNome().equals(gameNome)) {
				return game;
			}

			game = game.getProximoGame();
		}

		return null;
	}

	@Override
	public List<Game> consultarGamesPorData(LocalDate data) {
		List<Game> games = new ArrayList<>();

		for (int i = 0; i < gameHashTable.length; i++) {
			if (gameHashTable[i] == null) {
				continue;
			}

			Game game = gameHashTable[i];
			while (game != null) {
				if (game.getData().equals(data)) {
					games.add(game);
				}

				game = game.getProximoGame();
			}
		}

		return games;
	}

	@Override
	public List<Game> consultarGamesPorLink(String link) {
		List<Game> games = new ArrayList<>();

		for (int i = 0; i < gameHashTable.length; i++) {
			if (gameHashTable[i] == null) {
				continue;
			}

			Game game = gameHashTable[i];
			while (game != null) {
				if (game.getLink().equals(link)) {
					games.add(game);
				}

				game = game.getProximoGame();
			}
		}

		return games;
	}

	// inútil, já que a hashtable sempre estará ordenada
	@Override
	public List<Game> consultarTodosGamesOrdenado() {
		List<Game> games = new ArrayList<>();

		for (int i = 0; i < gameHashTable.length; i++) {
			if (gameHashTable[i] == null) {
				continue;
			}

			Game game = gameHashTable[i];
			while (game != null) {
				games.add(game);

				game = game.getProximoGame();
			}
		}

		return games;
	}

	@Override
	public List<Game> consultarTodos() {
		List<Game> games = new ArrayList<>();

		for (int i = 0; i < gameHashTable.length; i++) {
			if (gameHashTable[i] == null) {
				continue;
			}

			Game game = gameHashTable[i];
			while (game != null) {
				games.add(game);

				game = game.getProximoGame();
			}
		}

		return games;
	}
}
