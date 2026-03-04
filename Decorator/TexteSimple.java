package Decorator;

public class TexteSimple implements Texte {
    private String texte;

    public TexteSimple(String texte) {
        this.texte = texte;
    }

    @Override
    public String afficher() {
        return texte;
    }
}
