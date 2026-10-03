import javax.swing.*;
import java.awt.*;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;

    private Chatbot chatbot;

    public ChatbotGUI() {

        chatbot = new Chatbot();

        setTitle("AI Chatbot");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setPreferredSize(new Dimension(450, 45));

        // Send button
        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(100, 45));

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100, 45));

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        bottomPanel.add(clearButton, BorderLayout.WEST);

        // Add components
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("AI Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("AI Bot: Ask me anything!\n\n");

        // Send button
        sendButton.addActionListener(e -> sendMessage());

        // Enter key
        inputField.addActionListener(e -> sendMessage());

        // Clear button
        clearButton.addActionListener(e -> {
            chatArea.setText("");
            chatArea.append("AI Bot: Chat cleared. How can I help you?\n\n");
        });
    }

    private void sendMessage() {

        String userMessage = inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        // Display user message
        chatArea.append("You: " + userMessage + "\n");

        // Get chatbot response
        String response = chatbot.getResponse(userMessage);

        // Display response
        chatArea.append("AI Bot: " + response + "\n\n");

        // Clear input
        inputField.setText("");

        // Keep cursor in input box
        inputField.requestFocus();

        // Scroll to bottom
        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ChatbotGUI chatbotGUI = new ChatbotGUI();

            chatbotGUI.setVisible(true);
        });
    }
}