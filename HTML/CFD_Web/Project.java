package CFD_Web;

import java.io.File;
import java.sql.Array;
import java.util.List;

/**
 * Project
 */
public class Project {
    private String name;
    private String id;
    private Object model;
    private File filepath;
    private File outFile;
    private String[] options;
   
    public Project(String name, String id, Object model, File filepath, File outFile) {
        this.name = name;
        this.id = id;
        this.model = model;
        this.filepath = filepath;
        this.outFile = outFile;

        String[] tmp = {"Gravity", "Flow Strength", "Flow Direction"};
        this.options = tmp;
    }


    public Project(){}
    
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Object getModel() {
        return model;
    }
    public void setModel(Object model) {
        this.model = model;
    }
    public File getFilepath() {
        return filepath;
    }
    public void setFilepath(File filepath) {
        this.filepath = filepath;
    }
    public File getOutFile() {
        return outFile;
    }
    public void setOutFile(File outFile) {
        this.outFile = outFile;
    }
    public String[] getOptions() {
        return options;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    
}