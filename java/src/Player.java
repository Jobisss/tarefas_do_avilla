import java.util.ArrayList;

public class Player {
    String nome;
    ArrayList<Card> cards;
    Double cash;

    Boolean lose;

    Player(String nome, ArrayList<Card> cards, Double cash) {
        this.nome = nome;
        this.cards = cards;
        this.cash = cash;
        this.lose = false;
    }

    Boolean reciveCard(Card newCard){
        this.cards.add(newCard);
        int total = this.cards
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element.valor, Integer::sum);

        if(total > 21) {
            System.out.println("Estourou 21 !");
            this.lose = true;
        }

        return this.lose;
    }
}
