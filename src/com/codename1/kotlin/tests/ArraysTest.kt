package com.codename1.kotlin.tests


import com.codename1.testing.AbstractTest
import com.codename1.testing.TestUtils
import kotlin.random.Random


fun <T : Throwable> assertFailsWith(exClass: kotlin.reflect.KClass<T>, bounds: String, function: () -> Any) {
    try {
        function();

    } catch (t: Throwable) {
        if (!exClass.java.isAssignableFrom(t.javaClass)) {
            TestUtils.fail("Expected failure with "+(exClass.java).toString()+" but instead failed with "+t.javaClass.toString());
        }
        return;
    }
    TestUtils.fail("Expected to fail with type " + exClass + ", message: " + bounds)
}


fun <T> assertFailsWith(exClass: kotlin.reflect.KClass<Throwable>, function: () -> Any) {
    try {
        function();

    } catch (t: Throwable) {
        if (!exClass.java.isAssignableFrom(t.javaClass)) {
            TestUtils.fail("Expected failure with "+exClass+" but instead failed with "+t.javaClass);
        }
        return;
    }
    TestUtils.fail("Expected to fail with type " + exClass)
}

inline fun <reified T : Throwable> assertFailsWith(function: () -> Any) {
    try {
        function();
    } catch (t: Throwable) {
        if (!T::class.java.isAssignableFrom(t.javaClass)) {
            TestUtils.fail("Expected failure with "+(T::class.java).toString()+" but failed with "+t.javaClass.toString());
        }
        return
    }
    TestUtils.fail("Expected failure with ${T::class}");

}

inline fun <reified T : Throwable> assertFailsWith(message: String, function: () -> Any?) {
    try {
        function();
    } catch (t: Throwable) {
        if (!T::class.java.isAssignableFrom(t.javaClass)) {
            TestUtils.fail("Expected failure with "+T::class.java+" but failed with "+t.javaClass);
        }
        return
    }
    TestUtils.fail("Expected failure with ${T::class}. " + message);

}

fun <T> expect(expected: T, block: () -> T) {
    val actual = block()
    if (expected == null || actual == null) {
        if (!java.util.Objects.equals(expected, actual)) {
            TestUtils.fail("Expected " + expected + ", found " + actual);
        }
        return;
    }
    TestUtils.assertEqual(expected, actual)
}

fun assertTrue(block: () -> Boolean) {
    val actual = block()
    TestUtils.assertTrue(actual)
}


fun assertFalse(test: Boolean) {
    TestUtils.assertFalse(test)
}

fun assertTrue(test: Boolean, message: String) {
    TestUtils.assertTrue(test, message)
}

fun assertEquals(expected: Int, actual: Int) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Float, actual: Float) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Double, actual: Double) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Short, actual: Short) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Char, actual: Char) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Long, actual: Long) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Boolean, actual: Boolean) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Byte, actual: Byte) {
    TestUtils.assertEqual(expected, actual)
}

fun assertEquals(expected: Any?, actual: Any?) {
    TestUtils.assertEqual(expected, actual)
}

fun assertNotEquals(expected: Double, actual: Double) {
    TestUtils.assertNotEqual(expected, actual);
}

fun assertNotEquals(expected: Any?, actual: Any?) {
    TestUtils.assertNotEqual(expected, actual)
}

