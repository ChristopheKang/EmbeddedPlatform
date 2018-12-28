package com.example.neiris.embeddedplatform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_CONTENT = "content";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table contacts (id integer primary key not null ," +
            "name text not null, email text not null, uname text not null, pass text not null);";
    private static final String TABLE_CREATE2="create table articles (id integer primary key not null, name text not null, content text not null);";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME,    null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2); // inserting news table
        System.out.println("DB findEditTable: " + db.findEditTable("articles"));
//        db.execSQL("create table articles (id integer primary key not null, name text not null, content text not null);");
        this.db = db;
    }

    public void fillArticlesInDb() {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // parse files & assign ids
        int articleId = 0;
        String articleName = "Home Workout";
        // article content, might get it from web
        String articleContent = "180 Squat Jumps\n" +
                "\n" +
                "A. Stack the toilet paper rolls on top of each other. Stand facing the stack with feet wider than hip-width apart.\n" +
                "B. Lower into a squat to grab the first roll, exploding up into a jump and turning 180 degrees to face the other way.\n" +
                "C. Upon landing, immediately lower into another squat placing the toilet paper on the ground.\n" +
                "D. Repeat, unstacking the toilet paper on one side, and creating a new stack on the other side.\n" +
                "\n" +
                "Do AMRAP for 20 seconds; rest for 10 seconds.\n" +
                "Military Plank TP Stack\n" +
                "\n" +
                "A. Start in a high plank position with toilet paper in one stack in front of the right shoulder.\n" +
                "B. Shift right palm over so it's on the floor beneath the center of the chest.\n" +
                "C. Maintaining a strong, straight plank position, grab the top roll of toilet paper and place it on the floor about a foot to the left. Repeat, moving each roll to create a new stack.\n" +
                "\n" +
                "Do AMRAP for 20 seconds; rest for 10 seconds. Do every other set on the opposite side.\n" +
                "Single-Leg Around-the-World Floor Tap\n" +
                "\n" +
                "A. Place toilet paper rolls on floor in a semicircle. Stand on the left leg facing the rolls.\n" +
                "B. Keeping right leg lifted, squat to tap the left-most roll with the right hand. Stand, then squat to touch the next roll, repeating the movement while moving down the line.\n" +
                "C. After tapping the right-most roll, reverse the direction.\n" +
                "\n" +
                "Do AMRAP for 20 seconds; rest for 10 seconds. Do every other set on the opposite side.";

        values.put(COLUMN_ID, articleId);
        values.put(COLUMN_NAME, articleName);
        values.put(COLUMN_CONTENT, articleContent);
        System.out.println("[INSERTING IN DB]");

        db.insert("articles", null, values);
        db.close();
    }

    public String getArticle(int id) {
        db = this.getReadableDatabase();
        String query = "select content from articles where id=" + id;

        // getting specific article from id
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase(); // pourquoi pas la créer dans le onCreate?
        ContentValues values = new ContentValues();

        //create a string query
        String query = "select  * from contacts ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPass());
        values.put(COLUMN_UNAME, c.getUname());

        //this will insert the content in the database
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String name){

        db = this.getReadableDatabase();
        String query = "select name, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(name)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
