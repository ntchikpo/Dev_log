# Dev_log — Application de gestion des fraudes

Application console développée en **Java** dans le cadre d'un projet à l'ESEO Angers. Elle permet de gérer et d'analyser des cas de fraude (plagiat, falsification, etc.) au sein d'un établissement d'enseignement supérieur.

## Fonctionnalités

- Modélisation UML d'une hiérarchie de classes représentant les différents types de fraudes
- Détection et représentation des fraudes sous forme de graphe de plagiat
- Calcul de statistiques sur les fraudes recensées (nombre total, répartition, moyennes, etc.)
- Gestion des étudiants, formulaires et épreuves liés aux fraudes

## Structure du projet

```
src/
└── eseo/
    ├── enumeration/
    │   ├── Cursus
    │   └── Modalite
    ├── fraude/
    │   ├── Fraude
    │   ├── FraudeCalculatrice
    │   ├── FraudeIAG
    │   ├── FraudeIAGConnectee
    │   └── FraudePapier
    └── principal/
        ├── Epreuve
        ├── Etudiant
        ├── Formulaire
        └── Systeme

test/
└── eseo/...  (tests unitaires JUnit 5)
```

## Tests

Le projet inclut une suite de tests unitaires écrits avec **JUnit 5**, avec une couverture de code d'environ **80%**.

Pour lancer les tests, exécutez la classe `SystemeTest` (ou via votre IDE / outil de build préféré).

## Technologies utilisées

- Java
- Programmation Orientée Objet (POO)
- JUnit 5
- Modélisation UML

## Auteur

Noé Thierry Tchikpo — Étudiant ingénieur, ESEO Angers
