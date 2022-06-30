package com.example.splitit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class PhoneAuth extends AppCompatActivity {


    EditText phoneedittext;
    MaterialCardView number1;
    MaterialCardView number2;
    MaterialCardView number3;
    MaterialCardView number4;
    MaterialCardView number5;
    MaterialCardView number6;
    MaterialCardView number7;
    MaterialCardView number8;
    MaterialCardView number9;
    MaterialCardView number0;
    MaterialCardView number10;
    MaterialButton continuebotton;

    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);
        phoneedittext = findViewById(R.id.phoneedittext);


        phoneedittext.setRawInputType(InputType.TYPE_NULL);
        phoneedittext.setTextIsSelectable(true);

        number0 =findViewById(R.id.numberpressed0);
        number1 =findViewById(R.id.numberpressed1);
        number2 =findViewById(R.id.numberpressed2);
        number3 =findViewById(R.id.numberpressed3);
        number4 =findViewById(R.id.numberpressed4);
        number5 =findViewById(R.id.numberpressed5);
        number6 =findViewById(R.id.numberpressed6);
        number7 =findViewById(R.id.numberpressed7);
        number8 =findViewById(R.id.numberpressed8);
        number9 =findViewById(R.id.numberpressed9);
        number10 =findViewById(R.id.backspace);
        continuebotton = findViewById(R.id.continuebut);
        number = "";



        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "0";
                phoneedittext.setText(number);
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "1";
                phoneedittext.setText(number);
            }
        });

         number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "2";
                phoneedittext.setText(number);
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "3";
                phoneedittext.setText(number);
            }
        });


        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "4";
                phoneedittext.setText(number);
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "5";
                phoneedittext.setText(number);
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "6";
                phoneedittext.setText(number);
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "7";
                phoneedittext.setText(number);
            }
        });


        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "8";
                phoneedittext.setText(number);
            }
        });


        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + "9";
                phoneedittext.setText(number);
            }
        });


        number10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !number.isEmpty() ){
                    number = number.substring(0,number.length()-1);
                    phoneedittext.setText(number);
                }
            }
        });

    }
}