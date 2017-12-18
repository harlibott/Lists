package cs1302.p3;

import java.util.Comparator;

/**
 * A class that sorts a given array list of any <T> type.
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-20
 */

public class SortedArrayList<T extends Comparable<T>> implements List<T>{

    public Box<T> [] sorted;
    public int length = 0;

    /**
     * A default constructor that creates an array of boxes with an
     * initial length of 10.
     */
    public SortedArrayList(){

	sorted = Box.<T>array(10);
    }//SortedArrayListConstructor    

    /** 
     * Adds an element to the method and sorts the array in ascending order.
     *
     * {@inheritDoc}
     *
     * @param elem  takes in an element to add
     */
    public void add(T elem){
	boolean flag = false;
	int index = -1;

	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < sorted.length; i++){
	    if(sorted[i] == null){//checks for the null spot to place the add
		index = i;
		flag = true;
		break;
	    }//if
	}//for

	if(flag){
	    sorted[index] = new Box<T>(elem);//places the add
	}else if(index == -1){
	    Box<T> [] copy = sorted;
	    sorted = Box.<T>array(copy.length + (copy.length/2));//creates a bigger array 

	    for(int i = 0; i < copy.length; i++){
		sorted[i] = copy[i];//copies over the elements from the original array to the new array
	    }//for

	    sorted[copy.length] = new Box<T>(elem);//sets the element in the array at the end of the list
	}//if
	length ++;
	sort();
    }//add

    /**
     * Adds an element at the specified index, and sorts the array in 
     * ascending order. 
     *
     * {@inheritDoc}
     * @param  index  the index to place the element
     * @param  elem   the element added to the array
     */
    public void add(int index, T elem){
	boolean flag;
	Box<T> [] temp = Box.<T>array(sorted.length);

	if(elem == null) throw new NullPointerException("elem cannot be null");
	if(index < 0 || index > size()) throw new IndexOutOfBoundsException("index is out of bounds");

	for(int i = 0; i < sorted.length; i++){
	    temp[i] = sorted[i];//creates a temporary array to hold the original array
	}//for

	for(int i = index; i < temp.length; i++){
	    if(i == sorted.length-1){//testing to see if the array needs to be expanded (if the last index != null)
		Box<T> [] copy = sorted;
		sorted = Box.<T>array(copy.length + (copy.length/2));//creates a bigger array if needed

		for(int j = 0; j < copy.length; j++){
		    sorted[j] = copy[j];//copies over the old elements into the new array
		}//for
	    }//if

	    sorted[i+1] = temp[i];//shifts every element to the right by one

	}//for
	sorted[index] = new Box<T>(elem);//places the new element at the provided index
	length++;
	
	sort();
    }//add

    /**
     * Sorts any given array in ascending order. 
     */
    public void sort(){
	
	boolean swap = true;
	T temp;

	for(int j = 1; j < sorted.length & swap; j++){
	    swap = false;
	    for(int i = 0; i < sorted.length -j; i++){
		try{
		    if(sorted[i].get().compareTo(sorted[i+1].get()) > 0){
			temp = sorted[i+1].get();
			sorted[i+1] = new Box<T>(sorted[i].get());
			sorted[i] = new Box<T>(temp);
			swap = true;
		    }//if
		}catch(Exception e){
		}
	    }//for
	}//for
    }//sort
    
    @Override
    public void clear(){
	sorted = Box.<T>array(10);//clears the array and makes a new array with a length of 10
	length = 0;
    }//clear

    public boolean equals(Object list){
	boolean equal = false;

	if(list instanceof List){//cheks to make sure that the param list is an instance of List
	    List l = (List)list;//safely typecasts list into a List
	    if(l.size() == size()){//checks the size of the 2 lists
		for(int i = 0; i < size(); i++){
		    if(get(i).equals(l.get(i))){//cheks if the elements of each list are equal
			equal = true;
		    }//if
		}//for
	    }//if
	}//if

	return equal;
    }//equals

    @Override
    public T get(int index){
	if(index < 0 || index > size()) throw new IndexOutOfBoundsException("index is out of bounds");

	T e = sorted[index].get();

	return e;
    }//get

    @Override
    public T set(int index, T elem){
	if(elem == null) throw new NullPointerException("elem cannot be null");
	if(index < 0 || index > size()) throw new IndexOutOfBoundsException("index is out of bounds");

	T e = sorted[index].get();//gets the element at wanted index to return
	sorted[index].set(elem);//sets the element at the wanted index in the array

	sort(); //sorts the array after an element has been set
	return e;
    }//set

    @Override
    public int size(){
	int s = length;

	if(length == Integer.MAX_VALUE){//checks the length, if its > max value, return max value, if not, return true size
	    s = Integer.MAX_VALUE;
	}else{
	    s = length;
	}//if
	return s;
    }//size

    @Override
    public boolean isEmpty(){
	boolean empty = false;

	if(this.length == 0){//checks to see if the array is empty using the length
	    empty = true;
	}//if

	return empty;
    }//isEmpty

    @Override
    public boolean contains(T elem){
	boolean contain = false;

	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < sorted.length; i ++){
	    try{
		if(sorted[i].get().equals(elem)){//checks to see if the array contains the element wanted
		    contain = true;
		    break;
		}//if
	    }catch(Exception e){
		contain = false;
	    }
	}//for

	return contain;
    }//contains

    @Override
    public boolean remove(T elem){
	boolean rem = false;

	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < sorted.length; i++){
	    try{
		if(get(i).equals(elem)){
		    sorted[i] = null;//removes an element from the list
		    rem = true;
		    break;
		}//if
	    }catch(Exception e){
		rem = false;
	    }
	}//for
	length --;
	return rem;
    }//remove

    @Override
    public int indexOf(T elem){
	int index = -1;

	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < sorted.length; i++){
	    try{
		if(sorted[i].get().equals(elem)){
		    index = i;//sets the index at i if it is equal to the element
		    break;
		}//if
	    }catch(Exception e){
		index = -1;
	    }
	}//for
	return index;
    }//indexOf

    /**
     * Prints the array list. 
     */
    public void printList(){
	int counter = 0;

	    while(sorted[counter] != null){
		System.out.print( "   " + sorted[counter].get());//loops through and prints the array list
		counter++;
	    }//while
    }//printList
}//SortedArrayList