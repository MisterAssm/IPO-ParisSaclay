## Questions 1 à 3

1/
|   Class  	| Description                                                                                                  	|
|:--------:	|--------------------------------------------------------------------------------------------------------------	|
| Main     	| Contient la fonction statique 'main' pour démarrer un nouveau QCM                                            	|
| Answer   	| Classe représentant un choix de réponse possible, en indiquant si elle est vraie ou fausse                   	|
| Question 	| Classe représentant une question du QCM, avec les différentes réponses possible                              	|
| QCM      	| Classe représentant un QCM, contenant les questions, et permettant à l'utilisateur de répondre aux questions 	|

2/
| Class    	| Attributs                                                             	|
|----------	|-----------------------------------------------------------------------	|
| Main     	| /                                                                     	|
| Answer   	| String answer<br>boolean correct                                      	|
| Question 	| String question<br>Answer[] answers                                   	|
| QCM      	| List<Question> questionList<br>Map<Question, Answer[]> userHistorical 	|

3/ Pour les classes Answer et Question, nous pouvons mettre tous les attributs en paramètre des constructeurs.
Aucun constructeur n'est requis pour la classe Main
Pour la classe QCM, nous pouvons mettre en paramètre l'attribut questionList, et initialiser l'attribut userHistorical comme une HashMap vide.

Nous pourrons ajouter des méthodes supplémentaires pour initialiser un QCM en permettant à l'utilisateur de créer un QCM à partir du terminal, mais ce ne sera pas nécessaire