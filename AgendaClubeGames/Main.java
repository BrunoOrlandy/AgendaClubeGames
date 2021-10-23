package AgendaClubeGames;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class Main {

	public static AgendaGames agendaOperacoes = new AgendaGames();

	public static void main(String[] args) {

		int opcao = 10;
		Scanner entrada = new Scanner(System.in);
		Main m = new Main();
		do {
			printMenu();

			int op = entrada.nextInt();
			switch (op) {
			case 1:
				agendaOperacoes.inserirGame(menuCadastrarGame());
				break;
			case 2:
				System.out.println("Todos os games ineridos:");
				printDados(agendaOperacoes.consultarTodos());
				break;
			case 3:
				System.out.println("Informe o link para pesquisar o game:");
				String linkInformado = entrada.next();
				printDados(agendaOperacoes.consultarGamesPorLink(linkInformado));
				break;
			case 4:
				System.out.println("Informe a data do game:");
				String dataGame = entrada.next();
				agendaOperacoes.consultarGamesPorData(LocalDate.parse(dataGame));
				break;
			case 5:
				System.out.println("Informe o nome do game a ser removido:");
				String nomeGame = entrada.next();
				agendaOperacoes.removerGame(nomeGame);
				break;
			case 0:
				System.out.println("Fechando agenda de games");
				System.exit(0);
				break;
			default:
				printMenu();
			}

		} while (opcao != 0);
	}

	public static Game menuCadastrarGame() {
		Game novoGame = new Game();
		Scanner scannerGame = new Scanner(System.in);

		System.out.println("///////-Cadastro de Game-////////");
		System.out.println("Informe o nome do game:");
		novoGame.setNome(scannerGame.nextLine());

		System.out.println("Informe a data que o game ocorrerá: (dd/MM/yyyy)");
		novoGame.setData(LocalDate.parse(scannerGame.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		System.out.println("Informe o horário que o game ocorrerá (00:00)");
		novoGame.setHorario(LocalTime.parse(scannerGame.nextLine()));

		System.out.println("Informe a categoria:");
		CategoriaEnum.getListaCategoriaEnum();
		novoGame.setCategoria(mostrarMenuCategoria(scannerGame.nextLine()));

		System.out.println("Informe o link do evento");
		String link = scannerGame.nextLine();
		novoGame.setLink(link);

		System.out.println("Game :" + novoGame.getNome() + " foi cadastrado");
		return novoGame;
	}

	public static CategoriaEnum mostrarMenuCategoria(String op) {

		switch (op) {
		case "1":
			return CategoriaEnum.FPS;
		case "2":
			return CategoriaEnum.MMO;
		case "3":
			return CategoriaEnum.MMORPG;
		case "4":
			return CategoriaEnum.MOBA;
		case "5":
			return CategoriaEnum.RPG;
		case "6":
			return CategoriaEnum.RTS;
		}

		return null;
	}

	public static void printDados(List<Game> gamesConsultados) {
		for (Game game : gamesConsultados) {
			System.out.println(game.toString());
		}
	}

	public static void printMenu() {
		System.out.println("//////////////////////////");
		System.out.println(" Agenda de clube de games ");
		System.out.println("Escolha uma opção:");
		System.out.println("1- Cadastrar um game:");
		System.out.println("2- Consultar todos Games:");
		System.out.println("3- Cosultar game por link:");
		System.out.println("4- Consultar todos os game por data:");
		System.out.println("5- Remover game por nome:");
		System.out.println("0- Sair");
		System.out.println("//////////////////////////");
	}
}
