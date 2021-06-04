package com.pranab.playwithgraphs;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.pranab.playwithgraphs.model.MCUCharecter;
import com.pranab.playwithgraphs.unweightedgraphs.directed.AdjencyListDirectedGraph;

@TestMethodOrder(OrderAnnotation.class)
public class AdjacencyListDirectedGraphTest {

	private static AdjencyListDirectedGraph<MCUCharecter, String> graph = new AdjencyListDirectedGraph<>();
	private static MCUCharecter fury;
	private static MCUCharecter hulk;
	private static MCUCharecter hawkEye;
	private static MCUCharecter blackWidow;
	private static MCUCharecter tony;
	private static MCUCharecter thor;
	private static MCUCharecter cap;
	private static MCUCharecter antMan;
	private static MCUCharecter wasp;
	private static MCUCharecter witch;
	private static MCUCharecter xarvis;
	private static MCUCharecter bucky;
	private static MCUCharecter falcon;
	private static MCUCharecter godOfMischief;
	private static MCUCharecter strange;
	private static MCUCharecter quil;
	private static MCUCharecter yondu;
	private static MCUCharecter collector;
	private static MCUCharecter gamora;
	private static MCUCharecter nebula;
	private static MCUCharecter ronan;
	private static MCUCharecter groot;
	private static MCUCharecter rocket;
	private static MCUCharecter drax;
	private static MCUCharecter spidy;
	private static MCUCharecter blackPanther;
	private static MCUCharecter warMachine;

	@BeforeAll
	public static void generateCharecters() {
		fury = new MCUCharecter("NICK FURY", Arrays.asList("SPY", "STRATEGIST", "DOUBLE AGENT"), false, null);
		hulk = new MCUCharecter("BRUCE BANNER", Arrays.asList("SMASH", "INCREDEBILE STRENGTH", "QUICK RECOVERY"), false,
				null);
		hawkEye = new MCUCharecter("CLINT BARTON", Arrays.asList("ARCHERY", "MARTIAL ART"), false, null);
		blackWidow = new MCUCharecter("NATASHA ROMANOFF", Arrays.asList("DOUBLE AGENT", "MARTIAL ART"), false, null);
		tony = new MCUCharecter("TONY STARK", Arrays.asList("GENIUS", "IRON SUIT", "IRON HEART", "SOMEONE LIKE ME ;D"),
				false, null);
		thor = new MCUCharecter("THOR ODINSON", Arrays.asList("THUNDER GOD", "IMMORTAL", "QUICK HEAL"), false, null);
		cap = new MCUCharecter("STEVE ROGERS", Arrays.asList("SLOW AGING", "ENHANCED STREANGTH AND AGILITY"), false,
				null);
		antMan = new MCUCharecter("SCOTT LANG", Arrays.asList("CONTROLS PYM PARTICLE", "BURGLAR"), false, null);
		wasp = new MCUCharecter("JANET VAN DYNE", Arrays.asList("CONTROLS PYM PARTICLE", "FLY"), false, null);
		witch = new MCUCharecter("WANDA MAXIMOFF", Arrays.asList("REALITY WRAPPING", "ENERGY MANIPULATION"), false,
				null);
		xarvis = new MCUCharecter("VISION", Arrays.asList("SUPERHUMAN INTELLIGENCE", "STRENGTH"), true, "MIND STONE");
		bucky = new MCUCharecter("BUCKY BARNES", Arrays.asList("METAL ARM", "ENHANCED AGILITY"), false, null);
		falcon = new MCUCharecter("SAMUEL THOMAS", Arrays.asList("FLY", "AGILITY"), false, null);
		godOfMischief = new MCUCharecter("LOKI ODINSON", Arrays.asList("MANIPULATE REALITY", "IMMORTALITY"), true,
				"SPACE STONE");
		strange = new MCUCharecter("STEPHEN STRANGE", Arrays.asList("MAGIC", "CONTROL TIME"), true, "TIME STONE");
		quil = new MCUCharecter("PETER QUIL", Arrays.asList("DANCE OFF", "CELESTIAL"), false, null);
		yondu = new MCUCharecter("YONDU UDONTA", Arrays.asList("BOUNTY HUNTER", "WHISTLING ARROW"), false, null);
		collector = new MCUCharecter("THE COLLECTOR", Arrays.asList("COLLECTS ENTITY"), true, "REALITY STONE");
		gamora = new MCUCharecter("GAMORA", Arrays.asList("EXCELLENT FIGHTER", "ASASSINATOR"), true, "SOUL STONE");
		nebula = new MCUCharecter("NEBULA", Arrays.asList("ASASSINATOR", "CYBORG"), false, null);
		ronan = new MCUCharecter("RONAN THE DESTROYER", Arrays.asList("SUPER STRENGTH", "IMMORTALITY"), true,
				"POWER STONE");
		groot = new MCUCharecter("I AM GROOT", Arrays.asList("SUPER ENDURANCE", "REGENERATIVE"), false, null);
		rocket = new MCUCharecter("ROCKET", Arrays.asList("SUPER INTELIGENCE", "CYBORG"), false, null);
		spidy = new MCUCharecter("PETER PARKER", Arrays.asList("SUPER STRENGTH", "SUPER INTELIGENCE"), false, null);
		blackPanther = new MCUCharecter("TACHALLA", Arrays.asList("AGILITY", "POWER FIST"), false, null);
		warMachine=new MCUCharecter("JAMES RHODES", Arrays.asList("METAL SUIT", "HIGHER FIRE POWER"), false, null);
		drax=new MCUCharecter("DRAX THE DESTROYER", Arrays.asList("ENHANCED STRENGTH", "RESILIENCE"), false, null);
	}

