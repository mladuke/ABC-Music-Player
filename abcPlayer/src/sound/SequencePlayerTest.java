package sound;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

public class SequencePlayerTest {

	@Test
	public void testSamplePiece1() {
		SequencePlayer player;
		
		try {
			
			player = new SequencePlayer(140, 12);
			
			// New measure 
			
	        player.addNote(new Pitch('C').toMidiNote(), 0, 12);
	        player.addNote(new Pitch('C').toMidiNote(), 12, 12);
	        player.addNote(new Pitch('C').toMidiNote(), 24, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 33, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 36, 12);
	        
	        // New measure
	        
	        player.addNote(new Pitch('E').toMidiNote(), 48, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 57, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 60, 9);
	        player.addNote(new Pitch('F').toMidiNote(), 69, 3);
	        player.addNote(new Pitch('G').toMidiNote(), 72, 24);
	        
	        // New measure
	        
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 4);
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 100, 4);
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 104, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 108, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 112, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 116, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 120, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 124, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 128, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 132, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 136, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 140, 4);
	        
	        // New measure
	        
	        player.addNote(new Pitch('G').toMidiNote(), 144, 9);
	        player.addNote(new Pitch('F').toMidiNote(), 153, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 156, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 165, 3);
	        player.addNote(new Pitch('C').toMidiNote(), 168, 24);

	        System.out.println(player);
	        
	        ABCFileReader file_reader = new ABCFileReader("sample_abc/piece1.abc");
	        try {
	            String content = file_reader.readContent();
	            
	            Lexer newLexer = new Lexer(content);
	            Parser parser = new Parser(newLexer);
	            
	            Piece pieceToPlay = parser.Parse(); 
	            try {
	                String piece = pieceToPlay.play().toString();
	                assertEquals(piece,player.toString());
	            } catch (MidiUnavailableException e) {
	                e.printStackTrace();
	            } catch (InvalidMidiDataException e) {
	                e.printStackTrace();
	            } 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
		} catch (MidiUnavailableException e) {
            fail(e.toString());
        } catch (InvalidMidiDataException e) {
            fail(e.toString());
        }
	}
	
	@Test
    public void testSamplePiece2() {
        SequencePlayer player;
        try {
            
            player = new SequencePlayer(200, 12);
            
            // New measure
            
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 0, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 0, 6);
            player.addNote(new Pitch('F').toMidiNote(), 6, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 6, 6);
            // Rest
            player.addNote(new Pitch('F').toMidiNote(), 18, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 18, 6);
            // Rest
            player.addNote(new Pitch('F').toMidiNote(), 30, 6);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 30, 6);
            player.addNote(new Pitch('F').toMidiNote(), 36, 12);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 36, 12);
            
            // New Measure
            
            player.addNote(new Pitch('G').toMidiNote(), 48, 12);
            player.addNote(new Pitch('B').toMidiNote(), 48, 12);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 48, 12);
            // Rest
            player.addNote(new Pitch('G').toMidiNote(), 72, 12);
            // Rest
            
            // New Measure
            
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 18);          
            player.addNote(new Pitch('G').toMidiNote(), 114, 6);
            //Rest
            player.addNote(new Pitch('E').toMidiNote(), 132, 12);
                  
            // New Measure
            
            player.addNote(new Pitch('E').toMidiNote(), 144, 6);
            player.addNote(new Pitch('A').toMidiNote(), 150, 12);
            player.addNote(new Pitch('B').toMidiNote(), 162, 12);
            player.addNote(new Pitch('B').transpose(-1).toMidiNote(), 174, 6);
            player.addNote(new Pitch('A').toMidiNote(), 180, 12);
                       
            // New Measure
            
            player.addNote(new Pitch('G').toMidiNote(), 192, 8);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 200, 8);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 208, 8);
            player.addNote(new Pitch('A').transpose(Pitch.OCTAVE).toMidiNote(), 216, 12);
            player.addNote(new Pitch('F').transpose(Pitch.OCTAVE).toMidiNote(), 228, 6);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 234, 6);
            
            // New Measure
            
            // Rest
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 246, 12);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 258, 6);
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(), 264, 6);
            player.addNote(new Pitch('B').toMidiNote(), 270, 9);
            // Rest

            //System.out.println(player);
            
            player.play();
            
        } catch (MidiUnavailableException e) {
            fail(e.toString());
        } catch (InvalidMidiDataException e) {
            fail(e.toString());
        }
    }

}
