# Tricol Supply Management System

## About

Tricol est une entreprise spécialisée dans la conception et la fabrication de vêtements destinés aux professionnels. Les dirigeants souhaitent mettre en place une application qui permettra une gestion efficace des approvisionnements de l'entreprise. 

Dans sa version initiale, l'application se concentrera sur la **gestion des fournisseurs**, posant ainsi les fondations pour le système complet de gestion des approvisionnements qui comprendra ultérieurement la gestion des produits, des commandes et des stocks.

Cette première phase du projet vise à développer un module robuste de gestion des fournisseurs en utilisant les fondamentaux de Spring Core, avec une architecture qui permettra l'extension future du système.

## Fonctionnalités

### Gestion des fournisseurs

- **Ajouter un fournisseur** : Enregistrer un fournisseur avec les informations suivantes :
  - Société
  - Adresse
  - Contact
  - Email
  - Téléphone
  - Ville
  - ICE (Identifiant Commun Entreprise)

- **Modifier un fournisseur** : Mettre à jour les informations d'un fournisseur existant
- **Supprimer un fournisseur** : Retirer un fournisseur du système
- **Consulter la liste des fournisseurs** : Afficher tous les fournisseurs avec des options de tri (par nom)

## Technologies

### Core
- **Java** avec Spring Core
- **Spring MVC**
- **Spring Data JPA**
- **Maven**

### Spring Features
- Conteneur IoC pour la gestion des dépendances
- Spring beans et Scopes des beans
- ApplicationContext et BeanFactory
- Configuration Spring utilisant les trois approches (XML, annotations, Java Config)
- Component Scanning

### Documentation api
- https://documenter.getpostman.com/view/42631862/2sB3WjyisW

### Architecture
- Conception en couches (Repository, Service, Controller)
- Utilisation des interfaces repository de Spring Data JPA
- Utilisation des patterns Service et Controller

### Persistance
- Spring Data JPA pour la couche d'accès aux données
- Génération automatique des requêtes standard (`findAll()`, `findById()`, `count()`)
- Méthodes de requêtes personnalisées avec Query Methods (`findByNom()`, `findByEmailEndingWith()`)

## API REST Endpoints

### Fournisseur

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/v1/fournisseurs` | Récupérer tous les fournisseurs |
| `GET` | `/api/v1/fournisseurs/{id}` | Récupérer un fournisseur par ID |
| `POST` | `/api/v1/fournisseurs` | Créer un nouveau fournisseur |
| `PUT` | `/api/v1/fournisseurs/{id}` | Modifier un fournisseur |
| `DELETE` | `/api/v1/fournisseurs/{id}` | Supprimer un fournisseur |

## Modalités pédagogiques

**Travail individuel**

- **Date de lancement** : 20/10/2025
- **Deadline** : 24/10/2025

## Modalités d'évaluation

**Présentation de 30 minutes :**

- **10 minutes** : Démonstration des fonctionnalités de l'application
- **10 minutes** : Explication du code et de son organisation ainsi que la modélisation
- **5 minutes** : Mise en situation
- **5 minutes** : Évaluation des savoirs (Q/A)

## Livrables

- Le code source complet sur un dépôt Git
- Collection JSON (test des endpoints)
- Le fichier README.md
