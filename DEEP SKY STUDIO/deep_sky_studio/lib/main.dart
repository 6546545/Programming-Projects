import 'package:flutter/material.dart';
import 'editor_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Deep Sky Studio',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        brightness: Brightness.dark,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(
          child: Text('Deep Sky Studio'),
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              onPressed: () {
                // Add your onPressed code here!
                //TODO: Add code to take user to camera screen with DSLR settings
              },
              child: Text('Capture Image'),
            ),
            ElevatedButton(
              onPressed: () {
                // Add your onPressed code here!
                //TODO: Add code to take user to gallery screen
              },
              child: Text('View Gallery'),
            ),
            ElevatedButton(
              onPressed: () {
                // Add your onPressed code here!
                //TODO: Add code to take user to settings screen
              },
              child: Text('Settings'),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => EditorScreen()),
                );
              },
              child: Text('Edit Star Pictures'),
            ),
          ],
        ),
      ),
      backgroundColor: Colors.black,
    );
  }
}
