# Mars Photos - Android Kotlin Compose

Application Android moderne en **Kotlin + Jetpack Compose** qui affiche des photos de Mars recuperees depuis une API publique.
Le projet illustre une architecture simple et propre autour de **ViewModel**, **coroutines** et **Retrofit**.

---

## Presentation

**Mars Photos** est une application de demonstration Android qui :
- interroge un service web pour recuperer des images martiennes ;
- affiche les resultats dans une interface Compose ;
- gere les etats de chargement, succes et erreur.

Ce projet est adapte pour l'apprentissage de :
- l'UI declarative avec Compose ;
- la consommation d'API REST ;
- la separation des responsabilites (UI / logique / reseau).

---

## Fonctionnalites

- Affichage d'une liste de photos de Mars depuis une API distante.
- Gestion des etats UI : chargement, succes, erreur reseau.
- Interface Jetpack Compose simple et lisible.
- Architecture basee sur `ViewModel` pour piloter l'etat de l'ecran.

---

## Stack technique

- **Langage** : Kotlin
- **UI** : Jetpack Compose
- **Architecture** : UI Compose + `ViewModel`
- **Asynchrone** : Kotlin Coroutines
- **Reseau** : Retrofit
- **Build** : Gradle Kotlin DSL (`build.gradle.kts`)

Fichiers cles :
- `app/src/main/java/com/example/marsphotos/MainActivity.kt`
- `app/src/main/java/com/example/marsphotos/ui/MarsPhotosApp.kt`
- `app/src/main/java/com/example/marsphotos/ui/screens/HomeScreen.kt`
- `app/src/main/java/com/example/marsphotos/ui/screens/MarsViewModel.kt`
- `app/src/main/java/com/example/marsphotos/model/MarsPhoto.kt`
- `app/src/main/java/com/example/marsphotos/network/MarsApiService.kt`

---

## Installation

### Prerequis

- Android Studio recent (version stable recommandee)
- JDK compatible Android/Gradle
- SDK Android installe via Android Studio
- Connexion Internet (pour les appels API)

### Cloner le projet

```powershell
git clone <URL_DU_REPO>
cd "Mars Photos"
```

Si vous avez deja le projet localement, ouvrez simplement le dossier dans Android Studio.

---

## Execution

### Depuis Android Studio (recommande)

1. Ouvrir le projet.
2. Laisser Gradle synchroniser les dependances.
3. Lancer l'application sur un emulateur ou un appareil Android.

### Depuis PowerShell (optionnel)

```powershell
.\gradlew.bat assembleDebug
.\gradlew.bat installDebug
```

La commande `installDebug` necessite un appareil/emulateur connecte.

---

## Architecture

Organisation principale :

- `model/` : classes de donnees (`MarsPhoto`).
- `network/` : definition du service Retrofit (`MarsApiService`).
- `ui/` :
  - `MarsPhotosApp.kt` : structure globale Compose ;
  - `screens/` :
    - `HomeScreen.kt` : rendu de l'ecran selon l'etat ;
    - `MarsViewModel.kt` : recuperation des donnees et exposition de l'etat UI ;
  - `theme/` : theme Material/Compose.

Flux simplifie :

1. Le `MarsViewModel` declenche la recuperation des donnees.
2. Le service reseau retourne les photos.
3. L'etat UI est mis a jour (loading/success/error).
4. `HomeScreen` se recompose automatiquement selon cet etat.

---

## API

Le projet consomme l'API Mars Photos (NASA via endpoint utilise dans le codelab Android).

- Service reseau : `app/src/main/java/com/example/marsphotos/network/MarsApiService.kt`
- Modele de reponse principal : `app/src/main/java/com/example/marsphotos/model/MarsPhoto.kt`
- Les erreurs reseau sont refletees dans l'etat d'ecran.

Si l'endpoint change ou devient indisponible, adaptez la configuration Retrofit et la gestion d'erreur.

---

## Captures d'ecran (optionnel)

Vous pouvez ajouter vos captures dans un dossier, par exemple :

- `docs/images/home-loading.png`
- `docs/images/home-success.png`
- `docs/images/home-error.png`

Exemple d'integration Markdown :

```md
![Chargement](docs/images/home-loading.png)
![Succes](docs/images/home-success.png)
![Erreur](docs/images/home-error.png)
```

---

## Depannage

### Erreur de synchronisation Gradle
- Verifier la connexion Internet.
- Verifier les versions Gradle/AGP et le SDK installe.
- Relancer une sync depuis Android Studio.

### L'application affiche un etat d'erreur
- Verifier l'acces Internet de l'emulateur/appareil.
- Verifier la disponibilite de l'API distante.
- Verifier la configuration reseau dans `MarsApiService.kt`.

### Problemes de build
- Nettoyer/reconstruire le projet.
- Supprimer le cache Gradle local si necessaire.
- Verifier `local.properties` et le chemin SDK Android.

---

## Contribution

Les contributions sont bienvenues.

1. Fork du depot.
2. Creer une branche feature : `feature/nom-court`.
3. Commits clairs et cibles.
4. Ouvrir une Pull Request avec description du contexte, des changements et des captures si UI.

---

## Licence

Ce projet est distribue sous la licence indiquee dans le fichier [`LICENSE`](LICENSE).
