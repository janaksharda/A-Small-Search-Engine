import java.util.*;
import java.io.*;
import java.lang.String;
class PageEntry{
	PageIndex indexOfPage;
	String name;
	PageEntry(String pageName){
		name = pageName.substring(9,pageName.length());
		indexOfPage=new PageIndex();
		try{
			FileInputStream fstream =new FileInputStream(pageName);
			Scanner s = new Scanner(fstream);
			int counter=0;
			while(s.hasNextLine()){
				int i;
				String tempString = s.nextLine();
				tempString=tempString.toLowerCase();
				tempString=tempString.replaceAll("[-|=|.|,|;|:|<|>|?|{|}|'|\"|\\|(|)|#|!|]", " ");
				tempString = tempString.replaceAll("\\[", "").replaceAll("\\]","");//{ } [ ] < > = ( ) . , ; ’ ” ? # ! - :
				tempString=tempString.replaceAll("stacks","stack");
				tempString=tempString.replaceAll("applications","application");
				tempString=tempString.replaceAll("structures","structure");
				String[] arr = tempString.split(" +");
				for(i=0; i<arr.length;i++){
					counter++;
					if(!((arr[i].equals(""))||(arr[i].equals("a"))|| (arr[i].equals("an"))|| (arr[i].equals("the"))|| (arr[i].equals("they"))|| (arr[i].equals("these"))|| (arr[i].equals("this"))|| (arr[i].equals("for"))|| (arr[i].equals("is"))|| (arr[i].equals("are"))|| (arr[i].equals("was"))|| (arr[i].equals("of")) ||(arr[i].equals("or"))|| (arr[i].equals("and"))||(arr[i].equals("does"))||(arr[i].equals("will"))||(arr[i].equals("whose")))){
						Position temp = new Position(this,counter);
						indexOfPage.addPositionForWord(arr[i],temp);
					}
				}
			}
		}
		catch(IOException e){
			throw new IllegalArgumentException("File not found");
		}
	}
	PageIndex getPageIndex(){
		if(indexOfPage == null) throw new IllegalArgumentException("empty indexOfPage");
		return indexOfPage;
	}
}