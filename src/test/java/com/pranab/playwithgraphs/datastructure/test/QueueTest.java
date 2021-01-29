package com.pranab.playwithgraphs.datastructure.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.pranab.playwithgraphs.datastructure.Queue;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

@TestMethodOrder(OrderAnnotation.class)
class QueueTest {

	 private static Queue<String> queue;
	 private String one="ONE";
	 private String two="TWO";
	 private String three="THREE";
		
	 @BeforeAll
	 public static void setup() {
		 queue=new DynamicList<>(); 
	 }
	 
	 @Test
	 @Order(1)
	 void enqueueTest() {
		 queue.enqueue(one);
		 queue.enqueue(two);
		 queue.enqueue(three);
		 assertEquals(3, queue.size());
	 }
	 
	 @Test
	 @Order(2)
	 void peepTest() {
		 assertEquals(one, queue.peep());
	 }
	 
	 @Test
	 @Order(3)
	 void dequeueTest() {
		 assertAll(()->{assertEquals(one,queue.dequeue());},
				   ()->{assertEquals(two,queue.dequeue());},
				   ()->{assertEquals(three,queue.dequeue());});
	 }
}
