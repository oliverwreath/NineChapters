package com.AmazonSession.leetcode.algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TwitterDemo {

  public static void main(String[] arg) {
    new TwitterDemo().testTwitter();
  }

  private void testTwitter() {
    Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
    List<Integer> newsFeed = twitter.getNewsFeed(1);
    log.info("{}", newsFeed);

// User 1 follows user 2.
    twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    List<Integer> newsFeed6 = twitter.getNewsFeed(2);
    log.info("{}", newsFeed6);
    List<Integer> newsFeed2 = twitter.getNewsFeed(1);
    log.info("{}", newsFeed2);

// User 1 unfollows user 2.
    twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
    List<Integer> newsFeed3 = twitter.getNewsFeed(1);
    log.info("{}", newsFeed3);
  }

//    postTweet(userId, tweetId): Compose a new tweet.
//            getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
//    follow(followerId, followeeId): Follower follows a followee.
//    unfollow(followerId, followeeId): Follower unfollows a followee.

  public class Twitter {

    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, LinkedList<Tweet>> tweetMap;
    int timeCounter = 0;

    private class Tweet {

      int id;
      int time;

      public Tweet(int id, int time) {
        this.id = id;
        this.time = time;
      }

      public Tweet() {
      }

      @Override
      public String toString() {
        return "Tweet{" +
            "id=" + id +
            ", time=" + time +
            '}';
      }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
      followMap = new HashMap<>();
      tweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      if (!tweetMap.containsKey(userId)) {
        tweetMap.put(userId, new LinkedList<Tweet>());
      }
      tweetMap.get(userId).add(new Tweet(tweetId, timeCounter++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users
     * who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
      LinkedList<Tweet> news = new LinkedList<>();
      if (tweetMap.containsKey(userId)) {
        news.addAll(tweetMap.get(userId));
      }
//            log.info("userId = " + userId + "; tweetMap.containsKey(userId) = " + tweetMap.containsKey(userId) + "; followMap.containsKey(userId) = " + followMap.containsKey(userId));
//            log.info("tweetMap = " + tweetMap);
//            log.info("followMap = " + followMap);
      if (followMap.containsKey(userId)) {
        for (Integer aUser : followMap.get(userId)) {
          if (tweetMap.containsKey(aUser)) {
            news.addAll(tweetMap.get(aUser));
          }
        }
      }
      return getTopTenTweets(news);
    }

    private LinkedList<Integer> getTopTenTweets(LinkedList<Tweet> news) {
      LinkedList<Integer> newIds = new LinkedList<>();
      Collections.sort(news, tweetComparator);
      int counter = 0;
      for (Tweet aNew : news) {
        if (counter >= 10) {
          return newIds;
        }
        newIds.add(aNew.id);
        counter++;
      }
      return newIds;
    }

    private Comparator<Tweet> tweetComparator = new Comparator<Tweet>() {
      @Override
      public int compare(Tweet o1, Tweet o2) {
        return o2.time - o1.time;
      }
    };

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      if (followerId != followeeId) {
        if (!followMap.containsKey(followerId)) {
          followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).add(followeeId);
      }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      if (followMap.containsKey(followerId)) {
        followMap.get(followerId).remove(followeeId);
      }
    }
  }

}
