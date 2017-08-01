import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSamplePanel {

    public static void main(String args[]) {
        JFrame frame = new JFrame("JFileChooser Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        final JLabel directoryLabel = new JLabel(" ");
        directoryLabel.setFont(null);
        contentPane.add(directoryLabel, BorderLayout.NORTH);

        final JLabel filenameLabel = new JLabel(" ");
        filenameLabel.setFont(null);
        contentPane.add(filenameLabel, BorderLayout.SOUTH);

        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setControlButtonsAreShown(false);
        contentPane.add(fileChooser, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {


            public void actionPerformed(ActionEvent actionEvent) {

                JFileChooser theFileChooser = (JFileChooser) actionEvent
                        .getSource();

                String command = actionEvent.getActionCommand();
                if (command.equals(JFileChooser.APPROVE_SELECTION)) {

                    File selectedFile = theFileChooser.getSelectedFile();

                    directoryLabel.setText(selectedFile.getParent());

                    filenameLabel.setText(selectedFile.getName());

                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {

                    directoryLabel.setText(" ");
                    filenameLabel.setText(" ");
                }
            }
        };
        fileChooser.addActionListener(actionListener);

        frame.pack();
        frame.setVisible(true);
    }
}
