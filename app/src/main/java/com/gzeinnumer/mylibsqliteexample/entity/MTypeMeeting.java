package com.gzeinnumer.mylibsqliteexample.entity;

import com.gzeinnumer.mylibsqlitelib.SQLiteLIB;
import com.gzeinnumer.mylibsqlitelib.struck.Table;
import com.gzeinnumer.mylibsqlitelib.typeData.Int;
import com.gzeinnumer.mylibsqlitelib.typeData.PrimaryKey;
import com.gzeinnumer.mylibsqlitelib.typeData.TimeStamp;
import com.gzeinnumer.mylibsqlitelib.typeData.Varchar;

import java.util.List;

@Table(tableName = "m_type_meeting")
public class MTypeMeeting extends SQLiteLIB<MTypeMeeting> {

    @PrimaryKey
    private int id;

    @Varchar
    private String name;

    @Int
    private int flag_active;

    @Int
    private int created_by;

    @TimeStamp
    private String created_at;

    @Int
    private int updated_by;

    @TimeStamp
    private String updated_at;

    public MTypeMeeting() {}

    public MTypeMeeting(int id, String name, int flag_active, int created_by, String created_at, int updated_by, String updated_at) {
        this.id = id;
        this.name = name;
        this.flag_active = flag_active;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

    public boolean insert(MTypeMeeting data) {
        return false;
    }

    public boolean update(MTypeMeeting data, String whereCondition) {
        return false;
    }

    public boolean delete(String whereCondition) {
        return false;
    }

    public int count() {
        return 0;
    }

    public List<MTypeMeeting> read() {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag_active() {
        return flag_active;
    }

    public void setFlag_active(int flag_active) {
        this.flag_active = flag_active;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
