/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebtl;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author au duc nga
 */
public class JPanelWithBackground extends JPanel {

  private Image backgroundImage;

  public JPanelWithBackground(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    g.drawImage(backgroundImage, 0, 0, this);
  }
}