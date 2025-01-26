import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class AppLocalizations {
  static const supportedLocales = [
    Locale('en'),
    Locale('es'),
    Locale('fr'),
    Locale('de'),
    Locale('ja'),
  ];

  static LocalizationsDelegate<AppLocalizations> delegate = 
    _AppLocalizationsDelegate();
}

class _AppLocalizationsDelegate 
    extends LocalizationsDelegate<AppLocalizations> {
  @override
  bool isSupported(Locale locale) => true;

  @override
  Future<AppLocalizations> load(Locale locale) => 
    SynchronousFuture<AppLocalizations>(AppLocalizations());

  @override
  bool shouldReload(covariant LocalizationsDelegate<AppLocalizations> old) => false;
}