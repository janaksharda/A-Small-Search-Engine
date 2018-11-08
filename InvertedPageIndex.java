class InvertedPageIndex{
	MyHashTable InvertedIndex;
	InvertedPageIndex(){
		InvertedIndex = new MyHashTable();
	}
	void addPage(PageEntry p){
		if(p==null) throw new IllegalArgumentException("Empty PageEntry");
		MyLinkedList<WordEntry> temp = p.getPageIndex().getWordEntries();
		MySet<WordEntry> tempList = temp.list;
		for(node<WordEntry> tempNode = tempList.a;tempNode!=null;tempNode=tempNode.next){
			if(tempNode.data!=null)
				InvertedIndex.addPositionsForWord(tempNode.data);
			}
	}
	MySet<PageEntry> getPagesWhichContainWord(String str){
		try{
			int index = InvertedIndex.getHashIndex(str);
			MySet<PageEntry> returnList = new MySet<PageEntry>();
			MyHashTableNode tmp = InvertedIndex.hashTable[index];
			while(tmp!=null&&tmp.word!=null){
				if(tmp.word.str.equals(str)){
					break;
				}
				tmp = tmp.next; 
			}
			if(tmp!=null&&tmp.word!=null){
				node<Position> tempPositionListNode = tmp.word.positionlist.list.a;
				while(tempPositionListNode!=null){
					if(tempPositionListNode.data!=null){
						returnList.addElement(tempPositionListNode.data.getPageEntry());
					}
					tempPositionListNode = tempPositionListNode.next;
				}
				return returnList;
			}
			return null;
			//throw new IllegalArgumentException("str not found");
		} 
		catch(Exception e){
		  	throw new IllegalArgumentException("Error in function getPagesWhichContainWord");
		}
	}
}