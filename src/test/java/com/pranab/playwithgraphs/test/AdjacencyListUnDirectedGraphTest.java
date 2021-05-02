package com.pranab.playwithgraphs.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.pranab.playwithgraphs.model.Profile;
import com.pranab.playwithgraphs.model.ToonCharecters;
import com.pranab.playwithgraphs.unweightedgraphs.undirected.AdjencyListUnDirectedGraph;

@TestMethodOrder(OrderAnnotation.class)
public class AdjacencyListUnDirectedGraphTest {

	private static AdjencyListUnDirectedGraph<Profile, String> graph = new AdjencyListUnDirectedGraph<>();
	private static Profile john;
	private static Profile jane;
	private static Profile jonny;
	private static Profile mia;
	private static Profile sin;
	private static Profile swan;
	private static Profile jack;
	private static Profile jill;
	private static Profile jade;
	private static Profile joe;
	private static Profile helen;
	private static Profile seth;
	private static Profile rock;
	private static Profile peter;
	private static Profile pane;
	private static Profile bill;
	
	@BeforeAll
	public static void generateCharecters() {
		john=new Profile("John", "Doe", "Xang", new String[] {"Java","Spring"});
		jane=new Profile("Jane", "Doe", "Dang", new String[] {"JavaScript","Angular"});
		jonny=new Profile("Jonny", "Doe", "Xing", new String[] {"Java","Spring"});
		mia=new Profile("Mia", "Doe", "Hun", new String[] {"JSP","Servlet"});
		sin=new Profile("Sin", "Doe", "Zing", new String[] {"Dotnet","C++"});
		swan=new Profile("Swan", "Doe", "Xang", new String[] {"Python","Django"});
		jack=new Profile("Jack", "Doe", "Wuhan", new String[] {"Python","ML"});
		jill=new Profile("Jill", "Doe", "Xang", new String[] {"Python","Django"});
		jade=new Profile("Jade", "Doe", "Wuhan", new String[] {"Python","ML"});
		joe=new Profile("Joe", "Doe", "Xang", new String[] {"Python","Django"});
		helen=new Profile("Helen", "Doe", "Wuhan", new String[] {"Python","ML"});
		seth=new Profile("Seth", "Doe", "Wuhan", new String[] {"Python","ML"});
		rock=new Profile("Rock", "Doe", "Ping", new String[] {"React","Django"});
		peter=new Profile("Peter", "Doe", "Wuhan", new String[] {"Node","ML"});
		pane=new Profile("Pane", "Doe", "Pong", new String[] {"C","Django"});
		bill=new Profile("Bill", "Doe", "Wuhan", new String[] {"Python","ML"});
	}
	
	@Test
	@Order(1)
	void testCreateNode() {
		graph.createNode("john", john);
		graph.createNode("jane", jane);
		graph.createNode("jonny", jonny);
		graph.createNode("mia", mia);
		graph.createNode("sin", sin);
		graph.createNode("swan", swan);
		graph.createNode("jack", jack);
		graph.createNode("jill", jill);
		graph.createNode("jade", jade);
		graph.createNode("joe", joe);
		graph.createNode("helen", helen);
		graph.createNode("seth", seth);
		graph.createNode("rock", rock);
		graph.createNode("peter", peter);
		graph.createNode("pane", pane);
		graph.createNode("bill", bill);
		assertEquals(16, graph.size());
	}
	
	
	@Test
	@Order(2)
	void testRemoveNode() {
		graph.removeNode("jane");
		assertEquals(15, graph.size());
		graph.removeNode("joe");
		assertEquals(14, graph.size());
		graph.createNode("jane", jane);
		graph.createNode("joe", joe);
	}
	
	@Test
	@Order(3)
	void testUpdateNode() {
		Profile jane2=new Profile("Janeee", "Doe", "Tang", new String[] {"Cow","Cobol"});
		graph.updateNode("jane", jane2);
		assertEquals(jane2, graph.getValue("jane"));
		graph.updateNode("jane", jane);
		assertEquals(jane, graph.getValue("jane"));
	}
	
