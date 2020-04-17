package simpleTasks.pressconference;
import com.ibm.icu.text.Transliterator;

public class Pressconference {
    private final Celebrity alexsander_nevsky;
    private final TVReporter reporter;
    private final SynchTranslator dmitry_petrov;

    public Pressconference(Celebrity alexsander_nevsky, TVReporter reporter, SynchTranslator dmitry_petrov) {
        this.alexsander_nevsky = alexsander_nevsky;
        this.reporter = reporter;
        this.dmitry_petrov = dmitry_petrov;
    }

    public static void main(String[] args) {
        Celebrity alexsander_nevsky = new Celebrity("Alexsander Nevsky");
        TVReporter reporter = new TVReporter("Larry King");
        SynchTranslator dmitry_petrov = new SynchTranslator("Dmitry Petrov");
        Pressconference pressconference = new Pressconference(alexsander_nevsky, reporter, dmitry_petrov);

        pressconference.start();
    }

    private void start() {
        String openingQuestion = reporter.askQuestion();
        String translatedQuestion = dmitry_petrov.translate(openingQuestion); // TODO: 15.04.2020 доделать

    }
}
