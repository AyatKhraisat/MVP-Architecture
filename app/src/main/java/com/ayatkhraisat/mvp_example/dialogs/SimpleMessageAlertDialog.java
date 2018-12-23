package com.ayatkhraisat.mvp_example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.notes.ayatkhraisat.mvp_example.R;
import io.reactivex.annotations.Nullable;


/**
 * Created by ACER on 10/11/2017.
 */

public class SimpleMessageAlertDialog extends DialogFragment {
    public static final String ARGS_TITLE = "title";
    public static final String ARGS_MESSAGE = "message";
    public static final String ARGS_POSITIVE_BUTTON_LABEL = "positive_button_label";
    public static final String ARGS_NEGATIVE_BUTTON_LABEL = "negative_button_label";

    public static final String EMPTY_STRING = "";
    public static final String POSITIVE_BUTTON_DEFAULT_LABEL = "OK";
    public static final String NEGATIVE_BUTTON_DEFAULT_LABEL = "Cancel";

    private TextView messageTextView;
    private String dialogTitle;
    private String dialogMessage;

    private String dialogPositiveButtonLabel, dialogNegativeButtonLabel;
    private DialogInterface.OnClickListener positiveButtonOnClickListener, negativeButtonOnClickListener;

    public SimpleMessageAlertDialog() {
    }

    public static class Builder {
        private final Bundle args;
        DialogInterface.OnClickListener positiveButtonOnClickListener, negativeButtonOnClickListener;

        public Builder() {
            args = new Bundle();
        }

        public Builder setTitle(String title) {
            args.putString(ARGS_TITLE, title);
            return this;
        }

        public Builder setMessage(String message) {
            args.putString(ARGS_MESSAGE, message);
            return this;
        }


        public Builder setPositiveButton(String positiveButtonLabel, DialogInterface.OnClickListener listener) {
            args.putString(ARGS_POSITIVE_BUTTON_LABEL, positiveButtonLabel);
            positiveButtonOnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonLabel, DialogInterface.OnClickListener listener) {
            args.putString(ARGS_NEGATIVE_BUTTON_LABEL, negativeButtonLabel);
            negativeButtonOnClickListener = listener;
            return this;
        }

        public SimpleMessageAlertDialog build() {
            SimpleMessageAlertDialog dialog = new SimpleMessageAlertDialog();
            dialog.setArguments(args);
            if (positiveButtonOnClickListener != null)
                dialog.setPositiveButtonOnClickListener(positiveButtonOnClickListener);
            if (negativeButtonOnClickListener != null)
                dialog.setNegativeButtonOnClickListener(negativeButtonOnClickListener);
            return dialog;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDialogArguments();
    }

    protected void getDialogArguments() {
        if (getArguments() != null)
            getExistingArguments();
        else
            getDefaultArguments();
    }

    private void getExistingArguments() {
        dialogTitle = getArguments().getString(ARGS_TITLE, EMPTY_STRING);
        dialogMessage = getArguments().getString(ARGS_MESSAGE, EMPTY_STRING);
        dialogPositiveButtonLabel = getArguments().getString(ARGS_POSITIVE_BUTTON_LABEL, POSITIVE_BUTTON_DEFAULT_LABEL);
        dialogNegativeButtonLabel = getArguments().getString(ARGS_NEGATIVE_BUTTON_LABEL, NEGATIVE_BUTTON_DEFAULT_LABEL);
    }

    public void getDefaultArguments() {
        dialogTitle = EMPTY_STRING;
        dialogMessage = EMPTY_STRING;
        dialogPositiveButtonLabel = POSITIVE_BUTTON_DEFAULT_LABEL;
        dialogNegativeButtonLabel = NEGATIVE_BUTTON_DEFAULT_LABEL;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_simple_message, null);

        messageTextView = rootView.findViewById(R.id.dialog_massage);
        messageTextView.setText(dialogMessage);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

        dialogBuilder.setView(rootView);
        dialogBuilder.setTitle(dialogTitle);

        if (positiveButtonOnClickListener != null) {
            dialogBuilder.setPositiveButton(dialogPositiveButtonLabel, positiveButtonOnClickListener);
        }
        if (negativeButtonOnClickListener != null) {
            dialogBuilder.setNegativeButton(dialogNegativeButtonLabel, negativeButtonOnClickListener);
        }

        return dialogBuilder.create();
    }

    public void setPositiveButtonOnClickListener(DialogInterface.OnClickListener positiveButtonOnClickListener) {
        this.positiveButtonOnClickListener = positiveButtonOnClickListener;
    }

    public void setNegativeButtonOnClickListener(DialogInterface.OnClickListener negativeButtonOnClickListener) {
        this.negativeButtonOnClickListener = negativeButtonOnClickListener;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        //we need to make sure there is no dialog already present, as this should be just one dialog
        if (getDialog() == null)
            super.show(manager, tag);
    }

    @Override
    public void dismiss() {
        //we need to make sure that the dialog actually exists
        if (getDialog() != null)
            //we need to check if the dialog is actually showing or has been already dismissed
            if (getDialog().isShowing())
                super.dismiss();
    }


}
