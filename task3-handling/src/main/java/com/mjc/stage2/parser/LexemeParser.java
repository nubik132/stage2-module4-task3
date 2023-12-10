package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        switch (abstractTextComponent.getComponentType()){
            case SENTENCE:
                parseSentence(abstractTextComponent, string);
                break;
            case WORD:
                parseWord(abstractTextComponent, string);
                break;
        }

        if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }

    private void parseSentence(AbstractTextComponent abstractTextComponent, String string){
        String[] lexemes = string.split(LEXEME_REGEX);
        for (String lexeme :
                lexemes) {
            AbstractTextComponent component = new TextComponent(TextComponentType.WORD, lexeme);
            abstractTextComponent.add(component);

            parseWord(component, lexeme);
        }
    }

    private void parseWord(AbstractTextComponent abstractTextComponent, String string){
        for (char symbol :
                string.toCharArray()) {
            abstractTextComponent.add(new SymbolLeaf(TextComponentType.SYMBOL, symbol));
        }
    }
}
