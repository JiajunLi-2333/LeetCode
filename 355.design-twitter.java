/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */
import java.util.*;
// @lc code=start
class Twitter {
    private static int timestamp;
    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private static class User {
        private int id;
        public Set<Integer> followees; // Set of followee IDs
        public Tweet head; // Head of the linked list of tweets

        public User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
            this.head = null;
            follow(id); //Follow self by default
        }

        public void follow(int followeeId) {
            this.followees.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if(followeeId != this.id){
                this.followees.remove(followeeId);
            }
                
        }

        public void postTweet(int tweetId) {
            Tweet newTweet = new Tweet(tweetId, timestamp++);
            newTweet.next = this.head;
            this.head = newTweet;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        this.userMap = new HashMap<>();
    }


    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);

        }
        userMap.get(userId).postTweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return ans; // If user does not exist, return empty list
        }

        //Get the user's followees list
        Set<Integer> followees = userMap.get(userId).followees;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time); // Max-heap based on tweet time

        for(int followeeId : followees) {
            User followee = userMap.get(followeeId);
            if(followee != null && followee.head != null){
                pq.offer(followee.head);
            }
        }
        while(!pq.isEmpty() && ans.size() < 10) {
            Tweet tweet = pq.poll();
            ans.add(tweet.id);
            if(tweet.next != null) {
                pq.offer(tweet.next); // Add the next tweet of the same user
            }
        }
        return ans; // Return the list of tweet IDs in reverse chronological order
    }
    
    public void follow(int followerId, int followeeId) {
        //if followerid does not exist, create a new user
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            userMap.get(followerId).unfollow(followeeId);
        }
        //If the followerId does not exist, do nothing
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(f ollowerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

