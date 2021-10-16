package AgendaClubeGames;

import java.time.LocalDate;
import java.util.List;

public class AgendaGames implements AgendaGamesImpl {

	private Game head;
	private int posicao;

	@Override
	public void inserirGame(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerGame(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Game> consultarGame(String nome, LocalDate Data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> consultarGame(String nome) {
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
