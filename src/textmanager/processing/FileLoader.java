/*
 * FileLoader
 *
 * Version 1
 */
package textmanager.processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Provides loading input data from the text file
 * 
 * @author Tanya Domchenko
 * @version 1, 05 May 2016
 */
public class FileLoader {
    protected String content = "";  // the file content
    protected String error = "";    // the message
    
    /**
     * Loads a text from the file
     * 
     * @param filePath  // path of the file
     * @return 
     */
    public boolean loadFile( String filePath ) {
        boolean res = false;
        content = "";
        error = "";
        
        FileInputStream fs = null;
        BufferedReader buff = null;
        try {
            fs = new FileInputStream( filePath );
            buff = new BufferedReader( new InputStreamReader( fs, "cp1251" ) );
            String line;
            while ( ( line = buff.readLine() ) != null ) {
                content += line;
            }
            res = !content.isEmpty();
            if ( !res ) {
                error = "File is empty";
            }
        } catch (IOException ex) {
            content = "";
            error = ex.getMessage();
        } finally {
            if ( buff != null ) {
                try {
                    buff.close();
                } catch (IOException ex) {
                }        
            }
            if ( fs != null ) {
                try {
                    fs.close();
                } catch (IOException ex) {
                }
            }
        }
        return res;
    }
    
    /**
     * Returns the file contents
     * 
     * @return 
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Returns the message if error had occurred during the file loading
     * 
     * @return 
     */
    public String getError() {
        return error;
    }
    
}
