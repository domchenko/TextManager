/*
 * LanguageUnit
 *
 * Version 1
 */
package textmanager.structure;

/**
 * Provides the separate unit of the language
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public abstract class LanguageUnit implements Comparable<LanguageUnit>, Cloneable {
    protected String value;         // text
    protected boolean isSeparator;  // a sign whether a text is a separator or not
    
    public static final String VOWELS = "euioaEUIOAуеыіаоэияюєУЕЫІАОЭИЯЮЄ";
    public static final String CONSONANTS = "BCDFGHJKLMNPQRSTVXZWYbcdfghjklmnpqrstvxzwyЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБйцкнгшщзхъфвпрлджчсмтьб";
    
    /**
     * Returns text value
     * 
     * @return value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * Checks whether string is a separator or not
     * 
     * @param str   text
     * @return      true if text is a separator, false - if it's not
     */
    public static boolean isSeparator( String str ) {
        boolean res;
        res = str.matches( "[.,;:-?)(\\s]" );
        return res;
    }
    
    /**
     * Checks whether string is a space symbol
     * 
     * @param str   text
     * @return 
     */
    public static boolean isWhiteSpace( String str ) {
        boolean res;
        res = str.matches( "[\\s]+" );
        return res;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    /**
     * Creates a copy
     * 
     * @return 
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        LanguageUnit clone;
        try {
            clone = (LanguageUnit) super.clone();
            clone.value = this.value;
            clone.isSeparator = this.isSeparator;
        } catch ( CloneNotSupportedException e ) {
            clone = null;
        }
        return clone;
    }    
    
    /**
     * The default comparison
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo( LanguageUnit o) {
        return value.compareToIgnoreCase( o.getValue() );
    }
}
