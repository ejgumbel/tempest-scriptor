package mil.army.usace.hec.tempest.scriptor;

import java.io.IOException;

public class RExecutor implements ScriptExecutor {

    private static final String rPath = "C:\\Program Files\\R\\R-3.4.1\\bin\\Rscript.exe";

    @Override
    public void executeScript(ScriptContainer script) {
        try {
            Process process = new ProcessBuilder(rPath, script.filePath()).start();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
