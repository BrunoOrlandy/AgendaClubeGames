package AgendaClubeGames.Helpers;

public class GameHelper {
    public static int getGameHash(String gameNome) {
        gameNome = StringHelper.removeDiacritics(gameNome);

        int hash = gameNome.toLowerCase().charAt(0) - 97;

        if (hash < 0 || hash > 25) {
            hash = 26;
        }

        return hash;
    }
}