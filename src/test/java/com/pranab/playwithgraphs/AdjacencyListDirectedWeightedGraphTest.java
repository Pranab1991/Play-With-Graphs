package com.pranab.playwithgraphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;

import com.pranab.playwithgraphs.model.Entity;
import com.pranab.playwithgraphs.model.JourneyRisk;
import com.pranab.playwithgraphs.model.MiddleEarthGeoEntity;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.weightedgraphs.directed.AdjacencyListDirectedWeightedGraph;

@TestMethodOrder(OrderAnnotation.class)
class AdjacencyListDirectedWeightedGraphTest {

	private static AdjacencyListDirectedWeightedGraph<MiddleEarthGeoEntity, String, JourneyRisk> graph = new AdjacencyListDirectedWeightedGraph<>();

	private static MiddleEarthGeoEntity lindon = new MiddleEarthGeoEntity("Lindon", "Plain Land");
	private static MiddleEarthGeoEntity shire = new MiddleEarthGeoEntity("Shire", "Land of Hobbit Holes");
	private static MiddleEarthGeoEntity bree = new MiddleEarthGeoEntity("Bree", "Town");
	private static MiddleEarthGeoEntity wkoa = new MiddleEarthGeoEntity("Witch Kingdom Of Angamar", "Cementry");
	private static MiddleEarthGeoEntity greyMountain = new MiddleEarthGeoEntity("Grey Mountain", "Mountain");
	private static MiddleEarthGeoEntity akonHill = new MiddleEarthGeoEntity("Akon Hill", "Hills");
	private static MiddleEarthGeoEntity rhun = new MiddleEarthGeoEntity("Rhun", "Desert");
	private static MiddleEarthGeoEntity eriador = new MiddleEarthGeoEntity("Eriador", "Swamp");
	private static MiddleEarthGeoEntity dunland = new MiddleEarthGeoEntity("Dunland", "Swamp & Marshy");
	private static MiddleEarthGeoEntity rohan = new MiddleEarthGeoEntity("Rohan", "Green fields, Lands Of horses");
	private static MiddleEarthGeoEntity gondor = new MiddleEarthGeoEntity("Gondor", "City on Mountains");
	private static MiddleEarthGeoEntity rivendell = new MiddleEarthGeoEntity("Rivendell", "Land of rivers");
	private static MiddleEarthGeoEntity mistyMountains = new MiddleEarthGeoEntity("Misty Mountain", "Mountains");
	private static MiddleEarthGeoEntity isengaurd = new MiddleEarthGeoEntity("Isengaurd", "Watch Tower");
	private static MiddleEarthGeoEntity moria = new MiddleEarthGeoEntity("Moria", "Mines");
	private static MiddleEarthGeoEntity fangorn = new MiddleEarthGeoEntity("Fangorn",
			"Forest where tree shepherd moved");
	private static MiddleEarthGeoEntity mirkwood = new MiddleEarthGeoEntity("Mirk Wood", "Woods of Elf");
	private static MiddleEarthGeoEntity lorien = new MiddleEarthGeoEntity("Lorien", "Elf Land");
	private static MiddleEarthGeoEntity deadMarsh = new MiddleEarthGeoEntity("DeadMarsh", "Swam and Cementry");
	private static MiddleEarthGeoEntity ashMountain = new MiddleEarthGeoEntity("Ash Mountain", "Mountain of Ashes");
	private static MiddleEarthGeoEntity mordor = new MiddleEarthGeoEntity("Mordor", "SAURUMAN");

	@Test
	@Order(1)
	void testCreateNode() {
		graph.createNode("lindon", lindon);
		graph.createNode("shire", shire);
		graph.createNode("bree", bree);
		graph.createNode("wkoa", wkoa);
		graph.createNode("greyMountain", greyMountain);
		graph.createNode("akonHill", akonHill);
		graph.createNode("rhun", rhun);
		graph.createNode("eriador", eriador);
		graph.createNode("dunland", dunland);
		graph.createNode("rohan", rohan);
		graph.createNode("gondor", gondor);
		graph.createNode("rivendell", rivendell);
		graph.createNode("mistyMountains", mistyMountains);
		graph.createNode("isengaurd", isengaurd);
		graph.createNode("moria", moria);
		graph.createNode("fangorn", fangorn);
		graph.createNode("mirkwood", mirkwood);
		graph.createNode("lorien", lorien);
		graph.createNode("deadMarsh", deadMarsh);
		graph.createNode("ashMountain", ashMountain);
		graph.createNode("mordor", mordor);

		assertEquals(21, graph.size());
	}

