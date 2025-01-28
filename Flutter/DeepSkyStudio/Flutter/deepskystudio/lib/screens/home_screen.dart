import 'package:deepskystudio/services/camera_service.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
    late CameraService _cameraService;
    bool _isCameraReady = false;



  @override
  void initState() {
    super.initState();
    _cameraService.initialize();
    _initializeCamera();
  }

    Future<void> _initializeCamera() async {
    try {
      await _cameraService.initialize();
      if (!mounted) return;
      setState(() => _isCameraReady = true);
    } catch (e) {
      if (mounted) {
        showDialog(
          context: context,
          builder: (_) => AlertDialog(
            title: const Text('Camera Error'),
            content: Text('Failed to initialize camera: $e'),
          ),
        );
      }
    }
  }

 @override
Widget build(BuildContext context) {
  return Scaffold(
    appBar: AppBar(title: const Text('Astro Capture')),
    body: _isCameraReady 
        ? _cameraService.getPreview()
        : const Center(child: CircularProgressIndicator()),
    floatingActionButton: _isCameraReady 
        ? FloatingActionButton(
            onPressed: _cameraService.capture,
            child: const Icon(Icons.camera),
          )
        : null,
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