package org.example.infinispan.rocksdb.model;

import java.io.Serializable;
import java.util.UUID;

public class TestModel implements Serializable {

    private String field1;
    private String field2;
    private String field3;

    public TestModel() {
        field1 = UUID.randomUUID().toString();
        field2 = UUID.randomUUID().toString();
        field3 = UUID.randomUUID().toString();
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
