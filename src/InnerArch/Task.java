package InnerArch;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * Created by Marat on 30.09.2014.
 */

public class Task {
    public String cmd, param;
    public LocalDateTime runTime;
    public boolean remove;

    Task() {
        remove = false;
    }

    public void Do() { }
}

