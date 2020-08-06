package case_study.james;

public class Word {
    private String keyWord;
    private String pronoun;
    private String translate;
    private String wordType;
    private String synonymous;

    public Word(String keyWord, String pronoun, String translate, String wordType, String synonymous) {
        this.keyWord = keyWord;
        this.pronoun = pronoun;
        this.translate = translate;
        this.wordType = wordType;
        this.synonymous = synonymous;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    @Override
    public String toString() {
        return "Word{" +
                "keyWord='" + keyWord + '\'' +
                ", pronoun='" + pronoun + '\'' +
                ", translate='" + translate + '\'' +
                ", wordType='" + wordType + '\'' +
                ", synonymous='" + synonymous + '\'' +
                '}';
    }
}
