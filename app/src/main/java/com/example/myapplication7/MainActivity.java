package com.example.myapplication7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent;
        intent = new Intent(this, MainActivity2.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Activity 2")
                .setMessage("Перейти?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        intent.putExtra("a","Вы перешли во вторую активность");
                        startActivity(intent);

                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sendDataToActivity("Пользователь нажал Отмена в AlertDialog");
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

        /* ОСТАЛЬНЫЕ ДИАЛОГОВЫЕ ОКНА, ДЛЯ ТЕСТИРОВАНИЯ -- РАСКОМЕНЧИВАТЬ ПО ОТДЕЛЬНОСТИ! */
      /*  int year = 0;
        int month = 0;
        int day = 0;
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                sendDataToActivity("Выбранная дата: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        }, year, month, day);
        datePickerDialog.show();*/
     /*   int hour = 0;
        int minute = 0;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Передача данных в активность
                sendDataToActivity("Выбранное время: " + hourOfDay + ":" + minute);
            }
        }, hour, minute, true);
        timePickerDialog.show();*/
    /*    Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        Button closeButton = dialog.findViewById(R.id.close_button);
        Button confirmButton = dialog.findViewById(R.id.confirm_button);
        EditText editText = dialog.findViewById(R.id.edit_text);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                sendDataToActivity("Пользователь ввел " + editText.getText());
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                sendDataToActivity("Пользователь закрыл пользовательский диалог");
            }
        });
        dialog.show();*/

        Intent startIntent = new Intent(this, MyService.class);
        startService(startIntent);
    }

    private void sendDataToActivity(String s) {
        TextView textView;
        textView = findViewById(R.id.textView);
        textView.setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(this, MyService.class);
        stopService(stopIntent);
    }

}