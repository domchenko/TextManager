/*
 * Sentence
 *
 * Version 1
 */
package textmanager.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a grammatical construction that contains words and delimiters
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class Sentence {
    protected List<LanguageUnit> parts = new ArrayList<>(); // words and separators
    protected boolean isEnded = false;  // mark if sentence is ended
    
    /**
     * Returns true if the sentence has an ending delimiter, false - if it doesn't have
     * 
     * @return 
     */
    public boolean isEnded() {
        return isEnded;
    }
    
    /**
     * Returns all parts of this sentence - words and delimiters
     * 
     * @return
     */
    public List<LanguageUnit> getParts() {
        return parts;
    }
    
    /**
     * Adds a word or a delimiter into the sentence 
     * 
     * @param str   text value of the word or delimiter
     * @return 
     */
    public boolean addString( String str ) {
        // pass if the sentence has already an ending delimiter
        if ( isEnded && !LanguageUnit.isWhiteSpace( str ) ) {
            return false;
        }
        if ( LanguageUnit.isSeparator( str ) ) {
            Separator s = new Separator( str );
            parts.add( s );
            if ( !isEnded ) {
                isEnded = s.isEndOfTheSentence();
            }
        }
        else {
            Word w = new Word( str );
            parts.add( w );
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for ( LanguageUnit p: parts ) {
            str += p.toString();
        }
        return str;
    }

}