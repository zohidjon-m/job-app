import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JobApp {
    JFrame frame;
    JPanel panel;
    JLabel nameLabel, universityLabel, majorLabel, emailLabel, experienceLabel;
    JLabel prlangLabel, cvLabel, postLabel, jobLeveLabel;
    JTextField nameText, universityText, majorText, emailText;
    JTextArea experienceArea;
    JCheckBox cBox,javaBox, cPlusBox, pythonBox;
    CheckboxGroup cbg;
    JRadioButton javaPrBox, pythonPrBox;
    JComboBox experienceBox;
    String[] exp = {"Entry level", "3+ years experience","5+ years experience"};
    JButton clearAllB,exitB, submitB;

    public JobApp() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("Tech World Recruitment");
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setBounds(250, 10, 300, 30);
        panel.add(title);

        nameLabel = new JLabel("Applicant Name");
        nameLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        nameLabel.setBounds(50, 70, 300, 30);
        panel.add(nameLabel);

        universityLabel = new JLabel("Applicant University");
        universityLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        universityLabel.setBounds(50,120 , 300, 30);
        panel.add(universityLabel);

        majorLabel = new JLabel("Applicant Major");
        majorLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        majorLabel.setBounds(50, 170, 300, 30);
        panel.add(majorLabel);

        emailLabel = new JLabel("Applicant Email");
        emailLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        emailLabel.setBounds(50, 220, 300, 30);
        panel.add(emailLabel);

        experienceLabel = new JLabel("Work Experience");
        experienceLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        experienceLabel.setBounds(50, 270, 300, 30);
        panel.add(experienceLabel);

        nameText = new JTextField();
        nameText.setBounds(250, 70, 150, 30);
        panel.add(nameText);

        universityText = new JTextField();
        universityText.setBounds(250, 120, 150, 30);
        panel.add(universityText);

        majorText = new JTextField();
        majorText.setBounds(250, 170, 150, 30);
        panel.add(majorText);

        emailText = new JTextField();
        emailText.setBounds(250, 220, 150, 30);
        panel.add(emailText);

        experienceArea = new JTextArea();
        experienceArea.setBounds(250, 270, 300, 100);
        JScrollPane experienceScroll = new JScrollPane(experienceArea);
        experienceScroll.setBounds(250, 270, 300, 100);
        panel.add(experienceScroll);

        prlangLabel = new JLabel("Programming Language");
        prlangLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        prlangLabel.setBounds(50, 400, 200, 30);
        panel.add(prlangLabel);

        cBox = new JCheckBox("C");
        cBox.setBounds(250, 400, 50, 30);
        panel.add(cBox);

        javaBox = new JCheckBox("Java");
        javaBox.setBounds(300, 400, 70, 30);
        panel.add(javaBox);

        cPlusBox = new JCheckBox("C++");
        cPlusBox.setBounds(370, 400, 50, 30);
        panel.add(cPlusBox);

        pythonBox = new JCheckBox("Python");
        pythonBox.setBounds(430, 400, 70, 30);
        panel.add(pythonBox);

        cvLabel = new JLabel("Upload CV");
        cvLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        cvLabel.setBounds(50, 450, 150, 30);
        panel.add(cvLabel);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(350,450,250,30);
        panel.add(statusLabel);

        JButton cvButton = new JButton("Upload File");
        cvButton.setBounds(250, 450, 100, 30);
        cvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    statusLabel.setText("Selected file: "+file.getName());

                }else{
                    statusLabel.setText("No file selected");
                }

            }
        });
        panel.add(cvButton);

        postLabel = new JLabel("Select Post");
        postLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        postLabel.setBounds(50, 500, 150, 30);
        panel.add(postLabel);

        javaPrBox = new JRadioButton("Java Programmer", false);
        javaPrBox.setBounds(250, 500, 150, 30);
        panel.add(javaPrBox);

        pythonPrBox = new JRadioButton("Python Programmer", false);
        pythonPrBox.setBounds(400, 500, 150, 30);
        panel.add(pythonPrBox);

        jobLeveLabel = new JLabel(" Select Job Level");
        jobLeveLabel.setFont(new Font("Courier", Font.PLAIN, 15));
        jobLeveLabel.setBounds(50, 550, 150, 30);
        panel.add(jobLeveLabel);

        experienceBox = new JComboBox(exp);
        experienceBox.setBounds(250, 550, 200, 30);
        panel.add(experienceBox);

        clearAllB = new JButton("Clear all");
        clearAllB.setBounds(50,650,100,30);
        clearAllB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                universityText.setText("");
                majorText.setText("");
                emailText.setText("");
                experienceArea.setText("");
                cBox.setSelected(false);
                javaBox.setSelected(false);
                cPlusBox.setSelected(false);
                pythonBox.setSelected(false);
                javaPrBox.setSelected(false);
                pythonPrBox.setSelected(false);
                experienceBox.setSelectedIndex(0);
            }
        });
        panel.add(clearAllB);

        exitB = new JButton("Exit");
        exitB.setBounds(300,650,100,30);
        exitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitB);

        submitB = new JButton("Submit");
        submitB.setBounds(500,650,100,30);
        submitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedPrLang = new StringBuilder("\nProgramming Language: ");
                StringBuilder selectedPosts = new StringBuilder("\nPosts: ");
                StringBuilder selectedJobLevel = new StringBuilder("\nJob Level: ");

                if(cBox.isSelected()) selectedPrLang.append("C ");
                if(javaBox.isSelected()) selectedPrLang.append("Java ");
                if(cPlusBox.isSelected()) selectedPrLang.append("C++ ");
                if(pythonBox.isSelected()) selectedPrLang.append("Python ");
                if(javaPrBox.isSelected()) selectedPosts.append("Java Programmer");
                if(pythonPrBox.isSelected()) selectedPosts.append("Python Programmer");
                String jl = (String) experienceBox.getSelectedItem();
                selectedJobLevel.append(jl);

                if(selectedPrLang.toString().equals("\nProgramming Language: ")){
                    selectedPrLang = new StringBuilder("No Programming Languages selected\n");
                }
                if(selectedPosts.toString().equals("\nPosts")){
                    selectedPosts = new StringBuilder("No Posts selected\n");
                }
                if(selectedJobLevel.toString().equals("\nJob Level")){
                    selectedJobLevel = new StringBuilder("No Job Levels selected\n");
                }
                JFrame dFrame = new JFrame();
                int response = JOptionPane.showConfirmDialog(dFrame, "Name: " + nameText.getText() + "\nUniversity: " + universityText.getText() + "\nMajor: " + majorText.getText() + "\nEmail: " + emailText.getText() + "\nExperience: " + experienceArea.getText() + selectedPrLang.toString() + selectedPosts.toString() + selectedJobLevel.toString(),"Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if(response == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(dFrame,"Your application is successfully received","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                    clearAllB.doClick();
                }
            }
        });
        panel.add(submitB);


        frame.setPreferredSize(new Dimension(700, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }


}
