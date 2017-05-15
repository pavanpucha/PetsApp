package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

import org.w3c.dom.Text;

/**
 * Created by pavan on 5/6/2017.
 */

public class PetCursorAdapter extends CursorAdapter {
    /*
    Constructor
     */
    public PetCursorAdapter(Context context, Cursor c){
        super(context,c,0);

    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        // TODO
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        //return null;
    }
    public void bindView(View view, Context context, Cursor cursor){
        // FILL
        TextView petTextName = (TextView) view.findViewById(R.id.name);
        TextView petTextSummary = (TextView)view.findViewById(R.id.summary);
        int nameColumnIndex =cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String petName = cursor.getString(nameColumnIndex);
        String petBreed = cursor.getString(breedColumnIndex);
        petTextName.setText(petName);
        petTextSummary.setText(petBreed);

    }
}
