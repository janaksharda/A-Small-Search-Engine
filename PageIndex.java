class PageIndex{
	MyLinkedList<WordEntry> ListOfWordEntry;
	int totalWords;
	PageIndex(){
		ListOfWordEntry = new MyLinkedList<WordEntry>();
		totalWords=0;
	}
	void addPositionForWord(String str, Position p){
		if(p==null) throw new IllegalArgumentException("Position empty");
		MySet<WordEntry> b = ListOfWordEntry.list;
		node<WordEntry> temp = b.a;
		while((temp.next!=null)||(temp.data!=null)){
			String str1 = temp.data.str;
			if(str1.equals(str)){
				totalWords++;
				temp.data.addPosition(p);
				return;
			}
			temp=temp.next;
		}
		WordEntry tempa = new WordEntry(str);
		tempa.addPosition(p);
		totalWords++;
		ListOfWordEntry.addElement(tempa);
		return;
	}
	MyLinkedList<WordEntry> getWordEntries(){
		if(ListOfWordEntry==null) throw new IllegalArgumentException("Empty ListOfWordEntry");
		return ListOfWordEntry;
	}
}