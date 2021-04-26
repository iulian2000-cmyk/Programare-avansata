
package Optional;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.spec.ECField;
import java.util.*;

public class DoChart extends JFrame {

    public DoChart() throws  Exception{

        initUI();
    }

    private void initUI() throws Exception {

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Names length of the users");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private DefaultPieDataset createDataset() throws  Exception {

        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/main/java/Compulsory/users.txt");
            Scanner Reader = new Scanner(fileReader);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                dataset.setValue(data,data.length());
            }
            Reader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset) throws Exception {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Names length",
                dataset,
                false, true, false);
        BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(JFreeChart.KEY_SUPPRESS_SHADOW_GENERATION, true);

        Rectangle r = new Rectangle(0, 0, 600, 400);
        pieChart.draw(g2, r);
        File f = new File("Stats.png");
        BufferedImage chartImage = pieChart.createBufferedImage( 600, 400, null);
        ImageIO.write( chartImage, "png", f );
        return pieChart;
    }

    public static void main(String[] args) throws  Exception{

            EventQueue.invokeLater(() -> {
                try {
                    DoChart ex = new DoChart();
                    ex.setVisible(true);
                }catch (Exception a){
                    a.printStackTrace();
                }
            });
    }
}