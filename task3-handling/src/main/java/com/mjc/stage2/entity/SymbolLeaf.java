package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent {

    private char value;

    public SymbolLeaf(TextComponentType type, char value) {
        super(type);
        this.value = value;
    }

    @Override
    public String operation() {
        return Character.toString(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return -1;
    }

    // Write your code here!
}
