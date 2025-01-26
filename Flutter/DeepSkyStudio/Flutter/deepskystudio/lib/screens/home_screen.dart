import 'package:deepskystudio/services/camera_service.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final _cameraService = CameraService();

  @override
  void initState() {
    super.initState();
    _cameraService.initialize();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Astro Capture')),
      body: Column(
        children: [
          Expanded(child: _cameraService.getPreview()),
          _buildCaptureButton(),
        ],
      ),
    );
  }

  Widget _buildCaptureButton() {
    return FloatingActionButton(
      onPressed: () async {
        final image = await _cameraService.capture();
        // Process image
      },
      child: const Icon(Icons.camera),
    );
  }
}