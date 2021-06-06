package com.pranab.playwithgraphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.pranab.playwithgraphs.model.Entity;
import com.pranab.playwithgraphs.model.JourneyRisk;
import com.pranab.playwithgraphs.weightedgraphs.Weight;
import com.pranab.playwithgraphs.model.MiddleEarthGeoEntity;
import com.pranab.playwithgraphs.model.ToonCharecters;
import com.pranab.playwithgraphs.weightedgraphs.undirected.AdjancencyListUnDirectedWeightedGraph;
import com.pranab.playwithgraphs.weightedgraphs.undirected.SpanningEdge;

@TestMethodOrder(OrderAnnotation.class)
class AdjacencyListUnDirectedWeightedGraphTest {

	private static AdjancencyListUnDirectedWeightedGraph<MiddleEarthGeoEntity, String, JourneyRisk> graph = new AdjancencyListUnDirectedWeightedGraph<>();
	
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
			assertEquals(4, keyList.size());
		}, () -> {
			assertTrue(keyList.contains("fangorn"));
		}, () -> {
			assertTrue(keyList.contains("lorien"));
		}, () -> {
			assertTrue(keyList.contains("mirkwood"));
		}, () -> {
			assertTrue(keyList.contains("rivendell"));
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
		List<String> edgeKeyList = Arrays.asList("fangorn", "lorien", "mirkwood" , "rivendell");
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
		graph.createEdge("rivendell", "moria",  new JourneyRisk(5, Entity.BALROG));
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
		graph.createEdge("rivendell", "moria",  new JourneyRisk(5, Entity.BALROG));
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
	void testSortestPath() {
		AdjancencyListUnDirectedWeightedGraph<String, String, DemoPathLength> testSortestPath = new AdjancencyListUnDirectedWeightedGraph<>();
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
	
	@Test
	void testSearchClusters() {
		AdjancencyListUnDirectedWeightedGraph<ToonCharecters, String,AnimeWeights> storage = new AdjancencyListUnDirectedWeightedGraph<>();
		 createCharecters(storage);
		 createEdges(storage);		 
		 List<List<String>> groups=storage.findClusters();
		 assertAll(()->{assertEquals(3, groups.size());},
				   ()->{assertTrue(groups.contains(Arrays.asList("sherKhan", "baloo", "bagira", "mogli", "raksha")));},
			   ()->{assertTrue(groups.contains(Arrays.asList("mufasa", "scar", "nala", "pumba", "rafiki", "simba", "timon")));});
		
	}

	@Test
	void testSearchSpecificClusters() {
		AdjancencyListUnDirectedWeightedGraph<ToonCharecters, String,AnimeWeights> storage = new AdjancencyListUnDirectedWeightedGraph<>();
		 createCharecters(storage);
		 createEdges(storage);		 
		 List<String> group=storage.findClusters(t-> t.getMovie().equals("Mogli"));
		 assertAll(()->{assertEquals(5, group.size());},
				   ()->{assertTrue(group.contains("sherKhan"));},
				   ()->{assertTrue(group.contains("baloo"));},
				   ()->{assertTrue(group.contains("bagira"));},
				   ()->{assertTrue(group.contains("raksha"));},
				   ()->{assertTrue(group.contains("mogli"));},
				   ()->{assertFalse(group.contains("mufasa"));});
		
	}
	
	
	private void createEdges(AdjancencyListUnDirectedWeightedGraph<ToonCharecters, String, AnimeWeights> storage) {
		AnimeWeights mogliWeight=new AnimeWeights("Mogli");
		 AnimeWeights lionKingWeight=new AnimeWeights("Lion King");
		 AnimeWeights kungFuPandaWeight=new AnimeWeights("Kung Fu Panda");
		 
		 storage.createEdge("mogli", "sherKhan",mogliWeight);
		 storage.createEdge("mogli", "baloo",mogliWeight);
		 storage.createEdge("mogli", "bagira",mogliWeight);
		 storage.createEdge("mogli", "raksha",mogliWeight);
		 storage.createEdge("simba", "mufasa",lionKingWeight);
		 storage.createEdge("simba", "scar",lionKingWeight);
		 storage.createEdge("simba", "nala",lionKingWeight);
		 storage.createEdge("simba", "pumba",lionKingWeight);
		 storage.createEdge("simba", "timon",lionKingWeight);
		 storage.createEdge("simba", "rafiki",lionKingWeight);
		 storage.createEdge("po", "shifu",kungFuPandaWeight);
		 storage.createEdge("po", "oogway",kungFuPandaWeight);
		 storage.createEdge("po", "taiLang",kungFuPandaWeight);
		 storage.createEdge("po", "crane",kungFuPandaWeight);
		 storage.createEdge("po", "mantis",kungFuPandaWeight);
		 storage.createEdge("po", "viper",kungFuPandaWeight);
		 storage.createEdge("po", "trigress",kungFuPandaWeight);
		 storage.createEdge("po", "monkey",kungFuPandaWeight);
	}
	
	private void createCharecters(AdjancencyListUnDirectedWeightedGraph<ToonCharecters, String,AnimeWeights> storage) {
		storage.createNode("mogli", new ToonCharecters("Mogli","Jungle Book","Why can't I stay in the Jungle"));
		storage.createNode("sherKhan", new ToonCharecters("Sher Khan","Jungle Book","Kill the man cub"));
		storage.createNode("baloo", new ToonCharecters("Baloo","Jungle Book","Yaaro ka Yaar"));
		storage.createNode("bagira", new ToonCharecters("Bagira","Jungle Book","Will protect mogli forever"));
		storage.createNode("raksha", new ToonCharecters("Rakhsa","Jungle Book","Mogli you are my child"));
		storage.createNode("simba", new ToonCharecters("Simba","Lion King","Baba will be a great king someday"));
		storage.createNode("mufasa", new ToonCharecters("Mufasa","Lion King","Every where light touches is ours"));
		storage.createNode("scar", new ToonCharecters("Scar","Lion King","I need the throne"));
		storage.createNode("nala", new ToonCharecters("Nala","Lion King","Haha I laugh at the face of danger"));
		storage.createNode("pumba", new ToonCharecters("Pumba","Lion King","hakuna matata"));
		storage.createNode("timon", new ToonCharecters("timon","Lion King","hakuna matata"));
		storage.createNode("rafiki", new ToonCharecters("Rafiki","Lion King","You must take your part in circle of life"));
		storage.createNode("po", new ToonCharecters("Po","Kung Fu Panda","There are no secret ingredients"));
		storage.createNode("shifu", new ToonCharecters("Shi Fu","Kung Fu Panda","I am your master"));
		storage.createNode("oogway", new ToonCharecters("Oogway","Kung Fu Panda","There are no accidents"));
		storage.createNode("taiLang", new ToonCharecters("Tai Lang","Kung Fu Panda","I need the dragon scroll"));
		storage.createNode("crane", new ToonCharecters("Crane","Kung Fu Panda","wings of justice"));
		storage.createNode("mantis", new ToonCharecters("Mantis","Kung Fu Panda","strength to hold five"));
		storage.createNode("viper", new ToonCharecters("Viper","Kung Fu Panda","hissh hiss"));
		storage.createNode("trigress", new ToonCharecters("Trigress","Kung Fu Panda","you don't belong here"));
		storage.createNode("monkey", new ToonCharecters("Monkey","Kung Fu Panda","oh ooo owoo"));
	}
	
	@Test
	void testMinimumSpaningTree() {
		AdjancencyListUnDirectedWeightedGraph<String, String, Distance> storage = new AdjancencyListUnDirectedWeightedGraph<>();
		storage.createNode("girlhostel", "Girl's Hostel");
		storage.createNode("electrical","Electrical and Electronics Block");
		storage.createNode("civil", "Civil Block");
		storage.createNode("mechanical", "Mechanical Block");
		storage.createNode("admin", "Administrative Block and Library");
		storage.createNode("boyshostel", "Boy's Hostel");
		storage.createNode("computer", "Computer Science and IT block");
		
		storage.createEdge("girlhostel", "electrical", new Distance(1));
		storage.createEdge("electrical", "mechanical", new Distance(2));
		storage.createEdge("girlhostel", "civil", new Distance(1));
		storage.createEdge("civil", "mechanical", new Distance(2));
		storage.createEdge("girlhostel", "mechanical", new Distance(4));
		storage.createEdge("mechanical", "admin", new Distance(3));
		storage.createEdge("admin", "boyshostel", new Distance(2));
		storage.createEdge("boyshostel", "computer", new Distance(1));
		storage.createEdge("boyshostel", "mechanical", new Distance(4));
		
		List<SpanningEdge<String>> paths=storage.minimumSpaningTree();
		assertAll(()->{assertEquals(7, paths.size());},
				()->{assertEquals(0,paths.get(0).getScore());},
				()->{assertEquals(null,paths.get(0).getSourceKey());},
				()->{assertEquals("computer",paths.get(0).getTargetKey());},
				()->{assertEquals(1,paths.get(1).getScore());},
				()->{assertEquals("computer",paths.get(1).getSourceKey());},
				()->{assertEquals("boyshostel",paths.get(1).getTargetKey());},
				()->{assertEquals(2,paths.get(2).getScore());},
				()->{assertEquals("boyshostel",paths.get(2).getSourceKey());},
				()->{assertEquals("admin",paths.get(2).getTargetKey());},
				()->{assertEquals(3,paths.get(3).getScore());},
				()->{assertEquals("admin",paths.get(3).getSourceKey());},
				()->{assertEquals("mechanical",paths.get(3).getTargetKey());},
				()->{assertEquals(2,paths.get(4).getScore());},
				()->{assertEquals("mechanical",paths.get(4).getSourceKey());},
				()->{assertEquals("electrical",paths.get(4).getTargetKey());},
				()->{assertEquals(1,paths.get(5).getScore());},
				()->{assertEquals("electrical",paths.get(5).getSourceKey());},
				()->{assertEquals("girlhostel",paths.get(5).getTargetKey());},
				()->{assertEquals(1,paths.get(6).getScore());},
				()->{assertEquals("girlhostel",paths.get(6).getSourceKey());},
				()->{assertEquals("civil",paths.get(6).getTargetKey());});
	}
	
	private class AnimeWeights implements Weight {

		private int weight=1;
		private String movie;		
		
		public String getMovie() {
			return movie;
		}

		@Override
		public int getWeight() {
			return weight;
		}

		public AnimeWeights(String movie) {
			super();
			this.movie = movie;
		}		
	}
	
	
	
	private class Distance implements Weight {

		private int distance=1;		

		@Override
		public int getWeight() {
			return distance;
		}

		public Distance(int distance) {
			super();
			this.distance = distance;
		}		
	}
	
}
