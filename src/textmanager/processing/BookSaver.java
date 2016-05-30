/*
 * BookSaver
 *
 * Version 1
 */
package textmanager.processing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import textmanager.structure.LanguageUnit;
import textmanager.structure.Text;

/**
 * Provides the saving modified data to the file
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class BookSaver {
    protected String error = "";    // the message

    /**
     * Saves the text into the text file 
     * 
     * @param text      text to save
     * @param filePath  file path
     * @return 
     */
    public boolean save( Text text, String filePath ) {
        boolean res = true;
        error = "";
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter( new FileWriter( filePath ) );
            for ( LanguageUnit p: text.getParts() ) {
                buff.write( p.getValue() );
            }
            res = true;
        } catch (IOException ex) {
            error = ex.getMessage();
        } finally {
            if ( buff != null ) {
                try {
                    buff.close();
                } catch (IOException ex) {
                }        
            }
        }
        return res;
    }
    
    /**
     * Returns the message if error had occurred during the file saving
     * 
     * @return 
     */
    public String getError() {
        return error;
    }
}