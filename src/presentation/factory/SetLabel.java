package presentation.factory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentation.loginui.LoginUI;
import presentation.mainframe.MainFrame;

public class SetLabel extends JLabel{

		
		public SetLabel(){
			setBounds(40,600,50,50);
			setIcon(new ImageIcon("image\\set1.png"));
			addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					MainFrame.setContentPanel(new SetUI());
				}
		
				@Override
				public void mouseEntered(MouseEvent arg0) {
					setIcon(new ImageIcon("image\\set2.png"));

					
				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					setIcon(new ImageIcon("image\\set1.png"));
				
					
				}
		
				@Override
				public void mousePressed(MouseEvent arg0) {
					
					
				}
		
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
					
				}
		    	
		    });
		};
}
