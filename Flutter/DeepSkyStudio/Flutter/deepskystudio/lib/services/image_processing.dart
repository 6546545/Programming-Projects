import 'package:image/image.dart' as img;

class ImageStacker {
  static img.Image medianStack(List<img.Image> frames) {
    final output = img.Image.from(frames.first);
    
    for (int y=0; y<output.height; y++) {
      for (int x=0; x<output.width; x++) {
        final pixels = frames.map((f) => f.getPixel(x,y)).toList();
        output.setPixel(x,y,_medianPixel(pixels.cast<int>()) as img.Color);
      }
    }
    return output;
  }

  static int _medianPixel(List<int> pixels) {
    pixels.sort();
    return pixels[pixels.length ~/ 2];
  }
}