	@Test
	@Order(1)
	void testCreateNode() {
		graph.createNode("fury", fury);
		graph.createNode("hulk", hulk);
		graph.createNode("hawkEye", hawkEye);
		graph.createNode("blackWidow", blackWidow);
		graph.createNode("tony", tony);
		graph.createNode("thor", thor);
		graph.createNode("cap", cap);
		graph.createNode("antMan", antMan);
		graph.createNode("wasp", wasp);
		graph.createNode("witch", witch);
		graph.createNode("xarvis", xarvis);
		graph.createNode("bucky", bucky);
		graph.createNode("falcon", falcon);
		graph.createNode("godOfMischief", godOfMischief);
		graph.createNode("strange", strange);
		graph.createNode("quil", quil);
		graph.createNode("yondu", yondu);
		graph.createNode("collector", collector);
		graph.createNode("gamora", gamora);
		graph.createNode("nebula", nebula);
		graph.createNode("ronan", ronan);
		graph.createNode("groot", groot);
		graph.createNode("rocket", rocket);
		graph.createNode("spidy", spidy);
		graph.createNode("blackPanther", blackPanther);
		graph.createNode("warMachine", warMachine);
		graph.createNode("drax", drax);
		assertEquals(27, graph.size());
	}
	
	@Test
	@Order(2)
	void testRemoveNode() {
		graph.removeNode("fury");
		assertEquals(26, graph.size());
		graph.removeNode("ronan");
		assertEquals(25, graph.size());
		graph.createNode("fury", fury);
		graph.createNode("ronan", ronan);
	}
	
	@Test
	@Order(3)
	void testUpdateNode() {
		MCUCharecter fury2=new MCUCharecter("NICK FURY", Arrays.asList("SPY", "ONE EYED", "DOUBLE AGENT"), false, null);
		graph.updateNode("fury", fury2);
		assertEquals(fury2, graph.getValue("fury"));
		graph.updateNode("fury", fury);
		assertEquals(fury, graph.getValue("fury"));
	}
	
	@Test
	@Order(4)
	void testCreateEdge() {
		graph.createEdge("fury", "hulk");
		graph.createEdge("fury", "hawkEye");
		graph.createEdge("fury", "blackWidow");
		graph.createEdge("fury", "tony");
		graph.createEdge("fury", "thor");
		graph.createEdge("fury", "cap");
		List<String> keyList=graph.getAllEdgeKeys("fury");
		assertAll(()->{assertEquals(6, keyList.size());},
				  ()->{assertTrue(keyList.contains("hulk"));},
				  ()->{assertTrue(keyList.contains("tony"));},
				  ()->{assertTrue(keyList.contains("cap"));});
	}
	
