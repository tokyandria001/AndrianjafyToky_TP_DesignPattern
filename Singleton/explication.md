# Singleton

## Problème

Dans certaines situations, il est essentiel qu'une classe ne possède qu'une seule instance dans toute l'application.

Par exemple : 

- une configuration globale
- un gestionnaire de connexion
- un journal d'événements (logger)
- ou dans notre exemple, une équipe de football unique

Sans mécanisme particulier, il serait possible de créer plusieurs objets différents avec `new`, ce qui pourrait provoquer des incohérences ou des conflits de données.

Le Singleton garantit qu'il n'existe qu'un seul objet accessible.

---

## Principe de fonctionnement

Le pattern repose sur 3 idées fondamentales : 

1. Le contructeur est privé -> impossible de créer l'objet avec new depuis l'exérieur.
2. Une variable statique conserve l'unique instance.
3. Une méthode statique (``getInsance()``) permet d'accéder à cette instance.

---

## Structure

```java
class FootballTeam
```
Elle contient : 

- `private static FootballTeam instance;` -> l'unique instance
- un constructeur privé
- une méthode publique `getInstance()`

Les données internes :
```java
private List<String> joueurs;
private String coach;
```
Ces attributs représentent l'état partagé unique.

Le client : 

```java
public class SingleonExample
```
Dans le main : 

```java
FootballTeam team1 = FootballTeam.getInstance();
FootballTeam team2 = FootballTeam.getInstance();
```
Même si on appelle getInstance() deux fois, tem1 et team2 pointent vers le même objet.

On le voit car : 

- les joueurs ajoués via team1 sont visibles via team2.
- le coach défini via team2 est visible via team1

---

## Avantages

- Garantie d'une instane unique
- Point d'accès global à l'objet
- Evite les incohérences d'état
- Contrôle centralisé des ressources

---

## Inconvénients

- Peut compliquer les tests unitaires.
- Peut violer le principe de responsabilité unique si mal utilisé.

---

## Cas d'usage réel possible

- Pool de connexions à une base de données
- Gestionnaire de score ou paramètres globaux d'un jeu