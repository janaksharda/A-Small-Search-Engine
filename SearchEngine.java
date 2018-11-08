class SearchEngine{
	InvertedPageIndex invertedPageIndex;
	SearchEngine(){
		invertedPageIndex = new InvertedPageIndex();
	}
	void disp(){
		for(int i=0;i<50;i++){
			MyHashTableNode temp = invertedPageIndex.InvertedIndex.hashTable[i];
			for(;temp.word!=null;temp=temp.next){
				System.out.print(temp.word.str+" ");
				temp.word.disp();
			}
		}
	}
	void performAction(String actionMessage){
		String str[] = actionMessage.split(" ");
		if (str[0].equals("addPage")){
			try{
				PageEntry webPage = new PageEntry("webpages/"+str[1]);
				invertedPageIndex.addPage(webPage);
			}
			catch(Exception e){
				System.out.println("Error in actionMessage addPage");
			}
		}
		else if (str[0].equals("queryFindPagesWhichContainWord")){
			String tempString = str[1];
			str[1]=str[1].toLowerCase();
			MySet<PageEntry> temp = invertedPageIndex.getPagesWhichContainWord(str[1]);
			try{
				if(str[1].contains("!")||str[1].contains("#")||str[1].contains("-")||str[1].contains("=")||str[1].contains("}")||str[1].contains("{")||str[1].contains("]")||str[1].contains("[")||str[1].contains("\"")||str[1].contains("'")||str[1].contains(":")||str[1].contains(";")||str[1].contains("?")||str[1].contains(">")||str[1].contains(",")||str[1].contains(".")||str[1].contains("<")){
					System.out.println("Invalid input");
					return;
				}
				node<PageEntry> tempNode = temp.a;
				String tempStr="";
				while(tempNode!=null){
					if(tempNode.data!=null)
						tempStr = tempStr+(tempNode.data.name+", ");
					tempNode = tempNode.next;
				}
				System.out.println(tempStr.substring(0,tempStr.length()-2));
			}
			catch(Exception e){
				if(temp==null)System.out.println("No webpage contains word "+tempString);
			}
		}   	else if(str[0].equals("queryFindPositionsOfWordInAPage")){ 	
				int flag=0;
				if(str[1].contains("!")||str[1].contains("#")||str[1].contains("-")||str[1].contains("=")||str[1].contains("}")||str[1].contains("{")||str[1].contains("]")||str[1].contains("[")||str[1].contains("\"")||str[1].contains("'")||str[1].contains(":")||str[1].contains(";")||str[1].contains("?")||str[1].contains(">")||str[1].contains(",")||str[1].contains(".")||str[1].contains("<")){
					System.out.println("Invalid input");
					return;
				}
				String tempString1 = str[1];
				String tempString2 = str[2];
				str[1]=str[1].toLowerCase();
				MySet<PageEntry> temp = invertedPageIndex.getPagesWhichContainWord(str[1]);
			try{
				node<PageEntry> tempNode = temp.a;		
				while(tempNode.data!=null){
					if(tempNode.data.name.equals(str[2])) break;
					tempNode = tempNode.next;
				}

				if(tempNode.data!=null){
					node<WordEntry> tempNode1 = tempNode.data.indexOfPage.ListOfWordEntry.list.a;
					while(tempNode1.data!=null){
						if(str[1].equals(tempNode1.data.str)){
							break;
						}
						tempNode1 = tempNode1.next;
					}
					if(tempNode1.data!=null){
						System.out.println(tempNode1.data.disp());
						return;
					}
					else{
						flag=1;
						throw new IllegalArgumentException();
					}
				}
				else throw new IllegalArgumentException("Error");
			}
			catch(Exception e){
			 	if((temp == null)||(flag==1))System.out.println("Webpage "+tempString2+" does not contain word "+tempString1);
			 	else if(temp.a==null)System.out.println("No Webpage "+tempString2+"found");
			}
		}
	}
}