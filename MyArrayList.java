package jrJava.barbarianAttack3_linkedList;

public class MyArrayList<E> {

	private E[] elements;
	private int lastElementIndex; // numOfData = lastElementIndex + 1;
	
	public MyArrayList(){
		// default size 10;
		this(10);
	}
	
	
	public MyArrayList(int size){
		elements = (E[]) new Object[size];
		lastElementIndex = -1;
	}
	

	public int size(){
		return lastElementIndex + 1;
	}
	
	public E get(int index){
		if(index<0 || index>lastElementIndex) throw new IndexOutOfBoundsException();
		return elements[index];
	}
	
	
	public void add(E ref){
		add(lastElementIndex+1, ref);
	}
	
	
	public void add(int index, E ref){
		if(index<0 || index>lastElementIndex+1) throw new IndexOutOfBoundsException();
		
		if(lastElementIndex==elements.length-1){
			E[] elements2 = (E[]) new Object[elements.length*2];
			for(int i=0; i<=lastElementIndex; i++){
				elements2[i] = elements[i];
			}
			elements = elements2;
		}
		 
		for(int i=lastElementIndex; i>=index; i--) elements[i+1] = elements[i]; 
		
		elements[index] = ref;
		lastElementIndex++;
	}
	
	
	public E remove(int index){
		
		if(index<0 ||index>lastElementIndex) throw new IndexOutOfBoundsException();
		
		if(elements.length>=10 && size()<elements.length/2){
			E[] elements2 = (E[]) new Object[elements.length*3/4];
			for(int i=0; i<=lastElementIndex; i++) elements2[i] = elements[i];
			elements = elements2;
		}
		
		E toReturn =  elements[index];
		// shift to the left.
		for(int i=index; i<lastElementIndex; i++) elements[i] = elements[i+1];
		elements[lastElementIndex] = null;
		
		lastElementIndex--;
		return toReturn;
	}
	
	
	public boolean remove(E ref){
		for(int i=0; i<=lastElementIndex; i++){
			if(elements[i].equals(ref)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	public void printAll(){
		for(int i=0; i<elements.length; i++) System.out.print(elements[i] + " ");
		System.out.println();
	}
	
}






