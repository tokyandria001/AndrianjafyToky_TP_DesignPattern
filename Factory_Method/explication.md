# Factory Method

## Problème

Dans une agence spatiale, il faut préparer différents types de missions.  
Chaque mission nécessite un type spécifique de fusée :

- **Fusée Cargo** → transporte du matériel  
- **Fusée Passagers** → transporte des astronautes  
- **Fusée Exploration** → missions scientifiques  

Si le code créait directement les objets ainsi :

```java
Rocket r = new CargoRocket();
```

alors le client serait fortement lié aux classes concrètes.

**Conséquences :**

- Le client doit connaître toutes les fusées existantes

- Ajouter une nouvelle fusée implique de modifier le code existant

- La création d’objets est dispersée dans le programme

- Le code devient fragile et difficile à maintenir

Le problème principal : fort couplage entre le client et les classes concrètes.

Le pattern Factory Method résout ce problème en déléguant la création d’objets à des classes spécialisées appelées factories.

## Principe de fonctionnement

Le principe est simple :

- Définir une interface commune pour tous les objets (ici Rocket).

- Créer une factory abstraite qui déclare une méthode de création :

```java
createRocket()
```

- Chaque type de fusée a sa propre factory qui sait comment la construire.

- Le client demande une fusée à la factory sans connaître la classe exacte.

Résumé :
Le client demande un objet → la factory décide quel objet instancier → le code devient indépendant des classes concrètes.

## Structure

I***nterface commune***
```java
public interface Rocket {
    void launch();
}
```
Implémentations concrètes

- ***CargoRocket***

- ***PassengerRocket***

- ***ExplorationRocket***

Chaque classe définit son propre comportement :
```java
public class CargoRocket implements Rocket {
    public void launch() {
        System.out.println("Lancement d'une fusée cargo avec du matériel.");
    }
}
```

**Factory abstraite**

```java
public abstract class RocketFactory {
    public abstract Rocket createRocket();
}
```

Cette factory ne crée rien directement : elle définit seulement le contrat.

**Factories concrètes**

Chaque factory est responsable d’un type de fusée :

```java
public class CargoRocketFactory extends RocketFactory {
    public Rocket createRocket() {
        return new CargoRocket();
    }
}
```

**Autres exemples : PassengerRocketFactory, ExplorationRocketFactory.**

Utilisation par le client
```java
RocketFactory factory = new CargoRocketFactory();
Rocket rocket = factory.createRocket();
rocket.launch();
```

Le client ne connaît que :

- Rocket

- RocketFactory

Il n’utilise jamais new CargoRocket() directement.

## Avantages

Réduction du couplage entre les classes

Code plus facile à maintenir

Ajout de nouveaux types sans modifier le code existant

Respect du principe Open/Closed (ouvert à l’extension, fermé à la modification)

Centralisation de la création des objets

## Inconvénients

Augmentation du nombre de classes

Structure plus complexe pour un petit programme

Nécessite une bonne compréhension

## Cas d’usage réel possible

Le pattern Factory Method est utilisé quand un système doit produire plusieurs types d’objets liés mais que le client ne doit pas connaître leur implémentation concrète.

Exemples :

Création de différentes interfaces utilisateur pour desktop, mobile ou web

Instanciation de différents types de documents (PDF, Word, Excel)

Gestion de différents types de connexions réseau (HTTP, FTP, WebSocket)