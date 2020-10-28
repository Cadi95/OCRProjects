package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



	/**
	 * AnalyticsCounter est la classe contenant la fonction principale du programme.
	 * @author cadigrace
	 * @version 1.0
	 */
public class AnalyticsCounter {
	
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile.comptageSymptomes ();
		
	}
}