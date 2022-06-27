import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

//import Controller.myMouseAdapter;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

@SuppressWarnings({ "serial", "unused" })
class myCanvas extends Canvas 
{
	//Canvas Elements
	private  Color CanvasColor;
	private int x, y;
	private int BrushSize;
	private Boolean C_Eraser;
	
	
	//Constructor of myCanvas Class
	myCanvas()
	{
		C_Eraser = false;
	}
	
	//Methods
	public void setCanvasColor(Color c)
	{
		CanvasColor = c;
	}
	
	public void setX(int X) {
		x = X;
	}
	
	public void setY(int Y) {
		y = Y;
	}
	
	public void SetBrushSize(int CB_size) {
		BrushSize = CB_size;
	}
	
	public void SetEraser(boolean b) {
		C_Eraser = b;
	}
	
	@Override
	public void paint(Graphics g) {
		
		if(C_Eraser) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, BrushSize, BrushSize);
		}
		
		else {
			g.setColor(CanvasColor);
			g.fillOval(x, y, BrushSize, BrushSize);
		}
		
	}
	
	@Override
	public void update(Graphics g){
		paint(g);
	}
	
}
public class View 
{
	private JFrame frame;
	private JButton ChooseColor;
	private JButton Brush;
	private JButton Eraser;
	private JPanel myPanel;
	private JLabel sizeLabel;
	private JFormattedTextField sizeField;
	private myCanvas canvas;
	private NumberFormatter myFormatter;
	private Color myColor;

	
	public View()
	{
		 frame = new JFrame("Paint App by SNOWLEOPARDS");
		
		 frame.setSize(1000,1000);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 myPanel = new JPanel();
		 myPanel.setPreferredSize(new Dimension(100, 68));
		 myPanel.setMinimumSize(new Dimension(100, 68));
		 myPanel.setMaximumSize(new Dimension(100, 68));
		 
		 ChooseColor = new JButton("Pick Color");
		 ChooseColor.setPreferredSize(new Dimension(100, 20));
		 
	     Brush = new JButton("Brush");
	     Brush.setPreferredSize(new Dimension(80, 20));
	     
	     Eraser = new JButton("Eraser");
	     Eraser.setPreferredSize(new Dimension(80, 20));
	     
	     sizeLabel = new JLabel("       Size Number of Brush :");
	     sizeLabel.setPreferredSize(new Dimension(150, 20));
	     
	     myFormatter = new NumberFormatter(NumberFormat.getInstance());
		 myFormatter.setValueClass(Integer.class);
		 myFormatter.setMinimum(0);
		 myFormatter.setMaximum(Integer.MAX_VALUE);
		 myFormatter.setAllowsInvalid(false);
		 
		 sizeField  = new JFormattedTextField(myFormatter);
		 sizeField .setColumns(10);
	     	     
	     
	     canvas = new myCanvas();
	     canvas.setSize(1000, 1000);
		 canvas.setBackground(Color.WHITE);
		 frame.getContentPane().add(canvas, BorderLayout.CENTER);
	     
		 myPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		 
		 
		 myPanel.add(ChooseColor);
		 myPanel.add(Brush);
		 myPanel.add( Eraser);
		 myPanel.add(sizeLabel);
		 myPanel.add(sizeField);
		 
		 frame.add(canvas);
		 frame.getContentPane().add(myPanel, BorderLayout.NORTH);
		
		
	     frame.pack(); //Aligns frame dimensions automatically with those of sub components
		 
		 frame.setVisible(true);
	}

	
//	Registering Listeners with their Sources

public void addEraserListener(ActionListener listenForEraserButton){
	
	//EraserButton REGISTERS its LISTENER	
	Eraser.addActionListener(listenForEraserButton);
		
	}

public void addBrushListener(ActionListener listenForBrushButton){
	
	Brush.addActionListener(listenForBrushButton);
	
	}

public void addChooseColorListener(ActionListener listenForChooseColorButton){
	
	ChooseColor.addActionListener(listenForChooseColorButton);
	
	}
	
public void addMouse(MouseAdapter mouseAdapter, MouseMotionAdapter motionAdapter) 
{
//	So that the program can implicitly distinguish between pressed and dragged events
	canvas.addMouseMotionListener(motionAdapter);
	canvas.addMouseListener(mouseAdapter);
}

//IMPORTANT
public void addSizeTextActionListener(PropertyChangeListener A) 
{
	sizeField.addPropertyChangeListener(A);
}


//VIEW METHODS NECESSARY TO PROVIDE VIEW FUNCTIONALITIES

public Color getNewColor() {
	new JColorChooser();
	myColor = JColorChooser.showDialog(null, "Choose A Color", Color.WHITE); //returns selected color
	return myColor;
}

public myCanvas getMyCanvas() {
	return canvas;
}

public void ChangeCanvasColor(Color C) {
	canvas.setCanvasColor(C);
}

public void useEraser(boolean b) {
	canvas.SetEraser(b);
}

public void SettingInitialColorAndSize(Color color, int size) 
{
	canvas.setCanvasColor(color);
	sizeField.setValue(size);
	myColor = color;
}

}
