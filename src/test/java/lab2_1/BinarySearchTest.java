package lab2_1;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void seqLenght1_shouldFoundIndex() {
		int[] seq = { 1 };
		SearchResult sr = BinarySearch.search(1, seq);
		assertThat(sr.isFound(), is(true));
		
	}

	@Test
	public void seqLenght1_shouldNotFoundIndex() {
		int[] seq = { 1 };
		SearchResult sr = BinarySearch.search(2, seq);
		assertThat(sr.isFound(), is(false));
	}

	@Test
	public void seqLenghtLongerThan1_shouldFoundAtIndex1() {
		int[] seq = { -3, 5, 6, 7 };
		SearchResult sr = BinarySearch.search(-3, seq);
		assertThat(sr.isFound(), is(true));
		assertThat(sr.getPosition(), is(1));
	}

	@Test
	public void seqLenghtLongerThan1_shouldFoundAtLastIndex() {
		int[] seq = { -3, 5, 6, 7 };
		SearchResult sr = BinarySearch.search(7, seq);
		assertThat(sr.isFound(), is(true));
		assertThat(sr.getPosition(), is(seq.length));
	}
	
	@Test
	public void seqLenghtLongerThan1_shouldFoundAtMiddleIndex() {
		int[] seq = { -3, 4, 5, 6, 7 };
		SearchResult sr = BinarySearch.search(5, seq);
		assertThat(sr.isFound(), is(true));
		assertThat(sr.getPosition(), is((seq.length+1)/2));
	}
	
	@Test
	public void seqLenghtLongerThan1__shouldNotFoundIndex() {
		int[] seq = { -3, 4, 5, 6, 7 };
		SearchResult sr = BinarySearch.search(10, seq);
		assertThat(sr.isFound(), is(false));
	}
}
