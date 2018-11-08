class MyHashTableNode{
	WordEntry word;
	MyHashTableNode next;
	MyHashTableNode(){
		word = null;
		next = null;
	}
}
class MyHashTable{
	MyHashTableNode[] hashTable;
	MyHashTable(){
		hashTable = new MyHashTableNode[50];
		for(int i=0; i<50; i++){
			hashTable[i] = new MyHashTableNode();
		}
	}
	int getHashIndex(String str){
		int n=0;
		for(int i=0; i<str.length();i++){
			n+=(int)str.charAt(i);
		}
		return n%50;
	}
	void addPositionsForWord(WordEntry w){
		if(w==null) throw new IllegalArgumentException("empty wordentry in addPostitionsForWord");
		int index = getHashIndex(w.str);
		MyHashTableNode temp = hashTable[index];
		while(temp.word!=null){
			if(w.str.equals(temp.word.str)){
				temp.word.addPositions(w.positionlist);
				return;
			}
			temp=temp.next;
		}
		MyHashTableNode newNode = new MyHashTableNode();
		newNode.word = w;
		MyHashTableNode tempa = hashTable[index];
		hashTable[index] = newNode;
		newNode.next = tempa;
		return;		
	}
}