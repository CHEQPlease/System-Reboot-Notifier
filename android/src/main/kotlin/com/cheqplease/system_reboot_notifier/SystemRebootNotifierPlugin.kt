package com.cheqplease.system_reboot_notifier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

class SystemRebootNotifierPlugin : FlutterPlugin, BroadcastReceiver() {
    private lateinit var channel : MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {}

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {}

    override fun onReceive(context: Context, intent: Intent) {

        val flutterEngine = FlutterEngine(context);

        flutterEngine.navigationChannel.setInitialRoute("/");

        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());

        val methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.cheqplease.system_reboot_notifier/channel");

        methodChannel.invokeMethod("onSystemReboot", null);
    }
}