/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author longfei.wlf
 * @version $Id: LRULinkedHashMap.java, v 0.1 2020-04-26 6:06 PM longfei.wlf Exp $$
 */
public class LRULinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRULinkedHashMap(int capacity) {
        // access order
        super(capacity, 0.75F, true);
    }

    public int get(int key) {
        // Ä¬ÈÏÖµ-1
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        // ÂúÁËÉ¾³ý
        return super.size() > capacity;
    }
}