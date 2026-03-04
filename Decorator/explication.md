# Decorator

## Problème

Lorsqu'un programme doit ajouter de nouvelles fonctionnalités à des objets existants, l'approche traditionnelle (l'héritage) crée rapidement une explosion de classes.

Par exemple, si vous avez du texte et souhaitez le formater de différentes manières (gras, italique, souligné), vous devriez créer :
- TexteGras
- TexteItalique
- TexteSouligné
- TexteGrasItalique
- ...

Cela rend l'application difficile à modifier ou à faire évoluer.

Le pattern ``Decorator`` permet d'ajouter dynamiquement des responsabilités à des objets, sans créer de nouvelles sous-classes, en utilisant la composition plutôt que l'héritage.

---

## Principe de fonctionnement

Au lieu de créer des sous-classes pour chaque variante, on crée des **emballeurs** (décorateurs).

Chaque décorateur : 

- Implémente la même interface que l'objet original.
- Encapsule l'objet original en gardant une référence.
- Peut ajouter du comportement avant/après la délégation.

Ainsi : 

- Les décorateurs s'empilent dynamiquement
- On obtient différentes combinaisons sans créer des dizaines de classes.

---

## Structure

```java
public interface Texte {
    String afficher();
}
```
C'est l'interface commune à tous les objets (original et décorés).

```java
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
```
C'est limplémentation originale du composant.
C'est l'objet qu'on veut décorer.

```java
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
```
Déclare la structure commune pour tous les décorateurs.
Encapsule un objet Texte. Délègue le ravail à l'objet encapsulé.

```java
public class GrasDecorator extends TextDecorator {
    public GrasDecorator(Texte texte) {
        super(texte);
    }

    @Override
    public String afficher() {
        return "<b>" + super.afficher() + "</b>";
    }
}
```
Chaque décorateur ajoute une fonctionnalité spécifique. Ils redéfinissent les méthodes pour ajouter du comportement.

```java
public class Main
```
Utilisation par le client

```java
System.out.println("Texte simple :");
        Texte t1 = new TexteSimple("Bonjour");
        System.out.println(" " + t1.afficher());

        System.out.println("Texte en gras :");
        Texte t2 = new GrasDecorator(new TexteSimple("Bonjour"));
        System.out.println(" " + t2.afficher());

        System.out.println("Texte en italique :");
        Texte t3 = new ItaliqueDecorator(new TexteSimple("Bonjour"));
        System.out.println(" " + t3.afficher());
```

Le client ne connaît que 2 choses : 

- L'interface Texte
- La classe TexteSimple pour créer l'objet initial

Les décorateurs s'empilent dynamiquement. Le client les utilise sans les connaître, il travaille uniquement avec l'interface Texte.

Donc le principe du Decorator est respecté : le client envoie des messages à l'interface, sans savoir quels décorateurs sont appliqués.

```bash
javac .\Decorator\Main.java
java Decorator.Main
```

---

## Avantages

- Pas d'explosion de classes : N décorateurs pour N options au lieu de 2^N classes
- Respect du principe de responsabilité unique : chaque décorateur gère une fonctionnalité
- Respect du principe Open/Closed : facile d'ajouter de nouveaux décorateurs sans modifier les existants
- Composition felxible : combinez les décorateurs dans n'importe quel ordre

---

## Inconvénients

- Augmentation du nombre de petites classes
- Nécessite une bonne compréhension de la compoition

---

## Cas d'usage réel possible

- Compression et chiffrage de fichiers
- Formatage de texte
- Interface utilisateur (ajouts des bordures, ombres, scrollbar à des composants).