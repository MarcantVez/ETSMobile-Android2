package ca.etsmtl.applets.etsmobile.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;

import com.google.android.gms.gcm.GcmListenerService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import ca.etsmtl.applets.etsmobile.ApplicationManager;
import ca.etsmtl.applets.etsmobile.model.MonETSNotification;
import ca.etsmtl.applets.etsmobile.ui.activity.NotificationActivity;
import ca.etsmtl.applets.etsmobile.util.Constants;
import ca.etsmtl.applets.etsmobile.util.SecurePreferences;
import ca.etsmtl.applets.etsmobile2.R;

/**
 * Created by gnut3ll4 on 16/10/15.
 */
public class ETSGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";
    private static final int NUMBER_OF_NOTIF_TO_DISPLAY = 5;

    /**
     * Called when message is received.
     *
     * @param from SenderID of the sender.
     * @param data Data bundle containing message data as key/value pairs.
     *             For Set of keys use data.keySet().
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {

        // Calls SupportKit GCM Listener
        if (TextUtils.equals(data.getString("origin"), "SupportKit")) {
            super.onMessageReceived(from, data);
        } else {


            /**
             * Production applications would usually process the message here.
             * Eg: - Syncing with server.
             *     - Store message in local database.
             *     - Update UI.
             */

            /**
             * In some cases it may be useful to show a notification indicating to the user
             * that a message was received.
             */
            sendNotification(data);
        }
    }

    /**
     * Create and show a simple notification containing the received GCM message.
     *
     * @param data GCM message received.
     */
    private void sendNotification(Bundle data) {
        SecurePreferences securePreferences = new SecurePreferences(this);
        Gson gson = new Gson();

        String receivedNotifString = securePreferences.getString(Constants.RECEIVED_NOTIF, "");

        ArrayList<MonETSNotification> receivedNotif = gson.fromJson(
                receivedNotifString,
                new TypeToken<ArrayList<MonETSNotification>>() {
                }.getType());

        if (receivedNotif == null) {
            receivedNotif = new ArrayList<>();
        }

        MonETSNotification nouvelleNotification = getMonETSNotificationFromBundle(data);

        receivedNotif.add(nouvelleNotification);

        int numberOfNotifications = receivedNotif.size();
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_ets);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.school_48)
                .setColor(getResources().getColor(R.color.red))
                .setContentTitle(getString(R.string.ets))
                .setContentText(getString(R.string.new_notifications))
                .setContentIntent(pendingIntent)
                .setLargeIcon(icon)
                .setAutoCancel(true)
                .setNumber(numberOfNotifications);

        NotificationCompat.InboxStyle inBoxStyle = new NotificationCompat.InboxStyle();

        // Sets a title for the Inbox in expanded layout
        String bigContentTitle = getString(R.string.notification_content_title,
                numberOfNotifications+"",
                (numberOfNotifications == 1 ? "" : "s"),
                (numberOfNotifications == 1 ? "" : "s"));
        inBoxStyle.setBigContentTitle(bigContentTitle);

        String username = ApplicationManager.userCredentials.getUsername();
        Spannable sb = new SpannableString(username);
        sb.setSpan(
                new StyleSpan(android.graphics.Typeface.BOLD),
                0,
                username.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        inBoxStyle.setSummaryText(sb);

        securePreferences.edit().putString(Constants.RECEIVED_NOTIF, gson.toJson(receivedNotif)).commit();

        int minimumIndex = receivedNotif.size() - NUMBER_OF_NOTIF_TO_DISPLAY;
        minimumIndex = minimumIndex < 0 ? 0 : minimumIndex;
        for (int i = receivedNotif.size() - 1; i >= minimumIndex; i--) {
            inBoxStyle.addLine(receivedNotif.get(i).getNotificationTexte());
        }

        if (numberOfNotifications > NUMBER_OF_NOTIF_TO_DISPLAY) {

            int plusOthers = (numberOfNotifications - NUMBER_OF_NOTIF_TO_DISPLAY);
            String plusOthersString = getString(R.string.others_notifications, plusOthers+"", (plusOthers == 1 ? "" : "s"));
            Spannable others = new SpannableString(plusOthersString);
            others.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, others.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            inBoxStyle.addLine(others);
        }

        mBuilder.setStyle(inBoxStyle);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

    public MonETSNotification getMonETSNotificationFromBundle(Bundle data) {
        int id = Integer.valueOf(data.getString("Id"));
        String notificationTexte = data.getString("NotificationTexte");

        String notificationApplicationNom = data.getString("NotificationApplicationNom");
        //String notificationSigleCours = data.getString("NotificationSigleCours");
        String url = data.getString("Url");

        return new MonETSNotification(
                id,
                0,
                notificationTexte,
                null,
                notificationApplicationNom,
                url);
    }

}