	@Test
	@Order(5)
	void testCreateEdges() {
		graph.createEdges("cap",Arrays.asList("antMan","witch","bucky","falcon"));
		graph.createEdges("antMan",Arrays.asList("wasp"));
		graph.createEdges("witch",Arrays.asList("xarvis"));
		graph.createEdges("bucky",Arrays.asList("blackPanther"));
		graph.createEdges("thor",Arrays.asList("strange","godOfMischief","quil"));
		graph.createEdges("tony",Arrays.asList("spidy","warMachine"));
		graph.createEdges("quil",Arrays.asList("drax","rocket","groot","gamora","yondu"));
		graph.createEdges("yondu",Arrays.asList("collector"));
		graph.createEdges("gamora",Arrays.asList("nebula"));
		graph.createEdges("nebula",Arrays.asList("ronan"));
		List<String> capConnection=graph.getAllEdgeKeys("cap");
		List<String> quilConnection=graph.getAllEdgeKeys("quil");
		List<String> thorConnection=graph.getAllEdgeKeys("thor");
		assertAll(()->{assertEquals(4, capConnection.size());},
				  ()->{assertTrue(capConnection.contains("antMan"));},
				  ()->{assertTrue(capConnection.contains("bucky"));},
				  ()->{assertTrue(capConnection.contains("falcon"));},
				  ()->{assertEquals(5, quilConnection.size());},
				  ()->{assertTrue(quilConnection.contains("drax"));},
				  ()->{assertTrue(quilConnection.contains("yondu"));},
				  ()->{assertEquals(3, thorConnection.size());},
				  ()->{assertTrue(thorConnection.contains("strange"));},
				  ()->{assertTrue(thorConnection.contains("godOfMischief"));},
				  ()->{assertTrue(thorConnection.contains("quil"));});
	}
	
	@Test
	@Order(6)
	void testRemoveEdge() {
		graph.removeEdge("fury", "hulk");
		List<String> keyList=graph.getAllEdgeKeys("fury");
		assertEquals(5, keyList.size());
		assertFalse(keyList.contains("hulk"));
		graph.createEdge("fury", "hulk");
	}
	
	@Test
	@Order(7)
	void testRemoveEdges() {
		List<String> edgeKeyList=Arrays.asList("hulk","tony","cap");
		graph.removeEdges("fury", edgeKeyList);
		List<String> keyList=graph.getAllEdgeKeys("fury");
		assertAll(()->{assertEquals(3, keyList.size());},
				  ()->{assertFalse(keyList.contains("hulk"));},
				  ()->{assertTrue(keyList.contains("thor"));});
		graph.createEdges("fury", edgeKeyList);
	}	

	@Test
	@Order(8)
	void testRemoveAllEdges() {
		graph.removeAllEdges("cap");
		List<String> keyList=graph.getAllEdgeKeys("cap");
		assertEquals(0, keyList.size());
		graph.createEdges("cap",Arrays.asList("antMan","witch","bucky","falcon"));
	}
	
	@Test
	@Order(9)
	void testSearchLevel() {
		List<MCUCharecter> charecters=graph.searchLevel("fury", 2, false);
		assertAll(()->{assertEquals(9, charecters.size());},
				  ()->{assertTrue(charecters.contains(spidy));},
				  ()->{assertTrue(charecters.contains(warMachine));},
				  ()->{assertTrue(charecters.contains(quil));},
				  ()->{assertTrue(charecters.contains(godOfMischief));},
				  ()->{assertTrue(charecters.contains(strange));},
				  ()->{assertTrue(charecters.contains(falcon));},
				  ()->{assertTrue(charecters.contains(bucky));},
				  ()->{assertTrue(charecters.contains(witch));},
				  ()->{assertTrue(charecters.contains(antMan));});
	}
	
	@Test
	@Order(10)
	void testSearchDeeperLevel() {
		List<MCUCharecter> charecters=graph.searchLevel("fury", 5, false);
		assertAll(()->{assertEquals(1, charecters.size());},
				  ()->{assertTrue(charecters.contains(ronan));});
	}
	
