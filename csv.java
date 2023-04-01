package tercerparcial;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class csv {
	String archivoCSV = "C:\\Users\\xical\\Desktop\\Practica Hola Mundo\\tercerparcial\\emails.csv"; 
	        String linea = "";  
	        String separador = ",";  
	        int filas_a_evaluar = 50;   
	        int contador = 1; 
	        int digitos; 
	 
public void ejecutar (int id){
	         
 
	digitos=id%1000; 
	digitos=digitos-1;  
	
	        Map<String, Integer> columnas = new HashMap<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	        	
	            // Leer la primera línea del archivo
	            linea = br.readLine();
	            String[] titulos = linea.split(separador); 

	            // Agregar las columnas al HashMap
	            for (int i = 1; i < titulos.length; i++) {
	                columnas.put(titulos[i].trim(), 0); 
	            }

	            // Iterar a través de las filas y sumar los valores de las columnas
	            int count = 0;
	            while ((linea = br.readLine()) != null && count < filas_a_evaluar) {
	                String[] valores = linea.split(separador); 
	                 

	                if (contador == digitos) { // verificar si se ha alcanzado la fila deseada
	                    String[] datos = linea.split(separador);

	                    for (int i = 1; i < datos.length; i++) {
	                        String columna = titulos[i];
	                        int valor = Integer.parseInt(datos[i]);
	                        int sumaActual = columnas.get(columna);
	                        columnas.put(columna, sumaActual + valor);
	                    }
	                    count++; 
	                 }
	                else {
	                	contador++;
	                }
 

	            
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 

	        // Guardar los resultados en txt
	        
	        try {
	            FileWriter writer = new FileWriter("174527.txt");
	            for (Map.Entry<String, Integer> entry : columnas.entrySet()) {
	                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	                 
	            }
	            System.out.println("¡Documento creado con exito!");
	            writer.close();
	        } catch (IOException e_2) { 
	            e_2.printStackTrace();
	        }
	}
}
