# Factory Method

## Problème

Lorsqu'un programme doit créer des objets sans connaître précisement leur type concret à l'avance, le code peut devenir fortement dépendant des classes instanciées.

Cela rend l'application difficile à modifier ou à faire évoluer.

Le pattern ``Factory Method`` permet de déléguer la création des objets à des sous-classes spécialisées, évitant ainsi de lier le code principal à des classes concrètes.

---

## Principe de fonctionnement

Le principe est simple :
au lieu d'instancier directement un objet avec ``new``, on appelle une méthode de fabrication (factory method).

Cette méthode est déclarée dans une classe abstraite, puis redéfinie dans des sous-classes pour créer des objets spécifiques.

Ainsi : 

- Le client manipule une abstraction.
- La création réelle est déléguée à une factory concrète.

Le code client ne sait pas quelle classe exacte est créée, il travaille uniquement avec l'interface commune.

---

## Structure

**Product (Produit)**
```java
public interface Rocket {
    void launch();
}
```
C'est l'interface commune à tous les objets créés.

**Concrete Products (Produits concrets)**

```java
public class CargoRocket implements Rocket{
    @Override
    public void launch(){
        System.out.println("Lancement d'une fusée Cargo pour transporter du matériel !");
    }
}


public class PassengerRocket implements Rocket {
    @Override
    public void launch(){
        System.out.println("Lancement de la fusée Passagers pour transporter des astronautes !");
    }
}

```

Ce sont les implémentations réelles du produit.
Chaque type de fusée possède son propre comportement.

**Creator (Créateur abstrait)**
```java
public abstract class RocketFactory {
    public abstract Rocket createRocket();
}
```
Déclare la méthode de fabrication createRocket() sans préciser quel objet sera créé.

**Concrete Creators (Créateurs concrets)**
```java
public class CargoRocketFactory extends RocketFactory
public class PassengerRocketFactory extends RocketFactory
```

Chaque factory décide quel type de fusée instancier.

**Client**
```java
public class FactoryMethodExample
```

Utilisation par le client
```java
RocketFactory factory = new CargoRocketFactory();
Rocket rocket = factory.createRocket();
rocket.launch();
```

Le client ne connaît que :

- Rocket

- RocketFactory

Il n’utilise jamais `new CargoRocket()` directement.

Le client manipule uniquement : 

- l'abstraction Rocket
- l'abstraction RocketFactory

La création est déléguée aux sous-classes :

- CargoRocketFactory
- PassengerRocketFactory

Donc le principe fondamental du Factory Method est respecté : 
Le client ne connaît pas la classe concrète de l'objet qu'il utilise.

---

## Avantages

- Réduction du couplage entre le code client et les classes concrètes

- Respect du principe Open/Closed (ouvert à l’extension, fermé à la modification)

- Centralisation de la création des objets

---

## Inconvénients

- Augmentation du nombre de classes

- Structure plus complexe pour un petit programme

- Nécessite une bonne compréhension

---

## Cas d’usage réel possible

Le pattern Factory Method est utilisé quand un système doit produire plusieurs types d’objets liés mais que le client ne doit pas connaître leur implémentation concrète.

Exemples :

Création de différentes interfaces utilisateur pour desktop, mobile ou web

Instanciation de différents types de documents (PDF, Word, Excel)

Gestion de différents types de connexions réseau (HTTP, FTP, WebSocket)