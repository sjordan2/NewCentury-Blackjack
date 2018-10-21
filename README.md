# Project Title

This is Sean Jordan's implementation of the popular card game 'Blackjack', the programming challenge for the Next Century Corporation.
## Getting Started

How to run the Blackjack application.

### Prerequisites

Before you can run this application, you need to install the following prerequisites.

```
Java JDK 8 or higher
Apache Maven
```

### Installing

Here are instructions on how to install the Mobile Device Keyboard application on your system.

First, download the ZIP file from the portal and unzip it to a location of your choosing.

Then, in the folder containing the unzipped files, run the following command in your command line:

```
mvn clean install -Dmaven.wagon.http.ssl.allowall=true
```

This concludes the installment of the Blackjack Application.

## Running the application

In the project folder, there should now be a /target directory created during the maven install process. Inside, you should find multiple files and directories. The important one is nextcentury-blackjack-1.0.jar. This contains the program code.

### Executing the JAR file

In order to run the application, run the following command from the /target folder (or whereever you moved the JAR file):

```
java -jar nextcentury-blackjack-1.0.jar
```

### Navigating the application

Upon running the application, a few messages will appear. This is the initialization phase of the Blackjack game.

### Human Phase

Eventually, you will see a prompt asking you to enter either 'hit' or 'stand'. You will see your two cards as well as one of the dealer's cards in the console window. Assuming you know the rules of Blackjack, type your answer into the console and hit enter. Your response will be processed. This phase continues until you either type 'stand' or bust.

### Dealer Phase

This phase is only run if the human does not bust and is standing at a value less than 21. The second card is revealed, and the dealer has a predetermined set of rules that guides whether they hit or stand. You will see this process play out in the console window. Eventually, the game will result in either a win, tie, or loss for the player, depending on how the dealer did.

### Miscellaneous Instructions

At the end of each round, the program will ask you whether or not you want to play another game or not. Depending on your mood, type 'yes' or 'no' and hit enter.

Blackjack is all about luck, so don't get frustrated if you keep on losing. I've lost 7 games in a row before, and I screamed "I CREATED YOU" at my computer screen before I calmed myself down.

## Built With

* [Eclipse](https://www.eclipse.org/) - The IDE used for developing this application
* [Maven](https://maven.apache.org/) - JAR file development and packaging

## Authors

* **Sean Jordan** - [sjordan2](https://github.com/sjordan2)

## Acknowledgments

* UMBC
* The Next Century Corporation
* My dog
* My parents
