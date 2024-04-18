//Librerías utilizadas:

import javax.swing.JFileChooser;
import java.io.File;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.*;

/*
Hecho por: José Raymundo Baca Hernández
Algoritmos y Sistemas de Cifrado - Criptografía
Instituto Tecnológico de Chihuahua ll
 */
public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
        setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
        setTitle("Método AES"); //Declaramos título
    }
    
    private String codigoSeguridad;
    private SecretKey secretKey;
    private File selectedFolder;

    private void generarCodigoSeguridad() {
        SecureRandom random = new SecureRandom();
        int codigo = 1000 + random.nextInt(9000); // Genera un codigo de 4 digitos
        codigoSeguridad = String.valueOf(codigo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Cifrar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 153, 0));
        jButton2.setText("Enviar codigo");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(51, 204, 0));
        jButton3.setText("Descifrar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Seleccionar carpeta");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("AES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Generar una clave secreta utilizando el algoritmo AES con una longitud de 128 bits
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
            // Inicializar el cifrado con la clave secreta y el modo de cifrado (encriptar)
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Obtener la lista de archivos en la carpeta seleccionada
            File[] files = selectedFolder.listFiles();
            for (File file : files) {
                // Verificar si el objeto es un archivo
                if (file.isFile()) {
                    // Leer el contenido del archivo como bytes
                    byte[] fileBytes = Files.readAllBytes(file.toPath());
                    // Cifrar los bytes del archivo y obtener los bytes cifrados
                    byte[] encryptedFileBytes = cipher.doFinal(fileBytes);
                    // Escribir los bytes cifrados de vuelta al archivo, sobrescribiendo el contenido original
                    Files.write(Paths.get(file.getAbsolutePath()), encryptedFileBytes);
                }
            }
            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Archivos en la carpeta encriptados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // En caso de error, imprimir la traza de la excepción
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // Poner el código del sms recibido
            String codigoIngresado = jTextField1.getText();
            // Verificar si el código ingresado es correcto
            if (codigoIngresado != null && codigoIngresado.equals(codigoSeguridad)) {
                // Inicializar el cifrado con la clave secreta y el modo de cifrado (desencriptar)
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                // Obtener la lista de archivos en la carpeta seleccionada
                File[] encryptedFiles = selectedFolder.listFiles();
                for (File encryptedFile : encryptedFiles) {
                    // Verificar si el objeto es un archivo
                    if (encryptedFile.isFile()) {
                        // Leer el contenido del archivo encriptado como bytes
                        byte[] encryptedFileBytes = Files.readAllBytes(encryptedFile.toPath());
                        // Desencriptar los bytes del archivo y obtener los bytes desencriptados
                        byte[] decryptedFileBytes = cipher.doFinal(encryptedFileBytes);
                        // Escribir los bytes desencriptados de vuelta al archivo, sobrescribiendo el contenido encriptado
                        Files.write(Paths.get(encryptedFile.getAbsolutePath()), decryptedFileBytes);
                    }
                }
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Archivos en la carpeta desencriptados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostrar un mensaje de error si el código es incorrecto
                JOptionPane.showMessageDialog(this, "Código incorrecto. Desencriptación cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // En caso de error, imprimir la traza de la excepción
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = folderChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFolder = folderChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Carpeta seleccionada: " + selectedFolder.getAbsolutePath(), "Selección exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Generar un nuevo codigo de seguridad
        generarCodigoSeguridad();
        // Inicializar Twilio con tus credenciales
        String twilioAccountSid = ""; // Yout Twilio Acc SID bere
        String twilioAuthToken = ""; // Your Twilio AuthToken here
        Twilio.init(twilioAccountSid, twilioAuthToken);
        // Numeros de telefono
        String fromPhoneNumber = ""; // Twilio Phone Number here
        String toPhoneNumber = ""; // Your Personal Phone Number here
        // Mensaje a enviar
        String messageText = "Tu codigo de seguridad es: " + codigoSeguridad;
        // Enviar el mensaje
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                messageText
        ).create();
        // Mostrar el SID del mensaje en la consola
        System.out.println("Mensaje SID: " + message.getSid());
        // No mostramos el codigo en la interfaz
        JOptionPane.showMessageDialog(this, "Codigo de seguridad enviado por SMS.", "Exito", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
