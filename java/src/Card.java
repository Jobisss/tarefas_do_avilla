public class Card {
    String valor;
    String naipe;

    Card(String valor, String naipe) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String toString() {
        return STR."\{this.valor} de \{this.naipe}";
    }

    public Boolean isNumberString() {
        try {
            Integer.parseInt(this.valor);
           return true;
        } catch (NumberFormatException e ) {
            return false;
        }
    }
    public int getValue(int actualValue) {
        if(this.isNumberString()) {
            return Integer.parseInt(this.valor);
        }else {
            if(this.valor.equals("K")  || this.valor.equals("J") || this.valor.equals("Q")) {
                return 10;
            }else {

            }
        }
    }
}
