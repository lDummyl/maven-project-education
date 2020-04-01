package bonus;

// TODO: 1/26/20 Заменить все артикли "а" кроме первого и последнего, заменять следует только артикли
//  буквы "а" в составе слов замене не подлежат.


import java.util.ArrayList;

public class ArticleReplacement {

	public static void main(String[] args) {

		String s = "a creature is a small part of a big world. A bear is an example of wild animal who influences a lot on the whole world.";
		//String a = "a";
		//String b = "the";
		ArticleReplacement articleReplacement = new ArticleReplacement();
		findNumberOfArticle(s);
		changeArticle2(s, articleReplacement.findNumberOfArticle(s));


	//	changeArticle(s, articleReplacement.findNumberOfArticle(s));
	}

	public static ArrayList<Integer> findNumberOfArticle(String s){
		ArrayList<Integer> list = new ArrayList<>();
 		for (int i = 0; i < s.length(); i++){           //s.contains("a ") || s.contains("an ") || s.contains("A ") || s.contains("An ")
			if ( (('a' == s.charAt(i)) || ('A' == s.charAt(i)) ) && (' ' == s.charAt(i + 1))){
				list.add(i);
			}
		}
		System.out.println("Номера артиклей:  " + list);

 		return list;
	}

	/*public static void changeArticle(String s, ArrayList<Integer> list) {
		String str = "";
		for (Integer integer : list) {
			str = s.replace("a ", "the ");
		}
		System.out.println(str);
	}*/

	public static void changeArticle2(String s, ArrayList<Integer> list){
		String str = "";
		if (s.contains("a ") || s.contains("A ") || s.contains("an ")){
			str = s.replaceAll("a ", "the ");
			str = str.replaceAll("an ", "the ");
			str = str.replaceAll("A ", "The ");
		}
		System.out.println(str);

		for (int i = 0; i < list.size() ; i++ ){
			System.out.println(list.toArray()[0]);  //0
			System.out.println(list.toArray()[list.size()-1]); //94
		}
	}

}
