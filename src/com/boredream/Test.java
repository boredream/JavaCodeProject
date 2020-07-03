package com.boredream;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private List list = new ArrayList() {
        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }
    };

}
