package com.gzeinnumer.mylibsqliteexample.entity.old;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.gzeinnumer.mylibsqliteexample.helper.GblVariabel;

import java.util.ArrayList;

public class M_Type_Meeting {
    //field
    private String TABLE = "m_type_meeting";
    private String KEY_id = "id";
    private String KEY_name = "name";
    private String KEY_flag_active = "flag_active";
    private String KEY_created_by = "created_by";
    private String KEY_created_at = "created_at";
    private String KEY_updated_by = "updated_by";
    private String KEY_updated_at = "updated_at";

    private int id;
    private String name;
    private int flag_active;
    private int created_by;
    private String created_at;
    private int updated_by;
    private String updated_at;

    public M_Type_Meeting() {
    }

    public M_Type_Meeting(String name, int flag_active, int created_by, String created_at, int updated_by, String updated_at) {
        this.name = name;
        this.flag_active = flag_active;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
    }

    public ArrayList<M_Type_Meeting> getAll(){
        Cursor cursor;
        ArrayList<M_Type_Meeting> data = new ArrayList<>();
        cursor = GblVariabel.myDb.rawQuery(
                "SELECT * FROM "+
                        TABLE+
                        " WHERE "+
                        this.KEY_flag_active+" = 1"
                , null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                M_Type_Meeting current = new M_Type_Meeting();
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

    private static final String TAG = "M_Trip_Purpose";

    @SuppressLint("Recycle")
    public void insert(M_Type_Meeting data){
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_name,data.name);
            values.put(KEY_flag_active,data.flag_active);
            values.put(KEY_created_at,data.created_at);
            values.put(KEY_created_by,data.created_by);
            values.put(KEY_updated_by,data.updated_by);
            values.put(KEY_updated_at,data.updated_at);
            GblVariabel.myDb.insert(TABLE, null, values);
        } catch (Exception e){
            Log.d(TAG, "insert: " + e.getMessage());
        }
    }

    public boolean delete(int id){
        try{
            String query = "DELETE FROM " + TABLE +
                    " WHERE id="+id;
            GblVariabel.myDb.execSQL(query);
            return true;
        } catch (Exception e){
            Log.e(TAG, "deleted_order_detal failed "+ e.getMessage() );
            return  false;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFlag_active() {
        return flag_active;
    }

    public int getCreated_by() {
        return created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

}
