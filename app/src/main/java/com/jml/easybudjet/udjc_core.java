package com.jml.easybudjet;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;

import androidx.appcompat.app.AlertDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class udjc_core {

    public static String udf_GetCurrentDate() {
        Date udoTempCalendar = Calendar.getInstance().getTime();
        SimpleDateFormat udoTempDateFormated = new SimpleDateFormat("dd-MMM-yyyy");
        return udoTempDateFormated.format(udoTempCalendar);
    }

    public static String udf_GetCurrentTime() {
        Date udoTempCalendar = Calendar.getInstance().getTime();
        SimpleDateFormat udoTempDateFormated = new SimpleDateFormat("HH:mms z");
        return udoTempDateFormated.format(udoTempCalendar);
    }

    public void udf_ShowAlert(String udoTitle, String udoMessage, Context activity){

        final AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder( activity, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder( activity);
        }
        builder.setTitle(udoTitle)
                .setMessage(udoMessage)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) { dialog.dismiss();}
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
