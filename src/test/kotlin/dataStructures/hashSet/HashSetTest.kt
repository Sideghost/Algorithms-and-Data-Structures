package dataStructures.hashSet

import kotlin.test.Test
import kotlin.test.assertFalse

class HashSetTest {

	@Test
	fun `create empty hashSet`() {
		val set = HashSetStructure<Int>()
		assert(set.isEmpty())
	}

	@Test
	fun `create hashSet with 10 size`() {
		val set = HashSetStructure<Int>(size = 10)
		assert(set.isEmpty())
	}

	@Test
	fun `add element to hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assert(!set.isEmpty())
	}

	@Test
	fun `add element to hashSet twice`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assertFalse(set.add(1))
		assert(set.size == 1)
	}

	@Test
	fun `remove element from hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		set.remove(1)
		assert(set.isEmpty())
	}

	@Test
	fun `remove un-existent element from hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		set.remove(2)
		assert(!set.isEmpty())
	}

	@Test
	fun `search element in hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assert(set.search(1) == 1)
	}

	@Test
	fun `search un-existent element in hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assert(set.search(2) == null)
	}

	@Test
	fun `search element in empty hashSet`() {
		val set = HashSetStructure<Int>()
		assert(set.search(1) == null)
		assert(set.isEmpty())
	}

	@Test
	fun `search element in hashSet with multiple elements`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		set.add(2)
		set.add(3)
		assert(set.search(2) == 2)
	}

	@Test
	fun `check if element is in hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assert(set.contains(1))
	}

	@Test
	fun `check if un-existent element is in hashSet`() {
		val set = HashSetStructure<Int>()
		set.add(1)
		assert(!set.contains(2))
	}

}