	@Test
	@Order(11)
	void testSearchNotExistingLevel() {
		List<MCUCharecter> charecters=graph.searchLevel("fury", 6, false);
		assertEquals(0, charecters.size());
	}
	
	@Test
	@Order(12)
	void testSearchUniDirectionLevel() {
		List<MCUCharecter> charecters=graph.searchLevel("thor", 1, false);
		assertAll(()->{assertEquals(3, charecters.size());},
				  ()->{assertTrue(charecters.contains(strange));},
				  ()->{assertTrue(charecters.contains(godOfMischief));},
				  ()->{assertTrue(charecters.contains(quil));});
	}
	
	@Test
	@Order(13)
	void testSearchPath() {
		Queue<String> charecters=graph.searchSortestPath("fury", "ronan");
		assertAll(()->{assertEquals(6, charecters.size());},
				  ()->{assertEquals("ronan",charecters.poll());},
				  ()->{assertEquals("nebula",charecters.poll());},
				  ()->{assertEquals("gamora",charecters.poll());},
				  ()->{assertEquals("quil",charecters.poll());},
				  ()->{assertEquals("thor",charecters.poll());},
				  ()->{assertEquals("fury",charecters.poll());});
	}
	
	@Test
	@Order(14)
	void testSearchPathWithNoExistingPath() {
		Queue<String> charecters=graph.searchSortestPath("thor", "hulk");
		assertEquals(0, charecters.size());
	}
	
	@Test
	@Order(15)
	void testSearchPathToCheckReset() {
		Queue<String> charecters=graph.searchSortestPath("thor", "collector");
		assertAll(()->{assertEquals(4, charecters.size());},
				  ()->{assertEquals("collector",charecters.poll());},
				  ()->{assertEquals("yondu",charecters.poll());},
				  ()->{assertEquals("quil",charecters.poll());},
				  ()->{assertEquals("thor",charecters.poll());});
	}
	
	@Test
	@Order(16)
	void testSearchPathForSortestPath() {
		graph.createEdge("yondu", "ronan");
		Queue<String> charecters=graph.searchSortestPath("fury", "ronan");
		assertAll(()->{assertEquals(5, charecters.size());},
				  ()->{assertEquals("ronan",charecters.poll());},
				  ()->{assertEquals("yondu",charecters.poll());},
				  ()->{assertEquals("quil",charecters.poll());},
				  ()->{assertEquals("thor",charecters.poll());},
				  ()->{assertEquals("fury",charecters.poll());});
		graph.removeEdge("yondu", "ronan");
	}
	
	@Test
	@Order(17)
	void testCheckCycle() {
		graph.createEdge("ronan", "gamora");
		assertTrue(graph.checkCycle());
		graph.removeEdge("ronan", "gamora");
		assertFalse(graph.checkCycle());
	}
	
	@Test
	void testCheckCycleOnAcyclic() {
		AdjencyListDirectedGraph<Integer, Integer> cycleGraph=new AdjencyListDirectedGraph<>();
		cycleGraph.createNode(0, 0);
		cycleGraph.createNode(1, 1);
		cycleGraph.createNode(2, 2);
		cycleGraph.createNode(3, 3);
		cycleGraph.createNode(4, 4);
		cycleGraph.createEdge(0, 1);
		cycleGraph.createEdge(2, 1);
		cycleGraph.createEdge(2, 3);
		cycleGraph.createEdge(3, 4);
		cycleGraph.createEdge(4, 0);
		cycleGraph.createEdge(4, 2);
		assertTrue(cycleGraph.checkCycle());		
	}
	
	@Test
	void testTopologicalOrderingWithTaskScheduling() {
		AdjencyListDirectedGraph<String, String> depthGraph=new AdjencyListDirectedGraph<>();
		depthGraph.createNode("ac","apacheCommons.jar");
		depthGraph.createNode("l4","log4j.jar");
		depthGraph.createNode("sf","slf4j.jar");
		depthGraph.createNode("sc","spring-core.jar");
		depthGraph.createNode("sw","spring-web.jar");
		depthGraph.createNode("ss","sevlet-api.jar");
		depthGraph.createNode("je","javaee.jar");
		depthGraph.createEdge("l4","sf");
		depthGraph.createEdge("ac","sc");
		depthGraph.createEdge("sf","sc");
		depthGraph.createEdge("sc","sw");
		depthGraph.createEdge("ss","sw");
		depthGraph.createEdge("je","sw");
		List<String> orderedData=depthGraph.getTopologicalOrdered();
		List<String> expected=Arrays.asList("je", "l4", "sf", "ac", "ss", "sc", "sw");
		assertTrue(orderedData.equals(expected));
	}
	
