import 'package:camera/camera.dart';
import 'package:flutter/material.dart';

class CameraService {
  late CameraController _controller;
  bool _isReady = false;

  Future<void> initialize() async {
    final cameras = await availableCameras();
    _controller = CameraController(cameras[0], ResolutionPreset.medium);
    await _controller.initialize();
    _isReady = true;
  }

  Future<XFile> capture() async {
    if (!_isReady) throw Exception('Camera not ready');
    return await _controller.takePicture();
  }

  Widget getPreview() => CameraPreview(_controller);
  
  Future<void> dispose() async => await _controller.dispose();
}