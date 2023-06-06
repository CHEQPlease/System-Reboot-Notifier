
import 'package:flutter/services.dart';

class SystemRebootNotifier {
  static final SystemRebootNotifier _instance = SystemRebootNotifier._internal();

  factory SystemRebootNotifier() => _instance;

  SystemRebootNotifier._internal();

  void registerCallback(Function task) {
    const channel = MethodChannel('com.cheqplease.system_reboot_notifier/channel');

    channel.setMethodCallHandler((call) async {
      if (call.method == 'onSystemReboot') {
        task();
      }
    });
  }
}
