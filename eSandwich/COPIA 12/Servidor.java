import java.awt.Color;
import javax.swing.*;

import java.awt.event.*;
/*
 * Servidor.java
 *
 * Created on 5. marraskuuta 2007, 11:38
 */
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 
 * @author Marc
 */
public class Servidor extends JFrame implements Aplicacion {

  private static final long serialVersionUID = 1L;
  private JButton           jButton1;
  private JButton           jButton2;
  private JLabel            jLabel1;
  private ServidorModelo    sm;

  public Servidor() {

    try {
      sm = new ServidorModelo();
    } catch (RemoteException re) {
      mostrarError("Error: S'ha produ�t una excepci� remota: \n" + re,
          "Error connexi�");
    } catch (errorConexionBD e) {
    	mostrarError(e.getMessage(), "Error Base de Dades");
      System.err.println("Error: " + e);
    } catch (Exception e) {
    	mostrarError("Error: S'ha produ�t una excepci� general", "Error");
      System.err.println("Error: " + e);
    }

    initComponents();
  }

  private void initComponents() {
    jLabel1 = new JLabel();
    jButton1 = new JButton();
    jButton2 = new JButton();

    this.setLocation(200, 200);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Gesti\u00f3 del servidor RMI de MySandwich");
    jLabel1.setText("Pendent d'iniciar el servidor RMI de la PAC 3");

    jButton1.setText("Iniciar Servidor");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Aturar Servidor");
    jButton2.setEnabled(false);
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(
        GroupLayout.Alignment.LEADING).addGroup(
        layout.createSequentialGroup().addGap(26, 26, 26).addGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addGroup(
                    layout.createSequentialGroup().addComponent(jButton1)
                        .addPreferredGap(
                            LayoutStyle.ComponentPlacement.RELATED,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)).addComponent(jLabel1))
            .addContainerGap(18, Short.MAX_VALUE)));
    layout.setVerticalGroup(layout.createParallelGroup(
        GroupLayout.Alignment.LEADING).addGroup(
        layout.createSequentialGroup().addGap(24, 24, 24)
            .addComponent(jLabel1).addGap(28, 28, 28).addGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1).addComponent(jButton2))
            .addContainerGap(24, Short.MAX_VALUE)));
    pack();
  }

  private void jButton2ActionPerformed(ActionEvent evt) {
    try {
      sm.apagarServidor();
      jLabel1.setText("Servidor Aturat!");
      jLabel1.setForeground(Color.RED);
      jButton1.setEnabled(true);
      jButton2.setEnabled(false);
    } catch (MalformedURLException murle) {
    	mostrarError("Error: URL del servidor incorrecte", "Error connexi�");
    } catch (NotBoundException nbe) {
    	mostrarError("Error: Falta de refer�ncia de l'objecte en el registre",
          "Error connexi�");
    } catch (RemoteException re) {
    	mostrarError("Error: S'ha produ�t una excepci� remota", "Error connexi�");
    } catch (Exception e) {
    	mostrarError("Error: S'ha produ�t una excepci� general", "Error");
    }

  }

  private void jButton1ActionPerformed(ActionEvent evt) {

    try {
      sm.encenderServidor();
      jLabel1.setText("Servidor Engegat!");
      jLabel1.setForeground(Color.BLUE);
      jButton1.setEnabled(false);
      jButton2.setEnabled(true);

    } catch (MalformedURLException murle) {
      mostrarError("Error: URL del servidor incorrecte", "Error connexi�");
      System.err.println("Error: " + murle);
    } catch (RemoteException re) {
      mostrarError("Error: S'ha produ�t una excepci� remota", "Error connexi�");
      System.err.println("Error: " + re);
    } catch (Exception e) {
      mostrarError("Error: S'ha produ�t una excepci� general", "Error");
      System.err.println("Error: " + e);
    }

  }

  
	public int confirmacio(String mensaje, String titulo) {
		return JOptionPane.showConfirmDialog(null,mensaje,titulo, JOptionPane.YES_NO_OPTION);
		
	}


	public void mostrarError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		
	}


	public void mostrarInformacion(String mensaje, String titulo) {
		 JOptionPane.showInternalMessageDialog(this, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
		
	}

/**
 * @param args
 *          the command line arguments
 */
public static void main(String args[]) {
  java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
      new Servidor().setVisible(true);
    }
  });
}

}
