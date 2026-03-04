package Decorator.decorator;

import Decorator.Texte;

public abstract class TextDecorator implements Texte {
    protected Texte texte;

    public TextDecorator(Texte texte) {
        this.texte = texte;
    }

    @Override
    public String afficher() {
        return texte.afficher();
    }
    
}
