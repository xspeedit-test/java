package fr.service;

import java.util.ArrayList;
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
			List<Integer> listChaine = new ArrayList<>();
			// convert chaîne to list integer
			for (char ch: chaine.toCharArray()) {
			    listChaine.add(Integer.parseInt(Character.toString(ch)));
			}
			
			while(!ZERO.equals(listChaine.size())) {
				Integer lot = listChaine.get(0);
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
	static private String findLotInList(Integer lot, List<Integer> listChaine) 
			throws NumberFormatException {
		String lots = String.valueOf(lot);
		int sum = lot;
		for (int i = 0; i < listChaine.size(); i++) {
			Integer value = listChaine.get(i);
			// cardboard is full, go next cardboard
			if (DIX.equals(sum + value)) {
				sum = sum + value;
				lots = lots.concat(value.toString());
				removeLotInList(value, listChaine);
				break;
			}
			// cardboard is not full
			else if (sum + value < 10) {
				sum = sum + value;
				lots = lots.concat(value.toString());
				removeLotInList(value, listChaine);
			}
		}
		return lots;
	}
	
	/**
	 * Remove lot in list
	 * @param value
	 * @param listChaine
	 */
	static private void removeLotInList(Integer value, List<Integer> listChaine) {
		listChaine.remove(value);
	}
	
}
