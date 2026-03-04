package Decorator.decorator;

import Decorator.Texte;

public class ItaliqueDecorator extends TextDecorator {
    
    public ItaliqueDecorator(Texte texte) {
        super(texte);
    }

    @Override
    public String afficher() {
        return "<i>" + super.afficher() + "</i>";
    }
}
