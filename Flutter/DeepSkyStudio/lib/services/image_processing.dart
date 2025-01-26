import 'package:image/image.dart';
import 'package:path_provider/path_provider.dart';
import 'dart:io';

Future<void> processImage(String imagePath) async {
  final File imageFile = File(imagePath);
  final List<int> imageBytes = await imageFile.readAsBytes();
  final Image image = decodeImage(imageBytes);

  // Example: Convert to grayscale
  final Image grayscale = grayscaleImage(image);

  // Save the processed image
  final Directory extDir = await getApplicationDocumentsDirectory();
  final String outputPath = '${extDir.path}/Pictures/processed_${DateTime.now().millisecondsSinceEpoch}.jpg';
  await File(outputPath).writeAsBytes(encodeJpg(grayscale));
}