	@Test
	@Order(2)
	void testRemoveNode() {
		graph.removeNode("shire");
		assertAll(() -> {
			assertEquals(20, graph.size());
		}, () -> {
			assertEquals(null, graph.getValue("shire"));
		});
		graph.createNode("shire", shire);
	}

	@Test
	@Order(3)
	void testUpdateNode() {
		MiddleEarthGeoEntity shire2 = new MiddleEarthGeoEntity("Hobbiton", "hobbits holes by channel");
		graph.updateNode("shire", shire2);
		assertEquals(shire2, graph.getValue("shire"));
		graph.updateNode("shire", shire);
	}

	@Test
	@Order(4)
	void testCreateEdge() {
		graph.createEdge("shire", "lindon", new JourneyRisk(100, Entity.FRIENDLY));
		graph.createEdge("lindon", "eriador", new JourneyRisk(50, Entity.GOBLIN));
		graph.createEdge("eriador", "dunland", new JourneyRisk(70, Entity.ORCS));
		graph.createEdge("dunland", "rohan", new JourneyRisk(110, Entity.FRIENDLY));
		graph.createEdge("rohan", "gondor", new JourneyRisk(30, Entity.FRIENDLY));
		graph.createEdge("shire", "bree", new JourneyRisk(20, Entity.FRIENDLY));
		graph.createEdge("bree", "wkoa", new JourneyRisk(10, Entity.RINGWRAITHS));
		graph.createEdge("greyMountain", "akonHill", new JourneyRisk(120, Entity.TROLLS));
		graph.createEdge("akonHill", "rhun", new JourneyRisk(125, Entity.GOBLIN));
		graph.createEdge("rhun", "deadMarsh", new JourneyRisk(105, Entity.RINGWRAITHS));
		graph.createEdge("deadMarsh", "ashMountain", new JourneyRisk(20, Entity.GOLLUM));
		graph.createEdge("ashMountain", "mordor", new JourneyRisk(10, Entity.SAURUMAN));
		graph.createEdge("mistyMountains", "isengaurd", new JourneyRisk(140, Entity.ORCS));
		graph.createEdge("isengaurd", "rohan", new JourneyRisk(50, Entity.FRIENDLY));
		graph.createEdge("fangorn", "rohan", new JourneyRisk(5, Entity.FRIENDLY));
		graph.createEdge("lorien", "deadMarsh", new JourneyRisk(10, Entity.ORCS));
		graph.createEdge("mirkwood", "deadMarsh", new JourneyRisk(40, Entity.ORCS));
		graph.createEdge("gondor", "mordor", new JourneyRisk(5, Entity.SAURUMAN));

		List<String> keyList = graph.getAllEdgeKeys("shire");
		assertAll(() -> {
			assertEquals(2, keyList.size());
		}, () -> {
			assertTrue(keyList.contains("bree"));
		}, () -> {
			assertTrue(keyList.contains("lindon"));
		});
	}

