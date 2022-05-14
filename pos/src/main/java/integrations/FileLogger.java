package integrations;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Prints log messages to a file.
 * The log file will be called "log.txt" and will be saved to desctop.
 * @author Hjalmar
 */
public class FileLogger {
    private PrintWriter logStream;
    private LocalTime logTime;
    
    /**
     * Creates a new instance of FileLogger.
     * Also creates new log file.
     * @param fileLocationAndName represents the .txt file and the location it's printed to.
     */
    public FileLogger(String fileLocationAndName){
        try{
            FileWriter fileWriter = new FileWriter(fileLocationAndName);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            this.logStream = printWriter;
            System.out.println("File successfully printed to desktop");
        }catch(IOException ioe){
            System.out.println("Can't log exceptions");
        }
    }
    
    /**
     * Prints the logMessage to the log file.
     * @param logMessage represents the string that will be printed into the file. 
     */
    public void log(String logType, String logMessage){
        logStream.println(logTime.now()+" - "+ logType + logMessage);
    }
    
}
