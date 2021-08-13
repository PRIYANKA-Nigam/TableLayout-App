package com.example.tableslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public static final String mypress="mySharedPreferences";
    String month[]={"January","february","March","April","may","June","July","August","September",
            "October","November","December"};
private String savedMonthOfBirth;
private String savedToggleButtonChoice;
    private String savedNumberPicked;
    private Spinner sprMonthOfBirth; private ImageView imgMonthOfBirth,imgCatsorDogs,imgPickNumber; private ToggleButton tbnCatsorDogs;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sprMonthOfBirth=findViewById(R.id.sp);
        imgMonthOfBirth=findViewById(R.id.img1);
        tbnCatsorDogs=findViewById(R.id.toggleb);
        imgCatsorDogs=findViewById(R.id.img2);
        editText=findViewById(R.id.ed);
        imgPickNumber=findViewById(R.id.img3);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_spinner_item,month);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprMonthOfBirth.setAdapter(ad);
        sprMonthOfBirth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
                public void onItemSelected (AdapterView < ? > parent, View view,int position,
                long id){
                Object month = parent.getItemAtPosition(position);
                int pickedMonth = position + 1;
                savedMonthOfBirth = String.valueOf(pickedMonth);
                switch (savedMonthOfBirth) {
                    case "1": imgMonthOfBirth.setImageResource(R.drawable.january);break;
                    case "2": imgMonthOfBirth.setImageResource(R.drawable.february);break;
                    case "3": imgMonthOfBirth.setImageResource(R.drawable.march);break;
                    case "4": imgMonthOfBirth.setImageResource(R.drawable.april);break;
                    case "5": imgMonthOfBirth.setImageResource(R.drawable.may);break;
                    case "6": imgMonthOfBirth.setImageResource(R.drawable.june);break;
                    case "7": imgMonthOfBirth.setImageResource(R.drawable.july);break;
                    case "8": imgMonthOfBirth.setImageResource(R.drawable.august);break;
                    case "9": imgMonthOfBirth.setImageResource(R.drawable.september);break;
                    case "10": imgMonthOfBirth.setImageResource(R.drawable.october);break;
                    case "11": imgMonthOfBirth.setImageResource(R.drawable.november);break;
                    case "12": imgMonthOfBirth.setImageResource(R.drawable.december);break;
                    default: imgMonthOfBirth.setImageResource(R.drawable.ic_baseline_swap_calls_24);
                }
            }

                @Override
                public void onNothingSelected (AdapterView < ? > parent){
                savedMonthOfBirth = " ";
                imgMonthOfBirth.setImageResource(R.drawable.ic_baseline_swap_calls_24);
            }

        });

tbnCatsorDogs.setOnClickListener(this);
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
   if(!s.equals(" ")){
       savedNumberPicked=editText.getText().toString().toLowerCase();
   }
   switch (savedNumberPicked){
       case "1" : imgPickNumber.setImageResource(R.drawable.numberone); break;
       case "2" : imgPickNumber.setImageResource(R.drawable.numbertwo); break;
       case "3" : imgPickNumber.setImageResource(R.drawable.numberthree); break;
       case "4" : imgPickNumber.setImageResource(R.drawable.numberfour); break;
       case "5" : imgPickNumber.setImageResource(R.drawable.numberfive); break;
       case "6" : imgPickNumber.setImageResource(R.drawable.numbersix); break;
       case "7" : imgPickNumber.setImageResource(R.drawable.numberseven); break;
       case "8" : imgPickNumber.setImageResource(R.drawable.numbereight); break;
       case "9" : imgPickNumber.setImageResource(R.drawable.numbernine); break;
       default : imgPickNumber.setImageResource(R.drawable.ic_baseline_thumb_down_24);

   }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
});
loadPreferences();
    }

    private void loadPreferences() {
    }

    @Override
    public void onClick(View v) {
        if(tbnCatsorDogs.isChecked()){
            savedToggleButtonChoice="cat";
            imgCatsorDogs.setImageResource(R.drawable.cat);
        }
        else
        {
            savedToggleButtonChoice="dog";
            imgCatsorDogs.setImageResource(R.drawable.dog);
        }
    }
}