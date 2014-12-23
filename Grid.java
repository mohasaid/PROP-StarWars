/**
 *
 * @author Moha
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JPanel;

class Grid extends JPanel {
	//private static final long serialVersionUID = 1L;
    private ArrayList<Point> fillCells; // FORMA
    private ArrayList<Point> planetes;
    private int N;

    public Grid() 
    {
        fillCells = new ArrayList<>();
        planetes = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        for (Point fillCell : fillCells) {
            int cellX = 10 + (fillCell.x * 10);
            int cellY = 10 + (fillCell.y * 10);
            g.setColor(Color.RED); // LIMITE COLOR 
            g.fillRect(cellY, cellX, 10, 10); // cambiado va normal
        }
        for(Point planet : planetes) { // pinto planetas
        	int cellX = 10 + (planet.x * 10);
            int cellY = 10 + (planet.y * 10);
            g.setColor(Color.BLUE);
            g.fillRect(cellY, cellX, 10, 10);
        }
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, 10, 10);
        // empieza en 10
        for (int i = 10; i <= ((N*10)+10); i += 10) { // TAMANO A MODIFICAR * 10 + 10 
            g.drawLine(i, 10, i, ((N*10)+10)); // TAMANO A MODIFICAR * 10 + 10 posicion en panel
        }
        for (int i = 10; i <= ((N*10)+10); i += 10) { // TAMANO A MODIFICAR * 10 + 10
            g.drawLine(10, i, ((N*10)+10), i); // TAMANO A MODIFICAR * 10 + 10 posicion en panel
        }
    }

    public void fillCell(int x, int y) 
    {
        fillCells.add(new Point(x, y));
        repaint();
    }
    
    public void planetaCell(int x, int y)
    {
    	planetes.add(new Point(x,y));
    	repaint();
    }
    
    public void setN(String n) 
    {
    	N = Integer.valueOf(n);
        repaint();
    }
    
    public void borraLimites()
    {
        fillCells.clear();
        repaint();
    }
    
    public void borraPlanetas()
    {
        planetes.clear();
        repaint();
    }
    
    public void borraPlaneta(int x, int y)
    {
        Point p = new Point(x,y);
        planetes.remove(p);
        repaint();
    }
    
    public void PonTodos(String limite) {
    	Scanner sca = new  Scanner(limite);
    	sca.useDelimiter(",");
    	while(sca.hasNext()) {
    		int a = Integer.valueOf(sca.next());
    		int b = Integer.valueOf(sca.next());
    		fillCells.add(new Point(a,b));
    	}
    	sca.close();
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize() 
    {
        int tam = N;
        if(tam > 22) tam = 11*N;
        return new Dimension(tam, tam);
    }
}
