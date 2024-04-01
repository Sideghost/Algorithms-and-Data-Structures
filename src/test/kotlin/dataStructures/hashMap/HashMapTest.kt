package dataStructures.hashMap

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class HashTest {

	@Test
	fun hashMap_empty() {
		val map = HashMap<Int, String>()
		assertEquals(0, map.size)
	}

	@Test
	fun hashMap_singleton() {
		val map = HashMap<Int, String>()
		map.put(1, "aed")
		assertEquals(1, map.size)
		assertEquals("aed", map[1])
		assertEquals(null, map[2])
		assertEquals(1, map.iterator().next().key)
		assertEquals("aed", map.iterator().next().value)
		map.remove(2)
		assertEquals(1, map.size)
		map.remove(1)
		assertEquals(0, map.size)
	}

	@Test
	fun hashMap_equalElements() {
		val map = HashMap<Int, String>()
		map.put(1, "aed")
		map.put(1, "aed")
		assertEquals("aed", map[1])
		map.put(1, "xpto")
		map.put(1, "xpto")
		assertEquals(1, map.size)
		assertEquals("xpto", map[1])
		assertEquals(null, map[2])
	}

	@Test
	fun hashMap_someElements() {
		val map = HashMap<Int, String>()
		for (i in 0..99) {
			map.put(i, "" + i)
		}
		assertEquals(100, map.size)
		assertEquals("10", map[10])
		var it = map.iterator()
		var list = mutableListOf<Int>()
		while (it.hasNext()) {
			list.add(it.next().key)
		}
		list.sort()
		for (i in 0..99) {
			assertEquals(i, list[i])
		}
		for (i in 0..100) {
			map.remove(2 * i + 1)
		}
		it = map.iterator()
		list = mutableListOf()
		while (it.hasNext()) {
			list.add(it.next().key)
		}

		list.sort()
		for (i in list.indices) {
			assertEquals(2 * i, list[i])
		}
	}
}