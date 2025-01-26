import 'package:flutter/material.dart';
import 'camera_screen.dart';
import 'gallery_screen.dart';

void main() {
  runApp(DeepSpacePhotographyApp());
}

class DeepSpacePhotographyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Deep Space Photography',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomeScreen(),
      routes: {
        '/camera': (context) => CameraScreen(),
        '/gallery': (context) => GalleryScreen(),
      },
    );
  }
}

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Deep Space Photography')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, '/camera'),
              child: Text('Start Capture'),
            ),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, '/gallery'),
              child: Text('View Gallery'),
            ),
          ],
        ),
      ),
    );
  }
}