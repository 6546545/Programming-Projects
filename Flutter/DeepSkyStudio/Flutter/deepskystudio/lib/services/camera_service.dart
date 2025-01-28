import 'package:camera/camera.dart';
import 'package:flutter/material.dart';

class CameraService {
  late CameraController _controller;
  bool _isReady = false;

Future<void> initialize() async {
  try {
    final cameras = await availableCameras();
    if (cameras.isEmpty) {
      throw Exception('No cameras found');
    }
    _controller = CameraController(cameras[0], ResolutionPreset.medium);
    await _controller.initialize();
    _isReady = true;
  } on CameraException catch (e) {
    throw Exception('Camera error: ${e.description}');
  }
}

  Future<XFile> capture() async {
    if (!_isReady) throw Exception('Camera not ready');
    return await _controller.takePicture();
  }

  Widget getPreview() => CameraPreview(_controller);
  
  Future<void> dispose() async => await _controller.dispose();
}