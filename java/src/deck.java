import java.util.ArrayList;
import java.util.Collections;

public class deck {
    String[] naipes = {"Espadilha", "Ouros", "Copas", "Paus"};
    String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    ArrayList<Card> cartas = new ArrayList<Card>();


    deck() {
        for(String naipe : naipes) {
            for(String valor : valores) {
               cartas.add(new Card(valor, naipe));
            }
        }
    }
    public void suffleDeck() {
//        como isso funciona ?
        Collections.shuffle(this.cartas);
    }

    public ArrayList<Card> reciveCard(int countToSend) {
        ArrayList<Card> toSend = new ArrayList<Card>();
        for(int i = 0; i < countToSend ; i++) {
            if(!cartas.isEmpty()) {
                toSend.add(cartas.removeFirst());
            }
        }

        return toSend;
    }

    public void showRemaing() {

        System.out.println(this.cartas);
    }
}
