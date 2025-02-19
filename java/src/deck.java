import java.util.ArrayList;
import java.util.Collections;

public class deck {
    String[] naipes = {"Espadilha", "Ouros", "Copas", "Paus"};
    String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    ArrayList<carta> cartas = new ArrayList<carta>();


    deck() {
        for(String naipe : naipes) {
            for(String valor : valores) {
               cartas.add(new carta(valor, naipe));
            }
        }
    }
    public void suffleDeck() {
//        como isso funciona ?
        Collections.shuffle(this.cartas);
    }

    public carta[] reciveCard(int countToSend) {
        ArrayList<carta> toSend = new ArrayList<carta>();
        for(int i = 0; i < countToSend ; i++) {
            if(!cartas.isEmpty()) {
                return cartas.removeFirst();
            }
        }

        return  null;
    }

    public void showRemaing() {
        System.out.println(this.cartas);
    }
}
