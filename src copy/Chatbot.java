import java.util.*;

public class Chatbot {

    private Map<String, String> responses;

    public Chatbot() {
        responses = new HashMap<>();

        responses.put("hello", "Hello! How can I help you?");
        responses.put("hi", "Hi! Nice to meet you.");
        responses.put("hey", "Hey! How can I help you?");

        responses.put("how are you", "I am doing great! Thank you for asking.");
        responses.put("what is your name", "My name is JavaBot.");
        responses.put("who are you", "I am a Java-based AI chatbot.");

        responses.put("what can you do",
                "I can answer frequently asked questions and have a simple conversation with you.");

        responses.put("what is ai",
                "AI stands for Artificial Intelligence. It enables computers to perform tasks that normally require human intelligence.");

        responses.put("what is java",
                "Java is a popular object-oriented programming language.");

        responses.put("what is nlp",
                "NLP stands for Natural Language Processing. It helps computers understand and process human language.");
        responses.put("what is sql","SQL is used to store,retrieve and manage data in databases.");

        responses.put("what is machine learning",
        "Machine Learning is a branch of AI that allows computers to learn from data.");

responses.put("what is chatbot",
        "A chatbot is a computer program that communicates with users using text or voice.");

        responses.put("thank you", "You're welcome!");
        responses.put("thanks", "You're welcome!");

        responses.put("bye", "Goodbye! Have a nice day.");
        responses.put("exit", "Goodbye! See you again.");
    }

    // NLP text preprocessing
    private String preprocess(String input) {

        input = input.toLowerCase();

        input = input.replaceAll("[^a-zA-Z0-9 ]", "");

        input = input.trim();

        return input;
    }

    // Generate chatbot response
    public String getResponse(String input) {

        String message = preprocess(input);

        // Exact or phrase matching
        for (String question : responses.keySet()) {

            if (message.equals(question) || message.contains(question)) {
                return responses.get(question);
            }
        }

        // Keyword-based responses
        if (message.contains("college")) {
            return "College is a place where students learn academic and professional skills.";
        }

        if (message.contains("study")) {
            return "Regular practice and revision can help you improve your studies.";
        }

        if (message.contains("exam")) {
            return "Prepare a study schedule and practice important questions before exams.";
        }

        if (message.contains("programming")) {
            return "Programming is the process of writing instructions that a computer can execute.";
        }

        if (message.contains("python")) {
            return "Python is a popular high-level programming language.";
        }

        if (message.contains("sql")) {
            return "SQL is used to store, retrieve and manage data in databases.";
        }

        // Default response
        return "Sorry, I don't understand that yet. Please ask me another question.";
    }
}