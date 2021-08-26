package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class ByeCommand extends Command {
    public ByeCommand(String arguments) throws Exception {
        if (arguments.length() > 0) {
            throw new Exception("Command `bye` does not accept arguments");
        }
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
    }

    public boolean shouldExit() {
        return true;
    }
}
