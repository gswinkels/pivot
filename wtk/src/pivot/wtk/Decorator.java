package pivot.wtk;

import java.awt.Graphics2D;

public interface Decorator {
    public Graphics2D prepare(Component component, Graphics2D graphics);
    public void update();

    public Rectangle transform(Component component, Rectangle bounds);
}
