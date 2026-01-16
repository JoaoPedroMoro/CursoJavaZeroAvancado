package efeito;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelRevelacao extends JPanel implements MouseMotionListener{
	
	private BufferedImage imagemInferior;
	
	private BufferedImage imagemSuperior;
	
	private int posicaoMouseX = -100;
	
	private int posicaoMouseY = -100;
	
	private static final int RAIO = 50;
	
	public PainelRevelacao(String caminhoInferior, String caminhoSuperior) throws Exception {

        imagemInferior = ImageIO.read(new File(caminhoInferior));

        BufferedImage temp = ImageIO.read(new File(caminhoSuperior));

        imagemSuperior = new BufferedImage(
            imagemInferior.getWidth(),  
            imagemInferior.getHeight(), 
            BufferedImage.TYPE_INT_ARGB  
        );

        Graphics2D g = imagemSuperior.createGraphics();

        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,               
            RenderingHints.VALUE_INTERPOLATION_BILINEAR    
        );

        g.drawImage(
            temp,                        
            0, 0,                          
            imagemInferior.getWidth(),       
            imagemInferior.getHeight(),     
            null                            
        );

        g.dispose();

        setPreferredSize(new java.awt.Dimension(
            imagemInferior.getWidth(),  
            imagemInferior.getHeight()   
        ));


        addMouseMotionListener(this);

    }
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(imagemInferior, 0, 0, null);
		
		Graphics2D g2 = (Graphics2D) g.create();
		
		Ellipse2D areaDeRevelacao = new Ellipse2D.Double(posicaoMouseX - RAIO, posicaoMouseY - RAIO, RAIO * 2, RAIO * 2);
		
		g2.setClip(areaDeRevelacao);
		
		g2.drawImage(imagemSuperior, 0, 0, null);
		
		g2.dispose();
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		posicaoMouseX = e.getX();
		
		posicaoMouseY = e.getY();
		
		repaint();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

}
