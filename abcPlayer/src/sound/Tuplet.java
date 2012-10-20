package sound;

import java.util.ArrayList;
import java.util.List;

public class Tuplet implements Playable 
{
    private final TupletType type; 
    private final List<Note> notes; 
    
    public Tuplet(TupletType type, List<Note> notes)
    {
        this.type = type; 
        this.notes = new ArrayList<Note>(notes);
    }
    
    public List<Note> getNotes()
    {
        return new ArrayList<Note>();
    }
    
    public TupletType getType()
    {
        return type; 
    }
}