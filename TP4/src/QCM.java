import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCM {

    private final List<Question> questionList;
    // Map représentant les réponses que l'utilisateur a marqué comme true
    // Peut être utilisé par exemple pour afficher à la fin toutes les erreurs de l'utilisateur
    private final Map<Question, List<Integer>> userHistorical;

    public QCM(List<Question> questionList) {
        this.questionList = questionList;
        this.userHistorical = new HashMap<>();
    }

    public QCM(Question... questions) {
        this(List.of(questions));
    }

    // Retourne le score de l'utilisateur
    public double startQCM() {
        assert isValid();

        for (Question question : questionList) {
            List<Integer> inputs = question.askQuestion();
            userHistorical.put(question, inputs);
            endQuestion();
        }

        double score = questionList.stream().filter(question -> question.isCorrect(userHistorical.get(question)))
                .mapToDouble(Question::getGrading)
                .sum();

        System.out.printf("\nScore : %.2f/%.2f\n", score, calculateMaxScore());
        return score;
    }

    private void endQuestion() {
        int n = getUserHistorical().size();
        System.out.println("\n\n[entrer] pour passer à la question suivante");
        System.out.printf("[1-%d] Pour modifier une question précédente : Question n°", n);

        int input = Utils.enterPositiveIntOrPass(true, n);

        if (input > 0) {
            Question question = questionList.get(input - 1);

            while (input >= 0) {
                List<Integer> answers = userHistorical.get(question);
                System.out.println(question.toString(answers));
                System.out.print("Réponse à cocher / décocher ([entrer] pour sauvegarder la réponse) : ");
                input = Utils.enterPositiveIntOrPass(question.getAnswers().length - 1);

                if (input >= 0) {
                    if (answers.contains(input)) {
                        answers.remove(input);
                    } else {
                        answers.add(input);
                    }
                }
            }

            endQuestion();
        }
    }

    public boolean isValid() {
        return questionList.stream().allMatch(question ->
                question.getGrading() > 0.0 && Arrays.stream(question.getAnswers()).anyMatch(Answer::isCorrect));
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Map<Question, List<Integer>> getUserHistorical() {
        return userHistorical;
    }

    public double calculateMaxScore() {
        return questionList.stream().mapToDouble(Question::getGrading).sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Question question : questionList) {
            stringBuilder.append(question);
        }

        return stringBuilder.toString();
    }

    // Retourne un QCM sans aucune réponse d'enregistré
    public QCM copy() {
        return new QCM(questionList);
    }
}
