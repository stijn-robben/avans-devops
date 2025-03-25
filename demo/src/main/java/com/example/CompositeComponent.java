package com.example;

import java.util.ArrayList;

public class CompositeComponent extends Component
{
    private ArrayList<Component> parts;
    
    public CompositeComponent()
    {
        parts = new ArrayList<>();
    }

    public void addComponent(Component comp)
    {
        parts.add(comp);
    }

    public Component getComponent(int i)
    {
        return parts.get(i);
    }

    public int getSize()
    {
        return parts.size();
    }

    public void acceptVisitor(Visitor visitor)
    {
        for (Component component : parts)
        {
            component.acceptVisitor(visitor);
        }
    }
}
