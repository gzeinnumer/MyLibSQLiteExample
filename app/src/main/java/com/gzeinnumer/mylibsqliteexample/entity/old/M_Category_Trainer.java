package com.gzeinnumer.mylibsqliteexample.entity.old;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.gzeinnumer.mylibsqliteexample.helper.GblVariabel;

import java.util.ArrayList;
import java.util.List;

public class M_Category_Trainer {

    private final String TABLE = "m_category_trainer";
    private final String KEY_id = "id";
    private final String KEY_name = "name";
    private final String KEY_flag_active = "flag_active";
    private final String KEY_created_by = "created_by";
    private final String KEY_created_at = "created_at";
    private final String KEY_updated_by = "updated_by";
    private final String KEY_updated_at = "updated_at";
    private final String KEY_mtm_name = "mtm_name";

    private int id;
    private String name;
    private int flag_active;
    private int created_by;
    private String created_at;
    private int updated_by;
    private String updated_at;
    private String mtm_name;

    private static final String TAG = "M_Category_Trainer";

    public M_Category_Trainer() {}

    public M_Category_Trainer(int id, String name, int flag_active, int created_by,
                              String created_at, int updated_by, String updated_at) {
        this.id = id;
        this.name = name;
        this.flag_active = flag_active;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

    public boolean insert(M_Category_Trainer data){
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_id, data.getId());
            values.put(KEY_name, data.getName());
            values.put(KEY_flag_active, data.getFlag_active());
            values.put(KEY_created_by, data.getCreated_by());
            values.put(KEY_created_at, data.getCreated_at());
            values.put(KEY_updated_by, data.getUpdated_by());
            values.put(KEY_updated_at, data.getUpdated_at());
            GblVariabel.myDb.insert(TABLE, null, values);
            return true;
        } catch (Exception e) {
            Log.d(TAG, "insert: " + e.getMessage());
            return false;
        }
    }

    public boolean update(M_Category_Trainer data, String whereCondition){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_name, data.getName());
        contentValues.put(KEY_flag_active, data.getFlag_active());
        contentValues.put(KEY_created_by, data.getCreated_by());
        contentValues.put(KEY_created_at, data.getCreated_at());
        contentValues.put(KEY_updated_by, data.getUpdated_by());
        contentValues.put(KEY_updated_at, data.getUpdated_at());
        long row = GblVariabel.myDb.update(TABLE, contentValues, whereCondition, new String[]{String.valueOf(data.getId())});
        if (row > 0) {
            Log.d(TAG, "update: success");
            return true;
        } else {
            Log.d(TAG, "update: failed");
            return false;
        }
    }

    public boolean delete(String whereCondition){
        try{
            String query = "DELETE FROM " + TABLE + whereCondition;
            GblVariabel.myDb.execSQL(query);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "deleted failed " + e.getMessage());
            return false;
        }
    }

    public int count(){
        int count = 0;
        try {
            Cursor cursor = GblVariabel.myDb.rawQuery("SELECT id FROM "+TABLE+" WHERE is_uploaded = '0'", null);
            count = cursor.getCount();
            cursor.close();
        } catch (Exception e){
            Log.d(TAG, "count: "+e.getMessage());
        }
        return count;
    }

    public ArrayList<M_Category_Trainer> read(){
        Cursor cursor;
        ArrayList<M_Category_Trainer> data = new ArrayList<>();
        cursor = GblVariabel.myDb.rawQuery("SELECT * FROM " + TABLE +" WHERE flag_active = '1'", null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                M_Category_Trainer current = new M_Category_Trainer();
                current.id = cursor.getInt(cursor.getColumnIndex(this.KEY_id));
                current.name = cursor.getString(cursor.getColumnIndex(this.KEY_name));
                current.flag_active = cursor.getInt(cursor.getColumnIndex(this.KEY_flag_active));
                current.created_by = cursor.getInt(cursor.getColumnIndex(this.KEY_created_by));
                current.created_at = cursor.getString(cursor.getColumnIndex(this.KEY_created_at));
                current.updated_by = cursor.getInt(cursor.getColumnIndex(this.KEY_updated_by));
                current.updated_at = cursor.getString(cursor.getColumnIndex(this.KEY_updated_at));
                data.add(current);
            }
        }
        cursor.close();
        return data;
    }

    @SuppressLint("Recycle")
    public List<M_Category_Trainer> query(){
        List<M_Category_Trainer> current = new ArrayList<>();
        String query ="SELECT m_category_trainer.*, m_type_meeting.name AS mtm_name FROM m_category_trainer " +
                "LEFT JOIN m_type_meeting ON m_type_meeting.id = m_category_trainer.id WHERE m_category_trainer.id = '1'";
         Cursor cursor = GblVariabel.myDb.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                M_Category_Trainer data = new M_Category_Trainer();
                data.id = cursor.getInt(cursor.getColumnIndex(this.KEY_id));
                data.name = cursor.getString(cursor.getColumnIndex(this.KEY_name));
                data.flag_active = cursor.getInt(cursor.getColumnIndex(this.KEY_flag_active));
                data.created_by = cursor.getInt(cursor.getColumnIndex(this.KEY_created_by));
                data.created_at = cursor.getString(cursor.getColumnIndex(this.KEY_created_at));
                data.updated_by = cursor.getInt(cursor.getColumnIndex(this.KEY_updated_by));
                data.updated_at = cursor.getString(cursor.getColumnIndex(this.KEY_updated_at));
                data.mtm_name = cursor.getString(cursor.getColumnIndex(this.KEY_mtm_name));
                current.add(data);
            }
        }
        return current;
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

