import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Question {

    private String question;
    private Answer[] answers;
    private double grading;

    public Question(String question, double grading, Answer... answers) {
        this.question = question;
        this.answers = answers;
        this.grading = grading;
    }

    // Retourne true ssi toutes les réponses correctes sont contenues dans inputs
    // Et qu'aucune réponse de inputs soit fausse
    public boolean isCorrect(List<Integer> inputs) {
        return IntStream.range(0, answers.length).noneMatch(i -> answers[i].isCorrect() && !inputs.contains(i))
                && inputs.stream().allMatch(value -> answers.length > value && answers[value].isCorrect());
    }

    public List<Integer> askQuestion() {
        List<Integer> currentAnswers = new ArrayList<>();
        System.out.println(this);
        System.out.print("\nEntrez une première réponse : ");

        int response = Utils.enterPositiveInt(answers.length - 1);
        while (response != -1 && currentAnswers.size() < answers.length) {
            if (!currentAnswers.contains(response)) {
                currentAnswers.add(response);
            }

            System.out.print("Entrez une nouvelle réponse supplémentaire (facultatif) : ");
            response = Utils.enterPositiveIntOrPass(answers.length - 1);
        }

        return currentAnswers;
    }

    public double getGrading() {
        return grading;
    }

    public String getQuestion() {
        return question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public String toString(List<Integer> integerList) {
        StringBuilder stringBuilder = new StringBuilder(question).append("\n");

        for (int i = 0; i < answers.length; i++) {
            stringBuilder.append("  ");

            if (integerList.contains(i)) {
                stringBuilder.append("[").append(i).append("] ");
            } else {
                stringBuilder.append(" ").append(i).append("- ");
            }

            stringBuilder.append(answers[i]).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return toString(new ArrayList<>());
    }
}
