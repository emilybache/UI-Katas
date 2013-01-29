 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Main {
  private static JFrame buildFrame(JPanel contents) {
    JFrame frame = new JFrame("AdditionalDetailsEditor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    frame.setContentPane(contents);
    frame.pack();
 
    return frame;
  }
 
  public static void main(String[] args) throws InterruptedException {
    JFrame frame = buildFrame(new AdditionalDetailsPanel());
    frame.setVisible(true);
  }
}