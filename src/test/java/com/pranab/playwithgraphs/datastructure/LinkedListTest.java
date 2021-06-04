package com.pranab.playwithgraphs.datastructure;

import org.junit.jupiter.api.TestMethodOrder;

import com.pranab.playwithgraphs.datastructure.LinkedList;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@TestMethodOrder(OrderAnnotation.class)
class LinkedListTest {

	 private static LinkedList<String> list;
	 private String one="ONE";
	 private String two="TWO";
	 private String three="THREE";
	 private static Logger logger = LoggerFactory.getLogger(LinkedListTest.class);
		
	 @BeforeAll
	 public static void setup() {
		 list=new DynamicList<>(); 
	 }
	 
	 @Test
	 @Order(1)
	 void addFirstTestWhenListEmpty() {
		 list.addFirst(one);
		 assertEquals(1, list.size());
	 }
	 
	 @Test
	 @Order(2)
	 void removeFirstTestWhenListContainsOneElement() {		 
		 assertEquals(one, list.removeFirst());
	 }
	 
	 @Test
	 @Order(3)
	 void addFirstTestMultipleEntry() {
		 list.addFirst(one);
		 list.addFirst(two);
		 list.addFirst(three);
		 assertEquals(3, list.size());
	 }
	 
	 @Test
	 @Order(4)
	 void removeFirstTestWithMultipleEntries() {		 
		assertAll(()->{assertEquals(three, list.removeFirst());},
				  ()->{assertEquals(two, list.removeFirst());},
				  ()->{assertEquals(one, list.removeFirst());});
	 }
	
	 @Test
	 @Order(5)
	 void addLastTestWhenListEmpty() {
		 list.addLast(one);
		 assertEquals(1, list.size());
	 }
	 
	 @Test
	 @Order(6)
	 void removeLastTestWhenListContainsOneElement() {		 
		 assertEquals(one, list.removeLast());
	 }
	 
	 @Test
	 @Order(7)
	 void addLastTestMultipleEntry() {
		 list.addLast(one);
		 list.addLast(two);
		 list.addLast(three);
		 assertEquals(3, list.size());
	 }
	 
	 @Test
	 @Order(8)
	 void removeLastTestWithMultipleEntries() {		 
		assertAll(()->{assertEquals(three, list.removeLast());},
				  ()->{assertEquals(two, list.removeLast());},
				  ()->{assertEquals(one, list.removeLast());});
	 }
	 
	 @Test
	 @Order(9)
	 void iteratorAndSizeTest() {
		 list.addLast(one);
		 list.addLast(two);
		 list.addLast(three);
		 list.functionalIterate((v)->{logger.info(v);});
		 assertEquals(3, list.size());
	 }
	 
	 @Test
	 @Order(10)
	 void removeElementTest() {
		 assertAll(()->{two.equals(list.removeElement(two));},
				   ()->{assertEquals(2, list.size());});
	 }
	 
	 @Test
	 @Order(11)
	 void getFirstTest() {
		 assertAll(()->{one.equals(list.getFirst().get());},
				   ()->{assertEquals(2, list.size());});
	 }
	 
	 @Test
	 @Order(12)
	 void getLastTest() {
		 assertAll(()->{three.equals(list.getLast().get());},
				   ()->{assertEquals(2, list.size());});
	 }
	 
	 @Test
	 void removeIndexTest() {
		 LinkedList<String> testList=new DynamicList<>();
		 testList.addFirst("One");
		 testList.addFirst("Two");
		 testList.addFirst("Three");
		 testList.addFirst("Four");
		 testList.addFirst("Five");
		 assertAll(()->{assertEquals(5, testList.size());},
				 ()->{assertEquals("Two", testList.removeIndex(3));},
				 ()->{assertEquals(4, testList.size());});
	 }
	 
	 @Test
	 void getMethodTest() {
		 LinkedList<String> testList=new DynamicList<>();
		 testList.addFirst("One");
		 testList.addFirst("Two");
		 testList.addFirst("Three");
		 testList.addFirst("Four");
		 testList.addFirst("Five");
		 assertAll(()->{assertEquals("Four", testList.get(1));},
				 ()->{assertEquals("Two", testList.get(3));},
				 ()->{assertEquals(5, testList.size());});
	 }
}
