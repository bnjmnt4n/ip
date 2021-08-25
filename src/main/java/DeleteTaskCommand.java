public class DeleteTaskCommand extends Command {
    private String arguments;

    public DeleteTaskCommand(String arguments) throws Exception {
        if (arguments.length() == 0) {
            throw new Exception("Command `done` requires an arguments");
        }
        this.arguments = arguments;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        Task task;
        try {
            int taskIndex = Integer.parseInt(arguments);
            task = taskList.removeTask(taskIndex - 1);
        } catch (NumberFormatException e) {
            throw new Exception("Unable to parse number from arguments: " + arguments);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("There is no task with the following number: " + arguments);
        }

        storage.saveTasks(taskList);
        ui.printMessage("Removed the following task:\n    " + task.toString() + "\n" + "You now have "
                + taskList.size() + " tasks in your list.");
    }

    public boolean shouldExit() {
        return false;
    }
}
