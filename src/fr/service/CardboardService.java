package fr.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CardboardService {
	
	private static final Integer ZERO = 0;
	
	private static final Integer DIX = 10;

	/**
	 * Generate optimized list of cardboard
	 * @param chaine
	 * @return string
	 * @throws NumberFormatException
	 */
	static public String generateListCardBoard(String chaine) throws NumberFormatException  {
		String optimizedCardboard = new String();
		if (StringUtils.isNotBlank(chaine)) {
			List<String> listChaine = new LinkedList<String>(Arrays.asList(chaine.split("")));
			while(!ZERO.equals(listChaine.size())) {
				Integer lot = Integer.parseInt(listChaine.get(0));
				listChaine.remove(0);
				optimizedCardboard += findLotInList(lot, listChaine).concat("/");
			}
			optimizedCardboard.substring(0, optimizedCardboard.length() - 2);
		}
		return optimizedCardboard;
	}
	
	/**
	 * Get optimized cardboard
	 * @param lot
	 * @param listChaine
	 * @return string
	 * @throws NumberFormatException
	 */
	static private String findLotInList(Integer lot, List<String> listChaine) 
			throws NumberFormatException {
		String lots = String.valueOf(lot);
		int sum = lot;
		for (int i = 0; i < listChaine.size(); i++) {
			String value = listChaine.get(i);
			int number = Integer.parseInt(value);
			// cardboard is full, go next cardboard
			if (DIX.equals(sum + number)) {
				sum = sum + number;
				lots = lots.concat(value);
				removeLotInList(value, listChaine);
				break;
			}
			// cardboard is not full
			else if (sum + number < 10) {
				sum = sum + number;
				lots = lots.concat(value);
				removeLotInList(value, listChaine);
			}
		}
		return lots;
	}
	
	/**
	 * Remove lot in list
	 * @param lot
	 * @param listChaine
	 */
	static private void removeLotInList(String lot, List<String> listChaine) {
		listChaine.remove(lot);
	}
	
}
