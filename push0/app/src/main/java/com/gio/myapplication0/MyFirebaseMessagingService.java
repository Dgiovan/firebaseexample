package com.gio.myapplication0;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage mensajeObtenido) {
        super.onMessageReceived(mensajeObtenido);

       String mensaje = mensajeObtenido.getNotification().getBody();
       String titulo  = mensajeObtenido.getNotification().getTitle();

        enviarNotificacion(titulo,mensaje);


    }

    private void enviarNotificacion(String titulo,String mensage) {

        NotificationCompat.Builder creandoNotificacionEnDispositivo
        =new NotificationCompat.Builder(this,"Canal")
                .setContentTitle(titulo)
                .setAutoCancel(true)
                .setContentText(mensage);
        NotificationManagerCompat manejadordeNotificacion = NotificationManagerCompat.from(this);
        manejadordeNotificacion.notify(999,creandoNotificacionEnDispositivo.build());
    }
}
