import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFServidorRMI extends JFrame {

  private JPanel  jContentPane = null;
  private JButton jbStart      = null;
  private JButton jbStop       = null;
  private JLabel  jlblTexto    = null;

  /**
   * This is the default constructor
   */
  public JFServidorRMI() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(300, 150);
    this.setContentPane(getJContentPane());
    this.setTitle("Servidor RMI");
  }

  public void executeStart() {
    System.out.println("JServidorRMI.executeStart()");
    System.out.println("Iniciando servidor RMI...");
    try {
      RMILoginInterface rmiObj = new RMILoginImpl();
      Naming.rebind("rmi://localhost:1100/RMILoginService", rmiObj);
      System.out.println("servidor iniciado");

      // Actualizando estado de los botones
      getJbStart().setEnabled(false);
      getJbStop().setEnabled(true);
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }

  }

  public void executeStop() {
    System.out.println("Deteniendo el servidor RMI");
    try {
      Naming.unbind("rmi://localhost:1100/RMILoginService");
      System.out.println("servidor detenido");

      // Actualizando botones
      getJbStart().setEnabled(true);
      getJbStop().setEnabled(false);
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }

  }

  /**
   * This method initializes jbStart
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbStart() {
    if (jbStart == null) {
      jbStart = new JButton();
      jbStart.setBounds(new java.awt.Rectangle(29, 72, 110, 33));
      jbStart.setText("Start");
      jbStart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("start.actionPerformed()");
          executeStart();
        }
      });
    }
    return jbStart;
  }

  /**
   * This method initializes jbStop
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbStop() {
    if (jbStop == null) {
      jbStop = new JButton();
      jbStop.setBounds(new java.awt.Rectangle(159, 72, 110, 33));
      jbStop.setText("Stop");
      jbStop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("stop.actionPerformed()");
          executeStop();
        }
      });
    }
    return jbStop;
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jlblTexto = new JLabel();
      jlblTexto.setBounds(new java.awt.Rectangle(36, 19, 224, 31));
      jlblTexto.setText("Servidor RMI");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getJbStart(), null);
      jContentPane.add(getJbStop(), null);
      jContentPane.add(jlblTexto, null);
    }
    return jContentPane;
  }

  public static void main(String[] args) {
    JFServidorRMI jfsr = new JFServidorRMI();
    jfsr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfsr.setVisible(true);
  }

}
