
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.*;
import javax.swing.*;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.Socket;
import javax.imageio.ImageIO;



public class Client extends JFrame implements ActionListener
{
    JPanel panel;
    PrintWriter out;
    BufferedReader in;
    public void showMenu()
    {
        JButton buttonRefresh=new JButton("REFRESH");
        JButton buttonExit=new JButton("EXIT");
        JButton buttonTop = new JButton("TOP");

        pack();

        buttonExit.addActionListener(this);
        buttonExit.setMaximumSize(new Dimension(150, 30));
        buttonExit.setFont(new Font("Monospaced", Font.ITALIC, 14));
        buttonExit.setBackground(new Color(0x2dce98));
        buttonExit.setForeground(Color.white);

        buttonRefresh.setMaximumSize(new Dimension(150, 30));
        buttonRefresh.setFont(new Font("Monospaced", Font.ITALIC, 14));
        buttonRefresh.setBackground(new Color(0x2dce98));
        buttonRefresh.setForeground(Color.white);
        buttonRefresh.addActionListener(this);

        buttonTop.setMaximumSize(new Dimension(150,30));
        buttonTop.setFont(new Font("Monospaced", Font.ITALIC, 14));
        buttonTop.setBackground(new Color(0x2dce98));
        buttonTop.setForeground(Color.white);
        buttonTop.addActionListener(this);


        panel.add(buttonRefresh);
        panel.add(buttonTop);
        panel.add(buttonExit);

        Box box = Box.createVerticalBox();
        box.add(buttonRefresh);
        box.add(buttonTop);
        box.add(buttonExit);

        panel.add(box);
        add(panel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
    }

    public Client(PrintWriter out ,BufferedReader in) throws IOException
    {
        super("RecomandationSystem");
        this.out = out;
        this.in = in;
        setLayout(new BorderLayout());
        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        Image background_img;
        background_img = Toolkit.getDefaultToolkit().getImage("icon.jpg");
        ImageIcon icon =  new ImageIcon("back.jpg");
        setIconImage(icon.getImage());
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background_img, 0, 0, null);
            }
        });
        showMenu();
    }

    // Functie care trateaza fiecare buton in parte din aplicatie
    public void actionPerformed(ActionEvent event)  {
        Component[]storeAllButtonInPanel=panel.getComponents();

        if(event.getActionCommand().equals("REFRESH"))
        {
            for(int index=0;index < storeAllButtonInPanel.length;index++)
            {
                panel.remove(storeAllButtonInPanel[index]);
            }
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("EXIT"))
        {
            System.exit(0);
            out.println("exit");
            try {
                String msg = in.readLine();
                System.out.println(msg);
            }catch (IOException a)
            {
                System.out.println("IOException");
            }
        }
    }

    public static void main(String []args)
    {
        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter out = new PrintWriter( socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;

            String username = JOptionPane.showInputDialog("Enter username");
            String password = JOptionPane.showInputDialog("Enter the password");

            out.println(username);
            out.println(password);

            // Sa pasez din clasa asta ,un obiect de tipul PrintWriter  si  unul de tipul BufferReader  catre interfata mea .
            String msg = in.readLine();
            JOptionPane.showMessageDialog(null, msg, "Login status", JOptionPane.INFORMATION_MESSAGE);
            if(msg.compareTo("Connected")!=0)
            {
                System.out.println("Goodbye!");
                System.exit(0);
            }else{
                Client clientInterface = new Client(out,in);
                /**
                 while (!"exit".equalsIgnoreCase(line)) {
                 line = JOptionPane.showInputDialog("Enter command to server");
                 out.println(line);
                 out.flush();
                 String response = in.readLine();
                 JOptionPane.showMessageDialog(null,response, "Response from server", JOptionPane.INFORMATION_MESSAGE);
                 } **/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

