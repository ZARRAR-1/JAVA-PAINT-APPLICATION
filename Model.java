import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;


@SuppressWarnings("unused")
public class Model {

//	private Model M_View;
	
	private Color myColor;	
	
	
	//variblae to store size of brush
	int brushSize;
	
	public JButton modelEraser;
	public JButton modelBrush;
	public Color modelColor;
	
	public myCanvas modelCanvas;
	
	
	public Model()
	{
		myColor = Color.BLACK;
		brushSize = 10;
	}
	
	public int getSize() {
		return brushSize;
	}
	public void setSize(int Bs) {
		brushSize = Bs;		
	}
	public Color getColor() {
		return myColor;
	}
	public void setColor(Color color) {
		myColor = color;
	}
}
