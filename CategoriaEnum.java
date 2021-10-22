package AgendaClubeGames;

import java.util.Arrays;
import java.util.List;

// pode ser criada uma nova lista que iniciar com valores estaticos
// e contem a opção "outros" ao selecionar outros 
// recebe um nome informado pelo usuario e é adicionado na lista
// para poder ser selecionado quando for cadastrar uma novo game 

public enum CategoriaEnum {

	FPS("1", "First person shooter"), RPG("2", "Role playing game"), MOBA("3", "Multi-player online battle arena"),
	MMO("4", "Massively multiplayer online"), MMORPG("5", "Massively Multiplayer Online Role-Playing Game"),
	RTS("6", "Real-time strategy");

	private String id;
	private String name;

	private CategoriaEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static void getListaCategoriaEnum() {
		Arrays.asList(CategoriaEnum.values())
				.forEach(categoria -> System.out.println(categoria.getId() + "- " + categoria.getName()));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
