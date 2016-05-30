/*
 * Text
 *
 * Version 1
 */
package textmanager.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a construction that contains sentences
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class Text {
    protected List<Sentence> sentences = new ArrayList<>(); // parts of the text
    
    /**
     * Default class constructor
     */
    public Text() {
    }    
    
    /**
     * Adds a new sentence
     * 
     * @param s
     */
    public void addSentence( Sentence s ){
        if ( !sentences.contains( s ) ) {
            sentences.add( s );
        }
    }
    
    /**
     * Removes the sentence from the text
     * 
     * @param s 
     */
    public void removeSentence( Sentence s ) {
        sentences.remove( s );
    }

    /**
     * Returns all sentences in the text
     * 
     * @return List of sentence
     */
    public List<Sentence> getSentences() {
        return sentences;
    }
    
    /**
     * Adds a word or delimiter into the text
     * The language unit was automatically included in the last sentence 
     * or new sentence if the last one has ending delimiter
     * 
     * @param str   text
     */
    public void addString( String str ) {
        if ( str.isEmpty() ) {
            return;
        }
        Sentence s;
        if ( sentences.isEmpty() ) {
            s = new Sentence();
            sentences.add( s );
        }
        else {
            s = sentences.get( sentences.size() - 1 );
        }
        if ( !s.addString( str ) ) {
            s = new Sentence();
            sentences.add( s );
            s.addString( str );
        }
    }
    
    /**
     * Returns copies of the words that exist in this text
     * 
     * @return 
     */
    public List<Word> getWords() {
        List<Word> w = new ArrayList<>();
        for ( Sentence s: sentences ) {
            for ( LanguageUnit p: s.getParts() ) {
                if ( !p.isSeparator ) {
                    Word copy;
                    try {
                        copy = (Word) p.clone();
                        w.add( copy );
                    } catch (CloneNotSupportedException ex) {
                    }
                }
            }
        }
        return w;
    }
    
    /**
     * Returns a copy of the all text parts
     * 
     * @return 
     */
    public List<LanguageUnit> getParts() {
        List<LanguageUnit> lu = new ArrayList<>();
        for ( Sentence s: sentences ) {
            for ( LanguageUnit p: s.getParts() ) {
                try {
                    lu.add( (LanguageUnit) p.clone() );
                } catch (CloneNotSupportedException ex) {
                }
            }
        }
        return lu;
    }

    @Override
    public String toString() {
        String str = "";
        for ( Sentence s: sentences ) {
            str += s;
            if ( !str.endsWith( "\n" ) ) {
                str += "\n";
            }
        }
        return str;
    }
    
}