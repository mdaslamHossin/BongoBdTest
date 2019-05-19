import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

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