package com.pranab.playwithgraphs.datastructure;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.pranab.playwithgraphs.datastructure.Stack;
import com.pranab.playwithgraphs.datastructure.implementation.DynamicList;

@TestMethodOrder(OrderAnnotation.class)
class StackTest {

	 private static Stack<String> stack;
	 private String one="ONE";
	 private String two="TWO";
	 private String three="THREE";
	 
	 @BeforeAll
	 public static void setup() {
		 stack=new DynamicList<>(); 
	 }
	 
	 @Test
	 @Order(1)
	 void pushTest() {
		 stack.push(one);
		 stack.push(two);
		 stack.push(three);
		 assertEquals(3, stack.size());
	 }
	 
	 @Test
	 @Order(2)
	 void peekTest() {
		 assertEquals(three,stack.peek());
	 }
	 
	 @Test
	 @Order(3)
	 void popTest() {
		 assertAll(()->{assertEquals(three,stack.pop());},
				   ()->{assertEquals(two,stack.pop());},
				   ()->{assertEquals(one,stack.pop());});
	 }
}