fun <T> assertArrayNotSameButEquals(expected: Array<out T>, actual: Array<out T>, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: IntArray, actual: IntArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: LongArray, actual: LongArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: ShortArray, actual: ShortArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: ByteArray, actual: ByteArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: DoubleArray, actual: DoubleArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: FloatArray, actual: FloatArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: CharArray, actual: CharArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

fun assertArrayNotSameButEquals(expected: BooleanArray, actual: BooleanArray, message: String = "") {
    assertTrue(expected !== actual && expected contentEquals actual, message)
}

class ArraysTest : AbstractTest() {
    data class Value(val value: Int) {
        override fun hashCode(): Int = value
    }

    override fun runTest(): Boolean {
        orEmptyNotNull()
        orEmptyNull()
        emptyArrayLastIndex()
        arrayLastIndex()
        byteArray()
        byteArrayInit()
        shortArray()
        shortArrayInit()
        intArray()
        intArrayInit()
        longArray()
        longArrayInit()
        floatArray()
        floatArrayInit()
        doubleArray()
        doubleArrayInit()
        charArray()
        charArrayInit()
        booleanArray()
        booleanArrayInit()
        contentEquals()
        contentDeepEquals()
        contentToString()
        contentDeepToString()
        contentDeepToStringNoRecursion()
        contentHashCode()
        contentDeepHashCode()
        joinToString()
        min()
        minInPrimitiveArrays()
        max()
        maxInPrimitiveArrays()
        minWith()
        minWithInPrimitiveArrays()
        maxWith()
        maxWithInPrimitiveArrays()
        minBy()
        minByInPrimitiveArrays()
        maxBy()
        maxByInPrimitiveArrays()
        minIndex()
        maxIndex()
        minByEvaluateOnce()
        maxByEvaluateOnce()
        sum()
        sumInPrimitiveArrays()
        average()
        indexOfInPrimitiveArrays()
        indexOf()
        lastIndexOf()
        isEmpty()
        isNotEmpty()
        plusInference()
        plus()
        plusVararg()
        plusAssign()
        first()
        last()
        //random()
        //randomOrNull()
        contains()
        slice()
        sliceArray()
        iterators()
        asIterable()
        asList()
        toPrimitiveArray()
        toTypedArray()
        copyOf()
        copyAndResize()
        copyOfRange()
        copyRangeInto()
        copyRangeIntoVarianceTest()
        reduceIndexed()
        reduceRightIndexed()
        reduce()
        //reduceOrNull()
        reduceRight()
        //reduceRightOrNull()
        //scan()
        //scanIndexed()
        //scanReduce()
        //scanReduceIndexed()
        reverseInPlace()
        reversed()
        reversedArray()
        drop()
        dropLast()
        dropWhile()
        dropLastWhile()
        take()
        takeLast()
        takeWhile()
        takeLastWhile()
        filter()
        filterIndexed()
        filterNot()
        filterNotNull()
        map()
        mapIndexed()
        mapNotNull()
        mapIndexedNotNull()
        flattenArray()
        asListPrimitives()
        asListObjects()
        sort()
        sortedTests()
        sortStable()
        sortByInPlace()
        sortedBy()
        sortByStable()
        sortedNullableBy()
        sortedWith()
        elementAt()
        fill()
        return true
    }

    fun orEmptyNull() {
        val x: Array<String>? = null
        val y: Array<out String>? = null
        val xArray = x.orEmpty()
        val yArray = y.orEmpty()
        expect(0) { xArray.size }
        expect(0) { yArray.size }
    }

    fun orEmptyNotNull() {
        val x: Array<String>? = arrayOf("1", "2")
        val xArray = x.orEmpty()
        expect(2) { xArray.size }
        expect("1") { xArray[0] }
        expect("2") { xArray[1] }
    }

    fun emptyArrayLastIndex() {
        val arr1 = IntArray(0)
        assertEquals(-1, arr1.lastIndex)

        val arr2 = emptyArray<String>()
        assertEquals(-1, arr2.lastIndex)
    }

    fun arrayLastIndex() {
        val arr1 = intArrayOf(0, 1, 2, 3, 4)
        assertEquals(4, arr1.lastIndex)
        assertEquals(4, arr1[arr1.lastIndex])

        val arr2 = Array<String>(5, { "$it" })
        assertEquals(4, arr2.lastIndex)
        assertEquals("4", arr2[arr2.lastIndex])
    }

    fun byteArray() {
        val arr = ByteArray(2)

        val expected: Byte = 0
        assertEquals(arr.size, 2)
        assertEquals(expected, arr[0])
        assertEquals(expected, arr[1])
    }

    fun byteArrayInit() {
        val arr = ByteArray(2) { it.toByte() }

        assertEquals(2, arr.size)
        assertEquals(0.toByte(), arr[0])
        assertEquals(1.toByte(), arr[1])
    }

    fun shortArray() {
        val arr = ShortArray(2)

        val expected: Short = 0
        assertEquals(arr.size, 2)
        assertEquals(expected, arr[0])
        assertEquals(expected, arr[1])
    }

    fun shortArrayInit() {
        val arr = ShortArray(2) { it.toShort() }

        assertEquals(2, arr.size)
        assertEquals(0.toShort(), arr[0])
        assertEquals(1.toShort(), arr[1])
    }

    fun intArray() {
        val arr = IntArray(2)

        assertEquals(arr.size, 2)
        assertEquals(0, arr[0])
        assertEquals(0, arr[1])
    }

    fun intArrayInit() {
        val arr = IntArray(2) { it.toInt() }

        assertEquals(2, arr.size)
        assertEquals(0.toInt(), arr[0])
        assertEquals(1.toInt(), arr[1])
    }

    fun longArray() {
        val arr = LongArray(2)

        val expected: Long = 0
        assertEquals(arr.size, 2)
        assertEquals(expected, arr[0])
        assertEquals(expected, arr[1])
    }

    fun longArrayInit() {
        val arr = LongArray(2) { it.toLong() }

        assertEquals(2, arr.size)
        assertEquals(0.toLong(), arr[0])
        assertEquals(1.toLong(), arr[1])
    }

    fun floatArray() {
        val arr = FloatArray(2)

        val expected: Float = 0.0F
        assertEquals(arr.size, 2)
        assertEquals(expected, arr[0])
        assertEquals(expected, arr[1])
    }

    fun floatArrayInit() {
        val arr = FloatArray(2) { it.toFloat() }

        assertEquals(2, arr.size)
        assertEquals(0.toFloat(), arr[0])
        assertEquals(1.toFloat(), arr[1])
    }

    fun doubleArray() {
        val arr = DoubleArray(2)

        assertEquals(arr.size, 2)
        assertEquals(0.0, arr[0])
        assertEquals(0.0, arr[1])
    }

    fun doubleArrayInit() {
        val arr = DoubleArray(2) { it.toDouble() }

        assertEquals(2, arr.size)
        assertEquals(0.toDouble(), arr[0])
        assertEquals(1.toDouble(), arr[1])
    }

    fun charArray() {
        val arr = CharArray(2)

        val expected: Char = '\u0000'
        assertEquals(arr.size, 2)
        assertEquals(expected, arr[0])
        assertEquals(expected, arr[1])
    }

    fun charArrayInit() {
        val arr = CharArray(2) { 'a' + it }

        assertEquals(2, arr.size)
        assertEquals('a', arr[0])
        assertEquals('b', arr[1])
    }

    fun booleanArray() {
        val arr = BooleanArray(2)
        assertEquals(arr.size, 2)
        assertEquals(false, arr[0])
        assertEquals(false, arr[1])
    }

    fun booleanArrayInit() {
        val arr = BooleanArray(2) { it % 2 == 0 }

        assertEquals(2, arr.size)
        assertEquals(true, arr[0])
        assertEquals(false, arr[1])
    }

    fun contentEquals() {
        fun <T> checkArray(array: T, copy: T.() -> T, toList: T.() -> List<*>, check: (T, T) -> Boolean, modify: T.() -> Unit) {
            val list = toList(array)
            val array2 = copy(array)
            val list2 = toList(array2)
            assertEquals(list, list2)
            assertNotSame(array, array2)
            assertTrue(check(array, array2), "Copy of array should have the same content: original $list, modified $list2")

            modify(array2)
            val list2m = toList(array2)
            assertNotEquals(list, list2m)
            assertFalse(check(array, array2), "Modified array should be different: original $list, modified $list2m")
        }

        checkArray(arrayOf("a", 1, null), { copyOf() }, { toList() }, { a1, a2 -> a1 contentEquals a2 }, { reverse() })
        checkArray(byteArrayOf(1, 2, 3), { copyOf() }, { toList() }, { a1, a2 -> a1 contentEquals a2 }, { reverse() })
        checkArray(intArrayOf(1, 2, 3), { copyOf() }, { toList() }, { a1, a2 -> a1 contentEquals a2 }, { reverse() })
        checkArray(longArrayOf(1, 2, 3), { copyOf() }, { toList() }, { a1, a2 -> a1 contentEquals a2 }, { reverse() })
        checkArray(doubleArrayOf(Double.NaN, -0.0, 0.0, Double.POSITIVE_INFINITY, 1.0),
                { copyOf() }, { toList() }, { a1, a2 -> a1 contentEquals a2 }, { this[1] = 0.0 })
    }

    fun contentDeepEquals() {
        val arr1 = arrayOf("a", 1, intArrayOf(2))
        val arr2 = arrayOf("a", 1, intArrayOf(2))
        val arr3 = arrayOf("a", 1, uintArrayOf(2u))
        val arr4 = arrayOf("a", 1, uintArrayOf(2u))
        assertFalse(arr1 contentEquals arr2)
        assertTrue(arr1 contentDeepEquals arr2)

        assertFalse(arr1 contentDeepEquals arr3)
        assertTrue(arr3 contentDeepEquals arr4)

        arr2[2] = arr1
        assertFalse(arr1 contentDeepEquals arr2)

        arr4[2] = arr3
        assertFalse(arr3 contentDeepEquals arr4)

        val arr5 = arrayOf(doubleArrayOf(-0.0, Double.NaN))
        val arr6 = arrayOf(doubleArrayOf(0.0, Double.NaN))
        assertFalse(arr5 contentDeepEquals arr6)

        arr5[0][0] = 0.0
        assertTrue(arr5 contentDeepEquals arr6)
    }

    fun contentToString() {
        arrayOf("a", 1, null).let { arr -> assertEquals(arr.asList().toString(), arr.contentToString()) }
        charArrayOf('a', 'b', 'd').let { arr -> assertEquals(arr.asList().toString(), arr.contentToString()) }
        intArrayOf(1, 10, 42).let { arr -> assertEquals(arr.asList().toString(), arr.contentToString()) }
        longArrayOf(1L, 5L, Long.MAX_VALUE).let { arr -> assertEquals(arr.asList().toString(), arr.contentToString()) }
        doubleArrayOf(0.0, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN).let { arr -> assertEquals(arr.asList().toString(), arr.contentToString()) }
    }

    fun contentDeepToString() {
        val arr = arrayOf(
                "aa", 1, null, arrayOf(arrayOf("foo")), charArrayOf('d'), booleanArrayOf(false),
                intArrayOf(-1), longArrayOf(-1), shortArrayOf(-1), byteArrayOf(-1),
                uintArrayOf(UInt.MAX_VALUE), ulongArrayOf(ULong.MAX_VALUE), ushortArrayOf(UShort.MAX_VALUE), ubyteArrayOf(UByte.MAX_VALUE),
                doubleArrayOf(3.14), floatArrayOf(1.25f)
        )
        assertEquals("[aa, 1, null, [[foo]], [d], [false], [-1], [-1], [-1], [-1], [4294967295], [18446744073709551615], [65535], [255], [3.14], [1.25]]", arr.contentDeepToString())
    }

    fun contentDeepToStringNoRecursion() {
        // a[b[a, b]]
        val b = arrayOfNulls<Any>(2)
        val a = arrayOf(b)
        b[0] = a
        b[1] = b
        a.toString()
        assertTrue(true, "toString does not cycle")
        a.contentToString()
        assertTrue(true, "contentToString does not cycle")
        val result = a.contentDeepToString()
        assertEquals("[[[...], [...]]]", result)
    }

    fun contentHashCode() {
        val arr = arrayOf("a", 1, null, Value(5))
        assertEquals(listOf(*arr).hashCode(), arr.contentHashCode())
        assertEquals((1 * 31 + 2) * 31 + 3, arrayOf(Value(2), Value(3)).contentHashCode())

        longArrayOf(1L, Long.MAX_VALUE, Long.MIN_VALUE).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
        intArrayOf(1, Int.MAX_VALUE, Int.MIN_VALUE).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
        byteArrayOf(1, Byte.MAX_VALUE, Byte.MIN_VALUE).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
        charArrayOf('a', Char.MAX_VALUE, Char.MIN_VALUE).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
        doubleArrayOf(1.0, -0.0, 0.0, Double.NaN, Double.POSITIVE_INFINITY).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
        floatArrayOf(1.0f, -0.0f, 0.0f, Float.NaN, Float.POSITIVE_INFINITY).let { assertEquals(it.toList().hashCode(), it.contentHashCode()) }
    }

    fun contentDeepHashCode() {
        val arr = arrayOf(null, Value(2), arrayOf(Value(3)))
        assertEquals(((1 * 31 + 0) * 31 + 2) * 31 + (1 * 31 + 3), arr.contentDeepHashCode())

        val intArray2 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val intList2 = listOf(listOf(1, 2), listOf(3, 4))

        assertEquals(intList2.hashCode(), intArray2.contentDeepHashCode())

        val doubleArray2 = arrayOf(doubleArrayOf(1.0, Double.NaN), doubleArrayOf(-0.0, 0.0))
        val doubleList2 = listOf(listOf(1.0, Double.NaN), listOf(-0.0, 0.0))

        assertEquals(doubleList2.hashCode(), doubleArray2.contentDeepHashCode())

        val uintArray2 = arrayOf(uintArrayOf(1u, 2u), uintArrayOf(3u, 4u))
        val uintList2 = listOf(listOf(1u, 2u), listOf(3u, 4u))

        assertEquals(uintList2.hashCode(), uintArray2.contentDeepHashCode())
    }


    public fun joinToString() {
        val text = arrayOf("foo", "bar").joinToString("-", "<", ">")
        assertEquals("<foo-bar>", text)

        val text2 = arrayOf('a', "b", StringBuilder("c"), null, "d", 'e', 'f').joinToString(limit = 4, truncated = "*")
        assertEquals("a, b, c, null, *", text2)

        val text3 = intArrayOf(1, 2, 5, 8).joinToString("+", "[", "]")
        assertEquals("[1+2+5+8]", text3)

        val text4 = charArrayOf('f', 'o', 'o').joinToString()
        assertEquals("f, o, o", text4)
    }


    fun min() {
        expect(null, { arrayOf<Int>().min() })
        expect(1, { arrayOf(1).min() })
        expect(2, { arrayOf(2, 3).min() })
        expect(2000000000000, { arrayOf(3000000000000, 2000000000000).min() })
        expect('a', { arrayOf('a', 'b').min() })
        expect("a", { arrayOf("a", "b").min() })
    }

    fun minInPrimitiveArrays() {
        expect(null, { intArrayOf().min() })
        expect(1, { intArrayOf(1).min() })
        expect(2, { intArrayOf(2, 3).min() })
        expect(2000000000000, { longArrayOf(3000000000000, 2000000000000).min() })
        expect(1, { byteArrayOf(1, 3, 2).min() })
        expect(2, { shortArrayOf(3, 2).min() })
        expect(2.0F, { floatArrayOf(3.0F, 2.0F).min() })
        expect(2.0, { doubleArrayOf(2.0, 3.0).min() })
        expect('a', { charArrayOf('a', 'b').min() })
    }

    fun max() {
        expect(null, { arrayOf<Int>().max() })
        expect(1, { arrayOf(1).max() })
        expect(3, { arrayOf(2, 3).max() })
        expect(3000000000000, { arrayOf(3000000000000, 2000000000000).max() })
        expect('b', { arrayOf('a', 'b').max() })
        expect("b", { arrayOf("a", "b").max() })
    }

    fun maxInPrimitiveArrays() {
        expect(null, { intArrayOf().max() })
        expect(1, { intArrayOf(1).max() })
        expect(3, { intArrayOf(2, 3).max() })
        expect(3000000000000, { longArrayOf(3000000000000, 2000000000000).max() })
        expect(3, { byteArrayOf(1, 3, 2).max() })
        expect(3, { shortArrayOf(3, 2).max() })
        expect(3.0F, { floatArrayOf(3.0F, 2.0F).max() })
        expect(3.0, { doubleArrayOf(2.0, 3.0).max() })
        expect('b', { charArrayOf('a', 'b').max() })
    }

    fun minWith() {
        assertEquals(null, arrayOf<Int>().minWith(naturalOrder()))
        assertEquals("a", arrayOf("a", "B").minWith(String.CASE_INSENSITIVE_ORDER))
    }

    fun minWithInPrimitiveArrays() {
        expect(null, { intArrayOf().minWith(naturalOrder()) })
        expect(1, { intArrayOf(1).minWith(naturalOrder()) })
        expect(4, { intArrayOf(2, 3, 4).minWith(compareBy { it % 4 }) })
    }

    fun maxWith() {
        assertEquals(null, arrayOf<Int>().maxWith(naturalOrder()))
        assertEquals("B", arrayOf("a", "B").maxWith(String.CASE_INSENSITIVE_ORDER))
    }

    fun maxWithInPrimitiveArrays() {
        expect(null, { intArrayOf().maxWith(naturalOrder()) })
        expect(1, { intArrayOf(1).maxWith(naturalOrder()) })
        expect(-4, { intArrayOf(2, 3, -4).maxWith(compareBy { it * it }) })
    }

    fun minBy() {
        expect(null, { arrayOf<Int>().minBy { it } })
        expect(1, { arrayOf(1).minBy { it } })
        expect(3, { arrayOf(2, 3).minBy { -it } })
        expect('a', { arrayOf('a', 'b').minBy { "x$it" } })
        expect("b", { arrayOf("b", "abc").minBy { it.length } })
    }

    fun minByInPrimitiveArrays() {
        expect(null, { intArrayOf().minBy { it } })
        expect(1, { intArrayOf(1).minBy { it } })
        expect(3, { intArrayOf(2, 3).minBy { -it } })
        expect(2000000000000, { longArrayOf(3000000000000, 2000000000000).minBy { it + 1 } })
        expect(1, { byteArrayOf(1, 3, 2).minBy { it * it } })
        expect(3, { shortArrayOf(3, 2).minBy { "a" } })
        expect(2.0F, { floatArrayOf(3.0F, 2.0F).minBy { it.toString() } })
        expect(2.0, { doubleArrayOf(2.0, 3.0).minBy { it * it } })
    }

    fun maxBy() {
        expect(null, { arrayOf<Int>().maxBy { it } })
        expect(1, { arrayOf(1).maxBy { it } })
        expect(2, { arrayOf(2, 3).maxBy { -it } })
        expect('b', { arrayOf('a', 'b').maxBy { "x$it" } })
        expect("abc", { arrayOf("b", "abc").maxBy { it.length } })
    }

    fun maxByInPrimitiveArrays() {
        expect(null, { intArrayOf().maxBy { it } })
        expect(1, { intArrayOf(1).maxBy { it } })
        expect(2, { intArrayOf(2, 3).maxBy { -it } })
        expect(3000000000000, { longArrayOf(3000000000000, 2000000000000).maxBy { it + 1 } })
        expect(3, { byteArrayOf(1, 3, 2).maxBy { it * it } })
        expect(3, { shortArrayOf(3, 2).maxBy { "a" } })
        expect(3.0F, { floatArrayOf(3.0F, 2.0F).maxBy { it.toString() } })
        expect(3.0, { doubleArrayOf(2.0, 3.0).maxBy { it * it } })
    }

    fun minIndex() {
        val a = intArrayOf(1, 7, 9, -42, 54, 93)
        expect(3, { a.indices.minBy { a[it] } })
    }

    fun maxIndex() {
        val a = intArrayOf(1, 7, 9, 239, 54, 93)
        expect(3, { a.indices.maxBy { a[it] } })
    }

    fun minByEvaluateOnce() {
        var c = 0
        expect(1, { arrayOf(5, 4, 3, 2, 1).minBy { c++; it * it } })
        assertEquals(5, c)
    }

    fun maxByEvaluateOnce() {
        var c = 0
        expect(5, { arrayOf(5, 4, 3, 2, 1).maxBy { c++; it * it } })
        assertEquals(5, c)
    }

    fun sum() {
        expect(0) { arrayOf<Int>().sum() }
        expect(14) { arrayOf(2, 3, 9).sum() }
        expect(3.0) { arrayOf(1.0, 2.0).sum() }
        expect(200) { arrayOf<Byte>(100, 100).sum() }
        expect(50000) { arrayOf<Short>(20000, 30000).sum() }
        expect(3000000000000) { arrayOf<Long>(1000000000000, 2000000000000).sum() }
        expect(3.0F) { arrayOf<Float>(1.0F, 2.0F).sum() }
    }

    fun sumInPrimitiveArrays() {
        expect(0) { intArrayOf().sum() }
        expect(14) { intArrayOf(2, 3, 9).sum() }
        expect(3.0) { doubleArrayOf(1.0, 2.0).sum() }
        expect(200) { byteArrayOf(100, 100).sum() }
        expect(50000) { shortArrayOf(20000, 30000).sum() }
        expect(3000000000000) { longArrayOf(1000000000000, 2000000000000).sum() }
        expect(3.0F) { floatArrayOf(1.0F, 2.0F).sum() }
    }

    fun average() {
        assertTrue() { arrayOf<Int>().average().isNaN() }
        expect(3.8) { arrayOf(1, 2, 5, 8, 3).average() }
        expect(2.1) { arrayOf(1.6, 2.6, 3.6, 0.6).average() }
        expect(100.0) { arrayOf<Byte>(100, 100, 100, 100, 100, 100).average() }
        expect(0) { arrayOf<Short>(1, -1, 2, -2, 3, -3).average().toShort() }
        // TODO: Property based tests
        // for each arr with size 1 arr.average() == arr[0]
        // for each arr with size > 0  arr.average() = arr.sum().toDouble() / arr.size()
    }

    fun indexOfInPrimitiveArrays() {
        expect(-1) { byteArrayOf(1, 2, 3).indexOf(0) }
        expect(0) { byteArrayOf(1, 2, 3).indexOf(1) }
        expect(1) { byteArrayOf(1, 2, 3).indexOf(2) }
        expect(2) { byteArrayOf(1, 2, 3).indexOf(3) }

        expect(-1) { shortArrayOf(1, 2, 3).indexOf(0) }
        expect(0) { shortArrayOf(1, 2, 3).indexOf(1) }
        expect(1) { shortArrayOf(1, 2, 3).indexOf(2) }
        expect(2) { shortArrayOf(1, 2, 3).indexOf(3) }

        expect(-1) { intArrayOf(1, 2, 3).indexOf(0) }
        expect(0) { intArrayOf(1, 2, 3).indexOf(1) }
        expect(1) { intArrayOf(1, 2, 3).indexOf(2) }
        expect(2) { intArrayOf(1, 2, 3).indexOf(3) }

        expect(-1) { longArrayOf(1, 2, 3).indexOf(0) }
        expect(0) { longArrayOf(1, 2, 3).indexOf(1) }
        expect(1) { longArrayOf(1, 2, 3).indexOf(2) }
        expect(2) { longArrayOf(1, 2, 3).indexOf(3) }

        expect(-1) { floatArrayOf(1.0f, 2.0f, 3.0f).indexOf(0f) }
        expect(0) { floatArrayOf(1.0f, 2.0f, 3.0f).indexOf(1.0f) }
        expect(1) { floatArrayOf(1.0f, 2.0f, 3.0f).indexOf(2.0f) }
        expect(2) { floatArrayOf(1.0f, 2.0f, 3.0f).indexOf(3.0f) }

        expect(-1) { doubleArrayOf(1.0, 2.0, 3.0).indexOf(0.0) }
        expect(0) { doubleArrayOf(1.0, 2.0, 3.0).indexOf(1.0) }
        expect(1) { doubleArrayOf(1.0, 2.0, 3.0).indexOf(2.0) }
        expect(2) { doubleArrayOf(1.0, 2.0, 3.0).indexOf(3.0) }

        expect(-1) { charArrayOf('a', 'b', 'c').indexOf('z') }
        expect(0) { charArrayOf('a', 'b', 'c').indexOf('a') }
        expect(1) { charArrayOf('a', 'b', 'c').indexOf('b') }
        expect(2) { charArrayOf('a', 'b', 'c').indexOf('c') }

        expect(0) { booleanArrayOf(true, false).indexOf(true) }
        expect(1) { booleanArrayOf(true, false).indexOf(false) }
        expect(-1) { booleanArrayOf(true).indexOf(false) }
    }

    fun indexOf() {
        expect(-1) { arrayOf("cat", "dog", "bird").indexOf("mouse") }
        expect(0) { arrayOf("cat", "dog", "bird").indexOf("cat") }
        expect(1) { arrayOf("cat", "dog", "bird").indexOf("dog") }
        expect(2) { arrayOf("cat", "dog", "bird").indexOf("bird") }
        expect(0) { arrayOf(null, "dog", null).indexOf(null as String?) }

        expect(-1) { arrayOf("cat", "dog", "bird").indexOfFirst { it.contains("p") } }
        expect(0) { arrayOf("cat", "dog", "bird").indexOfFirst { it.startsWith('c') } }
        expect(1) { arrayOf("cat", "dog", "bird").indexOfFirst { it.startsWith('d') } }
        expect(2) { arrayOf("cat", "dog", "bird").indexOfFirst { it.endsWith('d') } }

        expect(-1) { sequenceOf("cat", "dog", "bird").indexOfFirst { it.contains("p") } }
        expect(0) { sequenceOf("cat", "dog", "bird").indexOfFirst { it.startsWith('c') } }
        expect(1) { sequenceOf("cat", "dog", "bird").indexOfFirst { it.startsWith('d') } }
        expect(2) { sequenceOf("cat", "dog", "bird").indexOfFirst { it.endsWith('d') } }
    }

    fun lastIndexOf() {
        expect(-1) { arrayOf("cat", "dog", "bird").lastIndexOf("mouse") }
        expect(0) { arrayOf("cat", "dog", "bird").lastIndexOf("cat") }
        expect(1) { arrayOf("cat", "dog", "bird").lastIndexOf("dog") }
        expect(2) { arrayOf(null, "dog", null).lastIndexOf(null as String?) }
        expect(3) { arrayOf("cat", "dog", "bird", "dog").lastIndexOf("dog") }

        expect(-1) { arrayOf("cat", "dog", "bird").indexOfLast { it.contains("p") } }
        expect(0) { arrayOf("cat", "dog", "bird").indexOfLast { it.startsWith('c') } }
        expect(2) { arrayOf("cat", "dog", "cap", "bird").indexOfLast { it.startsWith('c') } }
        expect(2) { arrayOf("cat", "dog", "bird").indexOfLast { it.endsWith('d') } }
        expect(3) { arrayOf("cat", "dog", "bird", "red").indexOfLast { it.endsWith('d') } }

        expect(-1) { sequenceOf("cat", "dog", "bird").indexOfLast { it.contains("p") } }
        expect(0) { sequenceOf("cat", "dog", "bird").indexOfLast { it.startsWith('c') } }
        expect(2) { sequenceOf("cat", "dog", "cap", "bird").indexOfLast { it.startsWith('c') } }
        expect(2) { sequenceOf("cat", "dog", "bird").indexOfLast { it.endsWith('d') } }
        expect(3) { sequenceOf("cat", "dog", "bird", "red").indexOfLast { it.endsWith('d') } }
    }

    fun isEmpty() {
        assertTrue(emptyArray<String>().isEmpty())
        assertFalse(arrayOf("").isEmpty())
        assertTrue(intArrayOf().isEmpty())
        assertFalse(intArrayOf(1).isEmpty())
        assertTrue(byteArrayOf().isEmpty())
        assertFalse(byteArrayOf(1).isEmpty())
        assertTrue(shortArrayOf().isEmpty())
        assertFalse(shortArrayOf(1).isEmpty())
        assertTrue(longArrayOf().isEmpty())
        assertFalse(longArrayOf(1).isEmpty())
        assertTrue(charArrayOf().isEmpty())
        assertFalse(charArrayOf('a').isEmpty())
        assertTrue(floatArrayOf().isEmpty())
        assertFalse(floatArrayOf(0.1F).isEmpty())
        assertTrue(doubleArrayOf().isEmpty())
        assertFalse(doubleArrayOf(0.1).isEmpty())
        assertTrue(booleanArrayOf().isEmpty())
        assertFalse(booleanArrayOf(false).isEmpty())
    }

    fun isNotEmpty() {
        assertFalse(intArrayOf().isNotEmpty())
        assertTrue(intArrayOf(1).isNotEmpty())
    }

    fun plusInference() {
        val arrayOfArrays: Array<Array<out Any>> = arrayOf(arrayOf<Any>("s") as Array<out Any>)
        val elementArray = arrayOf<Any>("a") as Array<out Any>
        val arrayPlusElement: Array<Array<out Any>> = arrayOfArrays.plusElement(elementArray)
        assertEquals("a", arrayPlusElement[1][0])
        // ambiguity
        // val arrayPlusArray: Array<Array<out Any>> = arrayOfArrays + arrayOfArrays

        val arrayOfStringArrays = arrayOf(arrayOf("s"))
        val arrayPlusArray = arrayOfStringArrays + arrayOfStringArrays
        assertEquals("s", arrayPlusArray[1][0])
    }


    fun plus() {
        assertEquals(listOf("1", "2", "3", "4"), listOf("1", "2") + arrayOf("3", "4"))
        assertArrayNotSameButEquals(arrayOf("1", "2", "3"), arrayOf("1", "2") + "3")
        assertArrayNotSameButEquals(arrayOf("1", "2", "3", "4"), arrayOf("1", "2") + arrayOf("3", "4"))
        assertArrayNotSameButEquals(arrayOf("1", "2", "3", "4"), arrayOf("1", "2") + listOf("3", "4"))
        assertArrayNotSameButEquals(intArrayOf(1, 2, 3), intArrayOf(1, 2) + 3)
        assertArrayNotSameButEquals(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2) + listOf(3, 4))
        assertArrayNotSameButEquals(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2) + intArrayOf(3, 4))
    }

    fun plusVararg() {
        fun stringOnePlus(vararg a: String) = arrayOf("1") + a
        fun longOnePlus(vararg a: Long) = longArrayOf(1) + a
        fun intOnePlus(vararg a: Int) = intArrayOf(1) + a

        assertArrayNotSameButEquals(arrayOf("1", "2"), stringOnePlus("2"), "Array.plus")
        assertArrayNotSameButEquals(intArrayOf(1, 2), intOnePlus(2), "IntArray.plus")
        assertArrayNotSameButEquals(longArrayOf(1, 2), longOnePlus(2), "LongArray.plus")
    }

    fun plusAssign() {
        // lets use a mutable variable
        var result = arrayOf("a")
        result += "foo"
        result += listOf("beer")
        result += arrayOf("cheese", "wine")
        assertArrayNotSameButEquals(arrayOf("a", "foo", "beer", "cheese", "wine"), result)
    }

    fun first() {
        expect(1) { arrayOf(1, 2, 3).first() }
        expect(2) { arrayOf(1, 2, 3).first { it % 2 == 0 } }
    }

    fun last() {
        expect(3) { arrayOf(1, 2, 3).last() }
        expect(2) { arrayOf(1, 2, 3).last { it % 2 == 0 } }
    }

