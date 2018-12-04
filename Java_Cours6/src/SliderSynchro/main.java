package SliderSynchro;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultButtonModel;
import javax.swing.JToggleButton.ToggleButtonModel;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BoundedRangeModel brm1 = new DefaultBoundedRangeModel();
		BoundedRangeModel brm2 = new DefaultBoundedRangeModel();
		BoundedRangeModel brm3 = new DefaultBoundedRangeModel();
		
		ToggleButtonModel tbm1 = new ToggleButtonModel();
		ToggleButtonModel tbm2 = new ToggleButtonModel();
		ToggleButtonModel tbm3 = new ToggleButtonModel();
		
		
		mySliderFrame msf1 = new mySliderFrame(brm1, brm2, brm3, tbm1, tbm2, tbm3);
		mySliderFrame msf2 = new mySliderFrame(brm1, brm2, brm3, tbm1, tbm2, tbm3);
		mySliderFrame msf3 = new mySliderFrame(brm1, brm2, brm3, tbm1, tbm2, tbm3);
		
		msf1.setVisible(true);
		msf2.setVisible(true);
		msf3.setVisible(true);
		
	}

}
