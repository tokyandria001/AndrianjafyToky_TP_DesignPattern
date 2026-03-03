# Strategy

## Problème
Lorsqu'une classe doit exécuter un comportement qui peut varier selon le contexte, on a tendance à utiliser des structures conditionnelles (if, switch) pour choisir l'algorithme à appliquer.

Avec le temps, ces conditions deviennent nombreuses, le code devient difficile à maintenir, et toute modification nécessite de modifier la classe principale. Cela viole le principe Open*Closed (ouvert à l'extension, fermé à la modification).

Le pattern Strategy permet de séparer les différents algorithmes d'une classe afin de les rendre interchangeables sans modifier le code existant.

## Principe de fonctionnement

Le principe consiste à : 
1. Définir une interface commune représentant un comportement.
2. Créer plusieurs classes qui implémentent cette interface.
3. Utiliser la composition dans la classe principale pour déléguer le comportement à un objet stratégie.
4. Permettre le changement de stratégie dynamiquement à l'exécution.

Ainsi, le comportement devient indépendant de la classe qui l'utilise.

## Structure
Dans mon exemple de calcul des frais de livraison : 

- ***DeliveryInterface*** -> Définit la méthode commune calculateFee().
- ***LocalDelivery***, ***NationalDelivery***, ***ExpressDelivery*** -> Contiennent chacune un algorithme différent de calcul.
- ***Order*** -> Possède une référence vers DeliveryStrategy et délègue le calcul des frais.

Le contexte ne connaît pas les détails des stratégies, il travaille uniquement avec l'interface.

Exécution du code : 
```bash
javac .\Strategy\Main.java 
java Strategy.Main
```
## Avantages

- Respect du principe Open/Closed.
- Suppresion des conditions multiples dans la classe principale.
- Code plus lisible et mieux structuré.
- Possibilité de changer de comportement dynamiquement.
- Meilleure testabilité (chaque stratégie peut être testée séparément).

## Inconvénients

- Augmentation du nombre de classes.
- Le client doit connaître les différentes stratégies disponibles.
- Peut être excessif si les variations d'algorithmes sont très simples.

## Cas d'usage réel possible

Le pattern Strategy est utilisé dans de nombreux cas réels : 

- Méthodes de paiement (carte bancaire, virement, portefeuille numérique).
- Algorithme de tri.
- Systèmes de recommendations avec différents critères.

Il est particulièrement utile lorsque le comportement doit pouvoir évoler sans modifier la classe principale.