	@Test
	@Order(4)
	void testCreateEdge() {
		graph.createEdge("john", "sin");
		graph.createEdge("john", "jane");
		graph.createEdge("john", "jonny");
		graph.createEdge("john", "swan");
		graph.createEdge("jonny", "mia");
		graph.createEdge("swan", "jack");
		graph.createEdge("swan", "jill");
		graph.createEdge("jade", "jill");
		graph.createEdge("helen", "seth");
		graph.createEdge("seth", "rock");
		graph.createEdge("jill", "peter");
		List<String> keyList=graph.getAllEdgeKeys("john");
		assertAll(()->{assertEquals(4, keyList.size());},
				  ()->{assertTrue(keyList.contains("sin"));},
				  ()->{assertTrue(keyList.contains("jonny"));},
				  ()->{assertTrue(keyList.contains("swan"));},
				  ()->{assertTrue(keyList.contains("jane"));},
				  ()->{assertEquals(1, graph.getAllEdgeKeys("jane").size());});
	}
	
	@Test
	@Order(5)
	void testCreateEdges() {
		graph.createEdges("joe", Arrays.asList("jade","sin","helen","pane","bill","peter"));
		List<String> keyList=graph.getAllEdgeKeys("joe");
		assertAll(()->{assertEquals(6, graph.getAllEdgeKeys("joe").size());},
				  ()->{assertTrue(keyList.contains("jade"));},
				  ()->{assertTrue(keyList.contains("sin"));},
				  ()->{assertTrue(keyList.contains("helen"));},
				  ()->{assertTrue(keyList.contains("peter"));},
				  ()->{assertTrue(keyList.contains("pane"));},
				  ()->{assertTrue(keyList.contains("bill"));});
	}
	
	
	@Test
	@Order(6)
	void testRemoveEdge() {
		graph.removeEdge("joe", "jade");
		List<String> keyList=graph.getAllEdgeKeys("joe");
		assertEquals(5, keyList.size());
		assertFalse(keyList.contains("jade"));
		assertFalse(graph.getAllEdgeKeys("jade").contains("joe"));
		graph.createEdge("joe", "jade");
	}

	@Test
	@Order(7)
	void testRemoveEdges() {
		List<String> edgeKeyList=Arrays.asList("sin","helen","pane");
		graph.removeEdges("joe", edgeKeyList);
		List<String> keyList=graph.getAllEdgeKeys("joe");
		assertAll(()->{assertEquals(3, keyList.size());},
				  ()->{assertFalse(keyList.contains("sin"));},
				  ()->{assertTrue(keyList.contains("bill"));},
				  ()->{assertFalse(graph.getAllEdgeKeys("helen").contains("joe"));},
				  ()->{assertFalse(graph.getAllEdgeKeys("pane").contains("joe"));});
		graph.createEdges("joe", edgeKeyList);
	}

	@Test
	@Order(8)
	void testRemoveAllEdges() {
		graph.removeAllEdges("jade");
		List<String> keyList=graph.getAllEdgeKeys("jade");
		assertAll(()->{assertEquals(0, keyList.size());},
				  ()->{assertFalse(keyList.contains("joe"));},
				  ()->{assertFalse(keyList.contains("jill"));},
				  ()->{assertFalse(graph.getAllEdgeKeys("jill").contains("jade"));});
		graph.createEdge("jade", "joe");
		graph.createEdge("jade", "jill");
	}
	
	@Test
	@Order(9)
	void testSearchLevel() {
		List<Profile> profiles=graph.searchLevel("joe", 1, false);
		assertAll(()->{assertEquals(6, profiles.size());},
				 ()->{assertTrue(profiles.contains(jade));},
				 ()->{assertTrue(profiles.contains(sin));},
				 ()->{assertTrue(profiles.contains(helen));},
				 ()->{assertTrue(profiles.contains(peter));},
				 ()->{assertTrue(profiles.contains(pane));},
				 ()->{assertTrue(profiles.contains(bill));});
	}
	
	@Test
	@Order(10)
	void testSearchDeeperLevel() {
		List<Profile> profiles=graph.searchLevel("jill", 3, false);
		assertAll(()->{assertEquals(6, profiles.size());},
				 ()->{assertTrue(profiles.contains(helen));},
				 ()->{assertTrue(profiles.contains(jonny));},
				 ()->{assertTrue(profiles.contains(bill));});		
	}
	
	@Test
	@Order(11)
	void testSearchNotExistingLevel() {
		List<Profile> profiles=graph.searchLevel("jill", 10, false);
        assertEquals(0, profiles.size());
	}
	
