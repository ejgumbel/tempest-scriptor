package mil.army.usace.hec.tempest.scriptor;

public class ExecutionContext {
    private ScriptExecutor executor;

    void setExecutor(ScriptExecutor executor) {
        this.executor = executor;
    }

    void execute(ScriptContainer script) {
        this.executor.executeScript(script);
    }
}
