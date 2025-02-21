import java.util.ArrayList;

public class BlackJack {

    deck blackJackDeck = new deck();
    ArrayList<Player> players;
    int playerCount;
    int countOfBots;
    BlackJack(int playerCount) {
        if(playerCount <= 1) {
            throw new RuntimeException("O jogo precisa ter ao menos 2 jogadores");
        }
        this.playerCount = playerCount;
        this.countOfBots = playerCount - 1;
    }
    void startGame () {

        Player player = new Player("player name", this.blackJackDeck.reciveCard(2), 20.0);
        this.players.add(player);
        for(int i = 0; i < countOfBots; i++) {
            Bot bot = new Bot(this.blackJackDeck.reciveCard(2));
            this.players.add(bot);
        }

    }





}
