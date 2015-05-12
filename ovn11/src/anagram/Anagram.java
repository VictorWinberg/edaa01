package anagram;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Anagram {
	private Map<String, Set<String>> anagrams;

	/** Skapar ett objekt som hanterar anagram. */
	public Anagram() {
		
	}

	/** Lägger till ordet word */
	public void add(String word) {
		
	}

	/**
	 * Returnerar en mängd med alla ord som är anagram till ett visst ord. word
	 * ska inte ing� i den m�ngd som returneras. Om word inte har n�gra insatta
	 * anagram ska en tom mängd returneras.
	 */
	public Set<String> getAnagramsOf(String word) {
		return null;
	}

	/** Returnerar en sträng med bokstäverna i word sorterade i bokstavsordning. */
	private String alphabetize(String word) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			StringBuilder temp = new StringBuilder();
			temp.append(word.charAt(i));
			list.add(temp.toString());
		}
		Collator collator = Collator.getInstance(new Locale("sv", "se"));
		Collections.sort(list, collator);
		StringBuilder b = new StringBuilder();
		for (String s : list) {
			b.append(s);
		}
		return b.toString();
	}

	public static void main(String[] args) {
		Anagram an = new Anagram();
		an.add("avig");
		an.add("viga");
		an.add("eldig");
		an.add("ledig");
		an.add("digel");
		System.out.println(an.getAnagramsOf("giva")); // utskrift: mängd med
														// orden avig, viga
		System.out.println(an.getAnagramsOf("ledig")); // utskrift: mängd med
														// orden digel, eldig
	}
}
