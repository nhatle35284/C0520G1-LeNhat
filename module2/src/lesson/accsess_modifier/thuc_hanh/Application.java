package lesson.accsess_modifier.thuc_hanh;

class Application {
    public static String language;

    static {
        if (System.getProperty("lang").equals("en")) {
            language = "english";
        } else {
            language = "spanish";
        }
    }

    public static void main(String[] args) {
       System.out.println("ket quả là : "+Application.language);
       // System.out.println(System.getProperty("lang"));
    }
}