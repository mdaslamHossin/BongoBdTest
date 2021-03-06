# Bongo's Android Developer Position Assigment 
## Problem 
Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are
anagrams but ‘eat’ and ‘tar’ are not

#### Task
    -Write a function for checking two string are anagram.
    -Run function
    -Write Unit test of anagram function.

#### Write a function for checking two string are anagram.
~~~kotlin
private fun areAnagrams(one: String, two: String): Boolean {
    val map = HashMap<Char, Int>()

    for (c in one.toCharArray())
        if (map.containsKey(c))
            map[c] = map[c]!! + 1
        else
            map[c] = 1

    for (c in two.toCharArray())
        if (!map.containsKey(c))
            return false
        else {
            map[c] = map[c]!! - 1

            if (map[c] == 0)
                map.remove(c)
        }
    return map.isEmpty()
}
~~~~

#### Run function

~~~kotlin
fun main() {
    val firstString = "table"
    val secondString = "bleat"
    println("Are anagrams: ${areAnagrams(firstString, secondString)}")
}
~~~

#### Write Unit test of anagram function.
~~~kotlin

class AnagramTest {
    @Test
    fun areAnagrams() {
        assertTrue(Anagram().areAnagrams("bleat", "table"))

    }

    @Test
    fun notAnagrams() {
        assertFalse(Anagram().areAnagrams("eat", "tar"))

    }

}
~~~