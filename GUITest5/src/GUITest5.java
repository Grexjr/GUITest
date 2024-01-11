import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class GUITest5 { //Move to new folder

    public static void firstButton(){ //Commit test comment seventh one
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button1 = new JButton("Hey Gavin! You copied this. Press here.");
        JButton button2 = new JButton("Hey! button 2 here!");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(button1, BorderLayout.NORTH); // Adds Button to content pane of frame
        frame.getContentPane().add(button2, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void complexLayoutButton(){
        JFrame frame = new JFrame("Complex button layout!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //Define buttons
        JButton button1 = new JButton("button1!");
        JButton button2 = new JButton("button2!");
        JButton button3 = new JButton("button3!");
        JButton button4 = new JButton("button4!");

        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //button1
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.getContentPane().add(button1, gbc);

        //button2
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.getContentPane().add(button2, gbc);

        //button3
        gbc.gridx = 3;
        gbc.gridy = 3;
        frame.getContentPane().add(button3, gbc);

        //button4
        gbc.gridx = 6;
        gbc.gridy = 6;
        frame.getContentPane().add(button4, gbc);

        frame.setVisible(true);

    }

    public static void buttonThatDoesThings(){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button1 = new JButton("One");
        JButton button2 = new JButton("Two");
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(button1, BorderLayout.NORTH); // Adds Button to content pane of frame
        frame.getContentPane().add(button2, BorderLayout.SOUTH);
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clicked_button = (JButton) e.getSource();
                String buttonText = clicked_button.getText();
                JOptionPane.showMessageDialog(frame,"Hello! Button " + buttonText + "clicked!");
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);

        frame.setVisible(true);
    }

    public static void textBoxTest(){
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }

    public static void textBoxWithSend() {
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m12 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m12);
        JMenuItem m21 = new JMenuItem("Get Help");
        m2.add(m21);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel nlabel = new JLabel("Enter Name");
        JLabel label = new JLabel("Enter Text");
        JTextField name = new JTextField(5);
        JTextField tf = new JTextField(20); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(nlabel);// Components Added using Flow Layout
        panel.add(name);
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        //Adding typed text to text area - and these can be put into separate functions to be used many times over! awesome!
        ActionListener submitter = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String submitted_text = name.getText() + ": " + tf.getText() + "\n";
                ta.append(submitted_text);
                tf.setText("");
            }};

        //Reset functionality
        ActionListener resetter = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                name.setText("");
                tf.setText("");
                ta.setText("");
            }};

        //Help Button functionality
        ActionListener helper = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                //Creating the help frame on button press
                JFrame help_window = new JFrame();
                help_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                help_window.setSize(200,200);

                //Creating the help message
                JPanel help_message_home = new JPanel();
                JLabel help_message = new JLabel("Get lost, nerd.");
                help_message_home.add(help_message);

                //Creating the close ok button
                JButton ok_sure = new JButton();
                JLabel ok = new JLabel("Ok, sure.");

                //Creating ok button functionality
                ActionListener okayer = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent s){
                        help_window.dispose();
                    }
                };

                //Adding ok button functionality to the button
                ok_sure.add(ok);
                ok_sure.addActionListener(okayer);

                //Adding help message to the frame
                help_window.getContentPane().add(help_message_home);
                help_window.getContentPane().add(BorderLayout.SOUTH,ok_sure);

                help_window.setVisible(true);
            }
        };

        //Save button functionality
        ActionListener saver = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent save){
                saveToFile(ta.getText());
            }
        };

        //Load button functionality
        ActionListener loader = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent load){
                //Creating new frame for confirm
                JFrame load_message_frame = new JFrame();
                load_message_frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //can't close, need button
                load_message_frame.setSize(500,200);

                //Set up the load message before loading new file
                JPanel load_message_home = new JPanel();
                JLabel load_message = new JLabel("WARNING! Loading new file will erase all unsaved changes. \n" +
                        "Confirm?");
                load_message_home.add(load_message);

                //Set frame as visible
                load_message_frame.setVisible(true);

                //ActionListeners for load warning
                ActionListener confirm = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent confirm){
                        load_message_frame.dispose();
                        loadFromFile(ta);
                    }
                };
                ActionListener deny = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent deny){
                        load_message_frame.dispose();
                        new JOptionPane().showMessageDialog(null,"Load cancelled!");
                    }
                };

                //Creating the confirm/deny buttons
                JButton conf = new JButton();
                JLabel buttonconfirm = new JLabel("Confirm");
                conf.add(buttonconfirm);
                JButton den = new JButton();
                JLabel buttondeny = new JLabel("Deny");
                den.add(buttondeny);

                //Adding behavior to buttons
                conf.addActionListener(confirm);
                den.addActionListener(deny);

                //Add load message to the frame
                load_message_frame.add(load_message_home);

                //Add button panels to frame
                JPanel button_panel = new JPanel();

                //Adding buttons to the panel
                button_panel.add(conf);
                button_panel.add(den);

                //Adding panel to the frame
                load_message_frame.add(BorderLayout.SOUTH, button_panel);
            }
        };



        //Adding help function to get help menu item
        m21.addActionListener(helper);

        //Adding save function to save to file from the save as menuitem
        m12.addActionListener(saver);

        //Adding load function to load from file to the open menuitem
        m11.addActionListener(loader);

        //Adding submitter to send button
        send.addActionListener(submitter);
        reset.addActionListener(resetter);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }

    //Function to save to new file
    public static void saveToFile(String content){
        JFileChooser file_browser = new JFileChooser();
        int result = file_browser.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_browser.getSelectedFile()))){
                writer.write(content);
                new JOptionPane().showMessageDialog(null, "File saved!");
            } catch(IOException ex){
                ex.printStackTrace();
                new JOptionPane().showMessageDialog(null,"Error in saving!");
            }
        } else {
            new JOptionPane().showMessageDialog(null,"Save cancelled.");
        }
    }


    //Function to load from new file
    public static void loadFromFile(JTextArea area){
        JFileChooser file_browser = new JFileChooser();
        int result = file_browser.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            try(BufferedReader reader = new BufferedReader(new FileReader(file_browser.getSelectedFile()))){
                String line;
                StringBuilder content = new StringBuilder();

                while((line = reader.readLine()) != null){
                    content.append(line).append("\n");
                }

                area.setText(content.toString());
                new JOptionPane().showMessageDialog(null,"File loaded successfully!");
            } catch(IOException ex){
                ex.printStackTrace();
                new JOptionPane().showMessageDialog(null,"ERROR loading file!");
            }
        } else{
            new JOptionPane().showMessageDialog(null,"File load cancelled.");
        }
    }

    public static void main(String args[]){
        //firstButton();
        //complexLayoutButton();
        //buttonThatDoesThings();
        textBoxWithSend();
    }
}


