package AgendaClubeGames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Game implements Comparable<Game> {

	private String nome;
	private LocalDate data;
	private LocalTime horario;
	private CategoriaEnum categoria;
	private String link;

	private Game proximoGame;

	public Game() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Game getProximoGame() {
		return proximoGame;
	}

	public void setProximoGame(Game game) {
		this.proximoGame = game;
	}

	@Override
	public int compareTo(Game other) {
		return this.nome.compareTo(other.getNome());
	}
}
