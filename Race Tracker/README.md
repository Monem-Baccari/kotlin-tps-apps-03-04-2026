# Race Tracker App

Race Tracker est une application Android de demonstration qui simule la progression de deux joueurs dans une course.  
Le projet illustre les concepts de base des **coroutines Kotlin** avec une interface construite en **Jetpack Compose**.

## Fonctionnalites

- Demarrer la course
- Mettre la course en pause
- Reinitialiser la course
- Visualiser la progression de deux joueurs en temps reel

## Prerequis

- Android Studio installe
- Connaissances de base en Kotlin
- Experience avec Jetpack Compose
- Notions de base sur les coroutines Kotlin

## Stack technique

- **Kotlin**
- **Jetpack Compose**
- **Kotlin Coroutines**
- **Gradle**

## Installation et execution

1. Ouvrir le projet dans Android Studio.
2. Laisser Gradle synchroniser les dependances.
3. Lancer l'application sur un emulateur ou un appareil Android.

## Structure du projet

- `app/` : code source principal de l'application Android
- `app/src/main/` : code Kotlin, ressources UI et `AndroidManifest.xml`
- `app/src/test/` : tests unitaires
- `build.gradle.kts` et `settings.gradle.kts` : configuration Gradle du projet

## Objectif pedagogique

Ce projet aide a comprendre comment :

- executer des taches asynchrones avec les coroutines ;
- piloter l'etat d'une interface (`start`, `pause`, `reset`) ;
- organiser une application Android moderne avec Compose.


