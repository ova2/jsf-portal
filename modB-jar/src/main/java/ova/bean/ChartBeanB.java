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
public class ChartBeanB implements Serializable
{
	//~ Instance fields --------------------------------------------------------

	private PieChartModel pieModel;

	//~ Constructors -----------------------------------------------------------

	public ChartBeanB()
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

		pieModel.set("Brand A", 540);
		pieModel.set("Brand B", 325);
		pieModel.set("Brand C", 702);
		pieModel.set("Brand D", 421);
	}
}
