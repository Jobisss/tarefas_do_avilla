public class carta {
    String valor;
    String naipe;

    carta(String valor, String naipe) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String toString() {
        return STR."\{this.valor} de \{this.naipe}";
    }
}
