import java.util.*;

/**
 * A generic heap data structure implementation that supports both max-heap and min-heap operations.
 * This implementation uses a dynamic array to store heap elements and maintains the heap property
 * through bubble-up and sink-down operations.
 */
public class Heap{
    private int[] data;     // The heap data array storing elements from index 0
    private int capacity;   // Maximum number of elements the heap can hold
    private int size;       // Current number of elements in the heap
    private boolean heapMax; // true for max-heap, false for min-heap

    /**
     * Constructor to create a heap with specified capacity and type.
     * @param capacity Maximum number of elements the heap can store
     * @param heapMax true for max-heap (largest element at root), false for min-heap (smallest at root)
     */
    public Heap(int capacity, boolean heapMax){
        this.capacity = capacity;
        this.heapMax = heapMax;
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * Default constructor creates a max-heap with capacity of 16.
     */
    public Heap(){
        this(16, true);
    }

    // ===== BASIC HEAP NAVIGATION METHODS =====

    /**
     * Returns the index of the parent node for a given index.
     * In a heap, parent of node at index i is at index (i-1)/2
     * @param i the current node index
     * @return the parent node index
     */
    private int parent(int i){
        return (i - 1) / 2;
    }

    /**
     * Returns the index of the left child for a given index.
     * In a heap, left child of node at index i is at index 2*i+1
     * @param i the current node index
     * @return the left child index
     */
    private int leftChild(int i){
        return 2 * i + 1;
    }

    /**
     * Returns the index of the right child for a given index.
     * In a heap, right child of node at index i is at index 2*i+2
     * @param i the current node index
     * @return the right child index
     */
    private int rightChild(int i){
        return 2 * i + 2;
    }

    /**
     * Swaps two elements in the heap array.
     * @param i first element index
     * @param j second element index
     */
    private void swap(int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * Compares two values according to heap type.
     * For max-heap: returns true if a > b
     * For min-heap: returns true if a < b
     * @param a first value to compare
     * @param b second value to compare
     * @return true if a has higher priority than b in this heap type
     */
    private boolean compare(int a, int b){
        return heapMax ? a > b : a < b;
    }

    // ===== CORE HEAP ADJUSTMENT METHODS =====
    
    /**
     * Maintains heap property by moving an element up the tree.
     * Used after inserting a new element at the end of the heap.
     * Continues swapping with parent until heap property is satisfied.
     * Time Complexity: O(log n)
     * @param i the index of the element to shift up
     */
    private void shiftUp(int i){
        // Continue until we reach root (index 0) or heap property is satisfied
        while(i > 0 && compare(data[i], data[parent(i)])){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Maintains heap property by moving an element down the tree.
     * Used after removing the root element and replacing it with the last element.
     * Compares with children and swaps with the appropriate child until heap property is satisfied.
     * Time Complexity: O(log n)
     * @param i the index of the element to sink down
     */
    private void sinkDown(int i){
        // Continue while the node has at least a left child
        while(leftChild(i) < size){
            // Start with left child as the target for potential swap
            int target = leftChild(i);
            
            // If right child exists and has higher priority than left child, choose right child
            if (rightChild(i) < size && compare(data[rightChild(i)], data[leftChild(i)])) {
                target = rightChild(i);
            }
            
            // Stop sinking if current element has higher or equal priority than target child
            if (compare(data[i], data[target]) || data[i] == data[target]) {
                break;
            }
            
            // Swap with the target child and continue sinking
            swap(i,target);
            i = target; 
        }
    }

    // ===== HEAPIFY METHODS (Alternative ways to build a heap) =====

    /**
     * Builds a heap from an array using the bottom-up approach (shift-up method).
     * Inserts elements one by one and maintains heap property by shifting up.
     * Time Complexity: O(n log n) - each insertion takes O(log n)
     * @param nums array of integers to convert into a heap
     */
    @SuppressWarnings("unused")
    private void heapifyUp(int[] nums){
        // Clear existing heap state
        size = 0;
        
        // Expand capacity if needed
        if(nums.length > capacity){
            capacity = nums.length;
            data = new int[capacity];
        }
        
        // Insert each element and maintain heap property
        for(int i = 0; i < nums.length; i++){
             data[size] = nums[i];
             size++; // Increment size to reflect the new element count
             shiftUp(size - 1); // Maintain heap property for the newly added element
        }
    }

    /**
     * Builds a heap from an array using the top-down approach (sink-down method).
     * Copies all elements first, then starts from the last non-leaf node and sinks down.
     * Time Complexity: O(n) - more efficient than heapifyUp method
     * @param nums array of integers to convert into a heap
     */
    @SuppressWarnings("unused")
    private void heapifyDown(int[] nums){
        size = nums.length;
        
        // Expand capacity if needed
        if(nums.length > capacity){
            capacity = nums.length;
            data = new int[capacity];
        }
        
        // Copy the entire array into heap data structure
        System.arraycopy(nums, 0, data, 0, nums.length);

        // Start from the last non-leaf node and sink down to maintain heap property
        int lastNoneLeafNode = parent(size - 1);
        for(int i = lastNoneLeafNode; i >= 0; i--){
            sinkDown(i);
        }
    }

    // ===== PUBLIC API METHODS =====

    /**
     * Adds a new element to the heap while maintaining heap property.
     * The element is initially placed at the end and then shifted up as needed.
     * Time Complexity: O(log n)
     * @param num the integer value to add to the heap
     * @throws RuntimeException if the heap is at full capacity
     */
    public void add(int num){
        if (size >= capacity) {
            throw new RuntimeException("heap is full");
        }
        data[size] = num;      // Place new element at the end
        size++;                // Increment heap size
        shiftUp(size - 1);     // Restore heap property by shifting up
    }

    /**
     * Checks if the heap is empty.
     * @return true if the heap contains no elements, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Removes and returns the root element (max in max-heap, min in min-heap).
     * Replaces root with the last element and restores heap property by sinking down.
     * Time Complexity: O(log n)
     * @return the root element of the heap
     * @throws RuntimeException if the heap is empty
     */
    public int remove(){
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }

        int top = data[0];              // Store the root element to return
        data[0] = data[size - 1];       // Move last element to root position
        size--;                         // Decrease heap size

        // Restore heap property if heap is not empty
        if(size > 0){
            sinkDown(0); 
        }
        return top;
    }

    /**
     * Returns the root element without removing it from the heap.
     * Time Complexity: O(1)
     * @return the root element (max in max-heap, min in min-heap)
     * @throws RuntimeException if the heap is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return data[0];
    }

    /**
     * Returns the current number of elements in the heap.
     * @return the size of the heap
     */
    public int size(){
        return size;
    }
    /**
     * Main method with comprehensive test cases to verify heap functionality.
     * Tests both max-heap and min-heap operations, as well as boundary conditions.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Max-Heap Smoke Test ===");
        Heap maxHeap = new Heap(10, true);
        int[] items = {5, 1, 9, 3, 7};
        System.out.println("Adding: " + Arrays.toString(items));
        for (int x : items) {
            maxHeap.add(x);
        }
        System.out.print("Poll sequence (should be 9,7,5,3,1): ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.remove() + " ");
        }
        System.out.println("\n");

        System.out.println("=== Min-Heap Smoke Test ===");
        Heap minHeap = new Heap(10, false);
        System.out.println("Adding: " + Arrays.toString(items));
        for (int x : items) {
            minHeap.add(x);
        }
        System.out.print("Poll sequence (should be 1,3,5,7,9): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.remove() + " ");
        }
        System.out.println("\n");

        System.out.println("=== Boundary Cases ===");
        // Test capacity overflow
        Heap small = new Heap(2, true);
        small.add(100);
        small.add(200);
        try {
            small.add(300); 
            System.out.println("ERROR: expected exception on add beyond capacity");
        } catch (RuntimeException e) {
            System.out.println("PASS: caught expected exception on overflow -> " + e.getMessage());
        }

        // Test operations on empty heap
        Heap empty = new Heap(5, true);
        try {
            empty.remove();
            System.out.println("ERROR: expected exception on remove from empty");
        } catch (RuntimeException e) {
            System.out.println("PASS: caught expected exception on remove empty -> " + e.getMessage());
        }
        try {
            empty.peek();
            System.out.println("ERROR: expected exception on peek from empty");
        } catch (RuntimeException e) {
            System.out.println("PASS: caught expected exception on peek empty -> " + e.getMessage());
        }

        System.out.println("\nSmoke tests completed.");
    }
}