	@Test
	@Order(5)
	void testCreateEdges() {
		Map<String, JourneyRisk> wkoaTargetMap = new HashMap<>();
		wkoaTargetMap.put("greyMountain", new JourneyRisk(15, Entity.ORCS));
		wkoaTargetMap.put("rivendell", new JourneyRisk(5, Entity.FRIENDLY));
		graph.createEdges("wkoa", wkoaTargetMap);

		Map<String, JourneyRisk> rivendellTargetMap = new HashMap<>();
		rivendellTargetMap.put("mistyMountains", new JourneyRisk(15, Entity.FRIENDLY));
		rivendellTargetMap.put("moria", new JourneyRisk(5, Entity.BALROG));
		graph.createEdges("rivendell", rivendellTargetMap);

		Map<String, JourneyRisk> moriaTargetMap = new HashMap<>();
		moriaTargetMap.put("fangorn", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("lorien", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("mirkwood", new JourneyRisk(20, Entity.ORCS));
		graph.createEdges("moria", moriaTargetMap);

		List<String> keyList = graph.getAllEdgeKeys("moria");
		assertAll(() -> {
			assertEquals(3, keyList.size());
		}, () -> {
			assertTrue(keyList.contains("fangorn"));
		}, () -> {
			assertTrue(keyList.contains("lorien"));
		}, () -> {
			assertTrue(keyList.contains("mirkwood"));
		}, () -> {
			assertFalse(keyList.contains("rivendell"));
		});
	}

	@Test
	@Order(6)
	void testRemoveEdge() {
		graph.removeEdge("shire", "bree");
		List<String> keyList = graph.getAllEdgeKeys("shire");
		assertAll(() -> {
			assertEquals(1, keyList.size());
		}, () -> {
			assertTrue(keyList.contains("lindon"));
		});
		graph.createEdge("shire", "bree", new JourneyRisk(20, Entity.FRIENDLY));
	}

	@Test
	@Order(7)
	void testRemoveEdges() {
		List<String> edgeKeyList = Arrays.asList("fangorn", "lorien", "mirkwood");
		graph.removeEdges("moria", edgeKeyList);
		List<String> keyList = graph.getAllEdgeKeys("moria");
		assertAll(() -> {
			assertEquals(0, keyList.size());
		}, () -> {
			assertFalse(keyList.contains("fangorn"));
		});

		Map<String, JourneyRisk> moriaTargetMap = new HashMap<>();
		moriaTargetMap.put("fangorn", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("lorien", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("mirkwood", new JourneyRisk(20, Entity.ORCS));
		graph.createEdges("moria", moriaTargetMap);
	}

	@Test
	@Order(8)
	void testRemoveAllEdges() {
		graph.removeAllEdges("moria");
		List<String> keyList = graph.getAllEdgeKeys("moria");
		assertAll(() -> {
			assertEquals(0, keyList.size());
		}, () -> {
			assertFalse(keyList.contains("fangorn"));
		});

		Map<String, JourneyRisk> moriaTargetMap = new HashMap<>();
		moriaTargetMap.put("fangorn", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("lorien", new JourneyRisk(10, Entity.FRIENDLY));
		moriaTargetMap.put("mirkwood", new JourneyRisk(20, Entity.ORCS));
		graph.createEdges("moria", moriaTargetMap);
	}

	@Test
	@Order(9)
	void testSearchLevel() {
		List<MiddleEarthGeoEntity> middleEarthgeoEntity = graph.searchLevel("shire", 2, false);
		assertAll(() -> {
			assertEquals(2, middleEarthgeoEntity.size());
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(wkoa));
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(eriador));
		});
	}

	@Test
	@Order(10)
	void testSearchDeeperLevel() {
		List<MiddleEarthGeoEntity> middleEarthgeoEntity = graph.searchLevel("shire", 4, false);
		assertAll(() -> {
			assertEquals(4, middleEarthgeoEntity.size());
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(rohan));
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(mistyMountains));
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(moria));
		}, () -> {
			assertTrue(middleEarthgeoEntity.contains(akonHill));
		});
	}

	@Test
	@Order(11)
	void testSearchNotExistingLevel() {
		List<MiddleEarthGeoEntity> charecters = graph.searchLevel("shire", 10, false);
		assertEquals(0, charecters.size());
	}

	@Test
	@Order(12)
	void testSortestPathMiddle() {
		Queue<String> queue=graph.searchSortestPath("shire", "mordor");
		assertAll(()->{assertEquals(9, queue.size());},
				  ()->{assertEquals("mordor",queue.poll());},
				  ()->{assertEquals("gondor",queue.poll());},
				  ()->{assertEquals("rohan",queue.poll());},
				  ()->{assertEquals("fangorn",queue.poll());},
				  ()->{assertEquals("moria",queue.poll());},
				  ()->{assertEquals("rivendell",queue.poll());},
				  ()->{assertEquals("wkoa",queue.poll());},
				  ()->{assertEquals("bree",queue.poll());},
				  ()->{assertEquals("shire",queue.poll());});
	}
	
