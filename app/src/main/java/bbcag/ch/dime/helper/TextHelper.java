package bbcag.ch.dime.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;

import bbcag.ch.dime.R;

public class TextHelper {
    public static void generateAlertDialog(final Fragment fragment, String title, String message) {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(fragment.getContext());
        dialogBuilder.setPositiveButton(fragment.getString(R.string.all_ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        dialogBuilder.setMessage(message).setTitle(title);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
