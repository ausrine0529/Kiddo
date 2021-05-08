package com.example.edukacine2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DBHelper extends SQLiteOpenHelper {
    public static final String VARTOTOJAS = "VARTOTOJAS";
    private static final String VAIKO_ZENKLIUKAI ="VAIKO_ZENKLIUKAI" ;


    public DBHelper(@Nullable Context context) {
        super(context, "edukacine.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatementUser = "CREATE TABLE VARTOTOJAS (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME STRING, PWDHASH STRING, TYPE STRING, ISACTIVE BOOL)";
        db.execSQL(createTableStatementUser);

        String createTableStatementKidStickers = "CREATE TABLE VAIKO_ZENKLIUKAI (KIDS_STICKER_ID INTEGER PRIMARY KEY AUTOINCREMENT, KID_ID INTEGER, STICKER_ID INTEGER)";
        db.execSQL(createTableStatementKidStickers);

        String createTableStatementTask = "CREATE TABLE UZDUOTIS (TASK_ID INTEGER PRIMARY KEY AUTOINCREMENT, KID_ID INTEGER, TYPE INTEGER, QSTQUANTITY INTEGER, LEVEL INTEGER, WAS_PERFORMED BOOL)";
        db.execSQL(createTableStatementTask);

          String createTableStatementResult = "CREATE TABLE REZULTATAS (RESULT_ID INTEGER PRIMARY KEY AUTOINCREMENT, KID_ID INTEGER, KID_USERNAME STRING, TASK_ID INTEGER, TASK_TYPE STRING, LEVEL INTEGER, CORRECTANSW INTEGER, QUESTIONSQNTT INTEGER, DATE STRING)";
          db.execSQL(createTableStatementResult);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean pridetiNaudotoja(User user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", user.getUsername());
        cv.put("PWDHASH", user.getPwdhash());
        cv.put("TYPE", user.getType());
        cv.put("ISACTIVE", user.getActive());

        long result = db.insert("VARTOTOJAS", null, cv);
        if (user.getType() == "Vaikas"){
            int kid_id = getKidIdByUsername(user.getUsername());
            boolean result2 = createSticerRecord(kid_id);

            if (result2){
                return true;
            }
            else{
                return false;
            }
        }

        if (result == -1){
            return false;
        }
        else {
            return  true;
        }
    }

    public boolean createSticerRecord(int kid_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("KID_ID", kid_id);
        cv.put("STICKER_ID", 0);

        long result = db.insert("VAIKO_ZENKLIUKAI", null, cv);

        if (result == -1){
            return false;
        }
        else {
            return  true;
        }
    }

    public boolean pridetiZenkliuka(String username){
        Sticker sticker = new Sticker();
        SQLiteDatabase db = this.getWritableDatabase();
        int id = getKidIdByUsername(username);
        sticker = getKidStickers(id);

        Integer qnt;
        qnt =  Integer.valueOf(sticker.getSticker_ID());
        Integer newqnt;
        newqnt = qnt + 1;

        ContentValues cv = new ContentValues();
        cv.put("STICKER_ID", newqnt);

        SQLiteDatabase db2 = this.getWritableDatabase();
        long result = db2.update("VAIKO_ZENKLIUKAI", cv, "KID_ID = ?", new String[] {String.valueOf(id)});
        if (result == -1){
            return false;
        }
        else {
            return  true;
        }
    }

    public boolean atliktiUzduoti(Result rez){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("WAS_PERFORMED", true);
        long result = db.update("UZDUOTIS", cv, "TASK_ID = ?", new String[] {String.valueOf(rez.getTask_id())});

        ContentValues cv2 = new ContentValues();
        cv2.put("KID_ID", rez.getKid_id());
        cv2.put("KID_USERNAME", rez.getUsername());
        cv2.put("TASK_ID", rez.getTask_id());
        cv2.put("LEVEL", rez.getLevel());
        cv2.put("TASK_TYPE", rez.getTaskType());
        cv2.put("CORRECTANSW", rez.getCorrectAnsw());
        cv2.put("QUESTIONSQNTT", rez.getQuestionQntt());
        cv2.put("DATE", rez.getDate());

        if (result == -1){
            return false;
        }
        else {
            return  true;
        }
    }

    public boolean skirtiUzduoti(Task task){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("KID_ID", task.getKid_name());
        cv.put("TYPE", task.getType());
        cv.put("QSTQUANTITY", task.getQuestquantitiy());
        cv.put("LEVEL", task.getLevel());
        cv.put("WAS_PERFORMED", task.getWasPerformed());


        long result = db.insert("UZDUOTIS", null, cv);

        if (result == -1){
            return false;
        }
        else {
            return  true;
        }

    }

    public List<Task> getKidUndoneTask(String username){
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM UZDUOTIS WHERE KID_ID = ? AND WAS_PERFORMED = 0", new String[] {username});
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String kidUsername = cursor.getString(1);
                int type = cursor.getInt(2);
                int quant = cursor.getInt(3);
                int level = cursor.getInt(4);
                tasks.add(new Task(id, type, quant, level, kidUsername, false));

            }while (cursor.moveToNext());
        }
        else{
        }
        cursor.close();
        db.close();
        return tasks;
    }

    public List<Result> getAllResults(){
        List<Result> results = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM REZULTATAS ORDER BY DATE DESC ", null);
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                int kidId = cursor.getInt(1);
                String username = cursor.getString(2);
                int taskId = cursor.getInt(3);
                String taskType = cursor.getString(4);
                int level = cursor.getInt(5);
                int correctAnsw = cursor.getInt(6);
                int questQntt = cursor.getInt(7);
                String date = cursor.getString(8);
                results.add(new Result(id, kidId, username, taskType, level, taskId, correctAnsw, questQntt, date));

            }while (cursor.moveToNext());
        }
        else{
        }
        cursor.close();
        db.close();
        return results;
    }

    public Sticker getKidStickers(int kid_id){
        Sticker sticker = new Sticker();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VAIKO_ZENKLIUKAI + " WHERE KID_ID = ?", new String[] {String.valueOf(kid_id)});
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                int child_id = cursor.getInt(1);
                int quantity = cursor.getInt(2);
                sticker.setID(id);
                sticker.setKid_ID(child_id);
                sticker.setSticker_ID(quantity);

            }while (cursor.moveToNext());
        }
        else{
        }
        cursor.close();
        db.close();
        return sticker;
    }

    public int getKidIdByUsername(String username){
        AtomicInteger id = new AtomicInteger();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VARTOTOJAS + " WHERE USERNAME = ?", new String[] {username});
        if (cursor.moveToFirst()) do id.set(cursor.getInt(0)); while (cursor.moveToNext());
        else{
        }
        cursor.close();
        db.close();
        return id.get();
    }

    public String getKidUsernameById(int id){
        String username = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VARTOTOJAS + " WHERE USER_ID = ?", new String[] {String.valueOf(id)});
        if (cursor.moveToFirst()) do {
            username = cursor.getString(1);
        } while (cursor.moveToNext());
        else{
        }
        cursor.close();
        db.close();
        return username;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from VARTOTOJAS where USERNAME = ?", new String[] {username});
        if (cursor.getCount()>0){
            cursor.close();
            db.close();
            return true;}else{
            cursor.close();
            db.close();
            return false;}
    }

    public List<User> returnKidsList2(){
        List<User> returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + VARTOTOJAS + " WHERE TYPE = ? AND ISACTIVE = 1 ORDER BY USERNAME COLLATE NOCASE", new String[] {"Vaikas"});
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String username = cursor.getString(1);
                String hash = cursor.getString(2);
                String type = cursor.getString(3);
                boolean isActive = cursor.getInt(4) == 1 ? true: false;

                User user = new User(id, username, hash, type, isActive);
                returnList.add(user);

            }while (cursor.moveToNext());
        }
        else{
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public List<User> checkUserPassword(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from VARTOTOJAS where USERNAME = ? ", new String[] {username});

        List<User> returnList = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String vardas = cursor.getString(1);
                String hash = cursor.getString(2);
                String type = cursor.getString(3);
                boolean isActive = cursor.getInt(4) == 1 ? true: false;

                User user = new User(id, vardas, hash, type, isActive);

                returnList.add(user);
            }while (cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }
}
