import static org.junit.jupiter.api.Assertions. *;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void test() {
		
		SpellChecker checker = new SpellChecker();

		int words = checker.getNumberOfWords();

		assertEquals(0, words);
	}


	@Test

	void testAddWord()
	{
		SpellChecker checker = new SpellChecker();
		checker.addWord("hello");

		assertEquals(1, checker.getNumberOfWords());
	}

	@Test

	void
	testAddDuplicateWord()
	{
		SpellChecker checker = new SpellChecker();
		checker.addWord("hat");
		checker.addWord("hat");

		assertEquals(1, checker.getNumberOfWords());
	}

   // 4) properly spelled word would return true
    @Test
    void testSpellingReturnTrue()
    {
        SpellChecker checker = new SpellChecker();
        checker.addWord("horse");
        assertTrue(checker.isWordSpelledCorrectly("horse"));
    }

    // 5) improperly spelled  word should return us false
    @Test
    void incorrectspellingreturnfalse()
    {
        SpellChecker checker = new SpellChecker();
        checker.addWord("table");
        assertFalse(checker.isWordSpelledCorrectly("cable"));
    }


	@Test

    // 6)this fucntion  ignores case
    @Test
    void ignoreCaseSpellingChecker()
    {
        SpellChecker checker = new SpellChecker();
        checker.addWord("cat");
        assertTrue(checker.isWordSpelledCorrectly("CaT"));
    }

//7
	@Test

	void closestWordSuggester()
	{
    
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank");
        assertEquals("bank", checker.suggestWord("bamk"));
    }

//8	
	@Test
    void ifCorrectOutputAlreadyCorrect()
    {
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank");
        assertEquals("bank", checker.suggestWord("bank"));
    }


	// New we are decreasing count if we remove something 
@Test

void removingWordDecreasesCount()
{
    SpellChecker checker = new SpellChecker();

    checker.addWord("cat");
    checker.addWord("dog");

    checker.removeWord("cat");

    assertEquals(1, checker.getNumberOfWords());
}

//here we wont add the word if it has space
@Test
void wordWithSpacesIsNotAdded()
{
    SpellChecker checker = new SpellChecker();

    checker.addWord("hello world");  

    assertEquals(0, checker.getNumberOfWords());
}
}



