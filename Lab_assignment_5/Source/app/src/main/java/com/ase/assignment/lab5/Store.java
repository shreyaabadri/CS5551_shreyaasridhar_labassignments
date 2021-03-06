package com.ase.assignment.lab5;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shreya on 9/28/2017.
 */

public class Store extends Dialog implements
        View.OnClickListener{
    public Activity c;
    public Dialog d;
    public Button yes, no;
    public List<StoreDetails> cc;
    public Store(Activity a, List<StoreDetails> cc) {
        super(a);
        this.c = a;
        this.cc=cc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_output);
        yes = (Button) findViewById(R.id.btn_ok);

        yes.setOnClickListener(this);

        ArrayList<TextView> textViewList =new ArrayList<TextView>();
        textViewList.add((TextView)findViewById(R.id.add1));
        textViewList.add((TextView)findViewById(R.id.add2));
        textViewList.add((TextView)findViewById(R.id.add3));
        textViewList.add((TextView)findViewById(R.id.add4));
        textViewList.add((TextView)findViewById(R.id.add5));
        textViewList.get(0).setText("StoreName"+"\t"+"Address");
        int i=1;
        Collections.shuffle(cc);
        for(StoreDetails concept:cc){
            if(i>4)break;
            textViewList.get(i).setText(concept.getName()+"\t"+"--"+concept.getAddress());

            i++;
        }
        // no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                this.dismiss();
                break;

            default:
                break;
        }

    }

}
