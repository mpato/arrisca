import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGrid02 {

    public static void main(String[] args) {
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	}
	
	JFrame frame = new JFrame("Testing");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new BorderLayout());
	frame.add(new TestPane());
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }

    public static class TestPane extends JPanel {

        private int columnCount = 5;
        private int rowCount = 5;
        private List<Rectangle> cells;
        private Point selectedCell;

        public TestPane() {
            cells = new ArrayList<>(columnCount * rowCount);
            MouseAdapter mouseHandler;
            mouseHandler = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    Point point = e.getPoint();

                    int width = getWidth();
                    int height = getHeight();

                    int cellWidth = width / columnCount;
                    int cellHeight = height / rowCount;

                    int column = e.getX() / cellWidth;
                    int row = e.getY() / cellHeight;

                    selectedCell = new Point(column, row);
                    repaint();

                }
            };
            addMouseMotionListener(mouseHandler);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void invalidate() {
            cells.clear();
            selectedCell = null;
            super.invalidate();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
	    float x, y;
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            int cellWidth = width / columnCount;
            int cellHeight = height / rowCount;

            int xOffset = (width - (columnCount * cellWidth)) / 2; // - cellWidth /2;
            int yOffset = (height - (rowCount * cellHeight)) / 2;

	     g2d.setColor(Color.GRAY);
            //if (cells.isEmpty()) {
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
			x = xOffset + (col * cellWidth);
			y = yOffset + (row * cellHeight);
			Rectangle cell = new Rectangle((int)x,
						       (int)y,
						       cellWidth,
						       cellHeight);
                        System.out.println("t: " + x +","+y);
			g2d.drawString(col + ", " + row, x, y);
			//      cells.add(cell);
			g2d.draw(cell);
                    }
                }
		//}

            if (selectedCell != null) {
                //int index = selectedCell.x + (selectedCell.y * columnCount);
                //Rectangle cell = cells.get(index);
		x = xOffset + ((int)selectedCell.x * cellWidth);
		y = yOffset + ((int)selectedCell.y * cellHeight);
		Rectangle cell = new Rectangle((int)x,
					       (int)y,
					       cellWidth,
					       cellHeight);
                g2d.setColor(Color.BLUE);
                g2d.fill(cell);

            }

            g2d.dispose();
        }
    }
}
