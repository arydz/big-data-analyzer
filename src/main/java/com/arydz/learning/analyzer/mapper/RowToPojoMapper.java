package com.arydz.learning.analyzer.mapper;

import com.arydz.learning.analyzer.model.Readable;

public interface RowToPojoMapper<T extends Readable> {

    /**
     * Map current row from file on desired java object
     * @return Object from current line
     */
    T map(String[] line);
}