/*
fun random() {
    Array(100) { it }.let { array ->
        val tosses = List(10) { array.random() }
        assertTrue(tosses.distinct().size > 1, "Should be some distinct elements in $tosses")

        val seed = Random.nextInt()
        val random1 = Random(seed)
        val random2 = Random(seed)

        val tosses1 = List(10) { array.random(random1) }
        val tosses2 = List(10) { array.random(random2) }

        assertEquals(tosses1, tosses2)
    }

    arrayOf("x").let { singletonArray ->
        val tosses = List(10) { singletonArray.random() }
        assertEquals(singletonArray.toList(), tosses.distinct())
    }

    assertFailsWith<NoSuchElementException> { emptyArray<Any>().random() }
}
*/


    /*
    fun randomOrNull() {
    Array(100) { it }.let { array ->
        val tosses = List(10) { array.randomOrNull() }
        assertTrue(tosses.distinct().size > 1, "Should be some distinct elements in $tosses")

        val seed = Random.nextInt()
        val random1 = Random(seed)
        val random2 = Random(seed)

        val tosses1 = List(10) { array.randomOrNull(random1) }
        val tosses2 = List(10) { array.randomOrNull(random2) }

        assertEquals(tosses1, tosses2)
    }

    arrayOf("x").let { singletonArray ->
        val tosses = List(10) { singletonArray.randomOrNull() }
        assertEquals(singletonArray.toList(), tosses.distinct())
    }

    assertNull(emptyArray<Any>().randomOrNull())
}
*/

    fun contains() {
        assertTrue(arrayOf("1", "2", "3", "4").contains("2"))
        assertTrue("3" in arrayOf("1", "2", "3", "4"))
        assertTrue("0" !in arrayOf("1", "2", "3", "4"))
    }

    fun slice() {
        val iter: Iterable<Int> = listOf(3, 1, 2)

        assertEquals(listOf("B"), arrayOf("A", "B", "C").slice(1..1))
        assertEquals(listOf('E', 'B', 'C'), arrayOf('A', 'B', 'C', 'E').slice(iter))

        assertEquals(listOf<Int>(), arrayOf<Int>().slice(5..4))
        assertEquals(listOf<Int>(), intArrayOf(1, 2, 3).slice(5..1))
        assertEquals(listOf(2, 3, 9), intArrayOf(2, 3, 9, 2, 3, 9).slice(iter))
        assertEquals(listOf(2.0, 3.0), doubleArrayOf(2.0, 3.0, 9.0).slice(0..1))
        assertEquals(listOf(2f, 3f), floatArrayOf(2f, 3f, 9f).slice(0..1))
        assertEquals(listOf<Byte>(127, 100), byteArrayOf(50, 100, 127).slice(2 downTo 1))
        assertEquals(listOf<Short>(200, 100), shortArrayOf(50, 100, 200).slice(2 downTo 1))
        assertEquals(listOf(100L, 200L, 30L), longArrayOf(50L, 100L, 200L, 30L).slice(1..3))
        assertEquals(listOf(true, false, true), booleanArrayOf(true, false, true, true).slice(iter))

        for (range in listOf(-1 until 0, 0 until 2, 2..2)) {
            val bounds = "range: $range"
            val exClass = IndexOutOfBoundsException::class
            assertFailsWith(exClass, bounds) { arrayOf("x").slice(range) }
            assertFailsWith(exClass, bounds) { intArrayOf(1).slice(range) }
            assertFailsWith(exClass, bounds) { longArrayOf(1L).slice(range) }
            assertFailsWith(exClass, bounds) { charArrayOf('C').slice(range) }
        }
    }


    fun sliceArray() {
        val coll: Collection<Int> = listOf(3, 1, 2)

        assertArrayNotSameButEquals(arrayOf("B"), arrayOf("A", "B", "C").sliceArray(1..1))
        assertArrayNotSameButEquals(arrayOf("B"), (arrayOf("A", "B", "C") as Array<out String>).sliceArray(1..1))
        assertArrayNotSameButEquals(arrayOf('E', 'B', 'C'), arrayOf('A', 'B', 'C', 'E').sliceArray(coll))


        assertArrayNotSameButEquals(arrayOf<Int>(), arrayOf<Int>().sliceArray(5..4))
        assertArrayNotSameButEquals(intArrayOf(), intArrayOf(1, 2, 3).sliceArray(5..1))
        assertArrayNotSameButEquals(intArrayOf(2, 3, 9), intArrayOf(2, 3, 9, 2, 3, 9).sliceArray(coll))
        assertArrayNotSameButEquals(doubleArrayOf(2.0, 3.0), doubleArrayOf(2.0, 3.0, 9.0).sliceArray(0..1))
        assertArrayNotSameButEquals(floatArrayOf(2f, 3f), floatArrayOf(2f, 3f, 9f).sliceArray(0..1))
//        assertArrayNotSameButEquals(byteArrayOf(127, 100), byteArrayOf(50, 100, 127).sliceArray(2 downTo 1))
//        assertArrayNotSameButEquals(shortArrayOf(200, 100), shortArrayOf(50, 100, 200).sliceArray(2 downTo 1))
        assertArrayNotSameButEquals(longArrayOf(100L, 200L, 30L), longArrayOf(50L, 100L, 200L, 30L).sliceArray(1..3))
        assertArrayNotSameButEquals(booleanArrayOf(true, false, true), booleanArrayOf(true, false, true, true).sliceArray(coll))

        for (range in listOf(-1 until 0, 0 until 2, 2..2)) {
            val bounds = "range: $range"
            val exClass = IndexOutOfBoundsException::class
            assertFailsWith(exClass, bounds) { arrayOf("x").sliceArray(range) }
            assertFailsWith(exClass, bounds) { intArrayOf(1).sliceArray(range) }
            assertFailsWith(exClass, bounds) { longArrayOf(1L).sliceArray(range) }
            assertFailsWith(exClass, bounds) { charArrayOf('C').sliceArray(range) }
        }
    }

    fun <T> compareIterators(it1: Iterator<T>, it2: Iterator<T>) {
        while (true) {
            TestUtils.assertEqual(it1.hasNext(), it2.hasNext());
            if (!it1.hasNext()) {
                return
            }
            TestUtils.assertEqual(it1.next(), it2.next())

        }
    }

    fun iterators() {
        fun <T, E> checkContract(array: T, toList: T.() -> List<E>, iterator: T.() -> Iterator<E>) =
                compareIterators(array.toList().iterator(), array.iterator())

        checkContract(arrayOf("a", "b", "c"), { toList() }, { iterator() })
        checkContract(intArrayOf(), { toList() }, { iterator() })
        checkContract(intArrayOf(1, 2, 3), { toList() }, { iterator() })
        checkContract(shortArrayOf(1, 2, 3), { toList() }, { iterator() })
        checkContract(byteArrayOf(1, 2, 3), { toList() }, { iterator() })
        checkContract(longArrayOf(1L, 2L, 3L), { toList() }, { iterator() })
        checkContract(doubleArrayOf(2.0, 3.0, 9.0), { toList() }, { iterator() })
        checkContract(floatArrayOf(2f, 3f, 9f), { toList() }, { iterator() })
        checkContract(charArrayOf('a', 'b', 'c'), { toList() }, { iterator() })
        checkContract(booleanArrayOf(true, false), { toList() }, { iterator() })
    }

    fun asIterable() {
        val arr1 = intArrayOf(1, 2, 3, 4, 5)
        val iter1 = arr1.asIterable()
        assertEquals(arr1.toList(), iter1.toList())
        arr1[0] = 0
        assertEquals(arr1.toList(), iter1.toList())

        val arr2 = arrayOf("one", "two", "three")
        val iter2 = arr2.asIterable()
        assertEquals(arr2.toList(), iter2.toList())
        arr2[0] = ""
        assertEquals(arr2.toList(), iter2.toList())

        val arr3 = IntArray(0)
        val iter3 = arr3.asIterable()
        assertEquals(iter3.toList(), emptyList<Int>())

        val arr4 = Array(0, { "$it" })
        val iter4 = arr4.asIterable()
        assertEquals(iter4.toList(), emptyList<String>())
    }

    fun <T> compareLists(l1: List<T>, l2: List<T>) {
        TestUtils.assertEqual(l1.size, l2.size);

        val len = l1.size
        for (index in 0 until len) {
            TestUtils.assertEqual(l1.get(index), l2.get(index))
        }
        val it1 = l1.iterator()
        val it2 = l2.iterator()
        while (it1.hasNext()) {
            TestUtils.assertEqual(it1.next(), it2.next())
        }


    }

    fun asList() {
        compareLists(listOf(1, 2, 3), intArrayOf(1, 2, 3).asList())
        compareLists(listOf<Byte>(1, 2, 3), byteArrayOf(1, 2, 3).asList())
        compareLists(listOf(true, false), booleanArrayOf(true, false).asList())

        compareLists(listOf(1, 2, 3), arrayOf(1, 2, 3).asList())
        compareLists(listOf("abc", "def"), arrayOf("abc", "def").asList())

        val ints = intArrayOf(1, 5, 7)
        val intsAsList = ints.asList()
        assertEquals(5, intsAsList[1])
        ints[1] = 10
        TestUtils.assertEqual(10, intsAsList[1], "Should reflect changes in original array")
    }

    fun toPrimitiveArray() {
        val genericArray: Array<Int> = arrayOf(1, 2, 3)
        val primitiveArray: IntArray = genericArray.toIntArray()
        expect(3) { primitiveArray.size }
        assertEquals(genericArray.asList(), primitiveArray.asList())


        val charList = listOf('a', 'b')
        val charArray: CharArray = charList.toCharArray()
        assertEquals(charList, charArray.asList())
    }

    fun toTypedArray() {
        val primitiveArray: LongArray = longArrayOf(1, 2, Long.MAX_VALUE)
        val genericArray: Array<Long> = primitiveArray.toTypedArray()
        expect(3) { genericArray.size }
        assertEquals(primitiveArray.asList(), genericArray.asList())
    }

    fun copyOf() {
        booleanArrayOf(true, false, true).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        byteArrayOf(0, 1, 2, 3, 4, 5).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        shortArrayOf(0, 1, 2, 3, 4, 5).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        intArrayOf(0, 1, 2, 3, 4, 5).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        longArrayOf(0, 1, 2, 3, 4, 5).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        floatArrayOf(0F, 1F, 2F, 3F).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0).let { assertArrayNotSameButEquals(it, it.copyOf()) }
        charArrayOf('0', '1', '2', '3', '4', '5').let { assertArrayNotSameButEquals(it, it.copyOf()) }
    }

    fun copyAndResize() {
        assertArrayNotSameButEquals(arrayOf("1", "2"), arrayOf("1", "2", "3").copyOf(2))
        assertArrayNotSameButEquals(arrayOf("1", "2", null), arrayOf("1", "2").copyOf(3))

        assertArrayNotSameButEquals(longArrayOf(1, 2), longArrayOf(1, 2, 3).copyOf(2))
        assertArrayNotSameButEquals(longArrayOf(1, 2, 0), longArrayOf(1, 2).copyOf(3))

        assertArrayNotSameButEquals(intArrayOf(1, 2), intArrayOf(1, 2, 3).copyOf(2))
        assertArrayNotSameButEquals(intArrayOf(1, 2, 0), intArrayOf(1, 2).copyOf(3))

        assertArrayNotSameButEquals(charArrayOf('A', 'B'), charArrayOf('A', 'B', 'C').copyOf(2))
        assertArrayNotSameButEquals(charArrayOf('A', 'B', '\u0000'), charArrayOf('A', 'B').copyOf(3))

        assertArrayNotSameButEquals(emptyArray(), arrayOf("x").copyOf(0))
        assertArrayNotSameButEquals(intArrayOf(), intArrayOf(1).copyOf(0))
        assertArrayNotSameButEquals(longArrayOf(), longArrayOf(1).copyOf(0))
        assertArrayNotSameButEquals(charArrayOf(), charArrayOf('a').copyOf(0))

        // RuntimeException is the most specific common of JVM and JS implementations
        assertFailsWith<RuntimeException> { arrayOf("x").copyOf(-1) }
        assertFailsWith<RuntimeException> { intArrayOf().copyOf(-1) }
        assertFailsWith<RuntimeException> { longArrayOf().copyOf(-1) }
        assertFailsWith<RuntimeException> { charArrayOf('c').copyOf(-1) }
    }

    fun copyOfRange() {
        assertArrayNotSameButEquals(arrayOf("b", "c"), arrayOf("a", "b", "c").copyOfRange(1, 3))
        assertArrayNotSameButEquals(booleanArrayOf(true, false, true), booleanArrayOf(true, false, true, true).copyOfRange(0, 3))
        assertArrayNotSameButEquals(byteArrayOf(0, 1, 2), byteArrayOf(0, 1, 2, 3, 4, 5).copyOfRange(0, 3))
        assertArrayNotSameButEquals(shortArrayOf(0, 1, 2), shortArrayOf(0, 1, 2, 3, 4, 5).copyOfRange(0, 3))
        assertArrayNotSameButEquals(intArrayOf(0, 1, 2), intArrayOf(0, 1, 2, 3, 4, 5).copyOfRange(0, 3))
        assertArrayNotSameButEquals(longArrayOf(0, 1, 2), longArrayOf(0, 1, 2, 3, 4, 5).copyOfRange(0, 3))
        assertArrayNotSameButEquals(floatArrayOf(0F, 1F, 2F), floatArrayOf(0F, 1F, 2F, 3F, 4F, 5F).copyOfRange(0, 3))
        assertArrayNotSameButEquals(doubleArrayOf(0.0, 1.0, 2.0), doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0).copyOfRange(0, 3))
        assertArrayNotSameButEquals(charArrayOf('0', '1', '2'), charArrayOf('0', '1', '2', '3', '4', '5').copyOfRange(0, 3))

        for (pos in 0..3) {
            assertArrayNotSameButEquals(emptyArray(), arrayOf("a", "b", "c").copyOfRange(pos, pos))
            assertArrayNotSameButEquals(intArrayOf(), intArrayOf(1, 2, 3).copyOfRange(pos, pos))
            assertArrayNotSameButEquals(charArrayOf(), charArrayOf('a', 'b', 'c').copyOfRange(pos, pos))
            assertArrayNotSameButEquals(longArrayOf(), LongArray(3) { it.toLong() }.copyOfRange(pos, pos))
        }

        for ((start, end) in listOf(-1 to 0, 0 to 2, 2 to 2, 1 to 0)) {
            val bounds = "start: $start, end: $end"
            val exClass = if (start > end) IllegalArgumentException::class else IndexOutOfBoundsException::class
            assertFailsWith(exClass, bounds) { arrayOf("x").copyOfRange(start, end) }
            assertFailsWith(exClass, bounds) { intArrayOf(1).copyOfRange(start, end) }
            assertFailsWith(exClass, bounds) { longArrayOf(1L).copyOfRange(start, end) }
            assertFailsWith(exClass, bounds) { charArrayOf('C').copyOfRange(start, end) }
        }
    }

    fun assertTypeEquals(expected: Any?, actual: Any?) {
        assertEquals(expected?.let { it::class.java }, actual?.let { it::class.java })
    }

    fun <T> assertFails(message: String, block: () -> T): Throwable? {
        try {
            block();
        } catch (t: Throwable) {
            return t
        }
        TestUtils.fail(message);
        return null
    }

    fun copyRangeInto() {
        fun <T> doTest(
                copyInto: T.(T, Int, Int, Int) -> T,
                assertTEquals: (T, T, String) -> Unit,
                toStringT: T.() -> String,
                dest: T, newValues: T,
                result1: T, result2: T, result3: T
        ) {
            newValues.copyInto(dest, 0, 1, 3)
            assertTypeEquals(result1, dest)
            assertTEquals(result1, dest, "Copying from newValues: ${result1.toStringT()}, ${dest.toStringT()}")

            dest.copyInto(dest, 0, 1, 3)
            assertTEquals(result2, dest, "Overlapping backward copy: ${result2.toStringT()}, ${dest.toStringT()}")

            dest.copyInto(dest, 1, 0, 2)
            assertTEquals(result3, dest, "Overlapping forward copy: ${result2.toStringT()}, ${dest.toStringT()}")

            for ((start, end) in listOf(-1 to 0, 0 to 4, 4 to 4, 1 to 0, 0 to -1)) {
                val bounds = "start: $start, end: $end"
                val ex = assertFails(bounds) { newValues.copyInto(dest, 0, start, end) }
                assertTrue(ex is IllegalArgumentException || ex is IndexOutOfBoundsException, "Unexpected exception type: $ex")
            }
            for (destIndex in listOf(-1, 2, 4)) {
                assertFailsWith<IndexOutOfBoundsException>("index: $destIndex") { newValues.copyInto(dest, destIndex, 0, 2) }
            }
        }

        doTest(
                Array<String>::copyInto, { e, a, msg -> assertArrayNotSameButEquals(e, a, msg) }, Array<*>::contentToString,
                arrayOf("a", "b", "c"), arrayOf("e", "f", "g"),
                arrayOf("f", "g", "c"), arrayOf("g", "c", "c"), arrayOf("g", "g", "c")
        )

        doTest(
                IntArray::copyInto, ::assertArrayNotSameButEquals, IntArray::contentToString,
                intArrayOf(1, 2, 3), intArrayOf(4, 5, 6),
                intArrayOf(5, 6, 3), intArrayOf(6, 3, 3), intArrayOf(6, 6, 3)
        )

        doTest(
                LongArray::copyInto, ::assertArrayNotSameButEquals, LongArray::contentToString,
                longArrayOf(1, 2, 3), longArrayOf(4, 5, 6),
                longArrayOf(5, 6, 3), longArrayOf(6, 3, 3), longArrayOf(6, 6, 3)
        )

        doTest(
                ByteArray::copyInto, ::assertArrayNotSameButEquals, ByteArray::contentToString,
                byteArrayOf(1, 2, 3), byteArrayOf(4, 5, 6),
                byteArrayOf(5, 6, 3), byteArrayOf(6, 3, 3), byteArrayOf(6, 6, 3)
        )

        doTest(
                CharArray::copyInto, ::assertArrayNotSameButEquals, CharArray::contentToString,
                charArrayOf('a', 'b', 'c'), charArrayOf('e', 'f', 'g'),
                charArrayOf('f', 'g', 'c'), charArrayOf('g', 'c', 'c'), charArrayOf('g', 'g', 'c')
        )

        doTest(
                UIntArray::copyInto, { e, a, msg -> assertTrue(e contentEquals a, msg) }, UIntArray::contentToString,
                uintArrayOf(1u, 2u, 3u), uintArrayOf(4u, 5u, 6u),
                uintArrayOf(5u, 6u, 3u), uintArrayOf(6u, 3u, 3u), uintArrayOf(6u, 6u, 3u)
        )

        doTest(
                ULongArray::copyInto, { e, a, msg -> assertTrue(e contentEquals a, msg) }, ULongArray::contentToString,
                ulongArrayOf(1u, 2u, 3u), ulongArrayOf(4u, 5u, 6u),
                ulongArrayOf(5u, 6u, 3u), ulongArrayOf(6u, 3u, 3u), ulongArrayOf(6u, 6u, 3u)
        )

        doTest(
                UByteArray::copyInto, { e, a, msg -> assertTrue(e contentEquals a, msg) }, UByteArray::contentToString,
                ubyteArrayOf(1u, 2u, 3u), ubyteArrayOf(4u, 5u, 6u),
                ubyteArrayOf(5u, 6u, 3u), ubyteArrayOf(6u, 3u, 3u), ubyteArrayOf(6u, 6u, 3u)
        )
    }

    inline fun <reified T> assertStaticTypeIs(arr: Array<T>) {
        for (e in arr) {
            if (!T::class.java.isAssignableFrom((e as Any).javaClass)) {
                TestUtils.fail("Expected static type to be "+T::class.java+" but found "+e.javaClass);
            }

        }
    }


    fun copyRangeIntoVarianceTest() {
        val sourceArr: Array<out Int> = arrayOf(1, 2, 3)
        val targetAnyArr: Array<Any?> = arrayOfNulls<Any?>(3)
        val targetNumberArr: Array<Number> = Array<Number>(3) { 0.0 }
        val targetArrProjection: Array<in Number> = targetNumberArr

        val c1 = sourceArr.copyInto(targetAnyArr)
        assertStaticTypeIs<Any?>(c1)

        val c2 = sourceArr.copyInto(targetNumberArr)
        assertStaticTypeIs<Number>(c2)

        val c3 = sourceArr.copyInto(targetArrProjection)
        //assertStaticTypeIsIn<in Number>(c3)
    }

    fun reduceIndexed() {
        expect(-1) { intArrayOf(1, 2, 3).reduceIndexed { index, a, b -> index + a - b } }
        expect(-1.toLong()) { longArrayOf(1, 2, 3).reduceIndexed { index, a, b -> index + a - b } }
        expect(-1F) { floatArrayOf(1F, 2F, 3F).reduceIndexed { index, a, b -> index + a - b } }
        expect(-1.0) { doubleArrayOf(1.0, 2.0, 3.0).reduceIndexed { index, a, b -> index + a - b } }
        expect('2') { charArrayOf('1', '3', '2').reduceIndexed { index, a, b -> if (a > b && index == 1) a else b } }
        expect(true) { booleanArrayOf(true, true, false).reduceIndexed { index, a, b -> a && b || index == 2 } }
        expect(false) { booleanArrayOf(true, true).reduceIndexed { index, a, b -> a && b && index != 1 } }
        expect(1.toByte()) { byteArrayOf(3, 2, 1).reduceIndexed { index, a, b -> if (index != 2) (a - b).toByte() else a.toByte() } }
        expect(1.toShort()) { shortArrayOf(3, 2, 1).reduceIndexed { index, a, b -> if (index != 2) (a - b).toShort() else a.toShort() } }

        assertFailsWith<UnsupportedOperationException> {
            intArrayOf().reduceIndexed { index, a, b -> index + a + b }
        }
    }

    fun reduceRightIndexed() {
        expect(1) { intArrayOf(1, 2, 3).reduceRightIndexed { index, a, b -> index + a - b } }
        expect(1.toLong()) { longArrayOf(1, 2, 3).reduceRightIndexed { index, a, b -> index + a - b } }
        expect(1F) { floatArrayOf(1F, 2F, 3F).reduceRightIndexed { index, a, b -> index + a - b } }
        expect(1.0) { doubleArrayOf(1.0, 2.0, 3.0).reduceRightIndexed { index, a, b -> index + a - b } }
        expect('2') { charArrayOf('1', '3', '2').reduceRightIndexed { index, a, b -> if (a > b && index == 0) a else b } }
        expect(true) { booleanArrayOf(true, true, false).reduceRightIndexed { index, a, b -> a && b || index == 1 } }
        expect(false) { booleanArrayOf(true, true).reduceRightIndexed { index, a, b -> a && b && index != 0 } }
        expect(1.toByte()) { byteArrayOf(3, 2, 1).reduceRightIndexed { index, a, b -> if (index != 1) (a - b).toByte() else a.toByte() } }
        expect(1.toShort()) { shortArrayOf(3, 2, 1).reduceRightIndexed { index, a, b -> if (index != 1) (a - b).toShort() else a.toShort() } }

        assertFailsWith<UnsupportedOperationException> {
            intArrayOf().reduceRightIndexed { index, a, b -> index + a + b }
        }
    }

    fun reduce() {
        expect(-4) { intArrayOf(1, 2, 3).reduce { a, b -> a - b } }
        expect(-4.toLong()) { longArrayOf(1, 2, 3).reduce { a, b -> a - b } }
        expect(-4F) { floatArrayOf(1F, 2F, 3F).reduce { a, b -> a - b } }
        expect(-4.0) { doubleArrayOf(1.0, 2.0, 3.0).reduce { a, b -> a - b } }
        expect('3') { charArrayOf('1', '3', '2').reduce { a, b -> if (a > b) a else b } }
        expect(false) { booleanArrayOf(true, true, false).reduce { a, b -> a && b } }
        expect(true) { booleanArrayOf(true, true).reduce { a, b -> a && b } }
        expect(0.toByte()) { byteArrayOf(3, 2, 1).reduce { a, b -> (a - b).toByte() } }
        expect(0.toShort()) { shortArrayOf(3, 2, 1).reduce { a, b -> (a - b).toShort() } }

        assertFailsWith<UnsupportedOperationException> {
            intArrayOf().reduce { a, b -> a + b }
        }
    }

    /*
    // Requires experimental API optin
    fun reduceOrNull() {
        expect(-4) { intArrayOf(1, 2, 3).reduceOrNull { a, b -> a - b } }
        expect(-4.toLong()) { longArrayOf(1, 2, 3).reduceOrNull { a, b -> a - b } }
        expect(-4F) { floatArrayOf(1F, 2F, 3F).reduceOrNull { a, b -> a - b } }
        expect(-4.0) { doubleArrayOf(1.0, 2.0, 3.0).reduceOrNull { a, b -> a - b } }
        expect('3') { charArrayOf('1', '3', '2').reduceOrNull { a, b -> if (a > b) a else b } }
        expect(false) { booleanArrayOf(true, true, false).reduceOrNull { a, b -> a && b } }
        expect(true) { booleanArrayOf(true, true).reduceOrNull { a, b -> a && b } }
        expect(0.toByte()) { byteArrayOf(3, 2, 1).reduceOrNull { a, b -> (a - b).toByte() } }
        expect(0.toShort()) { shortArrayOf(3, 2, 1).reduceOrNull { a, b -> (a - b).toShort() } }

        expect(null, { intArrayOf().reduceOrNull { a, b -> a + b } })
    }
    */
    fun reduceRight() {
        expect(2) { intArrayOf(1, 2, 3).reduceRight { a, b -> a - b } }
        expect(2.toLong()) { longArrayOf(1, 2, 3).reduceRight { a, b -> a - b } }
        expect(2F) { floatArrayOf(1F, 2F, 3F).reduceRight { a, b -> a - b } }
        expect(2.0) { doubleArrayOf(1.0, 2.0, 3.0).reduceRight { a, b -> a - b } }
        expect('3') { charArrayOf('1', '3', '2').reduceRight { a, b -> if (a > b) a else b } }
        expect(false) { booleanArrayOf(true, true, false).reduceRight { a, b -> a && b } }
        expect(true) { booleanArrayOf(true, true).reduceRight { a, b -> a && b } }
        expect(2.toByte()) { byteArrayOf(1, 2, 3).reduceRight { a, b -> (a - b).toByte() } }
        expect(2.toShort()) { shortArrayOf(1, 2, 3).reduceRight { a, b -> (a - b).toShort() } }

        assertFailsWith<UnsupportedOperationException> {
            intArrayOf().reduceRight { a, b -> a + b }
        }
    }
