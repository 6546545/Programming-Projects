import OpenCV

@objc class OpenCVProcessor: NSObject {
    @objc static func processStack(images: [UIImage]) -> UIImage? {
        let mats = images.map { Mat(uiImage: $0) }
        let result = Mat()
        Core.merge(mats, dst: result)
        return result.toUIImage()
    }
}