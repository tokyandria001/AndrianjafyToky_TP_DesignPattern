# Observer (Observateur)

## Problème

Lorsqu'un objet change d'état et que plusieurs autres objets doivent réagir à ce changement, on pourrait écrire du code qui lie directement le sujet aux objets dépendants.

**Problèmes :**

- Fort couplage entre l'objet principal et ses dépendants.
- Difficulté à ajouter ou retirer des objets qui doivent réagir aux changement.
- Code peu flexible et diffficile à maintenir.

Exemple : un capteur de lumière qui doit prévenir plusieurs lampes pour qu'elles s'allument ou s'éteignent selon la luminosité ambiante.

---

## Principe de fonctionnement

Le pattern **Observer** permet de **découpler le sujet (qui change d'état) des observateurs (qui réagissent)** : 

1. Le **sujet** maintient une liste d'observateurs.
2. Chaque **observateur** peut s'abonner ou se désabonner dynamiquement.
3. Quand l'état du sujet change, il **notifie automatiquement tous les observateurs** via une méthode 'update()'.

Ainsi : 

- Le sujet ne connaît pas les détails des observateurs.
- Les observateurs peuvent réagir différemment à un même événement.
- L'ajout ou la suppressoin d'observateurs se fait sans modifier le sujet.

---

## Structure

- **Subject (interface `LightSensorSubject`)** : fournit `attach()`, `detach()` et `notifyObservers()`.
- **ConcreteSubject (class `LightSensor`)** : implémente l'interface Subject et contient l'état surveillé (`lightLevel`).
- **Observer (interface `LightObserver`)** : définit la méthode `updateLight()` pour recevoir les notifications.
- **ConcreteObserver (class `Lamp`)** : implémente l'interface Observer et définit la réaction au changement d'état.
- **Client (`Main`)** : crée le sujet et les observateurs, les abonne et simule des événements.

---

## Avantages

- Découplage complet entre le sujet et les observateurs.
- Les observateurs peuvent être ajoutés ou retirés dynamiquement.
- Respect du principe **Open/Closed** : on peut ajouter de nouveaux observateurs sans modifier le sujet.
- Notifications automatiques à chaque changement d'état.

---

## Inconvénients

- Augmentation du nombre de classes.
- Notifications fréquentes peuvent impacter les performances si le nombre d'observateurs est très élevé.
- L'odre des notifications peut être imprévisible.

---

## Cas d'usage réel possible

- Systèmes financiers ou de trading en temps réel, pour notifier différents modules.
- Applications événementielles (notifications, alertes).
