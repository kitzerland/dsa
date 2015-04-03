
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kitz
 */
public class RealEstate extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public static int houseIndex = 0;

    public static HouseFile file = new HouseFile();
    public static SortedList list = new SortedList();

    public RealEstate() {

        super("Real Estate Program");
        ImageIcon icon = new ImageIcon("invisibleWalkers.png");
        setIconImage(icon.getImage());

        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Icon resetIcon = new ImageIcon("reset.png");
        Icon nextIcon = new ImageIcon("right.png");
        Icon searchIcon = new ImageIcon("search.png");
        Icon deleteIcon = new ImageIcon("delete.png");
        Icon clearIcon = new ImageIcon("clear.png");
        Icon addIcon = new ImageIcon("add.png");
        
        resetButton.setIcon(resetIcon);
        nextButton.setIcon(nextIcon);
        findButton.setIcon(searchIcon);
        deleteButton.setIcon(deleteIcon);
        clearButton.setIcon(clearIcon);
        addButton.setIcon(addIcon);

        Listener listener = new Listener();
        resetButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        addButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        findButton.addActionListener(listener);
        
        resetButton.setToolTipText("Reset");
        nextButton.setToolTipText("Next");
        addButton.setToolTipText("Add");
        deleteButton.setToolTipText("Delete");
        clearButton.setToolTipText("Clear");
        findButton.setToolTipText("Find");
        

    }


    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == resetButton) {
                houseIndex = 0;
                if (list.getSize() > 0) {
                    displayHouse(list.getItem(0));
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("No houses to display");
                    clearForm();
                }
            } else if (e.getSource() == nextButton) {
                houseIndex++;
                if (houseIndex < list.getSize()) {
                    displayHouse(list.getItem(houseIndex));
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("No more houses to display");
                }

            } else if (e.getSource() == addButton) {

                if (list.findItem(getCurrentHouse()) == false) {
                    list.insertItem(getCurrentHouse());
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("House already exists with this lot number");
                }
            } else if (e.getSource() == deleteButton) {

                if (list.findItem(getCurrentHouse()) == true) {
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure u want to delete the \n house with the lot number : " + getCurrentHouse().lotNumber() + " ?",
                            "Are you sure?",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        list.removeItem(getCurrentHouse());

                        houseIndex = 0;
                        if (list.getSize() > 0) {
                            displayHouse(list.getItem(0));
                            messageLabel.setText("");
                        } else {
                            messageLabel.setText("No houses to display");
                            clearForm();
                        }
                    }

                } else {
                    messageLabel.setText("No houses found with this lot number");
                }

            } else if (e.getSource() == clearButton) {
                
                houseIndex = 0;
                if (list.getSize() > 0) {
                    displayHouse(list.getItem(0));
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("No houses to display");
                    clearForm();
                }
                clearForm();

            } else if (e.getSource() == findButton) {

                String findLotNumber = JOptionPane.showInputDialog("Enter lot number");

                if (findLotNumber != null && findLotNumber.length() > 0) {
                    ListHouse newHouse = new ListHouse(Integer.parseInt(findLotNumber), "", "", 0, 0, 0);
                    if (list.findItem(newHouse) == true) {
                        displayHouse(list.getItem(newHouse));
                    } else {
                        messageLabel.setText("No house information found with the lot number : " + findLotNumber);
                    }
                }
            }
        }
    }

    private ListHouse getCurrentHouse() {
        int lotNumber = Integer.parseInt(lotNumberText.getText());
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        int price = Integer.parseInt(priceText.getText());
        int squareFeet = Integer.parseInt(squareFeetText.getText());
        int bedRooms = Integer.parseInt(bedRoomsText.getText());

        ListHouse house = new ListHouse(lotNumber, firstName, lastName, price, squareFeet, bedRooms);

        return house;
    }

    private void displayHouse(ListHouse house) {
        lotNumberText.setText(String.valueOf(house.lotNumber()));
        firstNameText.setText(String.valueOf(house.firstName()));
        lastNameText.setText(String.valueOf(house.lastName()));
        priceText.setText(String.valueOf(house.price()));
        squareFeetText.setText(String.valueOf(house.squareFeet()));
        bedRoomsText.setText(String.valueOf(house.bedRooms()));
    }

    private void clearForm() {
        lotNumberText.setText("");
        firstNameText.setText("");
        lastNameText.setText("");
        priceText.setText("");
        squareFeetText.setText("");
        bedRoomsText.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lotNumberText = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        priceText = new javax.swing.JTextField();
        firstNameText = new javax.swing.JTextField();
        squareFeetText = new javax.swing.JTextField();
        bedRoomsText = new javax.swing.JTextField();
        lastNameText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Lot Number");

        lotNumberText.setMinimumSize(new java.awt.Dimension(6, 16));
        lotNumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotNumberTextActionPerformed(evt);
            }
        });

        findButton.setFocusPainted(false);

        clearButton.setFocusPainted(false);

        deleteButton.setFocusPainted(false);

        resetButton.setFocusPainted(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        nextButton.setFocusPainted(false);

        addButton.setFocusPainted(false);

        priceText.setMinimumSize(new java.awt.Dimension(6, 16));

        firstNameText.setMinimumSize(new java.awt.Dimension(6, 16));
        firstNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextActionPerformed(evt);
            }
        });

        squareFeetText.setMinimumSize(new java.awt.Dimension(6, 16));
        squareFeetText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareFeetTextActionPerformed(evt);
            }
        });

        bedRoomsText.setMinimumSize(new java.awt.Dimension(6, 16));

        lastNameText.setMinimumSize(new java.awt.Dimension(6, 16));

        jLabel8.setText("First Name");

        jLabel10.setText("Last Name");

        jLabel11.setText("Price");

        jLabel12.setText("No of Rooms");

        jLabel13.setText("Square Feet");

        messageLabel.setEditable(false);
        messageLabel.setBackground(new java.awt.Color(51, 153, 255));
        messageLabel.setForeground(new java.awt.Color(255, 255, 255));
        messageLabel.setText("Help Tips: Lorem Ipsum");
        messageLabel.setMinimumSize(new java.awt.Dimension(6, 16));
        messageLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageLabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(lotNumberText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bedRoomsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(squareFeetText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lotNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(squareFeetText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bedRoomsText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

    private void firstNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextActionPerformed

    private void messageLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageLabelActionPerformed

    private void squareFeetTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareFeetTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_squareFeetTextActionPerformed

    private void lotNumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotNumberTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotNumberTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        RealEstate o = new RealEstate();
        o.setVisible(true);
        o.setLocationRelativeTo(null);
        o.messageLabel.setText("");

        file.resetToRead();
        while (file.hasNextHouse()) {
            list.insertItem(file.getNextHouse());
        }
        if (list.getSize() > 0) {
            o.displayHouse(list.getItem(0));
        } else {
            o.messageLabel.setText("No houses to display");
            o.clearForm();
        }

        o.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                file.addHouses(list);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField bedRoomsText;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField firstNameText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lastNameText;
    private javax.swing.JTextField lotNumberText;
    private javax.swing.JTextField messageLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField priceText;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField squareFeetText;
    // End of variables declaration//GEN-END:variables

    private Icon DrawImage(Icon resetIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
