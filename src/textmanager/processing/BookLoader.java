/*
 * BookLoader
 *
 * Version 1
 */
package textmanager.processing;

/**
 * Provides pre-processing text data
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class BookLoader extends FileLoader {

    /**
     * Returns the text without an unnecessary whitespace
     * 
     * @return 
     */
    @Override
    public String getContent() {
        return content.replaceAll( "[\\s]+", " " );
    }
}