	@Test
	void testCheckCycleOnAcyclic() {
		AdjacencyListDirectedWeightedGraph<Integer, Integer, PathLength> cycleGraph = new AdjacencyListDirectedWeightedGraph<>();
		cycleGraph.createNode(0, 0);
		cycleGraph.createNode(1, 1);
		cycleGraph.createNode(2, 2);
		cycleGraph.createNode(3, 3);
		cycleGraph.createNode(4, 4);
		cycleGraph.createEdge(0, 1, PathLength.pathLengthObj);
		cycleGraph.createEdge(2, 1, PathLength.pathLengthObj);
		cycleGraph.createEdge(2, 3, PathLength.pathLengthObj);
		cycleGraph.createEdge(3, 4, PathLength.pathLengthObj);
		cycleGraph.createEdge(4, 0, PathLength.pathLengthObj);
		cycleGraph.createEdge(4, 2, PathLength.pathLengthObj);
		assertTrue(cycleGraph.checkCycle());
	}

	@Test
	void testTopologicalOrderingWithTaskScheduling() {
		AdjacencyListDirectedWeightedGraph<String, String, PathLength> depthGraph = new AdjacencyListDirectedWeightedGraph<>();
		depthGraph.createNode("ac", "apacheCommons.jar");
		depthGraph.createNode("l4", "log4j.jar");
		depthGraph.createNode("sf", "slf4j.jar");
		depthGraph.createNode("sc", "spring-core.jar");
		depthGraph.createNode("sw", "spring-web.jar");
		depthGraph.createNode("ss", "sevlet-api.jar");
		depthGraph.createNode("je", "javaee.jar");
		depthGraph.createEdge("l4", "sf", PathLength.pathLengthObj);
		depthGraph.createEdge("ac", "sc", PathLength.pathLengthObj);
		depthGraph.createEdge("sf", "sc", PathLength.pathLengthObj);
		depthGraph.createEdge("sc", "sw", PathLength.pathLengthObj);
		depthGraph.createEdge("ss", "sw", PathLength.pathLengthObj);
		depthGraph.createEdge("je", "sw", PathLength.pathLengthObj);
		List<String> orderedData = depthGraph.getTopologicalOrdered();
		List<String> expected = Arrays.asList("je", "l4", "sf", "ac", "ss", "sc", "sw");
		assertTrue(orderedData.equals(expected));
	}

	@Test
	void testTopologicalOrderingWithCycledetection() {
		AdjacencyListDirectedWeightedGraph<String, String, PathLength> depthGraph = new AdjacencyListDirectedWeightedGraph<>();
		depthGraph.createNode("a", "a");
		depthGraph.createNode("b", "b");
		depthGraph.createNode("c", "c");
		depthGraph.createNode("d", "d");
		depthGraph.createNode("e", "e");
		depthGraph.createNode("f", "f");
		depthGraph.createNode("g", "g");
		depthGraph.createNode("h", "h");
		depthGraph.createNode("i", "i");
		depthGraph.createNode("j", "j");
		depthGraph.createEdge("a", "f", PathLength.pathLengthObj);
		depthGraph.createEdge("a", "b", PathLength.pathLengthObj);
		depthGraph.createEdge("b", "h", PathLength.pathLengthObj);
		depthGraph.createEdge("d", "c", PathLength.pathLengthObj);
		depthGraph.createEdge("d", "h", PathLength.pathLengthObj);
		depthGraph.createEdge("d", "i", PathLength.pathLengthObj);
		depthGraph.createEdge("d", "e", PathLength.pathLengthObj);
		depthGraph.createEdge("e", "i", PathLength.pathLengthObj);
		depthGraph.createEdge("g", "a", PathLength.pathLengthObj);
		depthGraph.createEdge("g", "b", PathLength.pathLengthObj);
		depthGraph.createEdge("g", "c", PathLength.pathLengthObj);
		depthGraph.createEdge("i", "c", PathLength.pathLengthObj);
		List<String> orderedData = depthGraph.getTopologicalOrdered();
		List<String> expected = Arrays.asList("j", "g", "d", "e", "i", "c", "a", "b", "h", "f");
		assertTrue(orderedData.equals(expected));
	}

