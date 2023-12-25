package TowerDefence.graphical_game;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import TowerDefence.inputs.MyMouseListener; // Import your MyMouseListener class

public class DragAndDropGridExample extends JFrame {

    private JPanel[][] gridCells;  // Represents the grid cells
    private MyMouseListener myMouseListener; // Add a MyMouseListener instance

    public DragAndDropGridExample() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        Gaulois1 gaulois1 = new Gaulois1(0, 0);
        Gaulois2 gaulois2 = new Gaulois2(0, 0);
        Gaulois3 gaulois3 = new Gaulois3(0, 0);

        JButton buttonG1 = new JButton("1");
        JButton buttonG2 = new JButton("2");
        JButton buttonG3 = new JButton("3");

        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(buttonG1, DnDConstants.ACTION_COPY, new DragGestureListener() {
            public void dragGestureRecognized(DragGestureEvent event) {
                ds.startDrag(event, DragSource.DefaultCopyDrop, new TransferableGaulois(gaulois1), null);
            }
        });

        DragSource ds2 = new DragSource();
        ds2.createDefaultDragGestureRecognizer(buttonG2, DnDConstants.ACTION_COPY, new DragGestureListener() {
            public void dragGestureRecognized(DragGestureEvent event) {
                ds2.startDrag(event, DragSource.DefaultCopyDrop, new TransferableGaulois(gaulois2), null);
            }
        });

        DragSource ds3 = new DragSource();
        ds3.createDefaultDragGestureRecognizer(buttonG3, DnDConstants.ACTION_COPY, new DragGestureListener() {
            public void dragGestureRecognized(DragGestureEvent event) {
                ds3.startDrag(event, DragSource.DefaultCopyDrop, new TransferableGaulois(gaulois3), null);
            }
        });

        buttonPanel.add(buttonG2);
        buttonPanel.add(buttonG1);
        buttonPanel.add(buttonG3);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize grid
        int rows = 5;
        int cols = 10;
        gridCells = new JPanel[rows][cols];

        JPanel gridPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridCells[i][j] = new JPanel();
                gridCells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add borders for clarity
                gridCells[i][j].setTransferHandler(new TransferHandler("gaulois"));
                new DropTarget(gridCells[i][j], new DropTargetAdapter() {
                    public void drop(DropTargetDropEvent dtde) {
                        try {
                            Gaulois1 droppedGaulois = (Gaulois1) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                            setColorForGridCell((JPanel) dtde.getDropTargetContext().getComponent(), Color.CYAN);  // Set color for the dropped cell
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                gridPanel.add(gridCells[i][j]);

                // Add MyMouseListener to each grid cell
                MyMouseListener listener = new MyMouseListener();
                gridCells[i][j].addMouseListener(listener);
                gridCells[i][j].addMouseMotionListener(listener);
            }
        }

        // Initialize MyMouseListener for the entire grid
        myMouseListener = new MyMouseListener(null);
        gridPanel.addMouseListener(myMouseListener);
        gridPanel.addMouseMotionListener(myMouseListener);

        add(gridPanel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Helper method to set color for a grid cell
    private void setColorForGridCell(JPanel cell, Color color) {
        cell.setBackground(color);
    }

    class TransferableGaulois implements Transferable {
        private Gaulois1 gaulois;
        private Gaulois2 gaulois2;
        private Gaulois3 gaulois3;

        public TransferableGaulois(Gaulois1 gaulois) {
            this.gaulois = gaulois;
        }

        public TransferableGaulois(Gaulois2 gaulois2) {
            this.gaulois2 = gaulois2;
        }

        public TransferableGaulois(Gaulois3 gaulois3) {
            this.gaulois3 = gaulois3;
        }

        public Object getTransferData(DataFlavor flavor) {
            return gaulois;
        }

        public Object getTransferData2(DataFlavor flavor) {
            return gaulois2;
        }

        public Object getTransferData3(DataFlavor flavor) {
            return gaulois3;
        }

        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{new DataFlavor(Gaulois1.class, "Gaulois")};
        }

        public boolean isDataFlavorSupported2(DataFlavor flavor) {
            return flavor.equals(new DataFlavor(Gaulois2.class, "Gaulois 2"));
        }

        public boolean isDataFlavorSupported3(DataFlavor flavor) {
            return flavor.equals(new DataFlavor(Gaulois3.class, "Gaulois 3"));
        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(new DataFlavor(Gaulois1.class, "Gaulois"));
        }

        public boolean isDataFlavorSupported4(DataFlavor flavor) {
            return flavor.equals(new DataFlavor(Gaulois2.class, "Gaulois 2"));
        }

        public boolean isDataFlavorSupported5(DataFlavor flavor) {
            return flavor.equals(new DataFlavor(Gaulois3.class, "Gaulois 3"));
        }
    }
}
