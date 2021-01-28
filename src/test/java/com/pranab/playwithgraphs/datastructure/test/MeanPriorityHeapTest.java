package com.pranab.playwithgraphs.datastructure.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pranab.playwithgraphs.datastructure.MinPriorityHeap;
import com.pranab.playwithgraphs.datastructure.ArrayMinPriorityHeap;
import com.pranab.playwithgraphs.model.Application;
import com.pranab.playwithgraphs.model.Person;

@TestMethodOrder(OrderAnnotation.class)
class MeanPriorityHeapTest {
	
	private static int order=1;
	private static List<Person> persons=new ArrayList<>();
	private static List<Application> applications=new ArrayList<>();
	private static MinPriorityHeap<Integer, String> minIntHeap=new ArrayMinPriorityHeap<>();
	private static MinPriorityHeap<Person, Application> minApplicationHeap=new ArrayMinPriorityHeap<>(); 
	private static Logger logger = LoggerFactory.getLogger(MeanPriorityHeapTest.class);
	@BeforeAll
	public static void setup() {
		
		minIntHeap.insert(10, "Ten");
		minIntHeap.insert(5, "Five");
		minIntHeap.insert(3, "Three");
		minIntHeap.insert(3, "Three");
		minIntHeap.insert(1, "One");
		

		persons.add(new Person("Hill Doe",'M',LocalDate.of(2000, 12, 20)));  
		persons.add(new Person("Shane Doe",'F',LocalDate.of(2000, 12, 20)));
		persons.add(new Person("John Doe",'M',LocalDate.of(1991, 12, 20)));
		persons.add(new Person("Jane Doe",'F',LocalDate.of(1991, 12, 20)));
		persons.add(new Person("Alice Doe",'F',LocalDate.of(2012, 12, 20)));
		persons.add(new Person("Fane Doe",'F',LocalDate.of(2015, 12, 20)));
		
		applications.add(new Application(100000, 12));  // 4th processed
		applications.add(new Application(200000, 12));  // 3rd processed
		applications.add(new Application(300000, 12));  // 2nd processed
		applications.add(new Application(400000, 12));  // 1st processed
		applications.add(new Application(500000, 12));  // 5th processed
		applications.add(new Application(600000, 12));	// 6th processed	
		
		for(int index=0;index<6;index++) {
			minApplicationHeap.insert(persons.get(index), applications.get(index));
		}
		 
	}
	
	@Test
	@Order(1)
	void insertTest() {
		minIntHeap.insert(-1, "Minus One");
		persons.add(new Person("Fill Doe",'M',LocalDate.of(1915, 12, 20)));
		applications.add(new Application(700000, 20));
		minApplicationHeap.insert(persons.get(6), applications.get(6));
		//minIntHeap.functionalIterator(t->{logger.info(t.getKey()+" "+t.getValue());});
		//minPersonHeap.functionalIterator(t->{logger.info(t.getKey().getName()+" "+t.getValue().getAmount());});
		assertAll(()->{assertEquals(6,minIntHeap.size());},()->{assertEquals(7,minApplicationHeap.size());});		
	}
	
	@Test
	@Order(2)
	void extractMinTest() {
		assertAll(()->{assertEquals(applications.remove(persons.size()-1), minApplicationHeap.extractMin());}
		,()->{assertEquals("Minus One", minIntHeap.extractMin());});
	}
	
	@Test
	@Order(3)
	void iterateTest() {
		while(minApplicationHeap.size()>0) {
			processApplication(minApplicationHeap.extractMin());
		}
		
		assertAll(()->{assertEquals(4,applications.get(0).getOrder());},
				  ()->{assertEquals(3,applications.get(1).getOrder());},
				  ()->{assertEquals(2,applications.get(2).getOrder());},
				  ()->{assertEquals(1,applications.get(3).getOrder());},
				  ()->{assertEquals(5,applications.get(4).getOrder());},
				  ()->{assertEquals(6,applications.get(5).getOrder());});
	}
	
	private void processApplication(Application app) {
		app.setOrder(order);
		order++;
		float policyAmount=app.getAmount();
		int term=app.getTerms();
		app.setMaturityAmmount((float)(policyAmount+(policyAmount*term*12.5)/100));
		app.setPremium((float)(app.getMaturityAmmount()/(app.getTerms()*12)));
	}
	
	@Test
	@Order(4)
    void peekTest() {		
		String data=minIntHeap.peek();
		assertEquals(data, minIntHeap.extractMin());
	}
	
	@Test
	@Order(5)
	void increasePriorityTest() {
		String initialMin=minIntHeap.peek();
		int index=minIntHeap.getIndex(10);
		minIntHeap.increasePriority(index, 0);
		String currentMin=minIntHeap.peek();
		assertAll(()->{assertEquals(currentMin,minIntHeap.extractMin());},
				  ()->{assertEquals(initialMin,minIntHeap.extractMin());});
	}
}