/*
// Requires experimental API optin
fun reduceRightOrNull() {
    expect(2) { intArrayOf(1, 2, 3).reduceRightOrNull { a, b -> a - b } }
    expect(2.toLong()) { longArrayOf(1, 2, 3).reduceRightOrNull { a, b -> a - b } }
    expect(2F) { floatArrayOf(1F, 2F, 3F).reduceRightOrNull { a, b -> a - b } }
    expect(2.0) { doubleArrayOf(1.0, 2.0, 3.0).reduceRightOrNull { a, b -> a - b } }
    expect('3') { charArrayOf('1', '3', '2').reduceRightOrNull { a, b -> if (a > b) a else b } }
    expect(false) { booleanArrayOf(true, true, false).reduceRightOrNull { a, b -> a && b } }
    expect(true) { booleanArrayOf(true, true).reduceRightOrNull { a, b -> a && b } }
    expect(2.toByte()) { byteArrayOf(1, 2, 3).reduceRightOrNull { a, b -> (a - b).toByte() } }
    expect(2.toShort()) { shortArrayOf(1, 2, 3).reduceRightOrNull { a, b -> (a - b).toShort() } }

    expect(null, { intArrayOf().reduceRightOrNull { a, b -> a + b } })
}
*/

    /*
    // requires experimental API optin
fun scan() {
    for (size in 0 until 4) {
        val expected = listOf("", "0", "01", "012", "0123").take(size + 1)
        // Array<T>
        assertEquals(expected, Array(size) { it }.scan("") { acc, e -> acc + e })
        // Primitive Arrays
        assertEquals(expected, ByteArray(size) { it.toByte() }.scan("") { acc, e -> acc + e })
        assertEquals(expected, CharArray(size) { '0' + it }.scan("") { acc, e -> acc + e })
        assertEquals(expected, ShortArray(size) { it.toShort() }.scan("") { acc, e -> acc + e })
        assertEquals(expected, IntArray(size) { it }.scan("") { acc, e -> acc + e })
        assertEquals(expected, LongArray(size) { it.toLong() }.scan("") { acc, e -> acc + e })
        assertEquals(expected, FloatArray(size) { it.toFloat() }.scan("") { acc, e -> acc + e.toInt() })
        assertEquals(expected, DoubleArray(size) { it.toDouble() }.scan("") { acc, e -> acc + e.toInt() })
        assertEquals(
                expected.map { it.map { c -> c.toInt() % 2 == 0 }.joinToString(separator = "") },
                BooleanArray(size) { it % 2 == 0 }.scan("") { acc, e -> acc + e }
        )
    }
}
*/
/*
// requires experimental API optin
fun scanIndexed() {
    for (size in 0 until 4) {
        val expected = listOf("+", "+[0: a]", "+[0: a][1: b]", "+[0: a][1: b][2: c]", "+[0: a][1: b][2: c][3: d]").take(size + 1)
        // Array<T>
        assertEquals(
                expected,
                Array(size) { 'a' + it }.scanIndexed("+") { index, acc, e -> "$acc[$index: $e]" }
        )
        // Primitive Arrays
        assertEquals(
                expected,
                ByteArray(size) { it.toByte() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )
        assertEquals(
                expected,
                CharArray(size) { it.toChar() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )
        assertEquals(
                expected,
                ShortArray(size) { it.toShort() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )
        assertEquals(
                expected,
                IntArray(size) { it }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e}]" }
        )
        assertEquals(
                expected,
                LongArray(size) { it.toLong() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )
        assertEquals(
                expected,
                FloatArray(size) { it.toFloat() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )
        assertEquals(
                expected,
                DoubleArray(size) { it.toDouble() }.scanIndexed("+") { index, acc, e -> "$acc[$index: ${'a' + e.toInt()}]" }
        )

        assertEquals(
                expected.map { it.map { c -> if (c.isAsciiLetter()) c.toInt() % 2 != 0 else c }.joinToString(separator = "") },
                BooleanArray(size) { it % 2 == 0 }.scanIndexed("+") { index, acc, e -> "$acc[$index: $e]" }
        )


    }
}
*/
/*
// Requires experimental API optin
fun scanReduce() {
    for (size in 0 until 4) {
        val expected = listOf(0, 1, 3, 6).take(size)
        // Array<T>
        assertEquals(
                expected,
                Array(size) { it }.scanReduce { acc, e -> acc + e }
        )
        // Primitive Arrays
        assertEquals(
                expected.map { it.toByte() },
                ByteArray(size) { it.toByte() }.scanReduce { acc, e -> (acc + e).toByte() }
        )
        assertEquals(
                expected.map { it.toChar() },
                CharArray(size) { it.toChar() }.scanReduce { acc, e -> acc + e.toInt() }
        )
        assertEquals(
                expected.map { it.toShort() },
                ShortArray(size) { it.toShort() }.scanReduce { acc, e -> (acc + e).toShort() }
        )
        assertEquals(
                expected,
                IntArray(size) { it }.scanReduce { acc, e -> acc + e }
        )
        assertEquals(
                expected.map { it.toLong() },
                LongArray(size) { it.toLong() }.scanReduce { acc, e -> acc + e }
        )
        assertEquals(
                expected.map { it.toFloat() },
                FloatArray(size) { it.toFloat() }.scanReduce { acc, e -> acc + e.toInt() }
        )
        assertEquals(
                expected.map { it.toDouble() },
                DoubleArray(size) { it.toDouble() }.scanReduce { acc, e -> acc + e.toInt() }
        )
        assertEquals(
                expected.indices.map { it % 2 == 0 },
                BooleanArray(size) { true }.scanReduce { acc, e -> acc != e }
        )
    }
}
*/
/*
// requires experimental API optin
fun scanReduceIndexed() {
    for (size in 0 until 4) {
        val expected = listOf(0, 1, 6, 27).take(size)
        // Array<T>
        assertEquals(
                expected,
                Array(size) { it }.scanReduceIndexed { index, acc, e -> index * (acc + e) }
        )
        // Primitive Arrays
        assertEquals(
                expected.map { it.toByte() },
                ByteArray(size) { it.toByte() }.scanReduceIndexed { index, acc, e -> (index * (acc + e)).toByte() })
        assertEquals(
                expected.map { it.toChar() },
                CharArray(size) { it.toChar() }.scanReduceIndexed { index, acc, e -> (index * (acc.toInt() + e.toInt())).toChar() }
        )
        assertEquals(
                expected.map { it.toShort() },
                ShortArray(size) { it.toShort() }.scanReduceIndexed { index, acc, e -> (index * (acc + e)).toShort() }
        )
        assertEquals(
                expected,
                IntArray(size) { it }.scanReduceIndexed { index, acc, e -> index * (acc + e) }
        )
        assertEquals(
                expected.map { it.toLong() },
                LongArray(size) { it.toLong() }.scanReduceIndexed { index, acc, e -> index * (acc + e) }
        )
        assertEquals(
                expected.map { it.toFloat() },
                FloatArray(size) { it.toFloat() }.scanReduceIndexed { index, acc, e -> index * (acc + e) }
        )
        assertEquals(
                expected.map { it.toDouble() },
                DoubleArray(size) { it.toDouble() }.scanReduceIndexed { index, acc, e -> index * (acc + e) }
        )
        assertEquals(
                expected.indices.map { it % 2 == 0 },
                BooleanArray(size) { true }.scanReduceIndexed { index, acc, e -> acc != e && index % 2 == 0 }
        )
    }
}
*/
    fun reverseInPlace() {

        fun <TArray, T> doTest(build: Iterable<Int>.() -> TArray, reverse: TArray.() -> Unit, snapshot: TArray.() -> List<T>) {
            val arrays = (0..4).map { n -> (1..n).build() }
            for (array in arrays) {
                val original = array.snapshot()
                array.reverse()
                val reversed = array.snapshot()
                assertEquals(original.asReversed(), reversed)
            }
        }

        doTest(build = { map { it }.toIntArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toLong() }.toLongArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toByte() }.toByteArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toShort() }.toShortArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toFloat() }.toFloatArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toDouble() }.toDoubleArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { 'a' + it }.toCharArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it % 2 == 0 }.toBooleanArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toString() }.toTypedArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toString() }.toTypedArray() as Array<out String> }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toUInt() }.toUIntArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toULong() }.toULongArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toUByte() }.toUByteArray() }, reverse = { reverse() }, snapshot = { toList() })
        doTest(build = { map { it.toUShort() }.toUShortArray() }, reverse = { reverse() }, snapshot = { toList() })
    }


    fun reversed() {
        expect(listOf(3, 2, 1)) { intArrayOf(1, 2, 3).reversed() }
        expect(listOf<Byte>(3, 2, 1)) { byteArrayOf(1, 2, 3).reversed() }
        expect(listOf<Short>(3, 2, 1)) { shortArrayOf(1, 2, 3).reversed() }
        expect(listOf<Long>(3, 2, 1)) { longArrayOf(1, 2, 3).reversed() }
        expect(listOf(3F, 2F, 1F)) { floatArrayOf(1F, 2F, 3F).reversed() }
        expect(listOf(3.0, 2.0, 1.0)) { doubleArrayOf(1.0, 2.0, 3.0).reversed() }
        expect(listOf('3', '2', '1')) { charArrayOf('1', '2', '3').reversed() }
        expect(listOf(false, false, true)) { booleanArrayOf(true, false, false).reversed() }
        expect(listOf("3", "2", "1")) { arrayOf("1", "2", "3").reversed() }
    }

    fun reversedArray() {
        assertArrayNotSameButEquals(intArrayOf(3, 2, 1), intArrayOf(1, 2, 3).reversedArray())
        assertArrayNotSameButEquals(byteArrayOf(3, 2, 1), byteArrayOf(1, 2, 3).reversedArray())
        assertArrayNotSameButEquals(shortArrayOf(3, 2, 1), shortArrayOf(1, 2, 3).reversedArray())
        assertArrayNotSameButEquals(longArrayOf(3, 2, 1), longArrayOf(1, 2, 3).reversedArray())
        assertArrayNotSameButEquals(floatArrayOf(3F, 2F, 1F), floatArrayOf(1F, 2F, 3F).reversedArray())
        assertArrayNotSameButEquals(doubleArrayOf(3.0, 2.0, 1.0), doubleArrayOf(1.0, 2.0, 3.0).reversedArray())
        assertArrayNotSameButEquals(charArrayOf('3', '2', '1'), charArrayOf('1', '2', '3').reversedArray())
        assertArrayNotSameButEquals(booleanArrayOf(false, false, true), booleanArrayOf(true, false, false).reversedArray())
        assertArrayNotSameButEquals(arrayOf("3", "2", "1"), arrayOf("1", "2", "3").reversedArray())
        assertArrayNotSameButEquals(arrayOf("3", "2", "1"), (arrayOf("1", "2", "3") as Array<out String>).reversedArray())
    }

    fun drop() {
        expect(listOf(1), { intArrayOf(1).drop(0) })
        expect(listOf(), { intArrayOf().drop(1) })
        expect(listOf(), { intArrayOf(1).drop(1) })
        expect(listOf(3), { intArrayOf(2, 3).drop(1) })
        expect(listOf(2000000000000), { longArrayOf(3000000000000, 2000000000000).drop(1) })
        expect(listOf(3.toByte()), { byteArrayOf(2, 3).drop(1) })
        expect(listOf(3.toShort()), { shortArrayOf(2, 3).drop(1) })
        expect(listOf(3.0f), { floatArrayOf(2f, 3f).drop(1) })
        expect(listOf(3.0), { doubleArrayOf(2.0, 3.0).drop(1) })
        expect(listOf(false), { booleanArrayOf(true, false).drop(1) })
        expect(listOf('b'), { charArrayOf('a', 'b').drop(1) })
        expect(listOf("b"), { arrayOf("a", "b").drop(1) })
        assertFails {
            listOf(2).drop(-1)
        }
    }

    fun assertFails(block: () -> Any?) {
        try {
            block();
        } catch (t: Throwable) {
            return
        }
        TestUtils.fail();
    }

    fun dropLast() {
        expect(listOf(), { intArrayOf().dropLast(1) })
        expect(listOf(), { intArrayOf(1).dropLast(1) })
        expect(listOf(1), { intArrayOf(1).dropLast(0) })
        expect(listOf(2), { intArrayOf(2, 3).dropLast(1) })
        expect(listOf(3000000000000), { longArrayOf(3000000000000, 2000000000000).dropLast(1) })
        expect(listOf(2.toByte()), { byteArrayOf(2, 3).dropLast(1) })
        expect(listOf(2.toShort()), { shortArrayOf(2, 3).dropLast(1) })
        expect(listOf(2.0f), { floatArrayOf(2f, 3f).dropLast(1) })
        expect(listOf(2.0), { doubleArrayOf(2.0, 3.0).dropLast(1) })
        expect(listOf(true), { booleanArrayOf(true, false).dropLast(1) })
        expect(listOf('a'), { charArrayOf('a', 'b').dropLast(1) })
        expect(listOf("a"), { arrayOf("a", "b").dropLast(1) })
        assertFails {
            listOf(1).dropLast(-1)
        }
    }

    fun dropWhile() {
        expect(listOf(), { intArrayOf().dropWhile { it < 3 } })
        expect(listOf(), { intArrayOf(1).dropWhile { it < 3 } })
        expect(listOf(3, 1), { intArrayOf(2, 3, 1).dropWhile { it < 3 } })
        expect(listOf(2000000000000), { longArrayOf(3000000000000, 2000000000000).dropWhile { it > 2000000000000 } })
        expect(listOf(3.toByte(), 1.toByte()), { byteArrayOf(2, 3, 1).dropWhile { it < 3 } })
        expect(listOf(3.toShort(), 1.toShort()), { shortArrayOf(2, 3, 1).dropWhile { it < 3 } })
        expect(listOf(3f, 1f), { floatArrayOf(2f, 3f, 1f).dropWhile { it < 3 } })
        expect(listOf(3.0, 1.0), { doubleArrayOf(2.0, 3.0, 1.0).dropWhile { it < 3 } })
        expect(listOf(false, true), { booleanArrayOf(true, false, true).dropWhile { it } })
        expect(listOf('b', 'a'), { charArrayOf('a', 'b', 'a').dropWhile { it < 'b' } })
        expect(listOf("b", "a"), { arrayOf("a", "b", "a").dropWhile { it < "b" } })
    }

    fun dropLastWhile() {
        expect(listOf(), { intArrayOf().dropLastWhile { it < 3 } })
        expect(listOf(), { intArrayOf(1).dropLastWhile { it < 3 } })
        expect(listOf(2, 3), { intArrayOf(2, 3, 1).dropLastWhile { it < 3 } })
        expect(listOf(3000000000000), { longArrayOf(3000000000000, 2000000000000).dropLastWhile { it < 3000000000000 } })
        expect(listOf(2.toByte(), 3.toByte()), { byteArrayOf(2, 3, 1).dropLastWhile { it < 3 } })
        expect(listOf(2.toShort(), 3.toShort()), { shortArrayOf(2, 3, 1).dropLastWhile { it < 3 } })
        expect(listOf(2f, 3f), { floatArrayOf(2f, 3f, 1f).dropLastWhile { it < 3 } })
        expect(listOf(2.0, 3.0), { doubleArrayOf(2.0, 3.0, 1.0).dropLastWhile { it < 3 } })
        expect(listOf(true, false), { booleanArrayOf(true, false, true).dropLastWhile { it } })
        expect(listOf('a', 'b'), { charArrayOf('a', 'b', 'a').dropLastWhile { it < 'b' } })
        expect(listOf("a", "b"), { arrayOf("a", "b", "a").dropLastWhile { it < "b" } })
    }

    fun take() {
        expect(listOf(), { intArrayOf().take(1) })
        expect(listOf(), { intArrayOf(1).take(0) })
        expect(listOf(1), { intArrayOf(1).take(1) })
        expect(listOf(2), { intArrayOf(2, 3).take(1) })
        expect(listOf(3000000000000), { longArrayOf(3000000000000, 2000000000000).take(1) })
        expect(listOf(2.toByte()), { byteArrayOf(2, 3).take(1) })
        expect(listOf(2.toShort()), { shortArrayOf(2, 3).take(1) })
        expect(listOf(2.0f), { floatArrayOf(2f, 3f).take(1) })
        expect(listOf(2.0), { doubleArrayOf(2.0, 3.0).take(1) })
        expect(listOf(true), { booleanArrayOf(true, false).take(1) })
        expect(listOf('a'), { charArrayOf('a', 'b').take(1) })
        expect(listOf("a"), { arrayOf("a", "b").take(1) })
        assertFails {
            listOf(1).take(-1)
        }
    }

    fun takeLast() {
        expect(listOf(), { intArrayOf().takeLast(1) })
        expect(listOf(), { intArrayOf(1).takeLast(0) })
        expect(listOf(1), { intArrayOf(1).takeLast(1) })
        expect(listOf(3), { intArrayOf(2, 3).takeLast(1) })
        expect(listOf(2000000000000), { longArrayOf(3000000000000, 2000000000000).takeLast(1) })
        expect(listOf(3.toByte()), { byteArrayOf(2, 3).takeLast(1) })
        expect(listOf(3.toShort()), { shortArrayOf(2, 3).takeLast(1) })
        expect(listOf(3.0f), { floatArrayOf(2f, 3f).takeLast(1) })
        expect(listOf(3.0), { doubleArrayOf(2.0, 3.0).takeLast(1) })
        expect(listOf(false), { booleanArrayOf(true, false).takeLast(1) })
        expect(listOf('b'), { charArrayOf('a', 'b').takeLast(1) })
        expect(listOf("b"), { arrayOf("a", "b").takeLast(1) })
        assertFails {
            listOf(1).takeLast(-1)
        }
    }

    fun takeWhile() {
        expect(listOf(), { intArrayOf().takeWhile { it < 3 } })
        expect(listOf(1), { intArrayOf(1).takeWhile { it < 3 } })
        expect(listOf(2), { intArrayOf(2, 3, 1).takeWhile { it < 3 } })
        expect(listOf(3000000000000), { longArrayOf(3000000000000, 2000000000000).takeWhile { it > 2000000000000 } })
        expect(listOf(2.toByte()), { byteArrayOf(2, 3, 1).takeWhile { it < 3 } })
        expect(listOf(2.toShort()), { shortArrayOf(2, 3, 1).takeWhile { it < 3 } })
        expect(listOf(2f), { floatArrayOf(2f, 3f, 1f).takeWhile { it < 3 } })
        expect(listOf(2.0), { doubleArrayOf(2.0, 3.0, 1.0).takeWhile { it < 3 } })
        expect(listOf(true), { booleanArrayOf(true, false, true).takeWhile { it } })
        expect(listOf('a'), { charArrayOf('a', 'c', 'b').takeWhile { it < 'c' } })
        expect(listOf("a"), { arrayOf("a", "c", "b").takeWhile { it < "c" } })
    }

    fun takeLastWhile() {
        expect(listOf(), { intArrayOf().takeLastWhile { it < 3 } })
        expect(listOf(1), { intArrayOf(1).takeLastWhile { it < 3 } })
        expect(listOf(1), { intArrayOf(2, 3, 1).takeLastWhile { it < 3 } })
        expect(listOf(2000000000000), { longArrayOf(3000000000000, 2000000000000).takeLastWhile { it < 3000000000000 } })
        expect(listOf(1.toByte()), { byteArrayOf(2, 3, 1).takeLastWhile { it < 3 } })
        expect(listOf(1.toShort()), { shortArrayOf(2, 3, 1).takeLastWhile { it < 3 } })
        expect(listOf(1f), { floatArrayOf(2f, 3f, 1f).takeLastWhile { it < 3 } })
        expect(listOf(1.0), { doubleArrayOf(2.0, 3.0, 1.0).takeLastWhile { it < 3 } })
        expect(listOf(true), { booleanArrayOf(true, false, true).takeLastWhile { it } })
        expect(listOf('b'), { charArrayOf('a', 'c', 'b').takeLastWhile { it < 'c' } })
        expect(listOf("b"), { arrayOf("a", "c", "b").takeLastWhile { it < "c" } })
    }

    fun filter() {
        expect(listOf(), { intArrayOf().filter { it > 2 } })
        expect(listOf(), { intArrayOf(1).filter { it > 2 } })
        expect(listOf(3), { intArrayOf(2, 3).filter { it > 2 } })
        expect(listOf(3000000000000), { longArrayOf(3000000000000, 2000000000000).filter { it > 2000000000000 } })
        expect(listOf(3.toByte()), { byteArrayOf(2, 3).filter { it > 2 } })
        expect(listOf(3.toShort()), { shortArrayOf(2, 3).filter { it > 2 } })
        expect(listOf(3.0f), { floatArrayOf(2f, 3f).filter { it > 2 } })
        expect(listOf(3.0), { doubleArrayOf(2.0, 3.0).filter { it > 2 } })
        expect(listOf(true), { booleanArrayOf(true, false).filter { it } })
        expect(listOf('b'), { charArrayOf('a', 'b').filter { it > 'a' } })
        expect(listOf("b"), { arrayOf("a", "b").filter { it > "a" } })
    }

    fun filterIndexed() {
        expect(listOf(), { intArrayOf().filterIndexed { i, v -> i > v } })
        expect(listOf(2, 5, 8), { intArrayOf(2, 4, 3, 5, 8).filterIndexed { index, value -> index % 2 == value % 2 } })
        expect(listOf<Long>(2, 5, 8), { longArrayOf(2, 4, 3, 5, 8).filterIndexed { index, value -> index % 2 == (value % 2).toInt() } })
        expect(listOf<Byte>(2, 5, 8), { byteArrayOf(2, 4, 3, 5, 8).filterIndexed { index, value -> index % 2 == (value % 2).toInt() } })
        expect(listOf('9', 'e', 'a'), { charArrayOf('9', 'e', 'd', 'a').filterIndexed { index, c -> c == 'a' || index < 2 } })
        expect(listOf("a", "c", "d"), { arrayOf("a", "b", "c", "d").filterIndexed { index, s -> s == "a" || index >= 2 } })
    }

    fun filterNot() {
        expect(listOf(), { intArrayOf().filterNot { it > 2 } })
        expect(listOf(1), { intArrayOf(1).filterNot { it > 2 } })
        expect(listOf(2), { intArrayOf(2, 3).filterNot { it > 2 } })
        expect(listOf(2000000000000), { longArrayOf(3000000000000, 2000000000000).filterNot { it > 2000000000000 } })
        expect(listOf(2.toByte()), { byteArrayOf(2, 3).filterNot { it > 2 } })
        expect(listOf(2.toShort()), { shortArrayOf(2, 3).filterNot { it > 2 } })
        expect(listOf(2.0f), { floatArrayOf(2f, 3f).filterNot { it > 2 } })
        expect(listOf(2.0), { doubleArrayOf(2.0, 3.0).filterNot { it > 2 } })
        expect(listOf(false), { booleanArrayOf(true, false).filterNot { it } })
        expect(listOf('a'), { charArrayOf('a', 'b').filterNot { it > 'a' } })
        expect(listOf("a"), { arrayOf("a", "b").filterNot { it > "a" } })
    }

    fun filterNotNull() {
        expect(listOf("a"), { arrayOf("a", null).filterNotNull() })
    }

    fun map() {
        assertEquals(listOf(1, 2, 4), arrayOf("a", "bc", "test").map { it.length })
        assertEquals(listOf('a', 'b', 'c'), intArrayOf(1, 2, 3).map { 'a' + it - 1 })
        assertEquals(listOf(1, 2, 3), longArrayOf(1000, 2000, 3000).map { (it / 1000).toInt() })
        assertEquals(listOf(1.0, 0.5, 0.4, 0.2, 0.1), doubleArrayOf(1.0, 2.0, 2.5, 5.0, 10.0).map { 1 / it })
    }

    fun mapIndexed() {
        assertEquals(listOf(1, 1, 2), arrayOf("a", "bc", "test").mapIndexed { index, s -> s.length - index })
        assertEquals(listOf(0, 2, 2), intArrayOf(3, 2, 1).mapIndexed { index, i -> i * index })
        assertEquals(listOf("0;20", "1;21", "2;22"), longArrayOf(20, 21, 22).mapIndexed { index, it -> "$index;$it" })
    }

    fun mapNotNull() {
        assertEquals(listOf(2, 3), arrayOf("", "bc", "def").mapNotNull { if (it.isEmpty()) null else it.length })
    }

    fun mapIndexedNotNull() {
        assertEquals(listOf(2), arrayOf("a", null, "test").mapIndexedNotNull { index, it -> it?.run { if (index != 0) length / index else null } })
    }

    fun flattenArray() {
        val arr1: Array<Array<Int>> = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6))
        val arr2: Array<out Array<Int>> = arr1
        val arr3: Array<out Array<out Int>> = arr1

        @Suppress("UNCHECKED_CAST")
        val arr4: Array<Array<out Int>> = arr1 as Array<Array<out Int>>

        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(expected, arr1.flatten())
        assertEquals(expected, arr2.flatten())
        assertEquals(expected, arr3.flatten())
        assertEquals(expected, arr4.flatten())
    }

    fun asListPrimitives() {
        // Array of primitives
        val arr = intArrayOf(1, 2, 3, 4, 2, 5)
        val list = arr.asList()
        assertEquals(list, arr.toList())

        assertTrue(2 in list)
        assertFalse(0 in list)
        assertTrue(list.containsAll(listOf(5, 4, 3)))
        assertFalse(list.containsAll(listOf(5, 6, 3)))

        expect(1) { list.indexOf(2) }
        expect(4) { list.lastIndexOf(2) }
        expect(-1) { list.indexOf(6) }

        assertEquals(list.subList(3, 5), listOf(4, 2))

        val iter = list.listIterator(2)
        expect(2) { iter.nextIndex() }
        expect(1) { iter.previousIndex() }
        expect(3) {
            iter.next()
            iter.previous()
            iter.next()
        }

        arr[2] = 4
        assertEquals(list, arr.toList())

        assertEquals(IntArray(0).asList(), emptyList<Int>())
    }

    fun asListObjects() {
        val arr = arrayOf("a", "b", "c", "d", "b", "e")
        val list = arr.asList()

        assertEquals(list, arr.toList())

        assertTrue("b" in list)
        assertFalse("z" in list)

        expect(1) { list.indexOf("b") }
        expect(4) { list.lastIndexOf("b") }
        expect(-1) { list.indexOf("x") }

        assertTrue(list.containsAll(listOf("e", "d", "c")))
        assertFalse(list.containsAll(listOf("e", "x", "c")))

        assertEquals(list.subList(3, 5), listOf("d", "b"))

        val iter = list.listIterator(2)
        expect(2) { iter.nextIndex() }
        expect(1) { iter.previousIndex() }
        expect("c") {
            iter.next()
            iter.previous()
            iter.next()
        }

        arr[2] = "xx"
        assertEquals(list, arr.toList())

        assertEquals(Array(0, { "" }).asList(), emptyList<String>())
    }

    fun sort() {
        val intArr = intArrayOf(5, 2, 1, 9, 80, Int.MIN_VALUE, Int.MAX_VALUE)
        intArr.sort()
        assertArrayNotSameButEquals(intArrayOf(Int.MIN_VALUE, 1, 2, 5, 9, 80, Int.MAX_VALUE), intArr)
        intArr.sortDescending()
        assertArrayNotSameButEquals(intArrayOf(Int.MAX_VALUE, 80, 9, 5, 2, 1, Int.MIN_VALUE), intArr)

        val longArr = longArrayOf(200, 2, 1, 4, 3, Long.MIN_VALUE, Long.MAX_VALUE)
        longArr.sort()
        assertArrayNotSameButEquals(longArrayOf(Long.MIN_VALUE, 1, 2, 3, 4, 200, Long.MAX_VALUE), longArr)
        longArr.sortDescending()
        assertArrayNotSameButEquals(longArrayOf(Long.MAX_VALUE, 200, 4, 3, 2, 1, Long.MIN_VALUE), longArr)

        val charArr = charArrayOf('d', 'c', 'E', 'a', '\u0000', '\uFFFF')
        charArr.sort()
        assertArrayNotSameButEquals(charArrayOf('\u0000', 'E', 'a', 'c', 'd', '\uFFFF'), charArr)
        charArr.sortDescending()
        assertArrayNotSameButEquals(charArrayOf('\uFFFF', 'd', 'c', 'a', 'E', '\u0000'), charArr)


        val strArr = arrayOf("9", "80", "all", "Foo")
        strArr.sort()
        assertArrayNotSameButEquals(arrayOf("80", "9", "Foo", "all"), strArr)
        strArr.sortDescending()
        assertArrayNotSameButEquals(arrayOf("all", "Foo", "9", "80"), strArr)
    }

    fun sortedTests() {
        assertTrue(arrayOf<Long>().sorted().none())
        assertEquals(listOf(1), arrayOf(1).sorted())

        fun <A, T : Comparable<T>> arrayData(vararg values: T, toArray: Array<out T>.() -> A) = ArraySortedChecker<A, T>(values.toArray(), naturalOrder())

        with(arrayData("ac", "aD", "aba") { toList().toTypedArray() }) {
            checkSorted<List<String>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<Array<String>>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        with(arrayData("ac", "aD", "aba") { toList().toTypedArray() as Array<out String> }) {
            checkSorted<List<String>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<Array<out String>>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        with(arrayData(3, 7, 1) { toIntArray() }) {
            checkSorted<List<Int>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<IntArray>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        val longVals = longArrayOf(1L, Long.MIN_VALUE, Long.MAX_VALUE)
        System.out.println("longVals: " + java.util.Arrays.toString(longVals))
        val sortedLongs = longVals.sorted()
        System.out.println("Sorted long vals: "+sortedLongs)





        with(arrayData(1L, Long.MIN_VALUE, Long.MAX_VALUE) { toLongArray() }) {
            checkSorted<List<Long>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<LongArray>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        with(arrayData('a', 'D', 'c') { toCharArray() }) {
            checkSorted<List<Char>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<CharArray>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        with(arrayData(1.toByte(), Byte.MAX_VALUE, Byte.MIN_VALUE) { toByteArray() }) {
            checkSorted<List<Byte>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<ByteArray>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }

        with(arrayData(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, -Double.MAX_VALUE,
                1.0, -1.0, Double.MIN_VALUE, -Double.MIN_VALUE, 0.0, -0.0, Double.NaN) { toDoubleArray() }) {
            checkSorted<List<Double>>({ sorted() }, { sortedDescending() }, { iterator() })
            checkSorted<DoubleArray>({ sortedArray() }, { sortedArrayDescending() }, { iterator() })
        }
    }

    fun sortStable() {
        val keyRange = 'A'..'D'
        for (size in listOf(10, 100, 2000)) {
            val array = Array(size) { index -> Sortable(keyRange.random(), index) }

            array.sortedArray().assertStableSorted()
            array.sortedArrayDescending().assertStableSorted(descending = true)

            array.sort()
            array.assertStableSorted()
            array.sortDescending()
            array.assertStableSorted(descending = true)
        }
    }

    fun sortByInPlace() {
        val data = arrayOf("aa" to 20, "ab" to 3, "aa" to 3)
        data.sortBy { it.second }
        assertArrayNotSameButEquals(arrayOf("ab" to 3, "aa" to 3, "aa" to 20), data)

        data.sortBy { it.first }
        assertArrayNotSameButEquals(arrayOf("aa" to 3, "aa" to 20, "ab" to 3), data)

        data.sortByDescending { (it.first + it.second).length }
        assertArrayNotSameButEquals(arrayOf("aa" to 20, "aa" to 3, "ab" to 3), data)
    }

    fun sortedBy() {
        val values = arrayOf("ac", "aD", "aba")
        val indices = values.indices.toList().toIntArray()

        assertEquals(listOf(1, 2, 0), indices.sortedBy { values[it] })
    }

    fun sortByStable() {
        val keyRange = 'A'..'D'
        for (size in listOf(10, 100, 2000)) {
            val array = Array(size) { index -> Sortable(keyRange.random(), index) }

            array.sortedBy { it.key }.assertStableSorted()
            array.sortedByDescending { it.key }.assertStableSorted(descending = true)

            array.sortBy { it.key }
            array.assertStableSorted()

            array.sortByDescending { it.key }
            array.assertStableSorted(descending = true)
        }
    }

    fun sortedNullableBy() {
        fun String.nullIfEmpty() = if (this.isEmpty()) null else this
        arrayOf(null, "").let {
            expect(listOf(null, "")) { it.sortedWith(nullsFirst(compareBy { it })) }
            expect(listOf("", null)) { it.sortedWith(nullsLast(compareByDescending { it })) }
            expect(listOf("", null)) { it.sortedWith(nullsLast(compareByDescending { it.nullIfEmpty() })) }
        }
    }

    fun sortedWith() {
        val comparator = compareBy { it: Int -> it % 3 }.thenByDescending { it }
        fun <A, T> arrayData(array: A, comparator: Comparator<T>) = ArraySortedChecker<A, T>(array, comparator)

        arrayData(intArrayOf(0, 1, 2, 3, 4, 5), comparator)
                .checkSorted<List<Int>>({ sortedWith(comparator) }, { sortedWith(comparator.reversed()) }, { iterator() })

        arrayData(arrayOf(0, 1, 2, 3, 4, 5), comparator)
                .checkSorted<Array<out Int>>({ sortedArrayWith(comparator) }, { sortedArrayWith(comparator.reversed()) }, { iterator() })

        // in-place
        val array = Array(6) { it }
        array.sortWith(comparator)
        array.iterator().assertSorted { a, b -> comparator.compare(a, b) <= 0 }
    }


    fun elementAt() {
        expect(0) { byteArrayOf(0, 1, 2).elementAt(0) }
        expect(1) { shortArrayOf(0, 1, 2).elementAt(1) }
        expect(2) { intArrayOf(0, 1, 2).elementAt(2) }

        assertFailsWith<IndexOutOfBoundsException> { arrayOf<String>().elementAt(0) }
        assertFailsWith<IndexOutOfBoundsException> { longArrayOf(0, 1, 2).elementAt(-1) }
    }


    fun fill() {
        fun <A, E> testFailures(array: A, fill: A.(E, Int, Int) -> Unit, element: E, arraySize: Int) {
            assertFailsWith<IndexOutOfBoundsException> {
                array.fill(element, -1, arraySize)
            }
            assertFailsWith<IndexOutOfBoundsException> {
                array.fill(element, 0, arraySize + 1)
            }
            assertFailsWith<IllegalArgumentException> {
                array.fill(element, 1, 0)
            }
        }

        testFailures(BooleanArray(5) { it % 2 == 0 }, BooleanArray::fill, true, 5)
        testFailures(ByteArray(5) { it.toByte() }, ByteArray::fill, 0.toByte(), 5)
        testFailures(CharArray(5) { it.toChar() }, CharArray::fill, 0.toChar(), 5)
        testFailures(FloatArray(5) { it.toFloat() }, FloatArray::fill, 0.0f, 5)
        testFailures(DoubleArray(5) { it.toDouble() }, DoubleArray::fill, 0.0, 5)
        testFailures(ShortArray(5) { it.toShort() }, ShortArray::fill, 0.toShort(), 5)
        testFailures(IntArray(5) { it }, IntArray::fill, 0, 5)
        testFailures(LongArray(5) { it.toLong() }, LongArray::fill, 0L, 5)
        testFailures(Array(5) { it.toString() }, Array<String>::fill, "0", 5)

        fun <A, E> test(
                array: IntArray,
                fill: A.(E, Int, Int) -> Unit,
                operations: List<OperationOnRange<Int, IntArray>>,
                arrayTransform: IntArray.() -> A,
                elementTransform: Int.() -> E,
                contentEquals: A.(A) -> Boolean
        ) {
            for (o in operations) {
                val result = array.arrayTransform()
                result.fill(o.element.elementTransform(), o.fromIndex, o.toIndex)
                assertTrue(o.expectedResult.arrayTransform().contentEquals(result))
            }
        }

        val array = IntArray(5) { it }

        val operations = listOf(
                OperationOnRange(5, 1, 4, intArrayOf(0, 5, 5, 5, 4)),
                OperationOnRange(1, 0, 5, intArrayOf(1, 1, 1, 1, 1)),
                OperationOnRange(2, 0, 3, intArrayOf(2, 2, 2, 3, 4)),
                OperationOnRange(3, 2, 5, intArrayOf(0, 1, 3, 3, 3))
        )

        test(array, BooleanArray::fill, operations, IntArray::toBooleanArray, { this % 2 == 0 }, BooleanArray::contentEquals)
        test(array, ByteArray::fill, operations, IntArray::toByteArray, Int::toByte, ByteArray::contentEquals)
        test(array, CharArray::fill, operations, IntArray::toCharArray, Int::toChar, CharArray::contentEquals)
        test(array, FloatArray::fill, operations, IntArray::toFloatArray, Int::toFloat, FloatArray::contentEquals)
        test(array, DoubleArray::fill, operations, IntArray::toDoubleArray, Int::toDouble, DoubleArray::contentEquals)
        test(array, ShortArray::fill, operations, IntArray::toShortArray, Int::toShort, ShortArray::contentEquals)
        test(array, IntArray::fill, operations, IntArray::copyOf, { this }, IntArray::contentEquals)
        test(array, LongArray::fill, operations, IntArray::toLongArray, Int::toLong, LongArray::contentEquals)
        test(array, Array<String>::fill, operations, IntArray::toStringArray, Int::toString, { contentEquals(it) })
    }

    private class OperationOnRange<E, R>(
            val element: E,
            val fromIndex: Int,
            val toIndex: Int,
            val expectedResult: R
    )
}

private fun IntArray.toBooleanArray() = BooleanArray(size) { get(it) % 2 == 0 }
private fun IntArray.toByteArray() = ByteArray(size) { get(it).toByte() }
private fun IntArray.toCharArray() = CharArray(size) { get(it).toChar() }
private fun IntArray.toFloatArray() = FloatArray(size) { get(it).toFloat() }
private fun IntArray.toDoubleArray() = DoubleArray(size) { get(it).toDouble() }
private fun IntArray.toShortArray() = ShortArray(size) { get(it).toShort() }
private fun IntArray.toLongArray() = LongArray(size) { get(it).toLong() }
private fun IntArray.toStringArray() = Array(size) { get(it).toString() }


fun <K : Comparable<K>> Array<out Comparable<K>>.assertStableSorted(descending: Boolean = false) {
    var last: Comparable<K>? = null
    for (next in this) {
        if (last == null) {
            last = next
        } else {
            val result = last.compareTo(next as K)
            if (descending) {
                TestUtils.assertTrue(result >= 0)
            } else {
                TestUtils.assertTrue(result <= 0)
            }

        }

    }

}


private class ArraySortedChecker<A, T>(val array: A, val comparator: Comparator<in T>) {
    public fun <R> checkSorted(sorted: A.() -> R, sortedDescending: A.() -> R, iterator: R.() -> Iterator<T>) {
        array.sorted().iterator().assertSorted { a, b -> comparator.compare(a, b) <= 0 }
        array.sortedDescending().iterator().assertSorted { a, b -> comparator.compare(a, b) >= 0 }
    }
}

fun <T> Iterable<T>.assertSorted(isInOrder: (T, T) -> Boolean) {
    this.iterator().assertSorted(isInOrder)
}

fun <T> Iterator<T>.assertSorted(isInOrder: (T, T) -> Boolean) {
    if (!hasNext()) return
    var index = 0
    var prev = next()
    while (hasNext()) {
        index += 1
        val next = next()
        assertTrue(isInOrder(prev, next), "Not in order at position $index, element[${index - 1}]: $prev, element[$index]: $next")
        prev = next
    }
    return
}

data class Sortable<K : Comparable<K>>(val key: K, val index: Int) : Comparable<Sortable<K>> {
    override fun compareTo(other: Sortable<K>): Int = this.key.compareTo(other.key)
}

fun <K : Comparable<K>> Iterator<Sortable<K>>.assertStableSorted(descending: Boolean = false) {
    assertSorted { a, b ->
        val relation = a.key.compareTo(b.key)
        (if (descending) relation > 0 else relation < 0) || relation == 0 && a.index < b.index
    }
}

fun <K : Comparable<K>> Iterable<Sortable<K>>.assertStableSorted(descending: Boolean = false) =
        iterator().assertStableSorted(descending = descending)