	@Test
	@Order(12)
	void testSearchWithInclusion() {
		List<Profile> profiles=graph.searchLevel("joe", 2, true);
		assertAll(()->{assertEquals(9, profiles.size());},
				 ()->{assertTrue(profiles.contains(helen));},
				 ()->{assertTrue(profiles.contains(john));},
				 ()->{assertTrue(profiles.contains(bill));});
	}
	
	@Test
	void testSearchClusters() {
		 AdjencyListUnDirectedGraph<ToonCharecters, String> graph = new AdjencyListUnDirectedGraph<>();
		 createCharecters(graph);
		 graph.createEdge("mogli", "sherKhan");
		 graph.createEdge("mogli", "baloo");
		 graph.createEdge("mogli", "bagira");
		 graph.createEdge("mogli", "raksha");
		 graph.createEdge("simba", "mufasa");
		 graph.createEdge("simba", "scar");
		 graph.createEdge("simba", "nala");
		 graph.createEdge("simba", "pumba");
		 graph.createEdge("simba", "timon");
		 graph.createEdge("simba", "rafiki");
		 graph.createEdge("po", "shifu");
		 graph.createEdge("po", "oogway");
		 graph.createEdge("po", "taiLang");
		 graph.createEdge("po", "crane");
		 graph.createEdge("po", "mantis");
		 graph.createEdge("po", "viper");
		 graph.createEdge("po", "trigress");
		 graph.createEdge("po", "monkey");		 
		 List<List<String>> groups=graph.findClusters();
		 assertAll(()->{assertEquals(3, groups.size());},
				   ()->{assertTrue(groups.contains(Arrays.asList("sherKhan", "baloo", "bagira", "mogli", "raksha")));},
				   ()->{assertTrue(groups.contains(Arrays.asList("mufasa", "scar", "nala", "pumba", "rafiki", "simba", "timon")));});
	}
	
	private void createCharecters(AdjencyListUnDirectedGraph<ToonCharecters, String> graph) {
		graph.createNode("mogli", new ToonCharecters("Mogli","Jungle Book","Why can't I stay in the Jungle"));
		graph.createNode("sherKhan", new ToonCharecters("Sher Khan","Jungle Book","Kill the man cub"));
		graph.createNode("baloo", new ToonCharecters("Baloo","Jungle Book","Yaaro ka Yaar"));
		graph.createNode("bagira", new ToonCharecters("Bagira","Jungle Book","Will protect mogli forever"));
		graph.createNode("raksha", new ToonCharecters("Rakhsa","Jungle Book","Mogli you are my child"));
		graph.createNode("simba", new ToonCharecters("Simba","Lion King","Baba will be a great king someday"));
		graph.createNode("mufasa", new ToonCharecters("Mufasa","Lion King","Every where light touches is ours"));
		graph.createNode("scar", new ToonCharecters("Scar","Lion King","I need the throne"));
		graph.createNode("nala", new ToonCharecters("Nala","Lion King","Haha I laugh at the face of danger"));
		graph.createNode("pumba", new ToonCharecters("Pumba","Lion King","hakuna matata"));
		graph.createNode("timon", new ToonCharecters("timon","Lion King","hakuna matata"));
		graph.createNode("rafiki", new ToonCharecters("Rafiki","Lion King","You must take your part in circle of life"));
		graph.createNode("po", new ToonCharecters("Po","Kung Fu Panda","There are no secret ingredients"));
		graph.createNode("shifu", new ToonCharecters("Shi Fu","Kung Fu Panda","I am your master"));
		graph.createNode("oogway", new ToonCharecters("Oogway","Kung Fu Panda","There are no accidents"));
		graph.createNode("taiLang", new ToonCharecters("Tai Lang","Kung Fu Panda","I need the dragon scroll"));
		graph.createNode("crane", new ToonCharecters("Crane","Kung Fu Panda","wings of justice"));
		graph.createNode("mantis", new ToonCharecters("Mantis","Kung Fu Panda","strength to hold five"));
		graph.createNode("viper", new ToonCharecters("Viper","Kung Fu Panda","hissh hiss"));
		graph.createNode("trigress", new ToonCharecters("Trigress","Kung Fu Panda","you don't belong here"));
		graph.createNode("monkey", new ToonCharecters("Monkey","Kung Fu Panda","oh ooo owoo"));
	}
}
