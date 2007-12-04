import java.awt.Color;
import java.awt.Dimension;

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
  private ControladorServidor cs = null;
  


  public Servidor() {

	  cs = new ControladorServidor(this);
	  
    
    initComponents();
  }

  private void initComponents() {
	this.setLocation(200, 200);
	 setResizable(false);   
	jLabel1 = new JLabel();
    jButton1 = new JButton();
    jButton2 = new JButton();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Servidor RMI de MySandwich");
    jLabel1.setText("Pendiente de iniciar el servidor RMI");

    jButton1.setText("Iniciar Servidor");
    jButton1.setActionCommand("ISERV");
    jButton1.addActionListener(cs);

    jButton2.setText("Apagar Servidor");
    jButton2.setEnabled(false);
    jButton2.setActionCommand("ASERV");
    jButton2.addActionListener(cs);

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

public JButton getJButton1() {
	return jButton1;
}

public void setJButton1(JButton button1) {
	jButton1 = button1;
}

public JButton getJButton2() {
	return jButton2;
}

public void setJButton2(JButton button2) {
	jButton2 = button2;
}

public JLabel getJLabel1() {
	return jLabel1;
}

public void setJLabel1(JLabel label1) {
	jLabel1 = label1;
}

}
