class Position{
	PageEntry p;
	int wordIndex;
	Position(PageEntry p, int wordIndex){
		this.p = p;
		this.wordIndex = wordIndex;
	}
	PageEntry getPageEntry(){
		if(p==null) throw new IllegalArgumentException("no pageEntry found");
		return p;
	}
	int getWordIndex(){
		return wordIndex;
	}
}