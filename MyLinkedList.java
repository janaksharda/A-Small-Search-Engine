class MyLinkedList<X>{
	MySet<X> list;
	MyLinkedList(){
		list = new MySet();
	}
	void addElement(X data){
		list.addElement(data);
	}
	void delete(X data){
		list.delete(data);
	}
	Boolean IsMember(X data){
		return list.IsMember(data);
	}
	MyLinkedList<X> Union(MyLinkedList b){
		MyLinkedList<X> union = new MyLinkedList<X>();
		union.list = list.Union(b.list);
		return union;
	}
	MyLinkedList<X> Intersection(MyLinkedList b){
		MyLinkedList<X> intersection = new MyLinkedList<X>();
		intersection.list = list.Intersection(b.list);
		return intersection;
	}
	int numOfElements(){
		int i=0;
		if(list == null) throw new IllegalArgumentException();
		node<X> temp = list.a;
		if(temp==null) return i;
		while(temp.next!=null){
			i++;
			temp=temp.next;
		}
		return i;
	}
}