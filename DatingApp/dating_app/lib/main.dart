import 'package:dating_app/pages/welcomePage.dart';
import 'package:dating_app/themes/light_mode.dart';
import 'package:flutter/material.dart';

import 'pages/IntroPage.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const IntroPage(),
      theme: light,
      routes: {
        '/introPage':(context) => const IntroPage(),
        '/welcomePage':(context) => const WelcomePage(),
        

      },
    );
  }
}