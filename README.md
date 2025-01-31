# Bank Kata - Java / Maven

Ce projet implémente un petit système de gestion de compte bancaire (Bank Kata) en Java,
en respectant l’interface imposée `AccountService` et en appliquant une approche TDD.

## Structure du projet

- **src/main/java**
    - `com.yassinechalh.bankkata/AccountService.java` (interface)
    - `com.yassinechalh.bankkata/Account.java` (implémentation)
    - `com.yassinechalh.bankkata/domain` (transactions, date provider, etc.)
    - `com.yassinechalh.bankkata/infrastructure` (implémentations concrètes : date, console)
    - `com.yassinechalh.bankkata/service` (interfaces de services, ex. StatementPrinter)
- **src/test/java**
    - Tests unitaires et test d'acceptation (AccountTest, TransactionRepositoryTest, AccountAcceptanceTest)

## Technologies

- **Java 17** 
- **Maven** pour la gestion de projet
- **JUnit 5** et **Mockito** pour les tests 

## Installation et Exécution

1. **Cloner** ce dépôt :
   ```bash
   git clone https://github.com/yaashall01/bank-kata.git
   cd bank-kata


2. **Compiler et lancer les tests** :
   ```bash
   mvn clean test
   ```
3. **Exécuter l’application**  :
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.yassinechalh.bankkata.App"
   ```
   Vous verrez alors un relevé s’afficher dans la console.

## Utilisation

1. **Deposit** et **Withdraw** modifient les transactions sur le compte.
2. **printStatement** affiche le relevé des opérations (date, montant, solde),
   du plus récent au plus ancien.

## Tests

- Les tests unitaires se trouvent dans `src/test/java/com/yassinechalh/bankkata`.
- Le test d’acceptation `AccountAcceptanceTest` reproduit le scénario prevu propose dans le document:
    - deux depots (1000 et 2000),
    - un retrait (500),
    - et l’affichage du relevé final.