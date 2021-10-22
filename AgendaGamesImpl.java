package AgendaClubeGames;

import java.time.LocalDate;
import java.util.List;

public interface AgendaGamesImpl {

	void inserirGame(Game game);

	void removerGame(String gameNome);

	Game consultarGame(String nome);

	List<Game> consultarTodosGamesOrdenado();
	
	List<Game> consultarTodos();
	
	List<Game> consultarGamesPorData(LocalDate data);
	
	Game consultarGamePorLink(String link);
	
	boolean isGameMesmaPosicao();

	// List<Game> likeGame
	// informado "Lo" busca todos os games que tem

	// List<Game> consultarGamesAcontecendo
	// data atual, verifica se o game ja aconteceu ou n�o

	// List<Game> consultarGamesHoje
	// data atual e hora atual
	// verifica se tem um game hoje e a hora ja ultrapassou o currentHour

}
