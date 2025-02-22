import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    deck blackJackDeck = new deck();
    ArrayList<Player> players = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
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
        System.out.println("Bem vindo ao BlackJack !");

        System.out.println("Qual o seu nome ? ");

        String nomeJogador = this.scanner.nextLine();

        Player player = new Player(nomeJogador, this.blackJackDeck.reciveCard(2), 20.0);
        this.players.add(player);
        for(int i = 0; i < countOfBots; i++) {
            Bot bot = new Bot(this.blackJackDeck.reciveCard(2));
            this.players.add(bot);
        }

        boolean haveLooser = false;
        while(!haveLooser) {
            Optional<Player> looser = playRound();

            if(looser.isPresent()) {
                System.out.println(STR."O jogador \{looser.get().nome} perdeu");
                looser.get().listCards();
            }

            haveLooser = true;
        }


    }


    public Optional<Player> playRound() {
        Random random = new Random();
        for (Player player : this.players) {
            if (random.nextInt(100) > 50) {
                player.reciveCards(this.blackJackDeck.reciveCard(1));
                return Optional.of(player);
            }
        }

        return Optional.empty();
    }
}
