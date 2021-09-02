package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.ui.Ui;
import duke.task.Task;

public class FilterTasksCommand extends Command {
    private String searchInput;

    /**
     * Creates a command that filters a user's tasklist by the search string.
     *
     * @param arguments Command arguments.
     */
    public FilterTasksCommand(String arguments) throws Exception {
        if (arguments.length() == 0) {
            throw new Exception("Command `find` requires an argument");
        }
        this.searchInput = arguments;
    }

    /**
     * Filters a user's tasklist.
     *
     * @param taskList The tasklist.
     * @param ui The instance of the {@link Ui} class.
     * @param storage The instance of the {@link Storage} class.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        TaskList filteredTaskList = taskList.filterTasks(searchInput);

        StringBuilder builder = new StringBuilder();
        int numTasks = filteredTaskList.size();

        if (numTasks == 0) {
            ui.printMessage("Couldn't find any tasks matchin: " + searchInput);
        } else {
            builder.append("Here are the matching tasks:\n");

            for (int i = 0; i < numTasks; i++) {
                Task item = filteredTaskList.getTask(i);
                builder.append(i + 1)
                        .append(". ")
                        .append(item.toString());
                if (i < numTasks - 1) {
                    builder.append("\n");
                }
            }

            ui.printMessage(builder.toString());
        }
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
