package mx.gft.rendimiento;

import java.io.FileReader;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import com.opencsv.CSVReader;

public class App3 {
	public static void main1(String[] args) throws Exception {
    	String archCSVTMed = "/home/zx/Downloads/maiz/prediction/tabasco.csv";
    	
    	CSVReader csvReader = new CSVReader(new FileReader(archCSVTMed));
    	String[] fila = null;
    	final int numRegist = 7;
    	final int numProp = 3;
    	final int indexRes = 3;
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		double[] y = new double[numRegist];
		double[][] x = new double[numRegist][];
		int i = 0;
    	while((fila = csvReader.readNext()) != null && i<numRegist) {
    		double[] xt = new double[numProp];
    		for(int j=0;j<numProp;j++) {
    			xt[j] = Double.parseDouble(fila[j]);
    		}
    		x[i] = xt;
    		y[i] = Double.parseDouble(fila[indexRes]);
    		i++;
    	}
		regression.newSampleData(y, x);
		
		double[] beta = regression.estimateRegressionParameters();

		double[] residuals = regression.estimateResiduals();

		double[][] parametersVariance = regression.estimateRegressionParametersVariance();

		double regressandVariance = regression.estimateRegressandVariance();

		double rSquared = regression.calculateRSquared();

		double sigma = regression.estimateRegressionStandardError();
		System.out.println(beta[1] + ", " + beta[2] + ", " + beta[3] + ", " + beta[0] + ", " + residuals[0] + "  " + rSquared);
	}
}
