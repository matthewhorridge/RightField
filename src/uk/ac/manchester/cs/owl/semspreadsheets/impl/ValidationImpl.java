package uk.ac.manchester.cs.owl.semspreadsheets.impl;

import uk.ac.manchester.cs.owl.semspreadsheets.model.Range;
import uk.ac.manchester.cs.owl.semspreadsheets.model.Sheet;
import uk.ac.manchester.cs.owl.semspreadsheets.model.Validation;

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 18-Sep-2009
 */
public class ValidationImpl implements Validation {

    private String list;

    private Sheet sheet;

    private int fromColumn;

    private int toColumn;

    private int fromRow;

    private int toRow;

    public ValidationImpl(String list, Sheet sheet, int fromColumn, int toColumn, int fromRow, int toRow) {
        this.list = list;
        this.sheet = sheet;
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.fromRow = fromRow;
        this.toRow = toRow;
    }

    public Range getRange() {
        return new Range(sheet, fromColumn, fromRow, toColumn, toRow);
    }

    public Sheet getSheet() {
        return sheet;
    }

    public String getListName() {
        return list;
    }

    public int getFirstColumn() {
        return fromColumn;
    }

    public int getLastColumn() {
        return toColumn;
    }

    public int getFirstRow() {
        return fromRow;
    }

    public int getLastRow() {
        return toRow;
    }





    public boolean contains(int col, int row) {
        return fromColumn >= col && row <= toColumn && row >= fromRow && row <= toRow;
    }
}
