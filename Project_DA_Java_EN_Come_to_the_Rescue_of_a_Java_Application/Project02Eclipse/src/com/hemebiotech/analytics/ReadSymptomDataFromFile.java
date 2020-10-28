package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * La fonction comptageSymptome est la fonction qui va récupérer les symptômes ligne par ligne et y associer un nombre 
	 * d'occurrence selon le nombre de fois où le symptôme sera apparu
	 * @throws Exception
	 * @see ordonnerListe
	 */

	public static void comptageSymptomes () throws Exception{
	
		BufferedReader reader = new BufferedReader (new FileReader("/Users/cadigrace/Desktop/Test/symptoms.txt"));
		String line = reader.readLine();
		
		Map<String, Integer> SymptomsCount = new HashMap<>();
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			
			
			if (SymptomsCount.containsKey(line)) {
				//incrémenter le compteur pour ce symptome
				//.get récupère la valeur à laquelle ce symptome est associé
				Integer count = SymptomsCount.get(line);
				
				//récupère la valeur du symptome et lui ajoute 1
				SymptomsCount.replace(line,count +1);
				
				//si le symptôme n'a pas encore de valeur, il est initialisé avec la valeur 1
			} else {
				SymptomsCount.put(line, 1);
				//si le symptôme n'a pas encore de valeur, il est initialisé avec la valeur 1
				
			}
			line=reader.readLine();
		}
		reader.close();
		ordonnerListe(SymptomsCount);
	}
	/**
	 * La fonction ordonnerListe récupère la map SymptomsCount, la converti en liste puis ordonne cette liste par 
	 * ordre alphabétique
	 * @param SymptomsCount: map contenant les symptômes et le nombre d'occurence associé
	 * @throws Exception
	 * @see comptageSymptomes
	 */
	public static void ordonnerListe(Map<String,Integer> SymptomsCount)throws Exception{
		
		// conversion de la map en liste
				List <String> symptomList=new ArrayList<>(SymptomsCount.keySet());
				// trier la liste par ordre alphabétique
				Collections.sort(symptomList);
				System.out.println("voyons ce que ça donne: " + symptomList);
				
				// next generate output
				FileWriter writer = new FileWriter ("/Users/cadigrace/Desktop/Test/result.out");
				
				//.keySet --> retourne une vue d'ensemble des clés contenues dans le Map
				for (String symptom: symptomList){ 
					 writer.write(symptom + " : " + SymptomsCount.get(symptom) + "\n");
				}
				
				writer.close();
		
	}
}
