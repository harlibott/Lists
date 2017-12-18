package cs1302.p3;

/**
 * A class that includes main that tests a sorted array list as well as 
 * a non-sorted array list of type <T>
 *
 * @author Harli Bott
 * @version 1.0
 * @since 2017-10-20
 */
public class Test{

    /**
     * A static method containing main that handles testing.
     *
     * @param args[]  a string input via command line
     */
    public static void main(String args[]){
	//TODO make sure all the exception handle for each methods work
	System.out.println();
	// ----------------------------------------------
	//        Tests for the Sorted Array List
	// ---------------------------------------------- 
	List<Integer> testList = new SortedArrayList<>();
	List<Integer> testList2 = new SortedArrayList<>();

	/* Test list 1 <Integer> */
	testList.add(1);
	testList.add(2);
	testList.add(3);
	testList.add(4);
	testList.add(5);
	testList.add(6);
	testList.add(7);
	testList.add(8);
	testList.add(9);
	testList.add(10);
	testList.add(11);
	testList.add(0, 10);
	testList.add(1, 9);
	testList.add(2, 8);
	testList.add(3, 7);
	testList.add(4, 6);
	testList.add(5, 5);
	testList.add(6, 4);
	testList.add(7, 3);
	testList.add(8, 2);
	testList.add(9, 1);

	/* Test list 2 <Integer>*/
	testList2.add(1);
	testList2.add(2);
	testList2.add(3);
	testList2.add(4);
	testList2.add(5);
	testList2.add(6);
	testList2.add(7);
	testList2.add(8);
	testList2.add(9);
	testList2.add(10);
	testList2.add(11);
	testList2.add(0,10);
	testList2.add(1,9);
	testList2.add(2,8);
	testList2.add(3,7);
	testList2.add(4,6);
	testList2.add(5,5);
	testList2.add(6,4);
	testList2.add(7,3);
	testList2.add(8,2);
	testList2.add(9,1);

	System.out.println("----------------TEST CASES FOR SORTED ARRAY LIST----------------");
	System.out.println();
	
	/* should print out the length of 21 */
	System.out.println("List Size for List 1: " + testList.size());
	System.out.println("List Size for List 2: " + testList2.size());

	/* should print out the list elements */
	System.out.println();
	System.out.println("ELEMENTS IN LIST 1");
	testList.printList();
	System.out.println();
	System.out.println();
	System.out.println("ELEMENTS IN LIST 2");
	testList2.printList();
	System.out.println();

	/*should print true bc objects are equal*/
	System.out.println();
	System.out.print("List 1 equals List 2: " + testList.equals(testList2));
	System.out.println();
	
	/* should print out 10 and 6 */
	System.out.println();
	System.out.println("Element at index 0 for List 1: " + testList.get(0));
	System.out.println("Element at index 4 for List 2: " + testList2.get(4));

	/* should print out 1 and replace the index at 9 with 6 */
	System.out.println();
	System.out.println("Previous element at index 9 for List 1: " + testList.set(9, 6));
	System.out.println("New element at index 9 for List 1: " + testList.get(9));
      
	/* should print out the new list of elements after replaced ^ */
	System.out.println();
	System.out.println("NEW ELEMENTS IN LIST 1");
	testList.printList();
	System.out.println();

	/* should print out false bc the list is not empty */
	System.out.println();
	System.out.println("List 1 is empty: " + testList.isEmpty());

	/* should print out true bc the element exists in the array */
	System.out.println();
	System.out.println("Element 10 is in the array of List 1: " + testList.contains(10));

	/* should print out 0 when searching for element 10, -1 when searching for element 99 */
	System.out.println();
	System.out.println("Element 10 index of List 2: " + testList2.indexOf(10));
	System.out.println("Element 99 index: " + testList2.indexOf(99));

	/* should print out true bc the element is in there, and should change index 2 to null, size to 20 */
	System.out.println();
	System.out.println("Element 8 remove from List 1: " + testList.remove(8));
	System.out.println("New List 1 size: " + testList.size());
	/* should clear the whole elements, should print true */
	testList.clear();
	System.out.println();
	System.out.println("List 1 is empty: " + testList.isEmpty());
	System.out.println("List 1 new size: " + testList.size());

	/* should print out index out of bounds*/
	/*	System.out.println();
	testList.get(99);
	*/

	//------------------------------------
	//       Tests for the ArrayList
	//------------------------------------       
  
	List<String> sList = new ArrayList();
	List<String> sList2 = new ArrayList();

	/* Test for sList <String> */ 
	sList.add("a");
       	sList.add("b");
	sList.add("c");
	sList.add("d");
	sList.add("e");
	sList.add(0,"f");
	sList.add(1,"g");
	sList.add(2,"h");
	sList.add(3,"i");
	sList.add(4,"j");
	sList.add(5,"x");

	/* Test for sList2 <String> */
	sList2.add("h");
	sList2.add("i");
	sList2.add("j");
	sList2.add("k");
	sList2.add("l");
	sList2.add(0,"m");
	sList2.add(1,"n");
	sList2.add(2,"o");
	sList2.add(3,"p");
	sList2.add(4,"q");
	sList2.add(5,"z");

	System.out.println();
	System.out.println("----------------TEST CASES FOR ARRAY LIST----------------");
	System.out.println();

	/* should print out 11 and 11 */
	System.out.println("List 1 size: " + sList.size());
	System.out.println("List 2 size: " + sList2.size());
	System.out.println();

	/* prints out the 2 lists */
	System.out.println("ELEMENTS IN LIST 1");
	sList.printList();
	System.out.println();
	System.out.println();
	System.out.println("ELEMENTS IN LIST 2");
	sList2.printList();
	System.out.println();

	/* should print out false bc the two array lists are not equal */
	System.out.println();
	System.out.println("Lists are equal: " + sList.equals(sList2));
	System.out.println();

	/* should print out x and m */
	System.out.println("Element at index 5 from list 1: " + sList.get(5));
	System.out.println("Element at index 0 from list 2: " + sList2.get(0));
	System.out.println();

	/* should print out o and O */
	System.out.println("Element previously at index 2 from list 2: " + sList2.set(2,"O"));
	System.out.println("Element now at index 2 from list 2: " + sList2.get(2));
	System.out.println();
	
	/* prints out a new list */
	System.out.println("NEW ELEMENTS FROM LIST 2");
	sList2.printList();
	System.out.println();

	/* should return false bc array is not empty */
	System.out.println();
	System.out.println("List 1 is empty: " + sList.isEmpty());
	System.out.println("List 2 is empty: " + sList2.isEmpty());
	System.out.println();

	/* should return true and false */
	System.out.println();
	System.out.println("List 1 Contains a: " + sList.contains("a"));
	System.out.println("List 2 Contains b: " + sList2.contains("b"));
	System.out.println();

	/* should return -1 and 4 */
	System.out.println();
	System.out.println("List 1 index of T: " + sList.indexOf("T"));
	System.out.println("List 2 index of q: " + sList2.indexOf("q"));
	System.out.println();

	/* should print true and 10*/
	System.out.println();
	System.out.println("Remove 'a' from list 1: " + sList.remove("a"));
	System.out.println("New Length of List 1: " + sList.size());
	System.out.println();

	/* should print true and 0 */
	sList2.clear();
	System.out.println("List 2 is clear: " + sList2.isEmpty());
	System.out.println("List 2 new size: " + sList2.size());
	System.out.println();
			 
    }//main
}//Test