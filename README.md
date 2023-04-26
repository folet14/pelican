# pelican
Projet dans le cadre du M1 INFO, DEVOPS
![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)

## -------------FONCTIONNALITES------------

* Création de dataframes avec des données de plusieurs types
* Création de dataframes via un fichier csv ou une liste de labels et une liste de lignes
* Création de sous-dataframes à partir d'un dataframe (en donnant les lignes ou avec une liste de labels)
* Modification de dataframe (ajout de lignes)
* Affichage du dataframe entier ou des premières/dernières lignes
* Statistiques possibles sur les dataframes ou directement sur un sous-dataframe (requiert que la partie analysée n'ait que des entiers ou des flottants, mais doivent être passés en String)
* Fonctions de statistique possibles: Minimum, maximum, moyenne

<!-- end of the list -->

## -------------API-------------

### Création : 

- DataFrame(ArrayList<ArrayList<Object>> table, ArrayList<String> labels): Construit un dataframe à partir d'une matrice d'objets et d'une liste de labels
- DataFrame(String filePath) : Construit un dataframe à partir d'un fichier CSV dont on fournit le path
- DataFrame selectionLignes(ArrayList<Integer> lignes): Crée un nouveau dataframe à partir d'une liste de numéros de lignes d'un dataframe existant (la première ligne du dataframe porte le numéro 0)
- DataFrame selectionColonne(ArrayList<String> col): Crée un nouveau dataframe à partir d'une liste de labels d'un dataframe existant en récupérant les colonnes correspondantes

<!-- end of the list -->

### Navigation et modification : 

* ArrayList<Object> getColumn(int index): Renvoie la colonne correspondant à l'index
* ArrayList<Object> getLigne(int index): Renvoie la ligne correspondant à l'index
* String getLabel(int index): Renvoie le label correspondant à l'index
* void addRow(ArrayList<Object> values): Ajoute une ligne à la fin du dataframe à partir d'une liste d'objets

<!-- end of the list -->

### Affichage : 

- void afficherAll() : Affiche le dataframe
- void afficherPremiereLigne(int ligne): Affiche (ligne) premières lignes du dataframe
- void afficherDerniereLigne(int ligne): Affiche (ligne) dernières lignes du dataframe

<!-- end of the list -->

### Statistiques : 

* double maxValue(ArrayList<String> colonne) : Récupère la valeur maximale d'un dataframe (si colonne non nulle, travaille uniquement sur les colonnes fournies)
* double minValue(ArrayList<String> colonne) : Récupère la valeur minimale d'un dataframe (si colonne non nulle, travaille uniquement sur les colonnes fournies)
* double moyenValue(ArrayList<String> colonne) : Calcule la valeur moyenne d'un dataframe (si colonne non nulle, travaille uniquement sur les colonnes fournies)

<!-- end of the list -->

## -------------CHOIX D'OUTILS-------------

1. Maven : Outil de gestion et d'automatisation de production des projets logiciels Java
2. Jacoco : Outil d'évaluation de couverture de code Java
3. Git/Github : Outil de gestion de version
4. Github Action : Outil d'intégration continue proposé par github

<!-- end of the list -->

## -------------WORKFLOW-------------------

Nous avons mis en place un workflow en feature branch. Les différentes fonctionnalités sont développées sur des branches séparées, et le master ne sert que pour les versions valides.

## -------------FEEDBACK-------------------

Il y a eu quelques difficultés pour comprendre les documentations, notamment celle de Jacoco, mais les problèmes ont réussi à être surmontés ou contournés.
