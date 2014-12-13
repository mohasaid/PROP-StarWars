import java.awt.*;
import javax.swing.*;

public class RoundedPanel extends JPanel{
    protected int StrokeSize = 1; //Para mejor visualizacion
    protected boolean HQ = true;
    protected Dimension Arcos = new Dimension(20,20);
    protected boolean Sombra = true;
    protected Color ColorSombra = Color.LIGHT_GRAY;
    protected int DistSombra = 4;
    protected int OffSetSombra = 3;
    protected int TransparenciaSombra = 100;
    
    public RoundedPanel() {
        super();
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        int DS = DistSombra;
        Color CS = new Color(ColorSombra.getRed(), ColorSombra.getGreen(), ColorSombra.getBlue(), TransparenciaSombra);
        Graphics2D graphics = (Graphics2D) g;
        
        if(HQ) graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(Sombra) {
            graphics.setColor(getBackground());
            graphics.fillRoundRect(OffSetSombra, OffSetSombra, w-StrokeSize-OffSetSombra, h-StrokeSize-OffSetSombra, Arcos.width, Arcos.height);
        }
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0,0, w-DistSombra, h-DistSombra, Arcos.width, Arcos.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(StrokeSize));
        graphics.drawRoundRect(0, 0, w - DistSombra, 
        h - DistSombra, Arcos.width, Arcos.height);
 
        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
 }
