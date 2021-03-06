package uk.ac.manchester.cs.owl.semspreadsheets.ui;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Author: Matthew Horridge<br>
 * The University of Manchester<br>
 * Information Management Group<br>
 * Date: 03-Feb-2010
 */
public class UILabels {
	
	private static Logger logger = Logger.getLogger(UILabels.class);

    private static UILabels instance = new UILabels();

    public static final String FREE_TEXT = "ui.label.freetext";

    public static final String FREE_TEXT_PROPERTY_DEFAULT_VALUE = "Free text";

    public static final String SUBCLASSES_PROPERTY = "ui.label.subclasses";

    public static final String SUBCLASSES_PROPERTY_DEFAULT_VALUE = "Subclasses";

    public static final String DIRECT_SUBCLASSES_PROPERTY = "ui.label.directsubclasses";

    public static final String DIRECT_SUBCLASSES_PROPERTY_DEFAULT_VALUE = "Direct subclasses";

    public static final String INSTANCES_PROPERTY = "ui.label.instances";

    public static final String INSTANCES_PROPERTY_DEFAULT_VALUE = "Instances";

    public static final String DIRECT_INSTANCES_PROPERTY = "ui.label.directinstances";

    public static final String DIRECT_INSTANCES_PROPERTY_DEFAULT_VALUE = "Direct instances";

    private Properties properties = null;

    private UILabels() {
        try {
            properties = new Properties();
            URL url = UILabels.class.getResource("/ui.properties");
            if (url != null) {
                BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
                properties.load(inputStream);
            }
            else {
                logger.error("Could not load UI properties file: Could not find file.");
            }
        }
        catch (IOException e) {
            ErrorHandler.getErrorHandler().handleError(e);
        }
    }

    public static UILabels getInstance() {
        return instance;
    }

    public String getFreeTextLabel() {
        return properties.getProperty(FREE_TEXT, FREE_TEXT_PROPERTY_DEFAULT_VALUE);
    }

    public String getSubClassesLabel() {
        return properties.getProperty(SUBCLASSES_PROPERTY, SUBCLASSES_PROPERTY_DEFAULT_VALUE);
    }

    public String getDirectSubClassesLabel() {
        return properties.getProperty(DIRECT_SUBCLASSES_PROPERTY, DIRECT_SUBCLASSES_PROPERTY_DEFAULT_VALUE);
    }

    public String getInstancesLabel() {
        return properties.getProperty(INSTANCES_PROPERTY, INSTANCES_PROPERTY_DEFAULT_VALUE);
    }

    public String getDirectInstancesLabel() {
        return properties.getProperty(DIRECT_INSTANCES_PROPERTY, DIRECT_INSTANCES_PROPERTY_DEFAULT_VALUE);
    }
}
