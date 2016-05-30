/*
 * Separator
 *
 * Version 1
 */
package textmanager.structure;

/**
 * Provides a punctuation marks 
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class Separator extends LanguageUnit {

    /**
     * Class constructor specifying text value 
     * 
     * @param value 
     */
    public Separator( String value ) {
        this.value = value;
        isSeparator = true;
    }
    
    /**
     * Returns true if the separator marks the end of the sentence
     * 
     * @return 
     */
    public boolean isEndOfTheSentence() {
        boolean res = value.matches( "[.!?]" );
        return res;
    }
}
