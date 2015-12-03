/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class StatisticsFrame 
{
   public StatisticsFrame( String title ) 
   {
      JFrame f = new JFrame(title);
      f.setTitle(title);
      RefineryUtilities.positionFrameOnScreen(f, 0.25, 0.25);
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setSize(new Dimension (400,400));
      f.setVisible(true);
      f.setContentPane(this.createPanel());
      
   }
   
   private static PieDataset createDataset( ) 
   {
      SaveEventToFile reader = new SaveEventToFile();
      ArrayList<Event> eventList = reader.readEventsFromFile();
      int doneCounter=0;
      for (int i=0; i<eventList.size() ; i++) {
            if (eventList.get(i).isDone()) {
                doneCounter++;
            }
      }
      
      
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Wykonane" , doneCounter );  
      dataset.setValue( "Niewykonane" , (eventList.size() - doneCounter ) );
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Wykonane / Niewykonane ",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);
      
      
      return chart;
   }
   public static JPanel createPanel()
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   
}