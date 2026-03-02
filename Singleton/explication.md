# Singleton


**Problème** :

Dans une application de gestion d’équipe de football, il est essentiel de conserver toutes les informations importantes de l’équipe dans un seul et unique endroit.

Si chaque partie du code pouvait créer sa propre instance d’une classe qui gère l’équipe, alors :

- La liste des joueurs pourrait être différente selon les modules, ce qui rendrait les données incohérentes.

- Le nom de l’entraîneur pourrait diverger d’un composant à l’autre.

- Les changements effectués dans une partie du programme ne seraient pas visibles ailleurs, rendant difficile toute coordination globale.

Le pattern Singleton résout ce problème en garantissant qu’il n’existe qu’une seule instance de la classe qui gère l’équipe de football, accessible partout dans l’application.

