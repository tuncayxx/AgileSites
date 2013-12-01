package wcs.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static wcs.core.Common.arg;

import org.junit.Test;

public class ModelTest {

	@Test
	public void testEmptyModel() {
		Model m = new Model();
		assertFalse(m.exists("hello"));
		assertFalse(m.exists("hello", 1));
		assertFalse(m.exists("hello", 2));
		assertNull(m.getString("hello"));
		assertNull(m.getInt("hello"));
		assertNull(m.getDate("hello"));
	}

	@Test
	public void testNewModel() {
		Model m = new Model(arg("a", "1"), arg("b", "10"), arg("b", "20"));

		assertTrue(m.exists("a"));
		assertTrue(m.exists("a", 1));
		assertFalse(m.exists("a", 0));
		assertFalse(m.exists("a", 2));

		assertEquals(m.getString("a"), "1");
		assertEquals(m.getString("a", 1), "1");
		assertEquals(m.getInt("a"), new Integer(1));
		assertEquals(m.getInt("a", 1), new Integer(1));
		assertEquals(m.getLong("a"), new Long(1));
		assertEquals(m.getLong("a", 1), new Long(1));

		assertTrue(m.exists("b"));
		assertTrue(m.exists("b", 1));
		assertTrue(m.exists("b", 2));
		assertFalse(m.exists("b", 0));
		assertFalse(m.exists("b", 3));

	}
}