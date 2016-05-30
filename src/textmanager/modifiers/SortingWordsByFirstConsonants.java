/*
 * SortingWordsByFirstConsonants
 *
 * Version 1
 */
package textmanager.modifiers;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import textmanager.structure.LanguageUnit;
import textmanager.structure.Sentence;
import textmanager.structure.Text;
import textmanager.structure.Word;

/**
 * Sorting words that starts with vowel by the first consonant letter
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class SortingWordsByFirstConsonants implements TextModifier {

    /**
     * Comparator for sorting words by the first consonant letter after vowels
     */
    static class FirstConsonantComparator implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            int pos1 = o1.getFirstConsonantPos();
            int pos2 = o2.getFirstConsonantPos();
            if ( pos1 < 0 ) {
                return -1;
            }
            else {
                if ( pos2 < 0 ) {
                    return 1;
                }
                else {
                    Character c1 = o1.getValue().charAt( pos1 );
                    Character c2 = o2.getValue().charAt( pos2 );
                    return c1.compareTo( c2 );
                }
            }
        }
    }
    
    /**
     * Sorts words in the text <code>inputData</code> by the vowel letters proportion
     * 
     * @param inputData text
     * @return          sorted words 
     */
    @Override
    public Text processText(Text inputData) {
        Text t = new Text();
        
        Comparator<Word> comparator = new FirstConsonantComparator();
        List<Word> w = inputData.getWords();
        w.sort( comparator );
        
        for ( ListIterator<Word> iterator = w.listIterator(); iterator.hasNext(); ) {
            if ( !iterator.next().startWithVowel() ) {
                iterator.remove();
            }
        }
        
        for ( LanguageUnit p: w ) {
            t.addString( p.getValue() + "\n" );
            t.addSentence( new Sentence() );
        }
        return t;
    }
}