	@Test
	void testTopologicalOrderingWithCycled() {
		AdjacencyListDirectedWeightedGraph<String, String, PathLength> depthGraph = new AdjacencyListDirectedWeightedGraph<>();
		depthGraph.createNode("a", "a");
		depthGraph.createNode("b", "b");
		depthGraph.createNode("c", "c");
		depthGraph.createNode("d", "d");
		depthGraph.createNode("e", "e");
		depthGraph.createEdge("a", "b", PathLength.pathLengthObj);
		depthGraph.createEdge("b", "c", PathLength.pathLengthObj);
		depthGraph.createEdge("c", "d", PathLength.pathLengthObj);
		depthGraph.createEdge("d", "e", PathLength.pathLengthObj);
		depthGraph.createEdge("e", "c", PathLength.pathLengthObj);
		assertThrows(UnsupportedOperationException.class, () -> {
			depthGraph.getTopologicalOrdered();
		});
	}

	@Test
	void testGetStrongConnectedComponent() {
		AdjacencyListDirectedWeightedGraph<Integer, Integer, PathLength> sccGraph = new AdjacencyListDirectedWeightedGraph<>();
		sccGraph.createNode(1, 1);
		sccGraph.createNode(2, 2);
		sccGraph.createNode(3, 3);
		sccGraph.createNode(4, 4);
		sccGraph.createNode(5, 5);
		sccGraph.createNode(6, 6);
		sccGraph.createNode(7, 7);
		sccGraph.createNode(8, 8);
		sccGraph.createNode(9, 9);

		sccGraph.createEdge(1, 4, PathLength.pathLengthObj);
		sccGraph.createEdge(4, 7, PathLength.pathLengthObj);
		sccGraph.createEdge(7, 1, PathLength.pathLengthObj);
		sccGraph.createEdge(9, 7, PathLength.pathLengthObj);
		sccGraph.createEdge(9, 3, PathLength.pathLengthObj);
		sccGraph.createEdge(3, 6, PathLength.pathLengthObj);
		sccGraph.createEdge(6, 9, PathLength.pathLengthObj);
		sccGraph.createEdge(8, 6, PathLength.pathLengthObj);
		sccGraph.createEdge(8, 5, PathLength.pathLengthObj);
		sccGraph.createEdge(5, 2, PathLength.pathLengthObj);
		sccGraph.createEdge(2, 8, PathLength.pathLengthObj);
		List<List<Integer>> sccLists = sccGraph.getStrongConnectedComponent();
		List<Integer> connectedComponentOne = Arrays.asList(7, 4, 1);
		List<Integer> connectedComponentTwo = Arrays.asList(6, 3, 9);
		List<Integer> connectedComponentThree = Arrays.asList(2, 5, 8);
		assertAll(() -> {
			assertTrue(sccLists.contains(connectedComponentOne));
		}, () -> {
			assertTrue(sccLists.contains(connectedComponentTwo));
		}, () -> {
			assertTrue(sccLists.contains(connectedComponentThree));
		});
	}

	@Test
	void testSortestPath() {
		AdjacencyListDirectedWeightedGraph<String, String, DemoPathLength> testSortestPath = new AdjacencyListDirectedWeightedGraph<>();
		testSortestPath.createNode("S", "S");
		testSortestPath.createNode("V", "V");
		testSortestPath.createNode("W", "W");
		testSortestPath.createNode("T", "T");

		testSortestPath.createEdge("S", "W", new DemoPathLength(4));
		testSortestPath.createEdge("S", "V", new DemoPathLength(1));
		testSortestPath.createEdge("V", "W", new DemoPathLength(2));
		testSortestPath.createEdge("W", "T", new DemoPathLength(3));
		testSortestPath.createEdge("V", "T", new DemoPathLength(6));
		
		Queue<String> pathQueue=testSortestPath.searchSortestPath("S","T");
		assertAll(()->{assertEquals(4,pathQueue.size());},
				()->{assertEquals("T",pathQueue.poll());},
				()->{assertEquals("W",pathQueue.poll());},
				()->{assertEquals("V",pathQueue.poll());},
				()->{assertEquals("S",pathQueue.poll());});
	}

	static class PathLength implements Weight {
		public static PathLength pathLengthObj = new PathLength();

		@Override
		public int getWeight() {
			return 0;
		}
	}

	class DemoPathLength implements Weight {

		private int weight;

		@Override
		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public DemoPathLength(int weight) {
			super();
			this.weight = weight;
		}

	}
}
