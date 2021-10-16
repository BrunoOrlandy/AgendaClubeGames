package AgendaClubeGames;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Game {

	private UUID id;
	private String nome;
	private LocalDate data;
	private LocalDateTime horario;
	private CategoriaEnum categoria;
	private String link;

	private Game proximoGame;
	private int posicao;

	public Game(Game proximoGame, int posicao) {
		this.id = UUID.randomUUID();
		this.proximoGame = proximoGame;
		this.posicao = 0;
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

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
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

}
