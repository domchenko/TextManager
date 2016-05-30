/*
 * Word
 *
 * Version 1
 */
package textmanager.structure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides the words - the parts of the sentences
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class Word extends LanguageUnit {
            
    /**
     * Class constructor specifying text value
     * 
     * @param value 
     */
    public Word( String value ) {
        this.value = value;
        isSeparator = false;
    }
    
    /**
     * Returns length of this word
     * 
     * @return 
     */
    public int length() {
        return value.length();
    }
    
    /**
     * Counts vowel letters in this word (supports UA, RU and EN languages)
     * 
     * @return 
     */
    public int getVowelCount() {
        int count = 0;
        Matcher matcher = Pattern.compile( 
            "[" + VOWELS + "]" ).matcher( value );
        while ( matcher.find() ) {
            count++;
        }
        return count;
    }
    
    /**
     * Checks whether the word starts with an any vowel letter
     * 
     * @return 
     */
    public boolean startWithVowel() {
        Matcher matcher = Pattern.compile( 
            "[" + VOWELS + "]" ).matcher( value );
        if ( matcher.lookingAt() ) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getFirstConsonantPos() {
        Matcher matcher = Pattern.compile( 
            "[" + CONSONANTS + "]" ).matcher( value );
        if ( matcher.find() ) {
            int pos = matcher.start();
            return pos;
        }
        else {
            return -1;
        }
    }
}
