package ocurance_of_given_character_in_string;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfGivenCharacterByHashmap {
public static void main(String[] args) {
	HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
	String str="abcdeabc";
	char ch[]=str.toCharArray();
	for(char c:ch)
	{
		if(hmap.containsKey(c))
		{
			hmap.put(c, hmap.get(c)+1);
		}
		else
			hmap.put(c, 1);
	}
	for(Map.Entry<Character, Integer> entry:hmap.entrySet())
	{
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
}
}
