package com.example.hazelcastnode;

import com.hazelcast.core.Hazelcast;

public class HazelcastNode {

    public static void main(String[] args) {
        Hazelcast.newHazelcastInstance();
    }
}
