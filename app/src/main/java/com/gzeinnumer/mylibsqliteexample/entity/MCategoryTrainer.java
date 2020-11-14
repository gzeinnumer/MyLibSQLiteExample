package com.gzeinnumer.mylibsqliteexample.entity;

import com.gzeinnumer.mylibsqliteexample.helper.GblVariabel;
import com.gzeinnumer.mylibsqlitelib.SQLiteLIB;
import com.gzeinnumer.mylibsqlitelib.struck.JoinColumn;
import com.gzeinnumer.mylibsqlitelib.struck.Table;
import com.gzeinnumer.mylibsqlitelib.typeData.Int;
import com.gzeinnumer.mylibsqlitelib.typeData.PrimaryKey;
import com.gzeinnumer.mylibsqlitelib.typeData.TimeStamp;
import com.gzeinnumer.mylibsqlitelib.typeData.Varchar;

import java.util.List;

@Table(tableName = "m_category_trainer")
public class MCategoryTrainer extends SQLiteLIB<MCategoryTrainer> {

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
    public int updated_by;
    @TimeStamp
    public String updated_at;

    @JoinColumn(withTable = "m_type_meeting", columnName = "name", alias = "mtm_name")
    private String mtm_name;

    public MCategoryTrainer() { }

    public MCategoryTrainer(int id, String name, int flag_active, int created_by,
                            String created_at, int updated_by, String updated_at) {
        this.id = id;
        this.name = name;
        this.flag_active = flag_active;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

    public boolean insert(MCategoryTrainer data) {
        return insertData(MCategoryTrainer.class, GblVariabel.myDb, data);
    }

    public boolean update(MCategoryTrainer data, String whereCondition) {
        return updatedData(MCategoryTrainer.class, GblVariabel.myDb, data, whereCondition);
    }

    public boolean delete(String whereCondition) {
        return deleteData(MCategoryTrainer.class, GblVariabel.myDb, whereCondition);
    }

    public int count() {
        String condition = "id='1'";
        return countData(MCategoryTrainer.class, GblVariabel.myDb, condition);
//        return countData(MCategoryTrainer.class, GblVariabel.myDb);
    }

    public List<MCategoryTrainer> read() {
        String condition = "id='1'";
        return readData(MCategoryTrainer.class, GblVariabel.myDb, condition);
//        return readData(MCategoryTrainer.class, GblVariabel.myDb);
    }

    public List<MCategoryTrainer> query(){
        String query ="SELECT m_category_trainer.*, m_type_meeting.name AS mtm_name FROM m_category_trainer " +
                "LEFT JOIN m_type_meeting ON m_type_meeting.id = m_category_trainer.id WHERE m_category_trainer.id = '1'";
        return queryData(MCategoryTrainer.class, GblVariabel.myDb, query);
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

    public String getMtm_name() {
        return mtm_name;
    }

    public void setMtm_name(String mtm_name) {
        this.mtm_name = mtm_name;
    }
}
