package InnerArch;

import java.util.List;

/**
 * Created by Marat on 30.09.2014.
 */
public class TaskList {
    private List<Task> items;

    public void Add(Task item)
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
}
