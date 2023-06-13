
package com.java.timeandspace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;

public class DemoTest {
	private static final int ELEMENT_COUNT = 100000;

	public static void main(String[] args) {
		// ArrayList vs. LinkedList
		System.out.println("ArrayList vs. LinkedList:");
		compareArrayListVsLinkedList();

		// HashSet vs. TreeSet
		System.out.println("\nHashSet vs. TreeSet:");
		compareHashSetVsTreeSet();

		// HashMap vs. TreeMap
		System.out.println("\nHashMap vs. TreeMap:");
		compareHashMapVsTreeMap();
	}

	private static void compareArrayListVsLinkedList() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();

		// Measure time for insert operation - ArrayList
		long arrayListStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			arrayList.add(i);
		}
		long arrayListEndTime = System.nanoTime();
		long arrayListTimeTaken = arrayListEndTime - arrayListStartTime;

		// Measure time for insert operation - LinkedList
		long linkedListStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			linkedList.add(i);
		}
		long linkedListEndTime = System.nanoTime();
		long linkedListTimeTaken = linkedListEndTime - linkedListStartTime;

		// Calculate memory usage - ArrayList
		long arrayListMemoryUsage = getMemoryUsage(arrayList);

		// Calculate memory usage - LinkedList
		long linkedListMemoryUsage = getMemoryUsage(linkedList);

		// Display results
		System.out.println("ArrayList time taken: " + arrayListTimeTaken + " nanoseconds");
		System.out.println("LinkedList time taken: " + linkedListTimeTaken + " nanoseconds");
		System.out.println("ArrayList memory usage: " + arrayListMemoryUsage + " bytes");
		System.out.println("LinkedList memory usage: " + linkedListMemoryUsage + " bytes");
	}

	private static void compareHashSetVsTreeSet() {
		HashSet<Integer> hashSet = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();

		// Measure time for insert operation - HashSet
		long hashSetStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			hashSet.add(i);
		}
		long hashSetEndTime = System.nanoTime();
		long hashSetTimeTaken = hashSetEndTime - hashSetStartTime;

		// Measure time for insert operation - TreeSet
		long treeSetStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			treeSet.add(i);
		}
		long treeSetEndTime = System.nanoTime();
		long treeSetTimeTaken = treeSetEndTime - treeSetStartTime;

		// Calculate memory usage - HashSet
		long hashSetMemoryUsage = getMemoryUsage(hashSet);

		// Calculate memory usage - TreeSet
		long treeSetMemoryUsage = getMemoryUsage(treeSet);

		// Display results
		System.out.println("HashSet time taken: " + hashSetTimeTaken + " nanoseconds");
		System.out.println("TreeSet time taken: " + treeSetTimeTaken + " nanoseconds");
		System.out.println("HashSet memory usage: " + hashSetMemoryUsage + " bytes");
		System.out.println("TreeSet memory usage: " + treeSetMemoryUsage + " bytes");
	}

	private static void compareHashMapVsTreeMap() {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		// Measure time for insert operation - HashMap
		long hashMapStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			hashMap.put(i, i);
		}
		long hashMapEndTime = System.nanoTime();
		long hashMapTimeTaken = hashMapEndTime - hashMapStartTime;

		// Measure time for insert operation - TreeMap
		long treeMapStartTime = System.nanoTime();
		for (int i = 0; i < ELEMENT_COUNT; i++) {
			treeMap.put(i, i);
		}
		long treeMapEndTime = System.nanoTime();
		long treeMapTimeTaken = treeMapEndTime - treeMapStartTime;

		// Calculate memory usage - HashMap
		long hashMapMemoryUsage = getMemoryUsage(hashMap);

		// Calculate memory usage - TreeMap
		long treeMapMemoryUsage = getMemoryUsage(treeMap);

		// Display results
		System.out.println("HashMap time taken: " + hashMapTimeTaken + " nanoseconds");
		System.out.println("TreeMap time taken: " + treeMapTimeTaken + " nanoseconds");
		System.out.println("HashMap memory usage: " + hashMapMemoryUsage + " bytes");
		System.out.println("TreeMap memory usage: " + treeMapMemoryUsage + " bytes");
	}

	private static long getMemoryUsage(Object object) {
		// Get the size of the object in memory
		long memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		// Call garbage collector to get more accurate results
		System.gc();

		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - memoryUsage;
	}
}

