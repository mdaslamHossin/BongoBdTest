fun main() {
    val firstString = "table"
    val secondString = "bleat"
    println("Are anagrams: ${Anagram().areAnagrams(firstString, secondString)}")
}
class Anagram {
     fun areAnagrams(one: String, two: String?): Boolean {
        val map = HashMap<Char, Int>()

        for (c in one.toCharArray())
            if (map.containsKey(c))
                map[c] = map[c]!! + 1
            else
                map[c] = 1

        for (c in two?.toCharArray()!!)
            if (!map.containsKey(c))
                return false
            else {
                map[c] = map[c]!! - 1

                if (map[c] == 0)
                    map.remove(c)
            }
        return map.isEmpty()
    }
}
