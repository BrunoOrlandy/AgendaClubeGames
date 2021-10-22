package AgendaClubeGames;

import java.time.LocalDate;
import java.util.List;

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
			Game atual = gameHashTable[hash];
			Game anterior = null;

			while (head != null) {
				if (game.compareTo(atual) == 0) {
					if (anterior != null) {
						anterior.setProximoGame(game);
					} else {
						gameHashTable[hash] = null;
					}

					return;
				}

				anterior = atual;
				atual = atual.getProximoGame();
			}
		}
	}

	@Override
	public Game consultarGame(String nome) {
		Int hash = GameHelper.getGameHash(nome);

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarGamesPorData(LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game consultarGamePorLink(String link) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarTodosGamesOrdenado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGameMesmaPosicao() {
		// TODO Auto-generated method stub
		return false;
	}
}
