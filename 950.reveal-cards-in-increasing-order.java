/*
 * @lc app=leetcode id=950 lang=java
 *
 * [950] Reveal Cards In Increasing Order
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        //! It is important to think about how to reverse the process of revealing cards
        if(deck.length == 1){
            return deck;
        }
        Arrays.sort(deck); // Sort the deck in increasing order
        int n = deck.length;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(deck[n-1]);
        for(int i = n -2; i >= 0; i--){
            queue.offerFirst(queue.pollLast()); // Move the last element to the front
            queue.offerFirst(deck[i]); // Add the next card to the front
        }
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = queue.pollFirst(); // Collect the cards in the order they are revealed
        }
        return result;
    }
}
// @lc code=end

