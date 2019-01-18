#include <jni.h>
#include <string>
#include <iostream>
using namespace std;

int add(int a,int b){
    return a + b;
}

extern "C"
JNIEXPORT jint JNICALL
Java_zc_neu_com_securitystorage_MainActivity_getInt(JNIEnv *env, jclass type) {

    return 10 + add(3,6);

}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_zc_neu_com_securitystorage_MainActivity_deal(JNIEnv *env, jclass type, jbyteArray buffer_) {
    jbyte *buffer = env->GetByteArrayElements(buffer_, NULL);

    unsigned char array[16];
    //(*env).GetByteArrayRegion(env,buffer,0,16,array);
    (*env)->GetByteArrayRegion(env,buffer,0,16,array);
    // TODO

    env->ReleaseByteArrayElements(buffer_, buffer, 0);
}