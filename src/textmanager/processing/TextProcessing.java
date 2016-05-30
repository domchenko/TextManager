/*
 * TextProcessor
 *
 * Version 1
 */
package textmanager.processing;

import textmanager.structure.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides functions for changing some text
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class TextProcessing {
    private final BookLoader dataLoader;  // delivers functions for loading text 
    private final BookSaver dataSaver;    // delivers functions for saving text 
    protected String error = "";    // the message
    
    /**
     * Default class constructor
     * 
     */
    public TextProcessing() {
        dataLoader = new BookLoader();
        dataSaver = new BookSaver();
    }
    
    /**
     * Allows to load text from the file
     * 
     * @param filePath  file path
     * @return 
     */
    public Text load( String filePath ) {
        Text text = new Text();
        
        if ( dataLoader.loadFile( filePath ) ) {
            String content = dataLoader.getContent();
            Matcher matcher = Pattern.compile( 
                    "[а-яА-Я\\w]+|[-().,;:?!\\s]" ).matcher( content );
            while ( matcher.find() ) {
                text.addString( matcher.group() );
            }
        }
        else {
            error = dataLoader.getError();
            text = null;
        }
        return text;
    }    
    
    /**
     * Allows to save data into the file
     * 
     * @param text      changed text
     * @param filePath  file path
     * @return 
     */
    public boolean save( Text text, String filePath ) {
        boolean b = true;
        if ( !dataSaver.save( text, filePath ) ) {
            error = dataLoader.getError();
            b = false;
        }
        return b;
    }
}
