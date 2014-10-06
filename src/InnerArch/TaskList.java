package InnerArch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marat on 30.09.2014.
 */
public class TaskList {
    private List<Task> items = new ArrayList<Task>();

    public TaskList() {

    }

    public void Add(Action item)
    {
        items.add(item);
    }

    public void Add(Notify item)
    {
        items.add(item);
    }

    public void RemoveId(int index)
    {
        items.remove(index);
    }

    public Task getValue(int pos)
    {
        return items.get(pos);
    }

    public void setValue(int pos, Task value)
    {
        items.set(pos, value);
    }

    public int GetLength() { return items.size(); }
}
