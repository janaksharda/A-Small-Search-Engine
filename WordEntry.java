class WordEntry{
	String str;
	MyLinkedList<Position> positionlist;
	WordEntry(String word){
		this.str = word;
		this.positionlist = new MyLinkedList<Position>();
	}
	void addPosition(Position position){
		positionlist.addElement(position);
	}
	void addPositions(MyLinkedList<Position> positions){
		positionlist = positionlist.Union(positions);
	}
	MyLinkedList<Position> getAllPositionsForThisWord(){
		return positionlist;
	}
	float getTermFrequency(String word){
		try{
			return positionlist.numOfElements()/positionlist.list.a.data.p.indexOfPage.totalWords;
		}
		catch(Exception e){
			throw new IllegalArgumentException();
		}
	}
	String disp(){
		node<Position> temp = positionlist.list.a;
		String str = "";
		while(temp.next!=null){
			str=(", "+temp.data.wordIndex)+str;
			temp = temp.next;
		}
		return str.substring(2,str.length());
	}
}