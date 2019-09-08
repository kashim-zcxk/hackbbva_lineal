package mx.gft.rendimiento;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main4( String[] args ) throws Exception
    {
    	String archCSV = "/home/zx/Downloads/maiz/prediction/red/red_2018.csv";
    	CSVReader csvReader = new CSVReader(new FileReader(archCSV));
    	String[] fila = null;
    	Map<String, Entidad> mapMeans = new HashMap<String, Entidad>();
    	csvReader.readNext();
    	while((fila = csvReader.readNext()) != null) {
    	  //  System.out.println(fila[2]
    	   //           + " | " + fila[21]);
    	    if(mapMeans.containsKey(fila[2])) {
    	    	Entidad enti = mapMeans.get(fila[2]);
    	    	enti.setRendimiento(enti.getRendimiento() + Double.parseDouble(fila[21] != null ? fila[21] : "0"));
    	    	enti.setNum(enti.getNum()+1);
    	    }else {
    	    	mapMeans.put(fila[2], new Entidad(Double.parseDouble(fila[21] != null ? fila[21] : "0"), 1));
    	    }
    	}
    	for (Map.Entry<String, Entidad> entry : mapMeans.entrySet()) {
    	    System.out.printf("\"" + entry.getKey().toUpperCase() + "\",%.2f\n", entry.getValue().getRendimiento()/entry.getValue().getNum());
    	}
    	csvReader.close();
    }
}
