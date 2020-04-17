package simpleTasks.pressconference;

import com.ibm.icu.text.Transliterator;

public class SynchTranslator {
    private static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";
    private static final String LATIN_TO_CYRILLIC = "Latin-Cyrillic";
    private static final String LATIN_ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String CYRILLIC_ALPHABET = "йцукенгшщзхъфывапролджэёячсмитьбю";

    private String name;

    public SynchTranslator(String name) {
        this.name = name;
    }

    public String translate(String sentence) {

        String latinToCyrillic = LATIN_TO_CYRILLIC;
        for (char c : LATIN_ALPHABET.toCharArray()) {
            if(sentence.indexOf(c) != -1){
                latinToCyrillic = LATIN_TO_CYRILLIC;
                break;
            }
        }

        for (char c : CYRILLIC_ALPHABET.toCharArray()) {
            if(sentence.indexOf(c) != -1){
                latinToCyrillic = CYRILLIC_TO_LATIN;
                break;
            }
        }

        Transliterator toLatinTrans = Transliterator.getInstance(latinToCyrillic);

        String translatedQuestion = toLatinTrans.transliterate(sentence);
        System.out.println(translatedQuestion);
        return translatedQuestion;
    }
}
