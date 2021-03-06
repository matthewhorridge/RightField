package uk.ac.manchester.cs.owl.semspreadsheets.model;

import uk.ac.manchester.cs.owl.semspreadsheets.change.WorkbookChange;

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 10-Nov-2009
 */
public interface MutableWorkbook extends Workbook {

    void applyChange(WorkbookChange change);

}
