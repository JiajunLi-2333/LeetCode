/*
 * @lc app=leetcode id=1845 lang=java
 *
 * [1845] Seat Reservation Manager
 */
import java.util.PriorityQueue; 
// @lc code=start
class SeatManager {
    private PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            availableSeats.offer(i);
        }
        
    }
    
    public int reserve() {
        if (availableSeats.isEmpty()) {
            return -1; // No seats available
        }
        return availableSeats.poll(); // Get and remove the smallest available seat number
        
    }
    
    public void unreserve(int seatNumber) {
        // Add the seat back to the priority queue
        availableSeats.offer(seatNumber);
        
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
// @lc code=end

