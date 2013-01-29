 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Enumeration;
 
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
 
public class AdditionalDetailsPanel extends JPanel implements ActionListener {
  private static final long serialVersionUID = 1L;
 
  private JRadioButton text;
  private JRadioButton url;
  private JRadioButton html;
 
  private JTextArea textArea;
 
  private JButton submit;
 
  String errorMessage;
 
  public AdditionalDetailsPanel() {
    text = new JRadioButton("Text");
    text.setMnemonic(KeyEvent.VK_T);
    text.setSelected(true);
    url = new JRadioButton("Url");
    url.setMnemonic(KeyEvent.VK_U);
    html = new JRadioButton("Html");
    html.setMnemonic(KeyEvent.VK_H);
 
    ButtonGroup buttons = new ButtonGroup();
    buttons.add(text);
    buttons.add(url);
    buttons.add(html);
 
    Enumeration<AbstractButton> elements = buttons.getElements();
    while (elements.hasMoreElements())
      elements.nextElement().addActionListener(this);
 
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
 
    radioPanel.add(text);
    radioPanel.add(url);
    radioPanel.add(html);
 
    add(radioPanel);
 
    textArea = new JTextArea(10, 60);
    add(textArea);
 
    submit = new JButton("Submit");
    add(submit);
    submit.addActionListener(this);
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    if ("Submit".equals(e.getActionCommand()))
      if (handleSubmit()) {
        JOptionPane.showMessageDialog(this,
            "Additional Information Stored");
        System.exit(0);
      } else {
        JOptionPane.showMessageDialog(this, errorMessage);
      }
    else
      handleRadio();
  }
 
  private void handleRadio() {
    textArea.setText("");
  }
 
  private boolean handleSubmit() {
    if (text.isSelected())
      return validateText();
    if (url.isSelected())
      return validateUrl();
    if (html.isSelected())
      return validateHtml();
    errorMessage = "No type selected";
    return false;
  }
 
  private boolean validateHtml() {
    String body = textArea.getText();
 
    if (body.length() < 10) {
      errorMessage = "Html is not valid";
      return false;
    }
 
    return true;
  }
 
  private boolean validateUrl() {
    String body = textArea.getText();
    try {
      new URL(body).toURI();
    } catch (Exception e) {
      errorMessage = e.getMessage();
      return false;
    }
    return true;
  }
 
  private boolean validateText() {
    String body = textArea.getText();
    if (body.length() < 10) {
      errorMessage = "Text description too short";
      return false;
    }
 
    return true;
  }
}