package ru.job4j.tracker;

public class StartUI {
    private final Output out;
    private final Input input;
    private final Tracker tracker;
    private final UserAction[] actions;

    public StartUI(Output out, Input input, Tracker tracker, UserAction[] actions) {
        this.out = out;
        this.input = input;
        this.tracker = tracker;
        this.actions = actions;
        init();
    }

    public void init() {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                    continue;
            }
                UserAction action = actions[select];
                run = action.execute(input, tracker, out);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllItem(), new EditItem(),
                                new DeleteItem(), new FindById(),
                                new FindByName(), new ExitAction()};
        new StartUI(output, input, tracker, actions);
    }
}