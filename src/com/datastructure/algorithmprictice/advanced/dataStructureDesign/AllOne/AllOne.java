package com.datastructure.algorithmprictice.advanced.dataStructureDesign.AllOne;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串
 * 注意：每个函数都应当满足 O(1) 平均时间复杂度
 * https://leetcode.cn/problems/all-oone-data-structure/
 */
public class AllOne {
    /**
     * 双向链表节点, 用来记录每个桶对应的词频count 和该词频下的String set
     */
    class Bucket {
        public int count;
        public HashSet<String> data;
        public Bucket next;
        public Bucket pre;
        public Bucket (int count, String data) {
            this.count = count;
            this.data = new HashSet<>();
            this.data.add(data);
        }
        public boolean isEmpty() {
            return this.data.isEmpty();
        }
    }

    HashMap<String, Bucket> stringBucketMap;
    Bucket head;
    Bucket tail;



    public AllOne() {
        this.stringBucketMap = new HashMap<>();
        this.head = new Bucket(0, "");
        this.tail = new Bucket(Integer.MAX_VALUE, "");
        head.next = tail;
        tail.pre = head;
    }

    /**
     * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key
     * @param key
     */
    public void inc(String key) {
        // 先判断key是否存在于map中
        if (!stringBucketMap.containsKey(key)) {
            // 如果不存在于map中, 那么它的词频一定是1, 检查head.next是不是1号桶
            if (head.next.count == 1) {
                // 如果是1号桶, 则将key加入1号桶中
                stringBucketMap.put(key, head.next);
                head.next.data.add(key);
            } else {
                // 如果1号桶不存在, 则需要新建1号桶
                Bucket newBucket = new Bucket(1, key);
                stringBucketMap.put(key, newBucket);
                insertBucketAfter(head, newBucket);
            }
        } else {
            // 如果 key已经存在于map中, 需要先找到它原来属于的桶
            Bucket curBucket = stringBucketMap.get(key);
            // 检查curBucket.next.count是否为curBucket.count + 1 即 x 桶后 是否为 x+1桶
            if (curBucket.next.count == curBucket.count + 1) {
                // 如果存在, 则可以在下一个桶里添加
                curBucket.next.data.add(key);
                // 更新map中key value内存地址到新的Bucket
                stringBucketMap.put(key, curBucket.next);
            } else {
                // 如果不存在, 就创建新的桶 并插入
                Bucket newBucket = new Bucket(curBucket.count + 1, key);
                stringBucketMap.put(key, newBucket);
                insertBucketAfter(curBucket, newBucket);
            }
            // 从curBucket中移除key 并检查是否需要删除桶
            removeElementFromBucket(key, curBucket);
        }
    }

    /**
     * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中
     * @param key
     */

    public void dec(String key) {
        // 题目已经保证key一定会存在
        // 直接获取对应的桶
        Bucket curBucket = stringBucketMap.get(key);
        if (curBucket.count == 1) {
            // 如果当前是一号桶, 那么不需要将元素移动到0号桶

            stringBucketMap.remove(key);

        } else {
            // 如果curBucket不是1号桶, 检查pre桶是否为count - 1桶
            if (curBucket.pre.count == curBucket.count - 1) {
                // 如果存在, 则直接添加
                stringBucketMap.put(key, curBucket.pre);
                curBucket.pre.data.add(key);
            } else {
                // 如果不存在就新建桶
                Bucket newBucket = new Bucket(curBucket.count - 1, key);
                stringBucketMap.put(key, newBucket);
                insertBucketAfter(curBucket.pre, newBucket);
            }
        }
        removeElementFromBucket(key, curBucket);
    }

    /**
     * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 ""
     * @return0
     */
    public String getMaxKey() {
        // 返回tail桶 pre桶里的一个元素
        return tail.pre.data.iterator().next();
    }
    /**
     * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 ""
     * @return
     */
    public String getMinKey() {
        // 返回head桶next桶里的一个元素
        return head.next.data.iterator().next();
    }

    private void insertBucketAfter(Bucket cur, Bucket newBucket){
        newBucket.next = cur.next;
        cur.next.pre = newBucket;
        cur.next = newBucket;
        newBucket.pre = cur;
    }

    private void removeBucket(Bucket cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    private void removeElementFromBucket(String ele, Bucket bucket) {
        bucket.data.remove(ele);
        if (bucket.isEmpty()) {
            removeBucket(bucket);
        }
    }
}
