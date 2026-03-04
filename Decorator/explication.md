# Decorator

## Problème

Nous avons un texte simple. Nous voulons parfois le gras, parfois l'italique, parfois les deux.
Mauvaise approche : 

- Classe TexteNormal
- Classe TexteGras
- Classe TexteItalique
- Classe TexteGrasItalique

Déjà 4 classes pour 2 options.

`Solution` : Au lieu de créer des sous-classes, on créé des emballeurs qui ajoutent du style.