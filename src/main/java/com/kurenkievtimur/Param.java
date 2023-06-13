package com.kurenkievtimur;

public enum Param {
    ONE_PARAM,
    TWO_PARAM,
    MORE_PARAM,
    HELP,
    EXIT;

    public static Param getParam(String[] params) {
        if (params.length == 1 && params[0].equals("0"))
            return EXIT;
        if (params.length == 1)
            return ONE_PARAM;
        else if (params.length == 2)
            return TWO_PARAM;
        else if (params.length == 0)
            return HELP;

        return MORE_PARAM;
    }
}
