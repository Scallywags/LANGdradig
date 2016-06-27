package scallywags.langdradig.ide.features.finished;

import javax.swing.event.DocumentEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

/**
 * Created by Jeroen Weener on 27/06/2016.
 */
public class IDEUndoManager extends UndoManager {
    public synchronized boolean addEdit(UndoableEdit anEdit)
    {
        if (anEdit instanceof AbstractDocument.DefaultDocumentEvent)
        {
            AbstractDocument.DefaultDocumentEvent de =
                    (AbstractDocument.DefaultDocumentEvent)anEdit;
            if (de.getType() == DocumentEvent.EventType.CHANGE )
            {
                return false;
            }
        }
        return super.addEdit(anEdit);
    }
}
