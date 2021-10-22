package AgendaClubeGames;

import java.time.LocalDate;
import java.util.List;

public class AgendaGames implements AgendaGamesImpl {

	private Game[] gameHashTable = new Game[27];

	@Override
	public void inserirGame(Game game) {
		Int hash = GameHelper.getGameHash(game.getNome());

		if (gameHashTable[hash] == null) {
			gameHashTable[hash] = game;
		} else {
			Game head = gameHashTable[hash];
			game.setProximoGame(head);

			gameHashTable[hash] = game;
		}
	}

	@Override
	public void removerGame(Game game) {
		Int hash = GameHelper.getGameHash(game.getNome());

		if (gameHashTable[hash] != null) {

		}
	}

	@Override
	public List<Game> consultarGame(String nome, LocalDate Data) {
		Int hash = GameHelper.getGameHash(nome);

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarGame(String nome) {
		Int hash = GameHelper.getGameHash(nome);

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarGamePorData(LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game consultarGamePorLink(String link) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGameMesmaPosicao() {
		// TODO Auto-generated method stub
		return false;
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

}
