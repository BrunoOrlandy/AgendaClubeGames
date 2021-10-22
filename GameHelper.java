public static class GameHelper {
    public static Int getGameHash(String gameNome) {
        return gameNome.toLowerCase().charAt(0) - 97;
    }
}