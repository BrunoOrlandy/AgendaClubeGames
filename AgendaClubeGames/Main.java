package AgendaClubeGames;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static AgendaGames agendaOperacoes;

	public static void main(String[] args) {
		agendaOperacoes = new AgendaGames();

		Game lol = new Game();
		lol.setCategoria(CategoriaEnum.MMORPG);
		lol.setLink("https://lolesports.com/%22");
		lol.setNome("Worlds 2021");

		agendaOperacoes.inserirGame(lol);
		
		Game lol2 = new Game();
		lol2.setCategoria(CategoriaEnum.MMORPG);
		lol2.setLink("https://lolesports.com/%22");
		lol2.setNome("Worlds 2020");

		agendaOperacoes.inserirGame(lol2);
		agendaOperacoes.removerGame("Worlds 2021");
		
		Game ds = new Game();
		ds.setCategoria(CategoriaEnum.RPG);
		ds.setLink("https://www.brasilgameshow.com.br/darkSouls%22");
		ds.setNome("Dark Souls");
		agendaOperacoes.inserirGame(ds);
		
		Game age = new Game();
		age.setCategoria(CategoriaEnum.RTS);
		age.setLink("https://www.brasilgameshow.com.br/ageOfEmpires2%22");
		age.setNome("Age 2021");
		agendaOperacoes.inserirGame(age);
		
		List<Game> consultados = agendaOperacoes.consultarTodos();
		Game porNome = agendaOperacoes.consultarGame("Dark Souls");

		// System.out.println("//////////////////////////");
		// System.out.println(" Agenda de clube de games ");
		// System.out.println("Escolha uma opção para:");
		// System.out.println("1- Cadastrar um game:");
		// System.out.println("2- Cosultar um game:");
		// System.out.println("3- Consultar todos Games:");
		// System.out.println("4- Remover um game da agenda:");
		// System.out.println("0- Sair");
		// System.out.println("//////////////////////////");

		// Scanner entrada = new Scanner(System.in);
		// int opcao = entrada.nextInt();
		// switch (opcao) {
		// case 1:
		// agendaOperacoes.inserirGame(menuCadastrarGame());
		// break;
		// case 2:
		// // agendaOperacoes.inserirGame();
		// break;
		// case 3:
		// // agendaOperacoes.inserirGame();
		// break;
		// case 4:
		// // agendaOperacoes.inserirGame();
		// break;
		// case 0:
		// System.out.println("Fechando agenda de games");
		// System.exit(0);
		// break;
		// }
	}

	public static Game menuCadastrarGame() {
		Game novoGame = new Game();
		Scanner scannerGame = new Scanner(System.in);

		System.out.println("///////-Cadastro de Game-////////");
		System.out.println("Informe o nome do game:");
		novoGame.setNome(scannerGame.nextLine());

		System.out.println("Informe a data que o game ocorrerá: (formato dd/MM/yyyy sem barras");
		// novoGame.setData(LocalDate.parse(scannerGame.nextLine()));

		System.out.println("Informe o horário que o game ocorrerá");
		novoGame.setHorario(LocalTime.parse(scannerGame.nextLine()));

		System.out.println("Informe a Categoria:");
		// mostrarMenuCategoria(scannerGame);
		// novoGame.setHorario(LocalTime.parse(scannerGame.nextLine()));

		System.out.println("Informe o link do evento");
		novoGame.setLink(scannerGame.nextLine());
		return novoGame;
	}

	public static CategoriaEnum mostrarMenuCategoria(Scanner scannerGame) {

		CategoriaEnum.getListaCategoriaEnum();

		switch (scannerGame.nextInt()) {
		case 1:
			return CategoriaEnum.FPS;
		case 2:
			return CategoriaEnum.MMO;
		case 3:
			return CategoriaEnum.MMORPG;
		case 4:
			return CategoriaEnum.MOBA;
		case 5:
			return CategoriaEnum.RPG;
		case 6:
			return CategoriaEnum.RTS;
		default:
			System.out.println("Valor inválido");
			break;
		}
		return null;
	}
}