package uk.ac.manchester.cs.owl.semspreadsheets.ui;

import org.semanticweb.owlapi.io.OWLOntologyCreationIOException;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import javax.swing.*;
import java.io.IOException;
import java.net.UnknownHostException;
/*
 * Copyright (C) 2009, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 07-Nov-2009
 */
public class ErrorHandler {

    private static ErrorHandler instance = new ErrorHandler();

    private ErrorHandler() {
    }

    public static ErrorHandler getErrorHandler() {
        return instance;
    }

    public void handleError(Throwable throwable) {
        if(throwable instanceof OWLOntologyCreationException) {
            if(throwable instanceof OWLOntologyCreationIOException) {
                OWLOntologyCreationIOException e = (OWLOntologyCreationIOException) throwable;
                JOptionPane.showMessageDialog(null, e.getCause().getMessage(), "Could not load ontology", JOptionPane.ERROR_MESSAGE);
            }
            else if(throwable instanceof UnparsableOntologyException) {
                JOptionPane.showMessageDialog(null, "The ontology document appears to be an unsupported format or contains syntax errors", "Could not load ontology", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, throwable.getMessage(), "Could not load ontology", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if(throwable instanceof UnknownHostException) {
            JOptionPane.showMessageDialog(null, "You are not connected to the internet.  Please check your network connection.", "Not connected to network", JOptionPane.ERROR_MESSAGE);
        }
        else if (throwable instanceof IOException) {
            JOptionPane.showMessageDialog(null, throwable.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        throwable.printStackTrace();
    }
}