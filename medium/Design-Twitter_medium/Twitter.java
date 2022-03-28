/*
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. 
Each item in the news feed must be posted by users who the user followed or by the user herself. 
Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/

public class Twitter {
    class Tweet {
        int time;
        int id;
        public Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
        @Override
        public boolean equals(Object o) {
            if(o == this)  return true;
            if( !(o instanceof Tweet)) return false;
            Tweet t = (Tweet)o;
            return this.time == t.time && this.id == t.id;
        }
    }
    int time = 0;
    Comparator<Tweet> comp;
    Map<Integer, PriorityQueue<Tweet>> posts;
    Map<Integer, List<Integer>> followed;
    Map<Integer, List<Tweet>> own;
    /** Initialize your data structure here. */
    public Twitter() {
        posts = new HashMap<Integer, PriorityQueue<Tweet>>();
        followed = new HashMap<Integer, List<Integer>>();
        own = new HashMap<Integer, List<Tweet>>();
        comp = new Comparator<Tweet>() {
            @Override 
            public int compare(Tweet t1, Tweet t2){
                return t2.time - t1.time;
            }
        };
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        time++;
        Tweet newT = new Tweet(time, tweetId);
        if(own.containsKey(userId)) {
            own.get(userId).add(newT);
        } else {
            List<Tweet> list = new ArrayList<Tweet>();
            list.add(newT);
            own.put(userId, list);            
        }
        if(posts.containsKey(userId)) {
            posts.get(userId).add(newT);
        } else {
            PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(10, comp);
            q.add(newT);
            posts.put(userId, q);
        }
        if(followed.containsKey(userId)) {
            for(Integer user: followed.get(userId)) {
                if(user == userId) continue;
                if(posts.containsKey(user)) {
                    posts.get(user).add(newT);
                } else {
                    PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(10, comp);
                    q.add(newT);
                    posts.put(user, q);
                }
            }
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if(posts.containsKey(userId)) {
            PriorityQueue<Tweet> q = posts.get(userId);
            Iterator<Tweet> iter = q.iterator();
            int count = 10;
            List<Tweet> list = new ArrayList<Tweet>();
            while(count !=0 && !q.isEmpty()) {
                list.add(q.poll());
                count--;
            }
            for(Tweet t:list) {
                q.add(t);
                res.add(t.id);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followed.containsKey(followeeId)) {
            List<Integer> list = followed.get(followeeId);
            if(list.contains(followerId)) {
                return;
            } else {
                list.add(followerId);
            }
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(followerId);
            followed.put(followeeId, list);
        }
        if(own.containsKey(followeeId) && followeeId != followerId) {
            List<Tweet> list = own.get(followeeId);
            PriorityQueue<Tweet> nq = (posts.containsKey(followerId))? posts.get(followerId) : new PriorityQueue<Tweet>(10, comp);
            for(Tweet t:list) {
                nq.add(t);
            }
            posts.put(followerId, nq);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followed.containsKey(followeeId)) {
            followed.get(followeeId).remove(new Integer(followerId));
        }
        if(own.containsKey(followeeId) && followeeId != followerId && posts.containsKey(followerId)) {
            List<Tweet> list = own.get(followeeId);
            PriorityQueue<Tweet> nq = posts.get(followerId);
            for(Tweet t:list) {
                nq.remove(t);
            }
            if(nq.isEmpty()) {
                posts.remove(followerId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
