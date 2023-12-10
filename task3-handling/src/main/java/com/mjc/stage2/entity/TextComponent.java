package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;
    private String string;

    public TextComponent(TextComponentType componentType, String string) {
        super(componentType);
        this.string = string;
    }

    @Override
    public String operation() {
        return string;
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return componentList.size();
    }
// Write your code here!
}
