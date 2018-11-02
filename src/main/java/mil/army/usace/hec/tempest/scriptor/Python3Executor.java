package mil.army.usace.hec.tempest.scriptor;

import java.io.IOException;

public class Python3Executor implements ScriptExecutor {

    private static final String pyPath = "C:\\Users\\q0hecgsk\\AppData\\Local\\Continuum\\Anaconda3\\pythonw.exe";

    @Override
    public void executeScript(ScriptContainer script) {
        try {
            Process process = new ProcessBuilder(pyPath, script.filePath()).start();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
