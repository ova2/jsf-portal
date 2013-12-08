package ova.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;


/**
 * ChartBean
 */
@Named
@ViewScoped
public class ChartBeanA implements Serializable
{
	//~ Instance fields --------------------------------------------------------

	private PieChartModel pieModel;

	private boolean showPanel;

	//~ Constructors -----------------------------------------------------------

	public ChartBeanA()
	{
		createPieModel();
	}

	//~ Methods ----------------------------------------------------------------

	public PieChartModel getPieModel()
	{
		return pieModel;
    }

    private void createPieModel()
	{
		pieModel = new PieChartModel();

		pieModel.set("Brand 1", 540);
		pieModel.set("Brand 2", 325);
		pieModel.set("Brand 3", 702);
		pieModel.set("Brand 4", 421);
	}

	public boolean isShowPanel()
	{
		return showPanel;	}

	public void setShowPanel(boolean showPanel)	{
	
  
         this.showPanel = showPanel;
	}

	public void toggleShowPanel()
	{
		showPanel = !showPanel;
	}
}
