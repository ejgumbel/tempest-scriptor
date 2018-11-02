package mil.army.usace.hec.tempest.scriptor;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ExecutionContextTest {

    private class simpleContainer implements ScriptContainer {

        private static final String py3Script = "C:\\Users\\q0hecgsk\\IdeaProjects\\tempest_scriptor\\src\\main\\python\\test.py";
        private static final String rScript =  "C:\\Users\\q0hecgsk\\IdeaProjects\\tempest_scriptor\\src\\main\\R\\test.R";
        private String selectedScript;

        simpleContainer(String scriptLanguage) {
            Objects.requireNonNull(scriptLanguage, "Language selection cannot be null.");
            switch (scriptLanguage) {
                case "R":
                    selectedScript = rScript;
                    break;
                case "Python3":
                    selectedScript = py3Script;
                    break;
                default:
                    throw new RuntimeException("That language cannot be selected.");
            }
        }

        @Override
        public String filePath() {
            return selectedScript;
        }
    }

    @Test
    void testExecutionOfRScript() throws InterruptedException {
        ScriptContainer sc = new simpleContainer("R");
        ExecutionContext exec = new ExecutionContext();
        exec.setExecutor(new RExecutor());
        exec.execute(sc);
        Thread.sleep(1000); //The file write is slow enough that checking happens too fast

        File f = new File("C:\\Users\\q0hecgsk\\Desktop\\Boneyard.csv");
        assertTrue(f.exists());
    }

    @Test
    void testExecutionOfPythonScript() throws InterruptedException {
        ScriptContainer sc = new simpleContainer("Python3");
        ExecutionContext exec = new ExecutionContext();
        exec.setExecutor(new Python3Executor());
        exec.execute(sc);
        Thread.sleep(1000); //The file write is slow enough that checking happens too fast

        File f = new File("C:\\Users\\q0hecgsk\\Desktop\\touch.txt");
        assertTrue(f.exists());
    }

}