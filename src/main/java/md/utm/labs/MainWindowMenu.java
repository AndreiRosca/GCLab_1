package md.utm.labs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MainWindowMenu {
	private MainWindow mainWindow;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");

	public MainWindowMenu(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		createMenu();
	}

	private JMenuItem createOpenMenuItem() {
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(new OpenMenuItemActionListener());
		return openMenuItem;
	}

	private JMenuItem createSaveMenuItem() {
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemActionListener());
		return saveMenuItem;
	}

	private JMenuItem createDrawMenuItem() {
		JMenuItem drawMenuItem = new JMenuItem("Draw");
		drawMenuItem.addActionListener((actionListener) -> {
			mainWindow.createShapes();
			SwingUtilities.updateComponentTreeUI(mainWindow);
		});
		return drawMenuItem;
	}

	private JMenuItem createExitMenuItem() {
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener((actionListener) -> System.exit(0));
		return exitMenuItem;
	}

	private void createMenu() {
		fileMenu.add(createOpenMenuItem());
		fileMenu.add(createSaveMenuItem());
		fileMenu.add(createDrawMenuItem());
		fileMenu.add(createExitMenuItem());
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);
	}

	private class OpenMenuItemActionListener implements ActionListener {
		private JFileChooser chooser = new JFileChooser();

		public void actionPerformed(ActionEvent actionEvent) {
			if (chooser.showOpenDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
				File chosenFile = chooser.getSelectedFile();
				try {
					mainWindow.setDrawing(Drawing.loadDrawing(chosenFile));
					SwingUtilities.updateComponentTreeUI(mainWindow);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured while reading the image", "Error", 0);
					throw new RuntimeException(e);
				}
			}
		}
	}

	private class SaveMenuItemActionListener implements ActionListener {
		private JFileChooser chooser = new JFileChooser();

		public void actionPerformed(ActionEvent actionEvent) {
			if (chooser.showSaveDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
				File chosenFile = chooser.getSelectedFile();
				try {
					mainWindow.getDrawing().saveDrawing(chosenFile);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry, an error occured while saving the image", "Error", 0);
					throw new RuntimeException(e);
				}
			}
		}
	}
}
