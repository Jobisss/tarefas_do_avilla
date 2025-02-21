import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    String nome;
    ArrayList<Card> cards;
    Double cash;

    Boolean lose;

    Player(ArrayList<Card> cards) {
        this.nome = "Bot";
        this.cards = cards;
        this.cash = 20.0;
        this.lose = false;
    }

    Player(String nome, ArrayList<Card> cards, Double cash) {
        this.nome = nome;
        this.cards = cards;
        this.cash = cash;
        this.lose = false;
    }

    void reciveCards(ArrayList<Card> newCards){
        this.cards.addAll(newCards);
    }

    Boolean getLose() {
        return this.lose;
    }

    void computeValue() {
        this.cards.sort((card1, card2) -> Integer.compare(card2.getValue(), card1.getValue()));

        int total = this.cards
                .stream()
                .reduce(0, (subtotal, element) -> {
                    if(element.getValue() == 0 ) {
                        if(subtotal >= 11) {
                            return subtotal + 1;
                        }else {
                            return  subtotal + 10;
                        }
                    }
                    return subtotal + element.getValue();
                }, Integer::sum);

        if(total > 21) {
            System.out.println("Estourou 21 !");
            this.lose = true;
        }
    }
}
