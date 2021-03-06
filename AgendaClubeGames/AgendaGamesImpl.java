package AgendaClubeGames;

import java.time.LocalDate;
import java.util.List;

public interface AgendaGamesImpl {

	void inserirGame(Game game);

	void removerGame(String gameNome);

	Game consultarGame(String gameNome);

	List<Game> consultarTodosGamesOrdenado();

	List<Game> consultarTodos();

	List<Game> consultarGamesPorData(LocalDate data);

	List<Game> consultarGamesPorLink(String link);

	// List<Game> likeGame
	// informado "Lo" busca todos os games que tem

	// List<Game> consultarGamesAcontecendo
	// data atual, verifica se o game ja aconteceu ou não

	// List<Game> consultarGamesHoje
	// data atual e hora atual
	// verifica se tem um game hoje e a hora ja ultrapassou o currentHour
}
