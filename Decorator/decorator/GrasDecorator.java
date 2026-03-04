package Decorator.decorator;

import Decorator.Texte;

public class GrasDecorator extends TextDecorator {
    public GrasDecorator(Texte texte) {
        super(texte);
    }

    @Override
    public String afficher() {
        return "<b>" + super.afficher() + "</b>";
    }
}
