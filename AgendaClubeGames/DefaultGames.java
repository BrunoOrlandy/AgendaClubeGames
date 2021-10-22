package AgendaClubeGames;

import java.time.LocalDate;
import java.time.LocalTime;

public class DefaultGames {

	public static void main(String[] args) {

	}

	public static Game getLol() {
		Game lol = new Game();
		lol.setCategoria(CategoriaEnum.MMORPG);
		lol.setData(LocalDate.now());
		lol.setHorario(LocalTime.parse("12:00"));
		lol.setLink("https://lolesports.com/");
		lol.setNome("Worlds 2021");

		return lol;
	}

	public static Game geDs() {
		Game ds = new Game();
		ds.setCategoria(CategoriaEnum.RPG);
		ds.setData(LocalDate.now().plusDays(7));
		ds.setHorario(LocalTime.parse("20:00"));
		ds.setLink("https://www.brasilgameshow.com.br/darkSouls");
		ds.setNome("Dark Souls");

		return ds;
	}

	public static Game getAge() {
		Game age = new Game();
		age.setCategoria(CategoriaEnum.RTS);
		age.setData(LocalDate.now());
		age.setHorario(LocalTime.parse("14:00"));
		age.setLink("https://www.brasilgameshow.com.br/ageOfEmpires2");
		age.setNome("Age 2021");

		return age;
	}

	public static Game getCs() {
		Game cs = new Game();
		cs.setCategoria(CategoriaEnum.FPS);
		cs.setData(LocalDate.now().plusDays(1));
		cs.setHorario(LocalTime.parse("10:00"));
		cs.setLink("https://www.brasilgameshow.com.br/Cs_go2021");
		cs.setNome("CS:GO 2021");

		return cs;
	}

	public static Game getWow() {
		Game wow = new Game();
		wow.setCategoria(CategoriaEnum.MMO);
		wow.setData(LocalDate.now().plusMonths(1));
		wow.setHorario(LocalTime.parse("16:00"));
		wow.setLink("https://worldofwarcraft.com/pt-br/esports/arena");
		wow.setNome("Wow 2021");

		return wow;
	}
}