	@Test
	void testTopologicalOrderingWithCycledetection() {
		AdjencyListDirectedGraph<String, String> depthGraph=new AdjencyListDirectedGraph<>();
		depthGraph.createNode("a","a");
		depthGraph.createNode("b","b");
		depthGraph.createNode("c","c");
		depthGraph.createNode("d","d");
		depthGraph.createNode("e","e");
		depthGraph.createNode("f","f");
		depthGraph.createNode("g","g");
		depthGraph.createNode("h","h");
		depthGraph.createNode("i","i");
		depthGraph.createNode("j","j");
		depthGraph.createEdge("a", "f");
		depthGraph.createEdge("a", "b");
		depthGraph.createEdge("b", "h");
		depthGraph.createEdge("d", "c");
		depthGraph.createEdge("d", "h");
		depthGraph.createEdge("d", "i");
		depthGraph.createEdge("d", "e");
		depthGraph.createEdge("e", "i");
		depthGraph.createEdge("g", "a");
		depthGraph.createEdge("g", "b");
		depthGraph.createEdge("g", "c");
		depthGraph.createEdge("i", "c");
		List<String> orderedData=depthGraph.getTopologicalOrdered();
		List<String> expected=Arrays.asList("j", "g", "d", "e", "i", "c", "a", "b", "h", "f");
		assertTrue(orderedData.equals(expected));
	}
	
	@Test
	void testTopologicalOrderingWithCycled() {
		AdjencyListDirectedGraph<String, String> depthGraph=new AdjencyListDirectedGraph<>();
		depthGraph.createNode("a","a");
		depthGraph.createNode("b","b");
		depthGraph.createNode("c","c");
		depthGraph.createNode("d","d");
		depthGraph.createNode("e","e");	
		depthGraph.createEdge("a", "b");
		depthGraph.createEdge("b", "c");
		depthGraph.createEdge("c", "d");
		depthGraph.createEdge("d", "e");
		depthGraph.createEdge("e", "c");
		assertThrows(UnsupportedOperationException.class,()->{ depthGraph.getTopologicalOrdered();});
	}
	
	@Test
	void testGetStrongConnectedComponent() {
		AdjencyListDirectedGraph<Integer, Integer> sccGraph=new AdjencyListDirectedGraph<>();
		sccGraph.createNode(1,1);
		sccGraph.createNode(2,2);
		sccGraph.createNode(3,3);
		sccGraph.createNode(4,4);
		sccGraph.createNode(5,5);
		sccGraph.createNode(6,6);
		sccGraph.createNode(7,7);
		sccGraph.createNode(8,8);
		sccGraph.createNode(9,9);
		
		sccGraph.createEdge(1, 4);
		sccGraph.createEdge(4, 7);
		sccGraph.createEdge(7, 1);
		sccGraph.createEdge(9, 7);
		sccGraph.createEdge(9, 3);
		sccGraph.createEdge(3, 6);
		sccGraph.createEdge(6, 9);
		sccGraph.createEdge(8, 6);
		sccGraph.createEdge(8, 5);
		sccGraph.createEdge(5, 2);
		sccGraph.createEdge(2, 8);
		List<List<Integer>> sccLists=sccGraph.getStrongConnectedComponent();
		List<Integer> connectedComponentOne=Arrays.asList(7,4,1);
		List<Integer> connectedComponentTwo=Arrays.asList(6,3,9);
		List<Integer> connectedComponentThree=Arrays.asList(2,5,8);
		assertAll(()->{assertTrue(sccLists.contains(connectedComponentOne));},
					()->{assertTrue(sccLists.contains(connectedComponentTwo));},
					()->{assertTrue(sccLists.contains(connectedComponentThree));});
	}
}
