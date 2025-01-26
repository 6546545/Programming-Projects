#include <jni.h>
#include <opencv2/core.hpp>
#include <opencv2/imgproc.hpp>

extern "C" JNIEXPORT void JNICALL
Java_com_example_astroapp_OpenCVBridge_stackFrames(
    JNIEnv *env, jobject thiz, 
    jlongArray inputMats, jlong outputMat) {
    
    jsize count = env->GetArrayLength(inputMats);
    jlong *mats = env->GetLongArrayElements(inputMats, 0);
    
    cv::Mat result;
    for(int i=0; i<count; i++) {
        cv::addWeighted(*(cv::Mat*)mats[i], 1.0/count, 
                       result, 1.0, 0.0, result);
    }
    
    env->ReleaseLongArrayElements(inputMats, mats, 0);
    *(cv::Mat*)outputMat = result;
}