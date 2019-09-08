package mx.gft.rendimiento;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main3( String[] args ) throws Exception
    {
    	for(int k = 12; k <19; k++) {
    	String archCSVRed = "/home/zx/Downloads/maiz/prediction/red/red_20"+k+"N.csv";
    	String archCSVPrep = "/home/zx/Downloads/maiz/prediction/prep/20"+k+"Precip.csv";
    	String archCSVTMax = "/home/zx/Downloads/maiz/prediction/tmax/20"+k+"Tmax.csv";
    	String archCSVTMed = "/home/zx/Downloads/maiz/prediction/tprom/20"+k+"Tmed.csv";
    	
    	CSVReader csvReader = new CSVReader(new FileReader(archCSVRed));
    	String[] fila = null;
    	Map<String, EntidadDataset> mapMeans = new HashMap<String, EntidadDataset>();
    	while((fila = csvReader.readNext()) != null) {
    	    if(!mapMeans.containsKey(fila[0])) {
    	    	mapMeans.put(fila[0], new EntidadDataset(null, null, null, fila[1]));
    	    }
    	}
    	
    	CSVReader csvReaderPrep = new CSVReader(new FileReader(archCSVPrep));
    	csvReaderPrep.readNext();
    	while((fila = csvReaderPrep.readNext()) != null) {
    	    if(mapMeans.containsKey(fila[0])) {
    	    	EntidadDataset enti = mapMeans.get(fila[0]);
    	    	double mean = 0;
    	    	for(int i=1; i < 13; i++) {
    	    		mean = mean + Double.parseDouble(fila[i]);
    	    	}
    	    	mean = mean / 12;
    	    	enti.setPrep(mean+"");
    	    }
    	}
    	
    	CSVReader csvReaderTMax = new CSVReader(new FileReader(archCSVTMax));
    	csvReaderTMax.readNext();
    	while((fila = csvReaderTMax.readNext()) != null) {
    	    if(mapMeans.containsKey(fila[0])) {
    	    	EntidadDataset enti = mapMeans.get(fila[0]);
    	    	double mean = 0;
    	    	for(int i=1; i < 13; i++) {
    	    		mean = mean + Double.parseDouble(fila[i]);
    	    	}
    	    	mean = mean / 12;
    	    	enti.setTmax(mean+"");
    	    }
    	}
    	
    	
    	CSVReader csvReaderTMed = new CSVReader(new FileReader(archCSVTMed));
    	csvReaderTMed.readNext();
    	while((fila = csvReaderTMed.readNext()) != null) {
    	    if(mapMeans.containsKey(fila[0])) {
    	    	EntidadDataset enti = mapMeans.get(fila[0]);
    	    	double mean = 0;
    	    	for(int i=1; i < 13; i++) {
    	    		mean = mean + Double.parseDouble(fila[i]);
    	    	}
    	    	mean = mean / 12;
    	    	enti.setTmed(mean+"");
    	    }
    	}
    	
    	for (Map.Entry<String, EntidadDataset> entry : mapMeans.entrySet()) {
    	    System.out.println("\"" + entry.getKey().toUpperCase() + "\", " + entry.getValue().toString());
    	}
    	csvReader.close();
    	csvReaderPrep.close();
    	csvReaderTMax.close();
    	csvReaderTMed.close();
    	System.out.println("\n\n");
    	}
    }
}
