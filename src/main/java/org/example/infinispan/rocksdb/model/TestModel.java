package org.example.infinispan.rocksdb.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
public class TestModel implements Serializable {

    private static final Random RANDOM = new Random();

    private String field1;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private LocalDateTime field2;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private LocalDateTime field3;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field4;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field5;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field6;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field7;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field8;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field9;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field10;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field11;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private Long field12;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private Integer field13;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private String field14;
    @GenericField(projectable = Projectable.YES, searchable = Searchable.YES, sortable = Sortable.YES, aggregable = Aggregable.NO)
    private Boolean field15;
    private String field16;
    private Map<String, List<String>> field17;
    private Map<String, List<String>> field18;

    public TestModel() {
        field1 = UUID.randomUUID().toString();
        field2 = LocalDateTime.now();
        field3 = LocalDateTime.now();
        field4 = UUID.randomUUID().toString();
        field5 = UUID.randomUUID().toString();
        field6 = UUID.randomUUID().toString();
        field7 = UUID.randomUUID().toString();
        field8 = UUID.randomUUID().toString();
        field9 = UUID.randomUUID().toString();
        field10 = UUID.randomUUID().toString();
        field11 = UUID.randomUUID().toString();
        field12 = RANDOM.nextLong();
        field13 = RANDOM.nextInt();
        field14 = UUID.randomUUID().toString();
        field15 = RANDOM.nextBoolean();
        field16 = UUID.randomUUID().toString();
        field17 = Map.of(UUID.randomUUID().toString(), List.of(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        field18 = Map.of(UUID.randomUUID().toString(), List.of(UUID.randomUUID().toString()), UUID.randomUUID().toString(), List.of(UUID.randomUUID().toString()));
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public LocalDateTime getField2() {
        return field2;
    }

    public void setField2(LocalDateTime field2) {
        this.field2 = field2;
    }

    public LocalDateTime getField3() {
        return field3;
    }

    public void setField3(LocalDateTime field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public String getField11() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11 = field11;
    }

    public Long getField12() {
        return field12;
    }

    public void setField12(Long field12) {
        this.field12 = field12;
    }

    public Integer getField13() {
        return field13;
    }

    public void setField13(Integer field13) {
        this.field13 = field13;
    }

    public String getField14() {
        return field14;
    }

    public void setField14(String field14) {
        this.field14 = field14;
    }

    public Boolean getField15() {
        return field15;
    }

    public void setField15(Boolean field15) {
        this.field15 = field15;
    }

    public String getField16() {
        return field16;
    }

    public void setField16(String field16) {
        this.field16 = field16;
    }

    public Map<String, List<String>> getField17() {
        return field17;
    }

    public void setField17(Map<String, List<String>> field17) {
        this.field17 = field17;
    }

    public Map<String, List<String>> getField18() {
        return field18;
    }

    public void setField18(Map<String, List<String>> field18) {
        this.field18 = field18;
    }
}
