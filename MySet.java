class node<X>{
	X data;
	node<X> next;
	node(X data){
		this.data = data;
		this.next = null;
	}
	node(){
		data = null;
		next = null;
	}
}
class MySet<X>{
	node<X> a;
	public MySet (){
		a = new node<X>();
	}
	public Boolean IsEmpty(){
		if(a.next==null) return true;
		return false;
	}
	void addElement(X n){
		if(IsMember(n)) return;
		node<X> b = new node<X>(n);
		b.next=a;
		a=b;
		return;
	}
	void print(){
		node<X> temp = new node<X>();                           //MySet<X> temp = new MySet<X>();
		temp = a;                                         //temp.a=a.next;
		while(temp.next!=null){                           //System.out.println(a.data);
			System.out.println(temp.data);                //temp.print();
			temp = temp.next;
		}
		return;
	}
	void delete(X n){

		node<X> temp = a;
		if(a.data==n){
			a=a.next;
			return;
		}
		while(a.next!=null){
			if (a.next.data==n){
				a.next=a.next.next;
				break;
			}
			a=a.next;
		}
		a=temp;
		return;
	}
	public Boolean IsMember(X n){
		node<X> temp = a;
		int c=0;
		while(temp.next!=null){
			if(temp.data==n){
				c=1;
				break;
			}
			temp=temp.next;
		}
		if(c==1) return true;
		return false;
	}
	public MySet<X> Union(MySet<X> b){
		MySet<X> union = new MySet<X>();
		node<X> tempa,tempb;
		tempa=a;
		tempb=b.a;
		while(tempa.next!=null) {
			union.addElement(tempa.data); 
			tempa=tempa.next;
		}
		while(tempb.next!=null) {
			union.addElement(tempb.data);
			tempb=tempb.next;
		}
		return union;
	}
	public MySet<X> Intersection(MySet<X> b){
		MySet<X> intersection = new MySet<X>();
		node<X> tempa;
		tempa=a;
		while(tempa.next!=null){
			if(b.IsMember(tempa.data)) intersection.addElement(tempa.data);
			tempa = tempa.next;
		}
		return intersection;
	}
}