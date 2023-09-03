import javax.swing.*;

public class MyGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My GUI"); 
            frame.setSize(400, 300); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

            JLabel label = new JLabel("Hello, GUI!");
            frame.add(label);

            frame.setVisible(true); 
        });
    }
}
