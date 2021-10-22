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
			Game gameJaExistente = this.consultarGame(game.getNome());

			if (gameJaExistente == null) {
				Game head = gameHashTable[hash];
				game.setProximoGame(head);

				gameHashTable[hash] = game;
			} else {
				System.err.println("Já existe um game com este nome!");
			}
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
			Game proximo = null;

			while (atual != null && game != null) {
				if (game.compareTo(atual) == 0) {
					if (anterior != null) {
						anterior.setProximoGame(proximo);

						gameHashTable[hash] = head;

						System.out.println("Game removido com sucesso!");
					} else {
						gameHashTable[hash] = null;

						System.out.println("Game removido com sucesso!");
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
					try {
						Game gameSemEncadeamento = (Game) game.clone();
						gameSemEncadeamento.setProximoGame(null);
						games.add(gameSemEncadeamento);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
					try {
						Game gameSemEncadeamento = (Game) game.clone();
						gameSemEncadeamento.setProximoGame(null);
						games.add(gameSemEncadeamento);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				game = game.getProximoGame();
			}
		}

		return games;
	}

	@Override
	public List<Game> consultarTodosGamesOrdenado() {
		List<Game> games = new ArrayList<>();

		for (int i = 0; i < gameHashTable.length; i++) {
			if (gameHashTable[i] == null) {
				continue;
			}

			Game startGame = gameHashTable[i];
			Game endGame = gameHashTable[i];
			while (endGame != null) {
				endGame = endGame.getProximoGame();
			}
			this.ordenar(startGame, endGame);

			Game game = gameHashTable[i];
			while (game != null) {
				try {
					Game gameSemEncadeamento = (Game) game.clone();
					gameSemEncadeamento.setProximoGame(null);
					games.add(gameSemEncadeamento);
				} catch (Exception e) {
					e.printStackTrace();
				}

				game = game.getProximoGame();
			}
		}

		return games;
	}

	private void ordenar(Game startGame, Game endGame) {
		if (startGame == null || startGame == endGame || startGame == endGame.getProximoGame()) {
			return;
		}

		Game pivo = particionarLista(startGame, endGame);
		this.ordenar(startGame, pivo);

		if (pivo != null && pivo == startGame) {
			this.ordenar(pivo.getProximoGame(), endGame);
		} else if (pivo != null && pivo.getProximoGame() != null) {
			this.ordenar(pivo.getProximoGame().getProximoGame(), endGame);
		}
	}

	private Game particionarLista(Game startGame, Game endGame) {
		if (startGame == endGame || startGame == null || endGame == null) {
			return startGame;
		}

		Game pivo = startGame;
		Game atual = startGame;
		Game gamePivo = endGame;

		while (startGame != endGame) {
			if (startGame.compareTo(gamePivo) < 0) {
				pivo = atual;
				String temp = atual.getNome();
				atual.setNome(startGame.getNome());
				startGame.setNome(temp);
				atual = atual.getProximoGame();
			}
			startGame = startGame.getProximoGame();
		}

		String temp = atual.getNome();
		atual.setNome(gamePivo.getNome());
		endGame.setNome(temp);

		return pivo;
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
				try {
					Game gameSemEncadeamento = (Game) game.clone();
					gameSemEncadeamento.setProximoGame(null);
					games.add(gameSemEncadeamento);
				} catch (Exception e) {
					e.printStackTrace();
				}

				game = game.getProximoGame();
			}
		}

		return games;
	}
}
