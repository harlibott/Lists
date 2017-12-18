package cs1302.p3;


/**
 * A class that allows you to manipulate array lists of type <T>
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-20
 */
public class ArrayList<T> implements List<T>{

    public Box<T> [] original;
    public int length = 0;

    /** 
     * A default constructor that creates an array of boxes.
     */
    public ArrayList(){
	original = Box.<T>array(10);	
	
    }//ArrayList Constructor

    @Override
    public void add(T elem){
	boolean flag = false;
	int index = -1;

	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < original.length; i++){	
	    if(original[i] == null){//checks to make sure the element will be placed in a null spot
		index = i;
		flag = true;
		break;
	    }//if
	}//for

	if(flag){
	    original[index] = new Box<T>(elem);//sets the element if the array doesnt need to be expanded
	}else if(index == -1){
	    Box<T> [] copy = original;//creates a copy of the original to hold temporarily
	    original = Box.<T>array(copy.length + (copy.length/2));//making a new array with a greater length from the original array

	    for(int i = 0; i < copy.length; i++){
		original[i] = copy[i];//copies over the old array elements to the new bigger array
	    }//for
	    
	    original[copy.length] = new Box<T>(elem);//places the element in the next availible spot
	}//if	
	
	length++;
    }//add
    
    @Override
    public void add(int index, T elem){
	boolean flag;
	Box<T> [] temp = Box.<T>array(original.length);
	
	if(elem == null) throw new NullPointerException("elem cannot be null");
	if(index < 0 || index > size()) throw new IndexOutOfBoundsException("index is out of bounds");
	
	for(int i = 0; i < original.length; i++){
	    temp[i] = original[i];//creates a temp array with a copy of the original array
	}//for

	for(int i = index; i < temp.length; i++){
	    if(i == original.length-1){
		Box<T>[] copy = original;//creating a copy array to hold the original array
		original = Box.<T>array(copy.length + (copy.length/2));//makes a new array with a bigger size
		
		for(int j = 0; j < copy.length; j++){
		    original[j] = copy[j];//copies over the old array elements to the new array
                }//for  
	    }//if
	    
	    original[i+1] = temp[i];//moves the array indecies over to the right one
	    
	}//for
	
	original[index] = new Box<T>(elem);//sets the element at the index wanted
	length++;		
    }//add
    
    @Override
    public void clear(){
	original = Box.<T>array(10);//creates a new array with the size of 10, uses that for the rest of the array
	length = 0;
    }//clear
    
    @Override
    public boolean equals(Object list){
	boolean equal = false;

	if(list instanceof List){
	    List l = (List) list;
	    if(l.size() == size()){
		for(int i = 0; i < size(); i ++){
		    if(get(i).equals(l.get(i))){
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

	T e  = original[index].get();//gets the element at the index wanted
	 
	return e;
    }//get
    
    @Override
    public T set(int index, T elem){
       
	if(elem == null) throw new NullPointerException("elem cannot be null");
	if(index < 0 || index > size()) throw new IndexOutOfBoundsException("index is out of bounds");

	T e = original[index].get();//gets the element at the index wanted
	original[index].set(elem);//sets the element at the index wanted

        return e;
    }//set
   
    public int size(){
	int s = length;

	if(length == Integer.MAX_VALUE){//checks to make sure that the size does not exceed max value
	    s = Integer.MAX_VALUE;
	}else{
	    s = length;
	}//if
	return length;
    }//size
    
    @Override
    public boolean isEmpty(){
	boolean empty = false;

	if(this.length == 0){//checks the number of elements to see if it is = 0, if so, it is empty
	    empty = true;
	}
	return empty;
    }//isEmpty
    
    @Override
    public boolean contains(T elem){
	boolean contain = false;
	
	if(elem == null) throw new NullPointerException("elem cannot be null");

	for(int i = 0; i < original.length; i++){
	    try{
		if(original[i].get().equals(elem)){//gets the element to determine if it contains the element wanted
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

	for(int i = 0; i < original.length; i++){
	    try{
		if(original[i].get().equals(elem)){//checks the element to ake sure that is in the array
		    original[i] = null;//removes the element and makes that indecie null
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

	for(int i = 0; i < original.length; i++){
	    try{
		if(original[i].get().equals(elem)){//checks to make sure that the element is in the array
		    index = i;//returns the index that it is at
		    break;
		}//if
	    }catch(Exception e){
		index = -1;
	    }
	}//for
	return index;
    }//indexOf

    /**
     * Prints the array list
     */
    public void printList(){
	int counter = 0;
      
	while(original[counter] != null){
	    System.out.print("   " + original[counter].get());
	    counter++;
	}//while
    }
}//ArrayList<T>