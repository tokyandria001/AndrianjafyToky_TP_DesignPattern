package Decorator;

import Decorator.decorator.GrasDecorator;
import Decorator.decorator.ItaliqueDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Texte simple :");
        Texte t1 = new TexteSimple("Bonjour");
        System.out.println(" " + t1.afficher());

        System.out.println("Texte en gras :");
        Texte t2 = new GrasDecorator(new TexteSimple("Bonjour"));
        System.out.println(" " + t2.afficher());

        System.out.println("Texte en italique :");
        Texte t3 = new ItaliqueDecorator(new TexteSimple("Bonjour"));
        System.out.println(" " + t3.afficher());
    }

}
