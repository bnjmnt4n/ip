package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws Exception;
    public abstract boolean shouldExit();
}
