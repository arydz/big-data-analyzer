package com.arydz.learning.analyzer.mapper;

import com.arydz.learning.analyzer.model.Readable;

public interface FileToPojoMapper<T extends Readable> {

    /**
     * Map current line on java object
     * @return Object from current line
     */
    T map();
}
