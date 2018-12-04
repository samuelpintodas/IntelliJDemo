package SliderSynchro;

import java.awt.FlowLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.text.Document;


public class mySliderFrame extends JFrame
{
	JSlider mySlider1 = new JSlider();
	JSlider mySlider2 = new JSlider();
	JSlider mySlider3 = new JSlider();
	
	JCheckBox myCheck1 = new JCheckBox("Mute all");
	JCheckBox myCheck2 = new JCheckBox("Mute aux 1");
	JCheckBox myCheck3 = new JCheckBox("Mute aux 2");
	
	JPanel panelSlide = new JPanel();
	JPanel panelCheck = new JPanel();

	public mySliderFrame(BoundedRangeModel brm1, BoundedRangeModel brm2, BoundedRangeModel brm3, ButtonModel tbm1, ToggleButtonModel tbm2, ToggleButtonModel tbm3)
	{
		
		setLayout(new FlowLayout());
		
		mySlider1.setModel(brm1);
		mySlider2.setModel(brm2);
		mySlider3.setModel(brm3);
		
		myCheck1.setModel(tbm1);
		myCheck2.setModel(tbm2);
		myCheck3.setModel(tbm3);
		
		
		panelSlide.add(mySlider1);
		panelSlide.add(mySlider2);
		panelSlide.add(mySlider3);
		
		panelCheck.add(myCheck1);
		panelCheck.add(myCheck2);
		panelCheck.add(myCheck3);
		
		add(panelCheck);
		add(panelSlide);
		
		setSize(700,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}
