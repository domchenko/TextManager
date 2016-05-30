package textmanager.main;

import textmanager.modifiers.SortingWordsByFirstConsonants;
import textmanager.modifiers.TextModifier;
import textmanager.processing.TextProcessing;
import textmanager.structure.Text;

/**
 *
 * @author Tanya Domchenko
 */
public class TextManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextProcessing tp = new TextProcessing();
        
        Text t1 = tp.load( "resources\\AlgorithmsBook.txt" );
        System.out.println( t1.toString() );
        
        TextModifier modifier =  new SortingWordsByFirstConsonants();
        Text t2 = modifier.processText( t1 );    
        System.out.println( t2.toString() );
        
        tp.save( t2, "resources\\AlgorithmsBook_Output.txt" );        
    }
    
}
